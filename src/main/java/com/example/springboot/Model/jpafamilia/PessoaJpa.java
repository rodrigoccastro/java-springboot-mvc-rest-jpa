package com.example.springboot.Model.jpafamilia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pessoas")
public class PessoaJpa {

	@Id
	private String cpf;

    @Column(nullable = false)
	private String nome;

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}