package com.JPA.Reservation.Service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserReservationServiceTest {

	private UserReservationService urs = new UserReservationService();
	
	@Test
	public void getUser() {
		assertEquals("User Registration Successfull",urs.getUser(null));
	}
	@Test
	public void loginUser() {
		assertEquals("Login Successfully",urs.loginUser(""));
	}

}
