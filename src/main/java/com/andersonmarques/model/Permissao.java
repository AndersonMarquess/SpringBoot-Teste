package com.andersonmarques.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nomePermissao;
	@ManyToMany(mappedBy="permissoes")
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePermissao() {
		return nomePermissao;
	}
	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	/**
	 * Adiciona um usuário na lista de permissões
	 * @param usuario
	 * @throws IllegalArgumentException caso o usuário seja nulo.
	 */
	public void adicionarUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário inválido.");
		}
		usuarios.add(usuario);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomePermissao == null) ? 0 : nomePermissao.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomePermissao == null) {
			if (other.nomePermissao != null)
				return false;
		} else if (!nomePermissao.equals(other.nomePermissao))
			return false;
		return true;
	}
}
