package br.com.dornel.easysystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.dornel.easysystem.entity.System;
import br.com.dornel.easysystem.util.JPAUtil;

public class SystemDAO implements ISystemDAO<System, Long> {
	
	private EntityManager entityManager = JPAUtil.getInstance().getEntityManager();
	
	public void save(System System) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(System);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void update(System System) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(System);
		entityManager.getTransaction().commit();
		entityManager.close();		
	}

	public void delete(Long id) {

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(System.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();			
	}

	public System findById(Long id) {
		
		return entityManager.find(System.class, id);
	}

	public List<System> findByName(String name) {
		TypedQuery<System> query = entityManager
				.createQuery("from System c where c.name like :name", System.class);		
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<System> findAll() {
		
		return entityManager.createQuery("from System").getResultList();
	}

}
