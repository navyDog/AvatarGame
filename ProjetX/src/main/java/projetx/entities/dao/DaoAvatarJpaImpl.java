package projetx.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import projetx.entities.avatar.Avatar;
import projetx.util.Context;

public class DaoAvatarJpaImpl implements DaoAvatar {

	@Override
	public void insert(Avatar obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
		
	}

	@Override
	public Avatar update(Avatar obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Avatar obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

}
