package infra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	
	private static final Logger log = LogManager.getLogger(DAO.class);
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("bd_jpa");
		}catch(Exception e) {
			log.error("Erro ao criar EMF: {}", e.getMessage(), e);//"{}" é substituido pela mensagem de exceção encontrada
			throw new ExceptionInInitializerError();
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade){//Atomico = incluir tudo, faz tudo de uma vez
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public List<E> getTodos(){ //Sobrecarga de metodos, sempre vai pegar os 10 primeiros
		return this.getTodos(10,0);
	}
	
	public List<E> getTodos(int qtde, int deslocamento){
		if(classe == null) {
			log.error("Classe nula log4j");
			throw new UnsupportedOperationException("Classe nula!");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public void fechar() {
		em.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
