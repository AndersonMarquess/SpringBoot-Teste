package com.andersonmarques.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message="O Nome não pode ser nulo.")
	private String nome;
	@Size(max=200, message="A Descrição deve possuir no máximo {max} caracteres.")
	private String descricao;
	@NotEmpty(message="A Data de início não pode ser nulo.")
	private String dataInicio;
	@NotEmpty(message="A Data limite de entrega não pode ser nulo.")
	private String dataLimite;
	private Integer idDoCriador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataCriacao) {
		this.dataInicio = dataCriacao;
	}

	@Override
	public String toString() {
		return String.format("Tarefa Id=%s, Nome=%s, Descricao=%s, DataLimite=%s, DataCriacao=%s \n", id, nome,
				descricao, dataLimite, dataInicio);
	}

	public Integer getIdDoCriador() {
		return idDoCriador;
	}

	public void setIdDoCriador(Integer idDoCriador) {
		this.idDoCriador = idDoCriador;
	}
}
