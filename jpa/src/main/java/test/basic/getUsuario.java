package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.Usuario;

public class getUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 1L);
		System.out.println(usuario.getNome());
		
		em.close();
		emf.close();
	}
}
