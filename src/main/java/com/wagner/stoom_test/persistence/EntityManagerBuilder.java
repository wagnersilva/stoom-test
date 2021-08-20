package com.wagner.stoom_test.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@ApplicationScoped
public class EntityManagerBuilder {
	
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		if(entityManager == null){
			createEntityManager();
		}
		return entityManager;
	}
	private void createEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Stoom-PU");
		entityManager = factory.createEntityManager();
	}
}