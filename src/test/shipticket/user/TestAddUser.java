package com.project.shipticket.user;

import java.time.LocalDate;
import java.util.Scanner;

import com.project.shipticket.user.User;
import com.project.shipticket.user.UserDAOImplementation;
import com.project.shipticket.util.Logger;

public class TestAddUser {

	static Logger logger = Logger.getInstance();
//	static Jdbi jdbi=TestConnection.getJdbi();
	//static UserDAO userDAO=jdbi.onDemand(UserDAO.class);

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);

		logger.input("Enter any of the following(login,insert,update,delete)");

		String value = sa.next();

		if (value.equalsIgnoreCase("insert")) {
			insert();
		} else if (value.equalsIgnoreCase("update")) {
			update();
		} else if (value.equalsIgnoreCase("delete")) {
			delete();
		} else if (value.equalsIgnoreCase("login")) {
			userLogin();
		}
		sa.close();

	}

	public static void insert() throws Exception {

		UserDAOImplementation m1 = new UserDAOImplementation();
		User u1 = new User();
		Scanner scn1 = new Scanner(System.in);

		logger.input("INSERT THE USER DETAILS:\n");
		logger.input("Enter the userId:\n");

		int userId = scn1.nextInt();

		logger.input("Enter the username:\n");
		String name = scn1.next();

		logger.input("Enter the dob of user(YYYY-MM-DD):\n");
		String dob = scn1.next();// 2020-01-01

		LocalDate date = LocalDate.parse(dob);
		logger.input("Enter the contact number:\n");

		long contactNumber = scn1.nextLong();
		logger.input("Enter a gender(M/F):\n");

		String gender = scn1.next();
		logger.input("Enter a password:\n");

		String password = scn1.next();
		logger.input("Enter a email:\n");

		String email = scn1.next();

		scn1.close();

		u1.setUserId(userId);
		u1.setUserName(name);
		u1.setDateOfBirth(date);
		u1.setContactNumber(contactNumber);
		u1.setGender(gender);
		u1.setPassword(password);
		u1.setEmail(email);
		
		//userDAO.addUser(u1);
		
		m1.addUser(u1);
	}

	// Date date = new Date();
	// SimpleDateFormat formatter = new SimpleDateFormat("01/11/1998");
	// String strDate= formatter.format(date);

	public static void update() throws Exception {
		UserDAOImplementation m2 = new UserDAOImplementation();
		User u2 = new User();
		Scanner scn2 = new Scanner(System.in);

		logger.input("ENTER THE UPDATE DETAILS:\n");
		logger.input("Enter the contact number:\n");

		long number = scn2.nextLong();

		logger.input("Enter the userid:\n");
		int id = scn2.nextInt();

		u2.setContactNumber(number);
		u2.setUserId(id);

		scn2.close();

		m2.updateUser(u2);

	}

	public static void delete() throws Exception {
		UserDAOImplementation m3 = new UserDAOImplementation();
		User u3 = new User();

		Scanner scn3 = new Scanner(System.in);

		logger.input("ENTER THE DELETE DETAILS:\n");
		logger.input("Enter the userid:\n");
		int id = scn3.nextInt();

		u3.setUserId(id);

		scn3.close();

		m3.deleteUser(u3);

	}

	/*public static void userLogin() throws Exception {
		UserDAOImplementation m4 = new UserDAOImplementation();
		User u4 = new User();
		Scanner sc = new Scanner(System.in);

		logger.input("Enter email :");
		String email = sc.next();
		logger.input("Enter Password:");
		String password = sc.next();

		if (m4.User(email, password)) {
			logger.input("----LOGIN SUCESSFULL----");
		} else {
			logger.input("----LOGIN FAILED----");
			logger.input("DO YOU WANT TO RESET PASSWORD(Y/N)");

			String reset = sc.next();
			if (reset.equalsIgnoreCase("Y")) {

				logger.input("Enter the userid:\n");
				int id = sc.nextInt();

				logger.input("Enter the new password:\n");
				String password1 = sc.next();

				u4.setPassword(password1);
				u4.setUserId(id);

				sc.close();

				m4.resetUser(u4);
			} else if (reset.equalsIgnoreCase("N")) {
				logger.debug("TRY AGAIN  ");
			} else {
				logger.debug("invalid selection");
			}
		}
	}*/
	

	public static void userLogin() throws Exception {
		UserDAOImplementation m4 = new UserDAOImplementation();
		User u4 = new User();
		Scanner sc = new Scanner(System.in);

		logger.input("Enter userid :");
		int user_id = sc.nextInt();
		logger.input("Enter Password:");
		String password = sc.next();

		if (m4.User(user_id, password)) {
			logger.input("----LOGIN SUCESSFULL----");
		} else {
			logger.input("----LOGIN FAILED----");
			logger.input("DO YOU WANT TO RESET PASSWORD(Y/N)");

			String reset = sc.next();
			if (reset.equalsIgnoreCase("Y")) {

				logger.input("Enter the userid:\n");
				int id = sc.nextInt();

				logger.input("Enter the new password:\n");
				String password1 = sc.next();

				u4.setPassword(password1);
				u4.setUserId(id);

				sc.close();

				m4.resetUser(u4);
			} else if (reset.equalsIgnoreCase("N")) {
				logger.debug("TRY AGAIN  ");
			} else {
				logger.debug("invalid selection");
			}
		}
	}

}