package test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProdutosDao;
import model.dao.ProdutosValidadeDao;
import model.entities.Produtos;
import model.entities.ProdutosValidade;

public class teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite 1 se for produto sem validade,\nDigite 2 se for produto com validade: ");
		int n = sc.nextInt();
		
		if(n == 1) {
			System.out.println("Teste Produto normal");
			ProdutosDao produtoDao = DaoFactory.createProdutosDao();
			
			System.out.println("\n=== TEST 1: findById =======");
			Produtos prod = produtoDao.findById(1);
			System.out.println(prod);
			
			
			System.out.println("\n=== TEST 2: insert =======");
			Produtos newProduto = new Produtos(null,"Oleo", 25.50);
			produtoDao.insert(newProduto);
			System.out.println("Inserted! New id: " + newProduto.getId());
			
			System.out.println("\n=== TEST 3: findAll =======");
			List<Produtos> list = produtoDao.findAll();
			for (Produtos d : list) {
				System.out.println(d);
			}
			
			System.out.println("\n=== TEST 4: delete =======");
			System.out.print("Enter id for delete test: ");
			int id = sc.nextInt();
			produtoDao.deleteById(id);
			System.out.println("Delete completed");
			
			List<Produtos> listDel = produtoDao.findAll();
			for (Produtos d : listDel) {
				System.out.println(d);
			}
			
			System.out.println("\n=== TEST 4: update =======");
			Produtos prodUp = produtoDao.findById(1);
			prodUp.setNome("Feijão");
			prodUp.setValor(9.55);
			produtoDao.update(prodUp);
			System.out.println("Update completed");
			
			List<Produtos> listUp = produtoDao.findAll();
			for (Produtos d : listUp) {
				System.out.println(d);
			}
		} else if(n == 2) {
			
			ProdutosValidadeDao produtoValidadeDao = DaoFactory.createProdutosValidadeDao();
			
			System.out.println("Teste Produto validade");
			System.out.println("\n=== TEST 1: findById =======");
			ProdutosValidade prodValidade = produtoValidadeDao.findById(1);
			System.out.println(prodValidade);
			
			
			System.out.println("\n=== TEST 2: insert =======");
			ProdutosValidade newProduto = new ProdutosValidade(null,"Oleo", 25.50,new Date());
			produtoValidadeDao.insert(newProduto);
			System.out.println("Inserted! New id: " + newProduto.getId());
			
			System.out.println("\n=== TEST 3: findAll =======");
			List<ProdutosValidade> list = produtoValidadeDao.findAll();
			for (ProdutosValidade d : list) {
				System.out.println(d);
			}
			
			System.out.println("\n=== TEST 4: delete =======");
			System.out.print("Enter id for delete test: ");
			int id = sc.nextInt();
			produtoValidadeDao.deleteById(id);
			System.out.println("Delete completed");
			
			List<ProdutosValidade> listDel = produtoValidadeDao.findAll();
			for (ProdutosValidade d : listDel) {
				System.out.println(d);
			}
			
			System.out.println("\n=== TEST 4: update =======");
			ProdutosValidade prodValidadeUp = produtoValidadeDao.findById(1);
			prodValidadeUp.setNome("Feijão");
			prodValidadeUp.setValor(9.55);
			produtoValidadeDao.update(prodValidadeUp);
			System.out.println("Update completed");
			
			List<ProdutosValidade> listup = produtoValidadeDao.findAll();
			for (ProdutosValidade d : listup) {
				System.out.println(d);
			}
		}
		
		sc.close();
	}

}
