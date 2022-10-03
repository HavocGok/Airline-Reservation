package com.JPA.Reservation.Dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.JPA.Reservation.Entity.DomesticAirLine;
import com.JPA.Reservation.Entity.UserReservation;
import com.JPA.Reservation.Service.DomesticService;


public class DomesticAirlineDao{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DomesticAirlineDao() {
		emf = Persistence.createEntityManagerFactory("DomesticAirline");
		em = emf.createEntityManager();
	}
	public String UserRegistration(UserReservation ur) {
		DomesticService ds = new DomesticService();
		em.getTransaction().begin();
		em.persist(ur);
		em.getTransaction().commit();
		return "User Registration Successfully";
	}
	
	public String LoginUser(String mobileNo) {
		em.getTransaction().begin();	
		TypedQuery<UserReservation> q = em.createQuery("select u from UserReservation u",UserReservation.class);
		for(UserReservation u: q.getResultList() ) {
			if(u.getmobileNo().equals(mobileNo))
				return "Login Successfully";
		}
	
			return "INVALID MOBILE NUMBER";
		}
	public String insertPayment(double ticketCost) {
		em.getTransaction().begin();	
		TypedQuery<DomesticAirLine> q = em.createQuery("select d from DomesticAirLine d",DomesticAirLine.class);
		for(DomesticAirLine d: q.getResultList() ) {
			if(d.getticketCost()== ticketCost)
				return "Transfer Successfully";
		}
	
			return "Transcation failed";
		}
	
	public String insertFlightDetails(DomesticAirLine dm) {
	em.getTransaction().begin();
	em.persist(dm);
	em.getTransaction().commit();
	return "FLight Booked Successfully";
	}
	
	public String deleteStudent(String mobileNo) {
		em.getTransaction().begin();
		DomesticAirLine da = em.find(DomesticAirLine.class, mobileNo);
		em.remove(da);
		em.getTransaction().commit();
		return "Ticket deleted Successfully";
	}
	public List<DomesticAirLine> getAll()
	{
		em.getTransaction().begin();
		TypedQuery<DomesticAirLine> q = em.createNamedQuery("viewAllTickets",DomesticAirLine.class);
		List<DomesticAirLine> slist = q.getResultList();
		em.getTransaction().commit();
		return slist;
	}
	public String UpdateTicket(String flightName,String property,String value,Time ArrivalTime,Time DepartureTime,Date fromDate,Date todate,double TicketCost) {
		em.getTransaction().begin();
		DomesticAirLine dm =em.find(DomesticAirLine.class, "flight_Id");
		if(property.equalsIgnoreCase("FlightName"))
		{
			dm.setName(value);
		}
		else if(property.equalsIgnoreCase("FlightSource"))
		{
			dm.setflightSource(value);
		}
		else if (property.equalsIgnoreCase("FligthDestination")) {
			dm.setflightDestination(value);
		}
		else if (property.equalsIgnoreCase("ArrivalTime")) {
			dm.setarrivalTime(ArrivalTime);
		}
		else if (property.equalsIgnoreCase("DepartureTime")) {
			dm.setdepatureTime(DepartureTime);
		}
		
		else if (property.equalsIgnoreCase("FromDate")) {
			dm.getFromDate();
		}
		else if (property.equalsIgnoreCase("ToDate")) {
			dm.getToDate();
		}
		else if (property.equalsIgnoreCase("TicketCost")) {
			dm.getticketCost();
		}
		return "TIcket updated Successfully";
	}
	
	public String fares(String flight_Id) {
		em.getTransaction().begin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Flight_Id :");
		flight_Id = sc.next();
		TypedQuery<DomesticAirLine> q = em.createQuery("select u from DomesticAirLine u where u.flight_Id=:flight_Id",DomesticAirLine.class);
		q.setParameter("flight_Id", flight_Id);
		System.out.println(q.getSingleResult().getName()+" "+q.getSingleResult().getticketCost());
		em.getTransaction().commit();
		return "Flight Details and TicketCosts..";
	}
	
}
	