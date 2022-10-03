package com.JPA.Reservation.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.JPA.Reservation.Dao.DomesticAirlineDao;
import com.JPA.Reservation.Entity.DomesticAirLine;
import com.JPA.Reservation.Entity.UserReservation;

public class DomesticService {
	private DomesticAirlineDao dado = new DomesticAirlineDao();

	// public String FlightDetails() {
	// return dado.getallFlights();
	// }
	// public String bookFlight() {
	// return dado.insertFlightDetails(dado);
	// }

	/*
	 * public String viewDomesticAirline() { return dado.getallFlights(); } public
	 * void viewAllFlights() {s System.out.println(dado.viewAllFlights());
	 */
	public String addUser(UserReservation ur) {
		try {
			return dado.UserRegistration(ur);
		} catch (Exception e) {
			return "No User Found";
		}
	}

	public String userLogin(String mobileNo) {
		try {
			return dado.LoginUser(mobileNo);
		} catch (Exception e) {
			return "U Need to Login !";
		}
	}

	public String bookFlight(DomesticAirLine dm) {
		try {
			return dado.insertFlightDetails(dm);
		} catch (Exception e) {
			return "Ticket Booking Successfully";
		}
	}

	public String Cancellation(String flight_Id) {
		try {
			return dado.deleteStudent(flight_Id);
		} catch (Exception e) {
			return "You entered a wrong input";
		}
	}

	public String UpdateBooking( String flightName,String flightSource,String flightDestination, Time arrivalTime, Time departureTime, Date fromDate,Date toDate,
			double ticketCost) {
		try {
			return dado.UpdateTicket(flightName,flightSource,flightDestination, arrivalTime, departureTime,fromDate,toDate,ticketCost);
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public String viewTicketCost(String flight_Id) {
		try {
			return dado.fares(flight_Id);
		} catch (Exception e) {
			return "Tickets Not Found";
		}
	}

	public List<DomesticAirLine> ViewAllTickets() {
		try {
			return dado.getAll();
		} catch (Exception e) {
			System.out.println("Tickets Not Found");
		}
		return null;
	}

	public String payCost(double ticketCost) {
		try {
			return dado.insertPayment(ticketCost);
		} catch (Exception e) {
			return "Transcation Failed!";
		}
	}
}
