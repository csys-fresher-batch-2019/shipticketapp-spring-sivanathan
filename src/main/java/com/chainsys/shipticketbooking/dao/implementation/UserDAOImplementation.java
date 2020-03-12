
package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.shipticketbooking.dao.UserDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class UserDAOImplementation implements UserDAO {
//	Logger logger = Logger.getInstance();
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImplementation.class);

	// for adding the user details in sql.
	public void saveUser(User a) throws DBException {
		/*
		 * Jdbi jdbi=TestConnection.getJdbi(); //ServiceShipTicket
		 * service=jdbi.onDemand(service.class); UserDAO user = new
		 * UserDAOImplementation();
		 */

		try (Connection connection = ConnectionUtil.getConnection();) {
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

				LOGGER.info("NO OF ROWS INSERTED:" + row);
				// System.out.println(row1);
				// smt.close();
			}

			catch (SQLException e)

			{
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);

			}
		} catch (SQLException | DBException e)

		{
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);

		}
	}

	// for update the user contact number using the user id.
	public void updateUser(User a) throws DBException {
		// PreparedStatement smt1 = null;

		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "update user_detail set contact_number=? where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt1 = com.prepareStatement(sql1);

				statement.setLong(1, a.getContactNumber());
				statement.setInt(2, a.getUserId());
				// logger.info(sql);

				int row1 = statement.executeUpdate();
				LOGGER.info("NO OF ROWS UPDATED:" + row1);
			}

			catch (SQLException e)

			{
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);

			}
		} catch (SQLException | DBException e)

		{
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);
			// logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);
			throw new DBException(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);

		}

	}

	// delete the user id from the sql.
	public void deleteUser(User a) throws DBException {
		// PreparedStatement smt2 = null;

		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "delete from user_detail  where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt2 = com.prepareStatement(sql1);
				statement.setInt(1, a.getUserId());
				// logger.info(sql);

				int row = statement.executeUpdate();
				LOGGER.info("NO OF ROWS DELETED:" + row);
			} catch (SQLException e)

			{
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);

			}
		} catch (SQLException | DBException e)

		{
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);
			// logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);
			throw new DBException(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);

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
	public void passwordResetUser(User a) throws DBException {
		// PreparedStatement smt3 = null;

		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "update user_detail set pass=? where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) { // smt3 =
																					// com.prepareStatement(sql3);
				statement.setInt(2, a.getUserId());
				statement.setString(1, a.getPassword());
				// logger.info(sql);

				int row = statement.executeUpdate();
				LOGGER.info("NO OF  UPDATED:" + row);

			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);

			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);

		}
	}

	public boolean userExist(int userId, String password) throws DBException {

		boolean result = false;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String usersql = "select user_id from user_detail  where user_id=?";
			String passql = "select pass from user_detail  where user_id=?";
			try (PreparedStatement statement = connection.prepareStatement(usersql);
					PreparedStatement state = connection.prepareStatement(passql);) {
				statement.setInt(1, userId);
				state.setInt(1, userId);

				if (statement.executeUpdate() != 0) {
					try (ResultSet value = state.executeQuery();) {
						value.next();

						if (password.equals(value.getString("pass"))) {

							result = true;
							return result;
						}

					}

					catch (SQLException e) {
						// e.printStackTrace();
						LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
						throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
					}
				}
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}
		}

		catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);
			throw new DBException(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);

		}

		return result;
	}

}