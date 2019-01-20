package com.andersonmarques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.service.DatabaseService;
import com.andersonmarques.service.TarefaService;

@Controller
@RequestMapping("/crud-tarefa")
public class CrudController {
	
	@Autowired
	private DatabaseService databaseService;
	@Autowired
	private TarefaService tarefaService;

	/**
	 * Endpoint para popular banco de dados.
	 * Disponível no caminho localhost:8080/crud-tarefa/popular
	 * @return
	 */
	@GetMapping("/popular")
	public String popularBancoDeDados() {
		databaseService.popularBancoDeDados();
		return "/popular";//retorna página dentro de main/resources/templates/popular.html
	}
	
	@GetMapping("/novo")
	public String novaTarefa(Tarefa tarefa) {
		return "/criar-tarefa";//criar-tarefa.html
	}
	
	@PostMapping("/adicionar")
	public String adicionar(Tarefa tarefa) {
		tarefaService.criar(tarefa);
		return "redirect:/crud-tarefa/listar-todas";
	}
	
	@GetMapping("/listar-todas")
	public String listarTodas(ModelMap model) {
		model.addAttribute("tarefas", tarefaService.encontrarTodasAsTarefas());
		return "/listar-tarefas";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id")int id, ModelMap model) {
		System.out.println("Valor recebido: "+id);
		model.addAttribute("tarefa", tarefaService.encontrarTarefaPorId(id));
		return "/editar-tarefa";
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Tarefa tarefa) {
		tarefaService.editarTarefa(tarefa);
		return "redirect:/crud-tarefa/listar-todas";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id")int id) {
		System.out.println("Valor recebido: "+id);
		tarefaService.removerTarefaPorId(id);
		return "redirect:/crud-tarefa/listar-todas";
	}
}
