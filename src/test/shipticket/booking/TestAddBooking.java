package com.project.shipticket.booking;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.project.shipticket.util.Logger;

public class TestAddBooking {
static Logger logger=Logger.getInstance();

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		logger.input("give any of the following command(insert,update,delete,total,select)");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			valueinsert();
		} else if (value.equalsIgnoreCase("update")) {
			valueupdate();
		} else if (value.equalsIgnoreCase("delete")) {
			valuedelete();
		} else if (value.equalsIgnoreCase("total")) {
			valuetotal();
		}else if (value.equalsIgnoreCase("select")) {
			select();
		}
		sa.close();
	}

	public static void select() throws Exception {
		BookingDAOImplementation m8 = new BookingDAOImplementation();
		Booking u8 = new Booking();
		Scanner scn8 = new Scanner(System.in);

		logger.input("ENTER THE SELECT DETAILS:\n");
		logger.input("Enter the userid:\n");
		int userId = scn8.nextInt();
		logger.input("Enter the journeyid:\n");
		int jId = scn8.nextInt();
		logger.input("Enter the shipid:\n");
		int sId = scn8.nextInt();
		u8.setJourneyId(jId);
		u8.setUserId(userId);
		u8.setShipId(sId);
		m8.book(u8);
		scn8.close();

	}

	public static void valueinsert() throws Exception {
		BookingDAOImplementation m1 = new BookingDAOImplementation();
		Booking u1 = new Booking();
		Scanner scn1 = new Scanner(System.in);
		logger.input("ENTER THE INSERT VALUE DETAILS:\n");
		//System.out.println("Enter the bookingId:\n");
		//int bookingId = scn1.nextInt();
		logger.input("Enter the userId:\n");

		int userId = scn1.nextInt();
		logger.input("Enter the shipId:\n");
		int shipid = scn1.nextInt();
		logger.input("Enter the journeyId:\n");
		int journeyId = scn1.nextInt();
		logger.input("Enter the booking seats:\n");
		int bookingSeats = scn1.nextInt();
		// System.out.println("Enter the shipId:\n");
		// int shipId = scn1.nextInt();
		// String dateOfBooking=scn.next();//2020-01-01T20:00:00
		logger.input("Enter the date of booking:\n");
		LocalDateTime date1 = /* LocalDateTime.parse(dateOfBooking); */LocalDateTime.now();
		// long contactNumber= scn.nextLong();
		logger.input("Enter the status:\n");
		String status = scn1.next();
		logger.input("Enter the cost:\n");
		int cost = scn1.nextInt();
		scn1.nextLine();
		// String classes = scn.nextLine();
		u1.setShipId(shipid);
		u1.setUserId(userId);
		u1.setJourneyId(journeyId);
		u1.setBookingSeats(bookingSeats);
		// u1.shipId = shipId;
		u1.setDateOfBooking(date1);
		u1.setStatus(status);
		u1.setCost(cost);
		m1.addBooking(u1);
		scn1.close();
	}

	public static void valueupdate() throws Exception {
		BookingDAOImplementation m2 = new BookingDAOImplementation();
		Booking u2 = new Booking();
		Scanner scn2 = new Scanner(System.in);

		logger.input("ENTER THE UPDATE DETAILS:\n");
		logger.input("Enter the status:\n");
		String status = scn2.next();
		logger.input("Enter the userId:\n");
		int userId = scn2.nextInt();
		logger.input("Enter the journeyId:\n");
		int Id = scn2.nextInt();
		u2.setJourneyId(Id);
		u2.setUserId(userId);
		u2.setStatus(status);
		m2.updateBooking(u2);
		scn2.close();

	}

	public static void valuedelete() throws Exception {
		BookingDAOImplementation m3 = new BookingDAOImplementation();
		Booking u3 = new Booking();
		Scanner scn3 = new Scanner(System.in);

		logger.input("ENTER THE DELETE DETAILS:\n");
		logger.input("Enter the userid:\n");
		int userId = scn3.nextInt();
		logger.input("Enter the journeyid:\n");
		int jId = scn3.nextInt();
		u3.setJourneyId(jId);
		u3.setUserId(userId);
		m3.deleteBooking(u3);
		scn3.close();

	}

		public static void valuetotal() throws Exception {
		BookingDAOImplementation m5 = new BookingDAOImplementation();
		// ShipDetail u5 = new ShipDetail();
		Scanner scn5 = new Scanner(System.in);

		logger.input("ENTER THE METHOD :\n");
		String value = scn5.next();
		//m5.count(value);
		m5.count();
		// u5.classes = classes;

		scn5.close();

	}

}