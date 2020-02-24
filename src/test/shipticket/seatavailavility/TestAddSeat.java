package com.project.shipticket.seatavailavility;

import java.util.Scanner;

import com.project.shipticket.booking.Booking;
import com.project.shipticket.util.Logger;

public class TestAddSeat

{
	static Logger logger = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		logger.input("select any one of the following(insert,update,delete,cost,procedure,availableseat,totalcost)");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			method1();
		} else if (value.equalsIgnoreCase("update")) {
			method2();
		} else if (value.equalsIgnoreCase("delete")) {
			method3();
		} else if (value.equalsIgnoreCase("cost")) {
			method4();
		} else if (value.equalsIgnoreCase("procedure")) {
			method5();
		}else if (value.equalsIgnoreCase("availableseat")) {
			method6();
		}else if(value.equalsIgnoreCase("totalcost")) {
			method7();
		}

		sa.close();
	}

	public static void method7() throws Exception {
		SeatDAOImplementation m7 = new SeatDAOImplementation();
		//Booking u1 = new Booking();
		Scanner scn1 = new Scanner(System.in);
		logger.input("ENTER THE  DETAILS:\n");
		logger.input("Enter the shipId:\n");
		int sId = scn1.nextInt();
		logger.input("Enter the journeyId:\n");
		int jId = scn1.nextInt();
		
		//u1.setShipId(sId);
		//u1.setJourneyId(jId);
		//u1.(Seats);
		m7.Totalcost(jId, sId);
		scn1.close();
		
	}

	public static void method1() throws Exception {
		SeatDAOImplementation m1 = new SeatDAOImplementation();
		SeatAvailability u1 = new SeatAvailability();
		Scanner scn1 = new Scanner(System.in);
		logger.input("ENTER THE INSERT VALUE DETAILS:\n");
		logger.input("Enter the shipId:\n");
		int sId = scn1.nextInt();
		logger.input("Enter the journeyId:\n");
		int jId = scn1.nextInt();
		logger.input("Enter the availabilitySeats:\n");
		int Seats = scn1.nextInt();
		u1.setShipId(sId);
		u1.setJourneyId(jId);
		u1.setAvailabilitySeats(Seats);
		m1.add(u1);
		scn1.close();
	}

	public static void method2() throws Exception {
		SeatDAOImplementation m2 = new SeatDAOImplementation();
		SeatAvailability u2 = new SeatAvailability();
		Scanner scn2 = new Scanner(System.in);

		logger.input("ENTER THE UPDATE DETAILS:\n");
		logger.input("Enter the availabilitySeats:\n");
		int status = scn2.nextInt();
		logger.input("Enter the shipId:\n");
		int Id = scn2.nextInt();
//		logger.input("Enter the journeyId:\n");
	//	int Idj = scn2.nextInt();
		logger.input(status);
		//u2.setJourneyId(Idj);
		u2.setAvailabilitySeats(status);
		u2.setShipId(Id);
		m2.update(u2);
		scn2.close();

	}

	public static void method3() throws Exception {
		SeatDAOImplementation m3 = new SeatDAOImplementation();
		SeatAvailability u3 = new SeatAvailability();
		Scanner scn3 = new Scanner(System.in);

		logger.input("ENTER THE DELETE DETAILS:\n");
		logger.input("Enter the shipid:\n");
		int Id = scn3.nextInt();
		logger.input("Enter the journeyid:\n");
		int Ijd = scn3.nextInt();
		u3.setShipId(Id);
		u3.setJourneyId(Ijd);
		m3.delete(u3);
		scn3.close();

	}

	public static void method4() throws Exception {
		SeatDAOImplementation m4 = new SeatDAOImplementation();
		// ShipDetail u5 = new ShipDetail();
		Scanner scn4 = new Scanner(System.in);

		logger.input("ENTER THE ANY OF METHOD FOR COST:\n");
		logger.input("sum or min or max or avg ");
		// System.out.println("Enter the classes:\n");
		String value = scn4.next();
		if (value.equalsIgnoreCase("sum")) {
			m4.costOfBooking(value);
		} else if (value.equalsIgnoreCase("min")) {
			m4.costOfBooking(value);
		} else if (value.equalsIgnoreCase("max")) {
			m4.costOfBooking(value);
		} else if (value.equalsIgnoreCase("avg")) {
			m4.costOfBooking(value);
		}

		// u5.classes = classes;

		scn4.close();

	}

	public static void method5() throws Exception // procedure call
	{
		SeatDAOImplementation m5 = new SeatDAOImplementation();
		SeatAvailability u5 = new SeatAvailability();
		Scanner scn6 = new Scanner(System.in);

		logger.input("ENTER THE PROCEDURE CALL DETAILS:\n");
		logger.input("Enter the userid:\n");
		int id = scn6.nextInt();
		logger.input("Enter the ship no:\n");
		int no = scn6.nextInt();
		logger.input("Enter the journey id:\n");
		int jno = scn6.nextInt();
		logger.input("Enter the booking seats:\n");
		int seat = scn6.nextInt();
		logger.input("Enter the ticket status:\n");
		String status = scn6.next();
		logger.input("Enter the cost:\n");
		int cost = scn6.nextInt();
		
		u5.setuserNo(id);
		u5.setShipNo(no);
		u5.setjourneyNo(jno);
		u5.setBookingSeats(seat);
		u5.setTicketStatus(status);
		u5.setCost(cost);
		m5.procedure(u5);
		scn6.close();

	}
	public static void method6() throws Exception
	{
		SeatDAOImplementation m6 = new SeatDAOImplementation();
		SeatAvailability u6 = new SeatAvailability();
		Scanner scn7 = new Scanner(System.in);

		//logger.input("ENTER THE PROCEDURE CALL DETAILS:\n");
		//logger.input("Enter the userid:\n");
		//int id = scn6.nextInt();
		logger.input("Enter the ship id:\n");
		int no = scn7.nextInt();
		logger.input("Enter the journey id:\n");
		int jno = scn7.nextInt();
		//logger.input("Enter the booking seats:\n");
		//int seat = scn6.nextInt();
		//logger.input("Enter the ticket status:\n");
		//String status = scn6.next();
		//logger.input("Enter the cost:\n");
		//int cost = scn6.nextInt();
		
		//u5.setUserId(id);
		u6.setShipId(no);
		u6.setJourneyId(jno);
		//u5.setBookingSeats(seat);
		//u5.setTicketStatus(status);
		//u5.setCost(cost);
		m6.seat(u6);
		scn7.close();

	}

}