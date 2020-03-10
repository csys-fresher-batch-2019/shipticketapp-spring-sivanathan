
package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chainsys.shipticketbooking.dao.UserDAO;
import com.chainsys.shipticketbooking.exception.DBException;
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

		try (Connection connection = TestConnection.getConnection();) {
			String sql = "insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt = com.prepareStatement(sql);

				statement.setString(1, a.getUserName());
				statement.setInt(2, a.getUserId());
				java.sql.Date date1 = java.sql.Date.valueOf(a.getDateOfBirth());
				statement.setDate(3, date1);
				statement.setLong(4, a.getContactNumber());
				statement.setString(5, a.getGender());
				statement.setString(6, a.getPassword());
				statement.setString(7, a.getEmail());

				// logger.info("sql statement:" + sql);
				// System.out.println(sql);

				int row = statement.executeUpdate();

				logger.info("NO OF ROWS INSERTED:" + row);
				// System.out.println(row1);
				// smt.close();
			}

			catch (SQLException e)

			{
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);

			}
		} catch (SQLException | DBException e)

		{
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);

		}
	}

	// for update the user contact number using the user id.
	public void updateUser(User a) {
		// PreparedStatement smt1 = null;

		try (Connection connection = TestConnection.getConnection();) {
			String sql = "update user_detail set contact_number=? where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt1 = com.prepareStatement(sql1);

				statement.setLong(1, a.getContactNumber());
				statement.setInt(2, a.getUserId());
				// logger.info(sql);

				int row1 = statement.executeUpdate();
				logger.info("NO OF ROWS UPDATED:" + row1);
			}

			catch (SQLException e)

			{
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);

			}
		} catch (SQLException | DBException e)

		{
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);

		}

	}

	// delete the user id from the sql.
	public void deleteUser(User a) {
		// PreparedStatement smt2 = null;

		try (Connection connection = TestConnection.getConnection();) {

			String sql = "delete from user_detail  where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt2 = com.prepareStatement(sql1);
				statement.setInt(1, a.getUserId());
				// logger.info(sql);

				int row = statement.executeUpdate();
				logger.info("NO OF ROWS DELETED:" + row);
			} catch (SQLException e)

			{
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);

			}
		} catch (SQLException | DBException e)

		{
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);

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

		try (Connection connection = TestConnection.getConnection();) {

			String sql = "update user_detail set pass=? where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) { // smt3 =
																					// com.prepareStatement(sql3);
				statement.setInt(2, a.getUserId());
				statement.setString(1, a.getPassword());
				// logger.info(sql);

				int row = statement.executeUpdate();
				logger.info("NO OF  UPDATED:" + row);

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);

			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);

		}
	}

	public boolean userExist(int userId, String password) {

		Statement statement = null;
		boolean result = false;
		ResultSet value = null;
		try (Connection connection = TestConnection.getConnection();) {
			try {
				statement = connection.createStatement();
				if (statement.executeUpdate("select user_id from user_detail  where user_id='" + userId + "'") != 0) {
					value = statement.executeQuery("select pass from user_detail  where user_id='" + userId + "'");
					value.next();

					if (password.equals(value.getString("pass"))) {

						result = true;
						return result;
					}

				}

			} catch (SQLException e) {
				logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);
				e.printStackTrace();
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);
		}
		return result;
	}
}
