package com.andersonmarques.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String descricao;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataLimite;
	private LocalDate dataCriacao;

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

	public LocalDate getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}

	public LocalDate getDataCricao() {
		return dataCriacao;
	}

	public void setDataCricao(LocalDate dataCricao) {
		this.dataCriacao = dataCricao;
	}

	@Override
	public String toString() {
		return String.format("Tarefa Id=%s, Nome=%s, Descricao=%s, DataLimite=%s, DataCriacao=%s \n", id, nome,
				descricao, dataLimite, dataCriacao);
	}
}
