package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.shipticketbooking.dao.BookingDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.Booking;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class BookingDAOImplementation implements BookingDAO {
	Connection com = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingDAOImplementation.class);
	// Logger logger = Logger.getInstance();

	public void saveBooking(Booking a) throws DBException {
		// PreparedStatement smt1=null;
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "insert into booking_detail(booking_id,user_id,ship_id,journey_id,booking_seats,date_of_booking,ticket_status,cost) values(booking_id.nextval,?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				// smt1.setInt(1, a.bookingId);
				statement.setInt(1, a.getUserId());
				statement.setInt(2, a.getShipId());
				statement.setInt(3, a.getJourneyId());
				statement.setInt(4, a.getBookingSeats());
				// smt1.setInt(5, a.shipId);
				java.sql.Timestamp date1 = java.sql.Timestamp.valueOf(LocalDateTime.now());
				statement.setTimestamp(5, date1);
				statement.setString(6, a.getStatus());
				statement.setInt(7, a.getCost());
				// logger.debug(sql);
				int row = statement.executeUpdate();
				LOGGER.debug("NO OF ROWS INSERTED:" + row);
			} catch (SQLException e) {
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// e.printStackTrace();
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public void updateBooking(Booking a) throws DBException {
		// PreparedStatement smt2 =null;
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "update booking_detail set ticket_status=? where user_id=? and journey_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				statement.setString(1, a.getStatus());
				statement.setInt(2, a.getUserId());
				statement.setInt(3, a.getJourneyId());
				// LOGGER.debug(sql);
				int row = statement.executeUpdate();
				// logger.debug("NO OF ROWS UPDATED:" + row); it is used for when we creating
				// the logger class
				LOGGER.debug("NO OF ROWS UPDATED:" + row);// it is the default logger class
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public void deleteBooking(Booking a) throws DBException {
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "delete from booking_detail  where user_id=? and journey_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a.getUserId());
				statement.setInt(2, a.getJourneyId());
				// System.out.println(sql);

				int row = statement.executeUpdate();
				LOGGER.debug("NO OF ROWS DELETED:" + row);
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public int countOfBooking() throws DBException {
		// public void count(String b) throws Exception {
		int value = 0;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select count(*) from booking_detail";
			// String sql4 = "select " + b + "(*) from booking_detail";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				try (ResultSet result = statement.executeQuery();) {

					if (result.next()) {
						value = result.getInt("count(*)");
						LOGGER.debug("count:" + value);
					}
				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// throw new Exception(ErrorMessages.INVALID_RESULTSET,e);
					// logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
				}
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return value;
	}

	public int findCostOfBooking(Booking b) throws DBException {

		int res = 0;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select cost from booking_detail where (ship_id=? and journey_id=? and user_id=?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, b.getShipId());
				statement.setInt(2, b.getJourneyId());
				statement.setInt(3, b.getUserId());
				// System.out.println(sql);

				try (ResultSet result = statement.executeQuery();) {
					if (result.next()) {
						res = result.getInt("cost");
						LOGGER.debug("cost:" + result.getInt("cost"));
					}
				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
				}
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);

			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);
			// logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT + "" + e);
			throw new DBException(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);

		}
		return res;

	}

}
