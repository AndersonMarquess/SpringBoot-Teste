package com.andersonmarques.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public void criar(Tarefa tarefa) {
		tarefa.setDataCricao(LocalDate.now());
		tarefaRepository.save(tarefa);
	}
	
	//buscar uma
	
	//buscar todas
	
	//editar
	
	//remover
}
