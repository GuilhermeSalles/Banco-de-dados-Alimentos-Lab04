
package model.dao;

import db.DB;
import model.impl.ProdutosDaoJDBC;
import model.impl.ProdutosValidadeDaoJDBC;

public class DaoFactory {

	public static ProdutosDao createProdutosDao() {
		return new ProdutosDaoJDBC(DB.getConnection());
	}
	
	public static ProdutosValidadeDao createProdutosValidadeDao() {
		return new ProdutosValidadeDaoJDBC(DB.getConnection());
	}
}