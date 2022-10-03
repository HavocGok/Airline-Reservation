package com.JPA.Reservation.Service;

import java.util.List;

import com.JPA.Reservation.Dao.UserReservationDao;
import com.JPA.Reservation.Entity.UserReservation;

public class UserReservationService<User> {

	private UserReservationDao ur = new UserReservationDao();

	/*
	 * public String createTab(UserReservation u) { return ur.createTable(u); }
	 */
	public String loginUser(String mobileNo) {
		try {
			return ur.loginUser(mobileNo);
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public String getUser(UserReservation U) {
		try {
			return ur.insertUser(U);
		} catch (Exception e) {
			return " You need To register";
		}
	}

}
