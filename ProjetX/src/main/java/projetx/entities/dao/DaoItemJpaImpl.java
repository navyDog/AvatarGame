package projetx.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import projetx.entities.items.Item;
import projetx.util.Context;

public class DaoItemJpaImpl implements DaoItem {

	@Override
	public void insert(Item obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
		
	}

	@Override
	public Item update(Item obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Item obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}
}
