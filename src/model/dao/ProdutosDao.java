package model.dao;

import java.util.List;

import model.entities.Produtos;

public interface ProdutosDao {

	void insert(Produtos obj);

	void update(Produtos obj);

	void deleteById(Integer id);

	Produtos findById(Integer id);

	List<Produtos> findAll(); 
}
