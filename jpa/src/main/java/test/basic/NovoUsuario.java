package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Teste", "teste@mail.com");	
		
		em.getTransaction().begin(); //abre uma transação
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("O Id gerado foi: " + novoUsuario.getId());
		
		em.close();
		emf.close();
	}
	
}
