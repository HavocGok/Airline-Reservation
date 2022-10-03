package com.JPA.Reservation.Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@NamedQuery(name="viewAllTickets",query= "select d from DomesticAirLine d")
@Entity
public class DomesticAirLine {
	@Id
	String flight_Id;
	String flightName;
	String flightSource;
	String flightDestination;
	Time arrivalTime;
	Time depatureTime;
	Date fromDate;
	Date toDate;
	double ticketCost;
	
	public DomesticAirLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DomesticAirLine(String flight_Id, String name, String flightSource, String flightDestination,
			Time arrivalTime,Time depatureTime, double ticketCost,Date fromDate,Date toDate) {
		super();
		this.flight_Id = flight_Id;
		this.flightName = name;
		this.flightSource = flightSource;
		this.flightDestination = flightDestination;
		this.arrivalTime = arrivalTime;
		this.depatureTime = depatureTime;
		this.ticketCost = ticketCost;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public String getflight_Id() {
		return flight_Id;
	}
	public void setflight_Id(String flight_Id) {
		flight_Id = flight_Id;
	}
	public String getName() {
		return flightName;
	}
	public String viewAllFlights() {
		return viewAllFlights();
	}
	public void setName(String name) {
		flightName = name;
	}
	public String getflightSource() {
		return flightSource;
	}
	public void setflightSource(String flightSource) {
		flightSource = flightSource;
	}
	public String getflightDestination() {
		return flightDestination;
	}
	public void setflightDestination(String flightDestination) {
		flightDestination = flightDestination;
	}
	public LocalDateTime getarrivalTime() {
		return Helper.StringToDateTimeFormatter(getflightDestination());
	}
	public void setarrivalTime(Time arrivalTime) {
		arrivalTime = arrivalTime;
	}
	public Time getdepatureTime() {
		return depatureTime;
	}
	public void setdepatureTime(Time depatureTime) {
		depatureTime = depatureTime;
	}
	public double getticketCost() {
		return ticketCost;
	}
	public void setticketCost(double ticketCost) {
		ticketCost = ticketCost;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "DomesticAirLine [flight_Id=" + flight_Id + ", Name=" + flightName + ", flightSource=" + flightSource
				+ ", flightDestination=" + flightDestination + ", arrivalTime=" + arrivalTime + ", depatureTime="
				+ depatureTime + ", ticketCost=" + ticketCost + "]";
	}

}
