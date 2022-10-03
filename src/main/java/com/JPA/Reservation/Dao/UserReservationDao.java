package com.JPA.Reservation.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.JPA.Reservation.Entity.UserReservation;

public class UserReservationDao<User> {
	private EntityManagerFactory emf;
	private EntityManager em;

	public UserReservationDao() {
		emf = Persistence.createEntityManagerFactory("AirlineReservation");
		em = emf.createEntityManager();
	}
	/*public String createTable(UserReservation ur) {
		em.getTransaction().begin();
		em.persist(ur);
		em.getTransaction().commit();
		return "Table Created Successfully";
	}*/
	public String insertUser(UserReservation U) {
		em.getTransaction().begin();
		em.persist(U);
		em.getTransaction().commit();
		return "User added Succesfully";
	}
	
	public String loginUser(String mobileNo) {
		em.getTransaction().begin();;
		UserReservation u = em.find(UserReservation.class, mobileNo);
		em.getTransaction().commit();
		if(mobileNo.equals(u)){
			return "Login Successfully";
		}
		else {
			return "Login process failed";
		}
		}
	public List <UserReservation> getAllFlight() {
		em.getTransaction().begin();
		Query q = em.createNamedQuery("FlightDetails");
		List<UserReservation> urv = q.getResultList() ;
		em.getTransaction().commit();
		return urv;
		
	}
	}
