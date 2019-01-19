package com.andersonmarques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonmarques.model.Tarefa;

/**
 * Responsável por realizar operações CRUD relacionado a entidade tarefa.
 * @author Anderson Marques
 *
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
