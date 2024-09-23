package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.Usuario;

public class GetUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";//Faz a busca de uma classe, o jpa passa para o sql
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(3);
		
		List<Usuario> usuarios = query.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("ID: " + usuario.getId() + "Email: " + usuario.getEmail());
		}
		
		em.close();
		emf.close();
	}
}
