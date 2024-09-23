package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.Usuario;

public class AlterarUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		usuario.setNome("Ze");
		usuario.setEmail("ze@mail.com");
		
		em.merge(usuario);//busca a entidade e faz o Uptade no sql
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
