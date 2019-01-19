package com.andersonmarques.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonmarques.model.Tarefa;
import com.andersonmarques.repository.TarefaRepository;

/**
 * Classe responsável por realizar operações realcionadas ao banco de dado em
 * geral.
 * 
 * @author Anderson Marques
 *
 */
@Service
public class DatabaseService {
	
	@Autowired
	private TarefaRepository tarefaRepository;

	/**
	 * Responsável por persistir informações padrão no banco.
	 */
	public void popularBancoDeDados() {
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setDataCricao(LocalDate.of(2019, 1, 19));
		tarefa1.setDataLimite(LocalDate.of(2019, 1, 20));
		tarefa1.setNome("Spring boot crud");
		tarefa1.setDescricao("Criar um crud com spring boot");
		
		tarefaRepository.save(tarefa1);
	}

}
