package com.andersonmarques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andersonmarques.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer>{

	/**
	 * Retorna uma lista com as permissões do usuário com base no id do usuário.
	 * @param id
	 * @return
	 */
	@Query("SELECT p FROM Permissao p JOIN p.usuarios pu WHERE pu.id = :id")
	List<Permissao> encontrarPermissoesPorIdUsuario(@Param("id")Integer id);
	
}
