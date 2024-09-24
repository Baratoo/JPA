package test.basic;

import infra.DAO;
import model.basic.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto prod = new Produto("Camisa", 100.00);
		dao.abrirTransacao().incluir(prod).fecharTransacao().fechar();
	}
}
