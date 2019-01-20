package com.andersonmarques.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public void criar(Tarefa tarefa) {
		tarefa.setDataCriacao(LocalDate.now());
		tarefaRepository.save(tarefa);
	}
	
	public Tarefa encontrarTarefaPorId(int id) {
		return tarefaRepository.findById(id).get();
	}
	
	public List<Tarefa> encontrarTodasAsTarefas() {
		return tarefaRepository.findAll();
	}
	
	public void editarTarefa(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}
	
	public void removerTarefaPorId(int id) {
		tarefaRepository.deleteById(id);
	}
}
