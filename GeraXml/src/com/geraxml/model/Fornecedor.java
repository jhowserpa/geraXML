package com.geraxml.model;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Fornecedor")
public class Fornecedor {

	private String nome;

	private String cpf;

	private String cel;

	private Date dataCadastro;

	private Endereco endereco;

	private List<Produtos> listProdutos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Produtos> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produtos> listProdutos) {
		this.listProdutos = listProdutos;
	}

}
