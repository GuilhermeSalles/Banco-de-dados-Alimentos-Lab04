package model.entities;

import java.util.Date;

public class ProdutosValidade {

	Integer id;
	String nome;
	Double valor;
	Date dataValidade;

	public ProdutosValidade() {

	}

	public ProdutosValidade(Integer id, String nome, Double valor, Date dataValidade) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
	}

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	@Override
	public String toString() {
		return "ProdutoValidade [id= " + id + ", nome= " + nome + ", valor= " + valor + ", dataValidade= " + dataValidade
				+ "]";
	}

}
