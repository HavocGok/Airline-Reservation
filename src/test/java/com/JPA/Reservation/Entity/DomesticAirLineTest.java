package com.JPA.Reservation.Entity;

import static org.junit.Assert.assertEquals;
import java.sql.Time;
import java.sql.Date;
import org.junit.Ignore;
import org.junit.Test;

import com.JPA.Reservation.Service.DomesticService;

public class DomesticAirLineTest {
	private DomesticService das = new DomesticService();
	
	@Test
	public void addUsertest() {
		assertEquals("User Registration Successfully", das.addUser(new UserReservation("Chandru", 232, 20, "78676554",
				"Telungana", "chandryooo@25gmail.com", "GH56af532FS", "INDIAN")));
	}
	
	@Test
	public void userLogin() {
		assertEquals("Login Successfully",das.userLogin("78676554"));
	}
	
	@Test
	public void bookFlight() {
		assertEquals("Ticket Booking Successfully",das.bookFlight(new DomesticAirLine("6583","AIRINDIA","Chennai","Secondrabad",Time.valueOf("07:59:04"),Time.valueOf("14:17:55"),11000.00,Date.valueOf("2022-08-18"),Date.valueOf("2022-08-18"))));
	}
	
	@Test
	public void viewTicketCost() {
		assertEquals("Your Tickets are :->",das.viewTicketCost("6583"));
	}
	
	@Test
	public void ViewAllTickets() {
		assertEquals("Ticket Details",das.ViewAllTickets());
	}
	
	@Test
	public void UpdateBooking() {
		assertEquals("Updated Done !!!",das.UpdateBooking("AIRAISA","Chennai","Agra",Time.valueOf("07:59:04"),Time.valueOf("14:17:55"),Date.valueOf("2022-08-18"),Date.valueOf("2022-08-18"),22000.00));
	}
	
	@Test
	public void Cancellation() {
		assertEquals("Ticket Cancelled",das.Cancellation("6583"));
	}
	
	@Test
	public void payCost() {
		assertEquals("Make a payment",das.payCost(22000.00));
	}
	
}
