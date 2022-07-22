package entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.personne.user.User;
import entities.util.Context;

public class DaoUser {

	public void insert(User obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	public User update(User obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	public void delete(User obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

//	public Formateur findFormateurByKey(Long key) {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		Formateur p = em.find(Formateur.class, key);
//		// System.out.println(p.getFormations());
//		em.close();
//		return p;
//	}
//
//	public Stagiaire findStagiaireByKey(Long key) {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		Stagiaire p = em.find(Stagiaire.class, key);
//		em.close();
//		return p;
//	}
//
//	public Personne findByKey(Long key) {
//		return null;
//	}
//
//	public List<Personne> findAll() {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		// Query query=em.createQuery("from Personne p");
//		TypedQuery<Personne> query = em.createQuery("from Personne p", Personne.class);
//		List<Personne> list = query.getResultList();
//		em.close();
//		return list;
//	}
//
//	public List<Formateur> findAllFormateur() {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		// Query query=em.createQuery("from Personne p");
//		TypedQuery<Formateur> query = em.createQuery("from Formateur f", Formateur.class);
//		List<Formateur> list = query.getResultList();
//		em.close();
//		return list;
//	}
//
//	public Formateur findFormateurByIdWithFormations(Long id) {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		Formateur formateur = null;
//		TypedQuery<Formateur> query = em.createQuery(
//				"select f from Formateur f left join fetch f.formations as formation  where f.id=:id", Formateur.class);
//		query.setParameter("id", id);
//		try {
//			formateur = query.getSingleResult();
//		} catch (NoResultException e) {
//
//		}
//		em.close();
//		return formateur;
//	}
//
//	public Formateur findFormateurByIdWithCompetences(Long id) {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		Formateur formateur = null;
//		TypedQuery<Formateur> query = em
//				.createQuery("select f from Formateur f left join fetch f.modules  where f.id=:id", Formateur.class);
//		query.setParameter("id", id);
//		try {
//			formateur = query.getSingleResult();
//		} catch (NoResultException e) {
//
//		}
//		em.close();
//		return formateur;
//	}
//
//	public Formateur findFormateurByIdWithFormationsAndWithCompetences(Long id) {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		Formateur formateur = null;
//		TypedQuery<Formateur> query = em.createQuery(
//				"select f from Formateur f left join fetch f.modules left join fetch f.formations  where f.id=:id",
//				Formateur.class);
//		query.setParameter("id", id);
//		try {
//			formateur = query.getSingleResult();
//		} catch (NoResultException e) {
//
//		}
//		em.close();
//		return formateur;
//	}
//
//	public List<Formateur> findAllFormateurWithFormations() {
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		List<Formateur> list = null;
//		TypedQuery<Formateur> query = em
//				.createQuery("select distinct f from Formateur f left join fetch f.formations as formation", Formateur.class);
//		list = query.getResultList();
//		em.close();
//		return list;
//	}

}
