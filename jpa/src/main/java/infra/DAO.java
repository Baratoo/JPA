package infra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<E> {
	
	private static final Logger log = LogManager.getLogger(DAO.class);
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("bd_jpa");
		}catch(Exception e) {
			log.error("Erro ao criar EMF: {}", e.getMessage(), e);//{} é substituido pela mensagem de exceção encontrada
			throw new ExceptionInInitializerError();
		}
	}
	
	public DAO() {
		em = emf.createEntityManager();
	}
	
}
