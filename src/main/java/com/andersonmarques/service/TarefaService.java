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
	
	public void criar(Tarefa tarefa) {
		tarefa.setDataCriacao(LocalDate.now().toString());
		tarefaRepository.save(tarefa);
	}
	
	public Tarefa encontrarTarefaPorId(int id) {
		return tarefaRepository.findById(id).get();
	}
	
	public List<Tarefa> encontrarTodasAsTarefas() {
		return tarefaRepository.findAll();
	}

	//Necessário para usar @Modifying com Update 
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editarTarefa(Tarefa tarefa) {
		tarefaRepository.update(tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataLimite(), tarefa.getId());
	}
	
	public void removerTarefaPorId(int id) {
		tarefaRepository.deleteById(id);
	}
}
