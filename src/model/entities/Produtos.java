package model.entities;

public class Produtos {

	Integer id;
	String nome;
	Double valor;
	
	public Produtos() {
	}

	public Produtos(Integer id, String nome, Double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
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

	@Override
	public String toString() {
		return "Produtos [id= " + id + ", nome= " + nome + ", valor= " + valor + "]";
	}
	
	
}
