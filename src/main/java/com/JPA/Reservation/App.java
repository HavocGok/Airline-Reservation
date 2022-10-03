package com.JPA.Reservation;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import com.JPA.Reservation.Dao.DomesticAirlineDao;
import com.JPA.Reservation.Entity.DomesticAirLine;
import com.JPA.Reservation.Entity.UserReservation;
import com.JPA.Reservation.Service.Account_Service;
import com.JPA.Reservation.Service.DomesticService;
import com.JPA.Reservation.Service.UserReservationService;

public class App {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome The AIRLINE-RESERVATION MANAGEMENT SYSTEM");
		System.out.println();
		System.out.println("What You Looking For?");
		System.out.println();
		System.out.println("1. Domestic Airline \n2. International Airline");
		System.out.println();
		System.out.println("Give your choice :");
		int choice = s.nextInt();
		char ch;
		while (choice == 1 || choice == 2) {
			System.out.println();	
			System.out.println();
			UserReservationService urs = new UserReservationService();
			DomesticService ds = new DomesticService();
			DomesticAirlineDao dad = new DomesticAirlineDao();
			// System.out.println(ds.FlightDetails());
			System.out.println("%%%%%%%%%%%%%%%%%%");
			switch (choice) {
			case 1:
				System.out.println("Domestic Airlines -->");
				System.out.println("******** FlightDetails *********");
				System.out.println();
				System.out.println(
						"      Domestic flights are flights within a specific country’s boundaries. \n      Passengers or cargo transportation can be handled through airline companies. Additionally,\n      Domestic flights can be arranged for military purposes.\n      In these cases, flights take place within the country and traveled only through certain domestic flight lines.\n      For these flights, passengers use domestic terminals. All of the airports designed for public use have domestic terminals.\n      Airports with international terminals can also be referred to as international airports");
				System.out.println();
				System.out.println("The Commonly used domestic Airlines are :");
				System.out.println();
				System.out.println("AIR INDIA AIRLINES ");
				System.out.println();
				System.out.println(
						"    1.The veteran of the domestic flight scene and India's biggest carrier,\n    2.Air India delivers domestic airline travel and provides international air travel too with the largest fleet.\n    3. Passengers can avail connections to more than 100 domestic and 70 international destinations.");
				System.out.println();
				System.out.println("VISTARA AIRLINES ");
				System.out.println();
				System.out.println(
						"     1.Tata SIA Airlines Limited, operating as Vistara, is an Indian domestic airline based in Gurgaon with its hub at Delhi-Indira Gandhi International Airport.\n     2.The carrier, a joint venture between Tata Sons and Singapore Airlines, commenced operations on 9 January 2015 with its inaugural flight between Delhi and Mumbai.");
				System.out.println();
				System.out.println("GO FIRST (Go Air)");
				System.out.println();
				System.out.println(
						"    1.Go First offers smart travel at a cheap cost for domestic flights.\n    2.Flying to over 28 destinations including all the metros and operating lots of cheap flights a week,\n    3. Go First is definitely a choice for convenient and economic travel.");
				System.out.println();
				System.out.println("INDIGO AIRLINES ");
				System.out.println();
				System.out.println(
						"     IndiGo based in Gurgaon has been consistently delivering quality cheap flights to various domestic sectors (17 of them) and operate over 120 flights to these places.");
				System.out.println();
				System.out.println("AIR INDIA EXPRESS");
				System.out.println();
				System.out.println(
						"     1.Air India Express is an Indian low-cost carrier headquartered in Kochi.\n     2.It is operated by Air India Express Limited, a wholly owned subsidiary of flag carrier airline Air India.");
				System.out.println();
				System.out.println("AIRASIA INDIA ");
				System.out.println();
				System.out.println(
						"     AirAsia India is an airline in India headquartered in Bengaluru, Karnataka. destinations. The airline is a joint venture between Tata Sons and AirAsia Investment Limited.");
				System.out.println();
				System.out.println("SPICEJET ");
				System.out.println();
				System.out.println(
						"     Spicejet has recently been rejuvenated with their overseas funding and with this they will continue to offer premier, affordable and high quality domestic airlines for travel throughout India.");
				System.out.println();
				ch = 'C';
				while (ch == 'C') {
					System.out.println();
					
					// System.out.println(ds.viewDomesticAirline());
					System.out.println(
							"1. UserRegistration \n2. Login \n3. Book a Ticket \n4. Cancel a Ticket \n5. Update Flight details \n6. fares \n7. Transcation \n8. Inventory.");
					System.out.println("Enter the option :");
					System.out.println();
					int option = s.nextInt();
					String flightName, flight_Id = null, fligthSource, flightDestination;
					Time arrivalTime, departureTime;
					Date fromDate, toDate;
					String name, passportNo, eMail, nationality;
					String mobileNo, address;
					int cus_Id, age;
					double ticketCost = 0;
					switch (option) {
					case 1:
						System.out.println("User Registration :");
						System.out.println();
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter Your Name :");
						name = sc.next();
						System.out.println("Enter Your cus_Id :");
						cus_Id = sc.nextInt();
						System.out.println("Enter Your Age :");
						age = sc.nextInt();
						System.out.println("Enter your MobileNo :");
						mobileNo = sc.next();
						System.out.println("Enter Your Address :");
						address = sc.next();
						System.out.println("Enter your E-Mail Id :");
						eMail = sc.next();
						System.out.println("Enter your PassPort Number :");
						passportNo = sc.next();
						System.out.println("Enter your Nationality :");
						nationality = sc.next();
						System.out.println();
						UserReservation u = new UserReservation(name, cus_Id, age, mobileNo, address, eMail, passportNo,
								nationality);
						System.out.println(ds.addUser(u));
						System.out.println();
						System.out.println("Now! You need to Login...");
						break;
					case 2:
						System.out.println("Login");
						System.out.println();
						System.out.println("Enter your MobileNo :");
						mobileNo = s.next();
						System.out.println(ds.userLogin(mobileNo));
						System.out.println();
						System.out.println("");
						break;
					case 3:
						System.out.println("Book flight");
						System.out.println();
						System.out.println("Enter Your Flight_Id :");
						flightName = s.next();
						System.out.println("Enter Your Flight_Name :");
						flight_Id = s.next();
						System.out.println("Enter Your FlightSource :");
						fligthSource = s.next();
						System.out.println("Enter Your FlightDestination :");
						flightDestination = s.next();
						System.out.println("Enter Your ArrivalTime :");
						arrivalTime = Time.valueOf(s.next());
						System.out.println("Enter Your DepartureTime :");
						departureTime = Time.valueOf(s.next());
						System.out.println("Enter Your TicketCost :");
						ticketCost = s.nextDouble();
						System.out.println("Enter Your FromDate :");
						fromDate = Date.valueOf(s.next());
						System.out.println("Enter Your ToDate :");
						toDate = Date.valueOf(s.next());
						System.out.println();
						DomesticAirLine da = new DomesticAirLine(flightName, flight_Id, fligthSource, flightDestination,
								arrivalTime, departureTime, ticketCost, fromDate, toDate);
						System.out.println();
						System.out.println(ds.bookFlight(da));

						break;
					case 4:
						System.out.println("Cancellation");
						System.out.println();
						System.out.println("Enter the Flight_Id :");
						flight_Id = s.next();
						System.out.println(ds.Cancellation(flight_Id));
						break;
					case 5:
						System.out.println("Update Ticket Details --->");
						System.out.println();
						System.out.println("Enter Your FlightName :");
						flightName = s.next();
						System.out.println("Enter Your FlightSource :");
						fligthSource = s.next();
						System.out.println("Enter Your FlightDestination :");
						flightDestination = s.next();
						System.out.println("Enter Your DepartureTime :");
						arrivalTime = Time.valueOf(s.next());
						System.out.println("Enter Your ArrivalTime :");
						departureTime = Time.valueOf(s.next());
						System.out.println("Enter Your TicketCost :");
						ticketCost = s.nextDouble();
						System.out.println("Enter Your FromDate :");
						fromDate = Date.valueOf(s.next());
						System.out.println("Enter Your ToDate :");
						toDate = Date.valueOf(s.next());
						System.out.println();
						System.out.println(ds.UpdateBooking(flightName, fligthSource, flightDestination, departureTime,
								arrivalTime,fromDate,toDate, ticketCost ));
						System.out.println();
						break;
					case 6:
						System.out.println("Flight Costs:");
						System.out.println("Enter the Flight_Id :");
						flight_Id = s.next();
						System.out.println(ds.viewTicketCost(flight_Id));
					case 7:
						System.out.println("Transcation");
						System.out.println();
						System.out.println(ds.payCost(ticketCost));
						break;
					case 8:
						System.out.println("Inventory");
						System.out.println("We are providing many service on this Inventory Operation.");
						ch = 'C';
						while (ch == 'C') {
							System.out.println(
									"1. Available Seats \n2. Luggages \n3. Life Jackets \n4. Medical Emergency \n5. Foods \n6. View your TicketDetails");
							System.out.println();
							System.out.println("Enter the option :");
							int option1 = s.nextInt();
							System.out.println();
							switch (option1) {
							case 1:
								System.out.println("Available Seats :");
								System.out.println();
								System.out.println("Totally 130 Seats are available!!!");
								System.out.println();
								System.out.println("        1.FirstClass seats = 30");
								System.out.println("        2.PremiumClass seats = 20");
								System.out.println("        3.BussinessClass seats = 30");
								System.out.println("        4.EconomyClass seats = 60");
								System.out.println();
								break;
							case 2:
								System.out.println("Luggages :");
								System.out.println();
								System.out.println(
										"The bags are loosely loaded on the floor of the cargo compartment/cargo hold on narrow-body aircraft or small to medium aircraft");
								System.out.println(
										"On large or wide-body aircraft, bags are stored on containers or ULDs which are loaded as units using deck loaders.");
								break;
							case 3:
								System.out.println("Life Jackets :");
								System.out.println(
										"Emergency safety item for aircraft passengers to be available on all air transport for all persons aboard.");
								System.out.println(
										"Automatic inflatable 2 cells floating vest, with CO2 and oral inflation system.");
								System.out.println(
										"Equipped with a light. 5 to 10 years shelf life depending on the type of package.");
								break;
							case 4:
								System.out.println("Medical Emergency");
								System.out.println();
								System.out.println("The most common emergencies involved:\r\n"
										+ "Lightheadedness or fainting (37.4% of emergencies);\r\n"
										+ "Respiratory problems (12.1%);\r\n" + "Nausea or vomiting (9.5%);\r\n"
										+ "Cardiac symptoms (7.7%); and.\r\n" + "Seizures (5.8%).");
								System.out.println(
										"In-flight medical emergencies most commonly involve near-syncope and gastrointestinal, respiratory, and cardiovascular symptoms.");
								break;
							case 5:
								System.out.println("View your Tickets :");
								System.out.println();
								System.out.println(ds.ViewAllTickets());
								System.out.println();
								break;
							case 6:
								System.out.println("Booked Tickets");
								System.out.println();
								System.out.println(ds.ViewAllTickets());
								System.out.println();
								break;
							default:
								break;
							}
							System.out.println("Want to Continue Press C");
							ch = s.next().charAt(0);
							
						}
						break;
					
					default:
						break;
					}
			
				}
			case 2:
				ch = 'C';
				while (ch == 'C') {
					System.out.println();
					System.out.println("  You can book a flight on Airline Reservation System in five easy steps:");
					System.out.println("    1. Head over to the ARS flight booking page,");
					System.out.println("    2. Enter your departure and arrival destinations, ");
					System.out.println(
							"    3. Select your air travel dates, Choose from our wide range of flights based on your airfare preferences, ");
					System.out.println(
							"    4. Press 3 to ‘Book Ticket’ and your air flight booking is done. Alternatively, you can also use the ARS app for your flight ticket booking. ");
					System.out.println(
							"    5. Download the ARS app, Put in the details i.e. date of journey, departure and arrival destinations, travel class of your choice,");
					System.out.println("     Select on your best comfortable option and click on 'Book Ticket'.");
					// System.out.println(ds.viewDomesticAirline());
					System.out.println();
					System.out.println("InterNational AirLInes  :-->> ");
					System.out.println();
					System.out.println("Top 10 InterNational Airlines in INDIA :");
					System.out.println();
					System.out.println();
					System.out.println("EMIRATES GROUPS");
					System.out.println();
					System.out.println("    1.It is also the largest airline in the Middle East, operating over 3,600 flights per week,\n    2.from its hub at Terminal 3 of Dubai International Airport before the COVID-19 pandemic.\n    3.It operates to more than 150 cities in 80 countries across 6 continents through its fleet of nearly 300 aircraft.\n    4.Emirates Airline is the largest major airline in the Middle East. It is an airline based in Dubai, United Arab Emirates. It runs more than 2400 passenger ...");
					System.out.println();
					System.out.println("Indian Destinations Covered by Emirates Air: ");
					System.out.println("     Ahmedabad, Bengaluru, Chennai, Delhi, Hyderabad, Kochi, Kolkata, Kozhikode, Mumbai, Thiruvanantapuram.\r\n"
							+ "\r\n"
							+ "");
					System.out.println();
					System.out.println("LUFTHANSA");
					System.out.println();
					System.out.println("    1.Deutsche Lufthansa AG or Lufthansa is the flag carrier of Germany. It is the largest airline in Europe in terms of overall passengers carried and fleet size.\n    2.Apart from 18 domestic destinations, this airline is operating services in 197 international destinations of 78 countries.\n    3.Lufthansa offers three classes of services on its flights, i.e., First Class, Business Class, Economy Class.\n    4.On the A-380 Airbus, the passengers of Economy Class can access internet service for a fee through Deutsche Telekom.");
					System.out.println();
					System.out.println("Indian Destinations Covered by Lufthansa:");
					System.out.println();
					System.out.println("    Bangalore, Delhi, Mumbai, Chennai and Pune");
					System.out.println();
					System.out.println();
					System.out.println("Swiss International Airlines");
					System.out.println();
					System.out.println("    1.The flag carrier airline of Switzerland, the Swiss International Airlines is a subsidiary of Lufthansa Group and has its services in a total 76 countries of the continent of Asia, Europe, Africa and America.\n    2.Zurich Airport is the hub of this aviation company as most of the flights operate via Zurich only.\n    3.There are mainly three lounges in all its flights i.e., First Lounge, Senator Lounge and Business Lounge.\n    3.The sophisticated Swiss customary and values are reflected in “personal service”, “in-depth quality” and “typical Swiss hospitality” of the airline.");
					System.out.println();
					System.out.println("Indian destinations covered by Swiss International Airlines:");
					System.out.println();
					System.out.println("    Delhi and Mumbai");
					System.out.println();
					System.out.println("Singapore Airlines");
					System.out.println();
					System.out.println("    1.If you are looking for an airbus which can go with your lavish standard of living and let you feel the charm of flying on a different world, then you must travel in Singapore Airlines.\n    2.The trendsetter in aviation industry, this airplane service is the first to introduce classy services in economy class. Beautiful and smart airhostesses serve the travelers with world class care and inflight services. \n    3.To upgrade the transportation sector to a different level, the company has invented innovative ideas in its list of services which include satellite-based inflight telephones, audio and video on demand (AVOD), free headsets, a choice of meals and free drinks in Economy Class for the first time in airline industry");
					System.out.println();
					System.out.println("Indian Destinations Covered by Singapore Airlines: \n    Ahmedabad, Pune, Chennai, Goa, Jalandhar, Kolkata, Delhi, Mumbai, Hyderabad");
					System.out.println();
					System.out.println("Thai Airways");
					System.out.println();
					System.out.println("    1.Being the largest airline of Thailand and flag carrier of the country, Thai Airways operates domestic, regional as well as intercontinental flights. \n    2.The home base of this airways is Bangkok from where the flights fly to 71 destinations in 34 countries. \n    3.It runs one of the longest non-stop commercial flights in the world among which Bangkok-Log Angeles flight runs non-stop 18 hours. There are mainly four classes of travel,\n      i.e., Royal First Class, Royal Silk Class, Premium Economy Class and Economy Class with each class having different bag allowance limit.");
					System.out.println();
					System.out.println("Indian Destinations Covered by Thai Airways: \n    Delhi, Bengaluru, Kolkata and Mumbai");
					System.out.println();
					System.out.println("Qatar Airways");
					System.out.println();
					System.out.println("    1.Winner of reputed international awards like Best Airline in the World for International Travel 2014 and \\n    2.Best in Business Travel Awards,Qatar Airways has taken air travelling to a different level.\n   3. To reach the pinnacle of excellence in the aviation industry, this prominent airline has introduced outstanding in-flight service, superior onboard products, and operational excellence. \n    4.Most of the flights operate to and from Doha. For those travelers who spend half of the year away from home and doesn’t want to compromise with their comfort,\n    5.Qatar Airways presents 5 star service.\n  Indian Destinations Covered by Qatar Airways: \n    Chennai, Ahmedabad, Delhi, Kolkata, Bengaluru, Mumbai");
					System.out.println();
					System.out.println(
							"1. UserRegistration \n2. Login \n3. Book a Ticket \n4. Cancel a Ticket \n5. Update Flight details \n6. Inventory  \n7. fares \n8. Transcation.");
					System.out.println("Enter the option :");
					System.out.println();
					int option = s.nextInt();
					String flightName, flight_Id = null, fligthSource, flightDestination;
					Time arrivalTime, departureTime;
					Date fromDate, toDate;
					String name, passportNo, eMail, nationality;
					String mobileNo, address;
					int cus_Id, age;
					double ticketCost = 0;
					switch (option) {

					case 1:
						System.out.println("User Registration :");
						System.out.println();
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter Your Name :");
						name = sc.next();
						System.out.println("Enter Your cus_Id :");
						cus_Id = sc.nextInt();
						System.out.println("Enter Your Age :");
						age = sc.nextInt();
						System.out.println("Enter your MobileNo :");
						mobileNo = sc.next();
						System.out.println("Enter Your Address :");
						address = sc.next();
						System.out.println("Enter your E-Mail Id :");
						eMail = sc.next();
						System.out.println("Enter your PassPort Number :");
						passportNo = sc.next();
						System.out.println("Enter your Nationality :");
						nationality = sc.next();
						System.out.println();
						UserReservation u = new UserReservation(name, cus_Id, age, mobileNo, address, eMail, passportNo,
								nationality);
						System.out.println(ds.addUser(u));
						System.out.println();
						System.out.println("Now! You need to Login...");
						break;

					case 2:
						System.out.println("Login");
						System.out.println();
						System.out.println("Enter your MobileNo :");
						mobileNo = s.next();
						System.out.println(ds.userLogin(mobileNo));
						System.out.println();
						System.out.println("");
						break;
					case 3:
						System.out.println("Book flight");
						System.out.println();
						System.out.println("Enter Your FlightName :");
						flightName = s.next();
						System.out.println("Enter Your Flight_id :");
						flight_Id = s.next();
						System.out.println("Enter Your FlightSource :");
						fligthSource = s.next();
						System.out.println("Enter Your FlightDestination :");
						flightDestination = s.next();
						System.out.println("Enter Your ArrivalTime :");
						arrivalTime = Time.valueOf(s.next());
						System.out.println("Enter Your DepartureTime :");
						departureTime = Time.valueOf(s.next());
						System.out.println("Enter Your TicketCost :");
						ticketCost = s.nextDouble();
						System.out.println("Enter Your FromDate :");
						fromDate = Date.valueOf(s.next());
						System.out.println("Enter Your ToDate :");
						toDate = Date.valueOf(s.next());
						System.out.println();
						DomesticAirLine da = new DomesticAirLine(flightName, flight_Id, fligthSource, flightDestination,
								arrivalTime, departureTime, ticketCost, fromDate, toDate);
						System.out.println();
						System.out.println(ds.bookFlight(da));

						break;
					case 4:
						System.out.println("Cancellation");
						System.out.println();
						System.out.println("Enter the MobileNo :");
						mobileNo = s.next();
						System.out.println(ds.Cancellation(mobileNo));
						break;
					case 5:
						System.out.println("Update Ticket Details --->");
						System.out.println();
						System.out.println("Enter Your FlightName :");
						flightName = s.next();
						System.out.println("Enter Your FlightSource :");
						fligthSource = s.next();
						System.out.println("Enter Your FlightDestination :");
						flightDestination = s.next();
						System.out.println("Enter Your ArrivalTime :");
						arrivalTime = Time.valueOf(s.next());
						System.out.println("Enter Your DepartureTime :");
						departureTime = Time.valueOf(s.next());
						System.out.println("Enter Your TicketCost :");
						ticketCost = s.nextDouble();
						System.out.println("Enter Your FromDate :");
						fromDate = Date.valueOf(s.next());
						System.out.println("Enter Your ToDate :");
						toDate = Date.valueOf(s.next());
						System.out.println();
						System.out.println(ds.UpdateBooking(flightName, fligthSource, flightDestination, arrivalTime,
								departureTime,fromDate,toDate, ticketCost));
						System.out.println();
						break;
					case 6:
						System.out.println("Inventory");
						System.out.println("We are providing many service on this Inventory Operation.");
						ch = 'C';
						while (ch == 'C') {
							System.out.println(
									"1. Available Seats \n2. Luggages \n3. Life Jackets \n4. Medical Emergency \n5. Foods ");
							System.out.println();
							System.out.println("Enter the option :");
							System.out.println();

							switch (choice) {
							case 1:
								System.out.println("Available Seats :");
								System.out.println();
								System.out.println("Totally 130 Seats are available!!!");
								System.out.println();
								System.out.println("        1.First seats = 30");
								System.out.println("        2.Premium seats = 20");
								System.out.println("        3.Bussiness seats = 30");
								System.out.println("        4.Economy seats = 60");
								break;
							case 2:
								System.out.println("Luggages :");
								System.out.println();
								System.out.println(
										"The bags are loosely loaded on the floor of the cargo compartment/cargo hold on narrow-body aircraft or small to medium aircraft");
								System.out.println(
										"On large or wide-body aircraft, bags are stored on containers or ULDs which are loaded as units using deck loaders.");
								break;
							case 3:
								System.out.println("Life Jackets :");
								System.out.println(
										"Emergency safety item for aircraft passengers to be available on all air transport for all persons aboard.");
								System.out.println(
										"Automatic inflatable 2 cells floating vest, with CO2 and oral inflation system.");
								System.out.println(
										"Equipped with a light. 5 to 10 years shelf life depending on the type of package.");
								break;
							case 4:
								System.out.println("Medical Emergency");
								System.out.println();
								System.out.println("The most common emergencies involved:\r\n"
										+ "Lightheadedness or fainting (37.4% of emergencies);\r\n"
										+ "Respiratory problems (12.1%);\r\n" + "Nausea or vomiting (9.5%);\r\n"
										+ "Cardiac symptoms (7.7%); and.\r\n" + "Seizures (5.8%).");
								System.out.println(
										"In-flight medical emergencies most commonly involve near-syncope and gastrointestinal, respiratory, and cardiovascular symptoms.");
								break;
							}
						}
					case 7:
						System.out.println("Flight Costs:");

						System.out.println(ds.viewTicketCost(flight_Id));

					case 8:

						System.out.println("------>>Transcation Management<<------");
						char ch1 = 'Y';
						Scanner sc1 = new Scanner(System.in);
						Account_Service accms = new Account_Service();
						int AccountNo;
						String AccName, mobileNo1, DOB;
						double balance = 0;

						while (ch1 == 'Y') {
							System.out.println(
									"1. Insert Account Details \n2. View Account Details \n3. Update Account Details \n4. Delete Account \n5. Credit\n8. Exit");
							int option1 = sc1.nextInt();
							switch (option1) {
							case 1:
								System.out.println("Insert Account Details :");
								System.out.println("Enter Account No :-->");
								AccountNo = sc1.nextInt();
								System.out.println("Enter Account Name :-->");
								AccName = sc1.next();
								System.out.println("Enter Mobile Number :-->");
								mobileNo = sc1.next();
								System.out.println("Enter Employee DOB :-->");
								DOB = sc1.next();
								if (accms.insertAccount(AccountNo, AccName, mobileNo, balance, DOB)) {
									System.out.println("********Account Added Successfully...********");
								} else {
									System.out.println("------Something Wrong------");
								}
								break;
							case 2:
								System.out.println("View Account Details..");
								System.out.println("Enter Account No :-->");
								AccountNo = sc1.nextInt();
								accms.viewAccount(AccountNo);
								break;
							case 3:
								System.out.println("Update Account Details :");
								System.out.println("Enter Account No :-->");
								AccountNo = sc1.nextInt();
								System.out.println("Enter Account Name :-->");
								AccName = sc1.next();
								System.out.println("Enter Mobile Number :-->");
								mobileNo = sc1.next();
								System.out.println("Enter Employee DOB :-->");
								DOB = sc1.next();
								if (accms.updateAccountDetails(AccountNo, AccName, mobileNo, DOB)) {
									System.out.println("********Account Updated Successfully...********");
								} else {
									System.out.println("------Something Wrong------");
								}
								break;
							case 4:
								System.out.println("Delete Account");
								System.out.println("Enter Account No :-->");
								AccountNo = sc1.nextInt();
								if (accms.deleteAccount(AccountNo)) {
									System.out.println("********Account Deleted Successfully...********");
								} else {
									System.out.println("------Something Wrong------");
								}
								break;

							case 5:
								System.out.println("Make a Transcation :");
								System.out.println("Enter Account No :-->");
								AccountNo = sc1.nextInt();
								System.out.println("Enter the Ticket Cost: ");
								double camt = sc1.nextDouble();
								if (accms.creditAccount(AccountNo, camt)) {
									System.out.println("Successfully Credited...");
								} else {
									System.out.println("Transaction Failure");
								}
								break;

							default:
								System.out.println("Thank You...");
								break;
							}
							System.out.println("You want To Continue(Press Y)");
							ch1 = sc1.next().charAt(0);
							break;
						}
					default:
						break;
					}
				}

			}
		}

	}
}