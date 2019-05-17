package com.andersonmarques.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.service.TarefaService;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/novo")
	public String novaTarefa(Tarefa tarefa) {
		return "criar-tarefa";// retorna página dentro de main/resources/templates/criar-tarefa.html
	}

	@PostMapping("/adicionar")
	public String adicionar(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "criar-tarefa";
		}
		tarefaService.criar(tarefa);
		return "redirect:/tarefa/listar";
	}

	@GetMapping("/listar")
	public String listarTodas(ModelMap model) {
		model.addAttribute("tarefas", tarefaService.encontrarTodasAsTarefas());
		return "listar-tarefas";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("tarefa", tarefaService.encontrarTarefaPorId(id));
		return "editar-tarefa";
	}

	@PostMapping("/atualizar")
	public String atualizar(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "editar-tarefa";
		}
		tarefaService.editarTarefa(tarefa);
		return "redirect:/tarefa/listar";
	}

	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") int id) {
		tarefaService.removerTarefaPorId(id);
		return "redirect:/tarefa/listar";
	}
}
