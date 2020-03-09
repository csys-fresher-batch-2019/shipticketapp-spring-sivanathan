
package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.shipticketbooking.dao.UserDAO;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.util.TestConnection;

public class UserDAOImplementation implements UserDAO {
	Logger logger = Logger.getInstance();

	// for adding the user details in sql.
	public void saveUser(User a) {
		/*
		 * Jdbi jdbi=TestConnection.getJdbi(); //ServiceShipTicket
		 * service=jdbi.onDemand(service.class); UserDAO user = new
		 * UserDAOImplementation();
		 */

		try (Connection com = TestConnection.getConnection();) {
			String sql = "insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)";
			try (PreparedStatement smt = com.prepareStatement(sql);) {
				// smt = com.prepareStatement(sql);

				smt.setString(1, a.getUserName());
				smt.setInt(2, a.getUserId());
				java.sql.Date date1 = java.sql.Date.valueOf(a.getDateOfBirth());
				smt.setDate(3, date1);
				smt.setLong(4, a.getContactNumber());
				smt.setString(5, a.getGender());
				smt.setString(6, a.getPassword());
				smt.setString(7, a.getEmail());

				logger.info("sql statement:" + sql);
				// System.out.println(sql);

				int row1 = smt.executeUpdate();

				logger.info("NO OF ROWS INSERTED:" + row1);
				// System.out.println(row1);
				// smt.close();
			}

			catch (Exception e)

			{
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
				e.printStackTrace();

			}
		} catch (Exception e)

		{
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT);
			e.printStackTrace();

		}
	}

	// for update the user contact number using the user id.
	public void updateUser(User a) {
		// PreparedStatement smt1 = null;

		try (Connection com = TestConnection.getConnection();) {
			String sql1 = "update user_detail set contact_number=? where user_id=?";
			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {
				// smt1 = com.prepareStatement(sql1);

				smt1.setLong(1, a.getContactNumber());
				smt1.setInt(2, a.getUserId());
				logger.info(sql1);

				int row1 = smt1.executeUpdate();
				logger.info("NO OF ROWS UPDATED:" + row1);
			}

			catch (Exception e)

			{
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
				e.printStackTrace();

			}
		} catch (Exception e)

		{
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT);
			e.printStackTrace();

		}

	}

	// delete the user id from the sql.
	public void deleteUser(User a) {
		// PreparedStatement smt2 = null;

		try (Connection com = TestConnection.getConnection();) {

			String sql1 = "delete from user_detail  where user_id=?";
			try (PreparedStatement smt2 = com.prepareStatement(sql1);) {
				// smt2 = com.prepareStatement(sql1);
				smt2.setInt(1, a.getUserId());
				logger.info(sql1);

				int row2 = smt2.executeUpdate();
				logger.info("NO OF ROWS DELETED:" + row2);
			} catch (Exception e)

			{
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
				e.printStackTrace();

			}
		} catch (Exception e)

		{
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT);
			e.printStackTrace();

		}
	}

	// return whether the email and password is same for the login.
	/*
	 * public boolean User(String email, String password) throws Exception {
	 * 
	 * Statement stmt6 = null; boolean result = false; ResultSet rs=null; Connection
	 * com = TestConnection.getConnection(); { try{stmt6 = com.createStatement(); if
	 * (stmt6.executeUpdate("select email from user_detail  where email='" + email +
	 * "'") != 0) { rs =
	 * stmt6.executeQuery("select pass from user_detail  where email='" + email +
	 * "'"); rs.next();
	 * 
	 * if (password.equals(rs.getString("pass"))) {
	 * 
	 * result = true; return result; }
	 * 
	 * }
	 * 
	 * } catch (Exception e) { logger.error("exception" + e); } return result; } }
	 */

	// reset the password for the user if there is login failed
	public void passwordResetUser(User a) {
		// PreparedStatement smt3 = null;

		try (Connection com = TestConnection.getConnection();) {

			String sql3 = "update user_detail set pass=? where user_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) { // smt3 = com.prepareStatement(sql3);
				smt3.setInt(2, a.getUserId());
				smt3.setString(1, a.getPassword());
				logger.info(sql3);

				int row3 = smt3.executeUpdate();
				logger.info("NO OF  UPDATED:" + row3);

			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.INVALID_CREATESTATEMENT);
			e.printStackTrace();
		}
	}

	public boolean userExist(int userId, String password) {

		Statement stmt6 = null;
		boolean result = false;
		ResultSet rs = null;
		try (Connection com = TestConnection.getConnection();) {
			try {
				stmt6 = com.createStatement();
				if (stmt6.executeUpdate("select user_id from user_detail  where user_id='" + userId + "'") != 0) {
					rs = stmt6.executeQuery("select pass from user_detail  where user_id='" + userId + "'");
					rs.next();

					if (password.equals(rs.getString("pass"))) {

						result = true;
						return result;
					}

				}

			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_CREATESTATEMENT);
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT);
		}
		return result;
	}
}
