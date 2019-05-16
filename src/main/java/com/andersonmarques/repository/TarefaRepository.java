package com.andersonmarques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andersonmarques.model.Tarefa;

/**
 * Responsável por realizar operações CRUD relacionado a entidade tarefa.
 * @author Anderson Marques
 *
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

	/**
	 * Atualiza os campos especificados onde o id for igual ao informado.
	 * Nota: O Campo de data_criacao não será afetado.
	 * 
	 * @param nome
	 * @param desc
	 * @param dataInicio
	 * @param dataLimite
	 * @param id
	 * @param idDoCriador
	 */
	@Modifying
	@Query("UPDATE Tarefa SET nome = :nome, descricao = :desc, data_inicio = :dataInicio, "
			+ "data_limite = :dataLimite WHERE id = :id AND id_do_criador = :idDoCriador")
	void update(
		@Param("nome") String nome,
		@Param("desc") String desc,
		@Param("dataInicio") String dataInicio,
		@Param("dataLimite") String dataLimite,
		@Param("id") Integer id,
		@Param("idDoCriador") Integer idDoCriador
	);
	
	void deleteByIdAndIdDoCriador(Integer id, Integer idDoCriador);
	
	List<Tarefa> findAllByIdDoCriador(Integer idDoCriador);
}
