package com.geraxml.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("produtos")
public class Produtos {

	private String codigo;

	private String nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
