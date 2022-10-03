package com.JPA.Reservation.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {

	public static int getId() {
		return 0;
		
	}
	Scanner sc = new Scanner(System.in);
	public static  LocalDateTime StringToDateTimeFormatter(String input) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime date = LocalDateTime.parse(input,format);
		return date;
	}
}
