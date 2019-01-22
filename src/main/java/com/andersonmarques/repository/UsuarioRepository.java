package com.andersonmarques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andersonmarques.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
	
	@Query("SELECT u FROM Usuario u WHERE u.nomeUsuario = :username")
	Usuario encontrarUsuarioComNome(@Param("username")String username);
}
