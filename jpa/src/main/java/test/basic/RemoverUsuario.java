package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.Usuario;

public class RemoverUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 5L);
		
		if(usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
}
