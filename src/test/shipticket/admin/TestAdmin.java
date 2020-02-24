package com.project.shipticket.admin;

import java.util.Scanner;

import com.project.shipticket.util.Logger;

public class TestAdmin {
	static Logger logger=Logger.getInstance();

	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
	logger.input("Enter Admin_Id:");
	int AdminId = scn.nextInt();
	logger.input("Enter Password:");
	String pass = scn.next();
	logger.input(AdminId+"  "+pass+"  ");
	AdminDAOImplementation com = new AdminDAOImplementation();
	boolean res=com.AdminLogin(AdminId, pass);
	logger.debug(res);
	if (res) 
	{
		logger.info(">>>>LOGIN SUCESSFULL<<<<");
	// view order details
	//System.out.println(" Enter 1 for insert Order Details: \n Enter 2 for insert CompanyDetails: \n Enter 3 for insert ProductDetails: \n Enter 4 for insert PurchaseDetails: \n Enter 5 for insert SalesDetails: \n Enter 6 for insert StockDetails:");



	} else {
		logger.info("login failed");
	}

	}

}


