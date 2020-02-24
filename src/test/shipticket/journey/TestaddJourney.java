package com.project.shipticket.journey;

import java.time.LocalDate;
import java.util.Scanner;

import com.project.shipticket.util.Logger;

public class TestaddJourney {
	static Logger logger = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		logger.input("insert or update or delete or getdate");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			insertmethod();
		} else if (value.equalsIgnoreCase("update")) {
			updatemethod();
		} else if (value.equalsIgnoreCase("delete")) {
			deletemethod();
		} else if (value.equalsIgnoreCase("getdate")) {
			getdatemethod();
		}

		sa.close();
	}

	public static void insertmethod() throws Exception {
		JourneyDAOImplementation m1 = new JourneyDAOImplementation();
		Journey u1 = new Journey();
		Scanner scn1 = new Scanner(System.in);
		logger.input("ENTER THE INSERT VALUE DETAILS:\n");
		// System.out.println("Enter the userId:\n");

		// int userId = scn1.nextInt();
		logger.input("Enter the journeyId:\n");
		int journeyId = scn1.nextInt();
		logger.input("Enter the journey source date:\n");
		String date1 = scn1.next();// 2020-01-01
		LocalDate date = LocalDate.parse(date1);
		logger.input("Enter the journey destination date:\n");
		String date3 = scn1.next();// 2020-01-01
		LocalDate date2 = LocalDate.parse(date3);
		logger.input("Enter the shipId:\n");
		int shipId = scn1.nextInt();

		// u1.userId = userId;
		u1.setJourneyId(journeyId);
		u1.setSourceDate(date);
		u1.setDestinationDate(date2);
		u1.setShipId(shipId);

		scn1.close();
		m1.addJourney(u1);
	}

	public static void updatemethod() throws Exception {
		JourneyDAOImplementation m2 = new JourneyDAOImplementation();
		Journey u2 = new Journey();
		Scanner scn2 = new Scanner(System.in);

		logger.input("ENTER THE UPDATE DETAILS:\n");
		logger.input("Enter the destination date:\n");
		String date5 = scn2.next();// 2020-01-01
		LocalDate date6 = LocalDate.parse(date5);
		logger.input("Enter the ship Id:\n");
		int shipId = scn2.nextInt();

		u2.setShipId(shipId);
		u2.setDestinationDate(date6);
		m2.updateJourney(u2);

		scn2.close();

	}

	public static void deletemethod() throws Exception {
		JourneyDAOImplementation m3 = new JourneyDAOImplementation();
		Journey u3 = new Journey();
		Scanner scn3 = new Scanner(System.in);

		logger.input("ENTER THE DELETE DETAILS:\n");
		logger.input("Enter the ship id:\n");
		int id = scn3.nextInt();

		u3.setShipId(id);
		m3.deleteJourney(u3);
		System.out.println(m3);
		scn3.close();

	}

	public static void getdatemethod() throws Exception {
		JourneyDAOImplementation m4 = new JourneyDAOImplementation();
		// Journey u4 = new Journey();
		Scanner scn4 = new Scanner(System.in);

		logger.input("ENTER THE SHIP ID:\n");
		int id = scn4.nextInt();
		

		// u4.journeyId = id;
		m4.getJourney(id);

		scn4.close();

	}

}