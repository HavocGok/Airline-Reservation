package com.JPA.Reservation.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserReservation {

	private String name;
	private int cus_Id;
	private int age;
	@Id
	private String mobileNo;
	private String address;
	private String eMail;
	String passportNo;
	String nationality;
	
	public UserReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserReservation(String name, int cus_Id, int age, String mobileNo, String address, String eMail,
			String passportNo, String nationality) {
		super();
		this.name = name;
		this.cus_Id = cus_Id;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address;
		this.eMail = eMail;
		this.passportNo = passportNo;
		this.nationality = nationality;
	}

	public void UserRegistration(String name, int cus_Id, int age, String mobileNo, String address,String eMail,String passportNo,String nationality) {
		name = name;
		cus_Id = cus_Id;
		age = age;
		mobileNo = mobileNo;
		address = address;
		passportNo = passportNo;
		nationality = nationality;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		name = name;
	}

	public int getcus_Id() {
		return cus_Id;
	}

	public void setcus_Id(int cus_Id) {
		cus_Id = cus_Id;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		age = age;
	}

	public String getmobileNo() {
		return mobileNo;
	}

	public void setmobileNo(String mobileNo) {
		 mobileNo = mobileNo;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		address = address;
	}
	

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		eMail = eMail;
	}
	

	public String getpassportNo() {
		return passportNo;
	}

	public void setpassportNo(String passportNo) {
		passportNo = passportNo;
	}
	
	public String getnationality() {
		return nationality;
	}

	public void setnationality(String nationality) {
		nationality = nationality;
	}

	@Override
	public String toString() {
		return "Passengers [name=" + name + ", cus_Id=" + cus_Id + ", age=" + age + ", mobileNo=" + mobileNo
				+ ", address=" + address + ", eMail=" + eMail + ", passportNo=" + passportNo + ",nationality="+nationality+"]";
	}

	public void displayPassengersDetails(){
		
	System.out.println("Full name =" + name);
	System.out.println("passport No =" + passportNo);
	System.out.println("age =" + age);
	System.out.println("Mobile No =" + mobileNo);
	System.out.println("nationality =" + nationality);
	}

	public String insertUserReservationDetails(UserReservation u) {
		return  "Passengers [name=" + name + ", cus_Id=" + cus_Id + ", age=" + age + ", mobileNo=" + mobileNo
				+ ", address=" + address + ", eMail=" + eMail + ", passportNo=" + passportNo + ",nationality="+nationality+"]";
	}

	

	
}



