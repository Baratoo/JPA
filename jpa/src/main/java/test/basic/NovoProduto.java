package test.basic;

import infra.DAO;
import model.basic.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto prod = new Produto("Meiao", 20.00);
		dao.incluirAtomico(prod).fechar();
		
		System.out.println("Id: " + prod.getId());
	}
}
