package model.dao;

import java.util.List;

import model.entities.ProdutosValidade;

public interface ProdutosValidadeDao {

	void insert(ProdutosValidade obj);

	void update(ProdutosValidade obj);

	void deleteById(Integer id);

	ProdutosValidade findById(Integer id);

	List<ProdutosValidade> findAll(); 
}
