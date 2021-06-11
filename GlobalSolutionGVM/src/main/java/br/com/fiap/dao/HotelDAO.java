package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Hotel;

import br.com.fiap.util.EntityManagerFacade;

public class HotelDAO {
	
	private EntityManager manager = EntityManagerFacade.getEntityManager();

//	CREATE
	public void save(Hotel setup) {
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}
	
//	READ
	public List<Hotel> getAll() {
		String jpql = "SELECT s FROM Setup s";
		TypedQuery<Hotel> query = manager.createQuery(jpql, Hotel.class);
		return query.getResultList();
		
	}

//	READ
	public Hotel findById(int id) {
		return manager.find(Hotel.class, id);
		
	}
	
	//UPDATE
	public void update(Hotel setup) {
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();
	
	}

//	DELETE
	public void delete(Hotel hotel) {
		manager.getTransaction().begin();
		manager.remove(hotel);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
}
