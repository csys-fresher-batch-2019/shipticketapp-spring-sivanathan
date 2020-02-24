package com.project.shipticket.shipdetails;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.shipticket.util.Logger;

public class TestAddShip {

	static Logger logger = Logger.getInstance();

	public static void main(String[] args) throws Exception {

		Scanner sa = new Scanner(System.in);
		logger.input("Enter any of the following(insert or update or delete or getshipdetails  or distinct or ship )");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			insert();
		} else if (value.equalsIgnoreCase("update")) {
			update();
		} else if (value.equalsIgnoreCase("delete")) {
			delete();
		} else if (value.equalsIgnoreCase("getshipdetails")) {
			getshipdetails();
		} else if (value.equalsIgnoreCase("distinct")) {
			distinct();
		} else if (value.equalsIgnoreCase("ship")) {
			ship();
		}
		/*
		 * else if (value.equalsIgnoreCase("count")) { method6();}
		 */
		sa.close();
	}

	public static ArrayList<ShipDetail> ship() throws Exception  {
		ShipDetailDAOImplementation m4 = new ShipDetailDAOImplementation();
		
		ArrayList<ShipDetail> list=m4.Ship();
		for(ShipDetail s:list)
		{
			System.out.println(s);
		}
		return list;
		

	}


	public static void insert() throws Exception {
		ShipDetailDAOImplementation m1 = new ShipDetailDAOImplementation();
		ShipDetail u1 = new ShipDetail();
		Scanner scn1 = new Scanner(System.in);
		logger.input("ENTER THE INSERT VALUE DETAILS:\n");
		logger.input("Enter the shipId:\n");
		int shipId = scn1.nextInt();
		logger.input("Enter the shipname:\n");
		String shipName = scn1.next();
		logger.input("Enter the sourceplace:\n");
		String sourcePlace = scn1.next();
		logger.input("Enter the destination:\n");
		String destinationPlace = scn1.next();
		logger.input("Enter the no of seats:\n");
		int noOfSeats = scn1.nextInt();
		scn1.nextLine();
		logger.input("Enter the classes:\n");
		String classes = scn1.nextLine();
		logger.input("Enter the amount:\n");
		int amount = scn1.nextInt();

		u1.setShipId(shipId);
		u1.setShipName(shipName);
		u1.setSourcePlace(sourcePlace);
		u1.setDestinationPlace(destinationPlace);
		u1.setNoOfSeats(noOfSeats);
		u1.setClasses(classes);
		u1.setAmount(amount);
		m1.addShip(u1);
		scn1.close();
	}

	public static void update() throws Exception {
		ShipDetailDAOImplementation m2 = new ShipDetailDAOImplementation();
		ShipDetail u2 = new ShipDetail();
		Scanner scn2 = new Scanner(System.in);

		logger.input("ENTER THE UPDATE DETAILS:\n");
		logger.input("Enter the no of seats:\n");
		int noOfSeats = scn2.nextInt();
		logger.input("Enter the ship id:\n");
		int shipId = scn2.nextInt();
		u2.setNoOfSeats(noOfSeats);
		u2.setShipId(shipId);
		m2.updateShip(u2);
		scn2.close();

	}

	public static void delete() throws Exception {
		ShipDetailDAOImplementation m3 = new ShipDetailDAOImplementation();
		ShipDetail u3 = new ShipDetail();
		Scanner scn3 = new Scanner(System.in);

		logger.input("ENTER THE DELETE DETAILS:\n");
		logger.input("Enter the shipid:\n");
		int id = scn3.nextInt();
		u3.setShipId(id);
		m3.deleteShip(u3);
		scn3.close();

	}

	public static ArrayList<ShipDetail> getshipdetails() throws Exception {
		ShipDetailDAOImplementation m4 = new ShipDetailDAOImplementation();
		ShipDetail u4 = new ShipDetail();
		Scanner scn4 = new Scanner(System.in);

		logger.input("ENTER THE SHIP  DETAILS:\n");
		logger.input("Enter the source place:\n");
		String source = scn4.next();
		logger.input("Enter the destination place:\n");
		String destination = scn4.next();
		u4.setSourcePlace(source);
		u4.setDestinationPlace(destination);
		scn4.close();
		ArrayList<ShipDetail> list=m4.getShip(u4);
		for(ShipDetail s:list)
		{
			System.out.println(s);
		}
		return list;
		

	}

	public static void distinct() throws Exception {
		ShipDetailDAOImplementation m5 = new ShipDetailDAOImplementation();
		Scanner scn5 = new Scanner(System.in);

		logger.input("ENTER THE DISTINCT  DETAILS:\n");
		String cl = scn5.next();
		m5.distinctShip(cl);
		scn5.close();

	}
}