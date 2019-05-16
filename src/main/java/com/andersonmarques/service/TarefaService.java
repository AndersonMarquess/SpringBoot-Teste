package com.andersonmarques.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private UsuarioAutenticavelService usuarioAutenticavelService;

	public void criar(Tarefa tarefa) {
		tarefa.setDataInicio(LocalDate.now().toString());
		tarefa.setIdDoCriador(usuarioAutenticavelService.getIdDoUsuarioLogado());
		tarefaRepository.save(tarefa);
	}

	public Tarefa encontrarTarefaPorId(int id) {
		return tarefaRepository.findById(id).get();
	}

	public List<Tarefa> encontrarTodasAsTarefas() {
		return tarefaRepository.findAllByIdDoCriador(usuarioAutenticavelService.getIdDoUsuarioLogado());
	}

	// Necessário para usar @Modifying com Update
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editarTarefa(Tarefa tarefa) {
		tarefaRepository.update(tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataInicio(), tarefa.getDataLimite(),
				tarefa.getId(), usuarioAutenticavelService.getIdDoUsuarioLogado());
	}

	public void removerTarefaPorId(int id) {
		tarefaRepository.deleteByIdAndIdDoCriador(id, usuarioAutenticavelService.getIdDoUsuarioLogado());
	}
}
