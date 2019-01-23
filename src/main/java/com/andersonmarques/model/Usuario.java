package com.andersonmarques.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(unique=true)
	private String nomeUsuario;
	private String senha;
	@ManyToMany
	@JoinTable(
		name="Usuario_Permissao",
		joinColumns=@JoinColumn(name="FK_Usuario"),
		inverseJoinColumns=@JoinColumn(name="FK_Permissao")
	)
	@ElementCollection(targetClass=Permissao.class)//Resolve o problema da classe não mapeada
	private Set<Permissao> permissoes = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Adiciona uma permissão ao usuário.
	 * @param permissao
	 * @throws IllegalArgumentException caso a permissão ou seu nome sejam nulos.
	 */
	public void addPermissao(Permissao permissao) {
		if(permissao.getNomePermissao().trim().isEmpty() || permissao== null) {
			throw new IllegalArgumentException("Permissão inválida.");
		}
		permissoes.add(permissao);
	}
}
