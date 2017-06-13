package dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null){
			emf = Persistence.createEntityManagerFactory("Biblioteca");
		}	
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		if (em != null && em.isOpen()){
			return em;
		}
		else {
			return em = getEntityManagerFactory().createEntityManager();
		}
	}
	
	public static void closeEntityManager() {
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.commit();
			}
			em.close();
		}
	}
	
	public static void beginTrasaction() {
		getEntityManager().getTransaction().begin();
	}
	
	public static void commit() {
		EntityTransaction tx = getEntityManager().getTransaction();
		if (tx.isActive())
			tx.commit();
	}
	
	public static void rollBack() {
		EntityTransaction tx = getEntityManager().getTransaction();
		if (tx.isActive())
			tx.rollback();
	}
	
}
