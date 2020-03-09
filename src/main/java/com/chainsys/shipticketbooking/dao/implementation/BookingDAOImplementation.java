package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import com.chainsys.shipticketbooking.dao.BookingDAO;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.Booking;
import com.chainsys.shipticketbooking.util.TestConnection;

public class BookingDAOImplementation implements BookingDAO {
	Connection com = null;
	Logger logger = Logger.getInstance();

	public void saveBooking(Booking a) {
		// PreparedStatement smt1=null;
		try (Connection com = TestConnection.getConnection();) {

			String sql1 = "insert into booking_detail(booking_id,user_id,ship_id,journey_id,booking_seats,date_of_booking,ticket_status,cost) values(booking_id.nextval,?,?,?,?,?,?,?)";
			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {

				// smt1.setInt(1, a.bookingId);
				smt1.setInt(1, a.getUserId());
				smt1.setInt(2, a.getShipId());
				smt1.setInt(3, a.getJourneyId());
				smt1.setInt(4, a.getBookingSeats());
				// smt1.setInt(5, a.shipId);
				java.sql.Timestamp date1 = java.sql.Timestamp.valueOf(LocalDateTime.now());
				smt1.setTimestamp(5, date1);
				smt1.setString(6, a.getStatus());
				smt1.setInt(7, a.getCost());
				logger.debug(sql1);
				int row = smt1.executeUpdate();
				logger.debug(row);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public void updateBooking(Booking a) {
		// PreparedStatement smt2 =null;
		try (Connection com = TestConnection.getConnection();) {

			String sql2 = "update booking_detail set ticket_status=? where user_id=? and journey_id=?";
			try (PreparedStatement smt2 = com.prepareStatement(sql2);) {

				smt2.setString(1, a.getStatus());
				smt2.setInt(2, a.getUserId());
				smt2.setInt(3, a.getJourneyId());
				logger.debug(sql2);
				int row1 = smt2.executeUpdate();
				logger.debug(row1);
			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public void deleteBooking(Booking a) {
		try (Connection com = TestConnection.getConnection();) {

			String sql3 = "delete from booking_detail  where user_id=? and journey_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) {
				smt3.setInt(1, a.getUserId());
				smt3.setInt(2, a.getJourneyId());
				System.out.println(sql3);

				int row2 = smt3.executeUpdate();
				logger.debug(row2);
			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public int countOfBooking() {
		// public void count(String b) throws Exception {
		int value = 0;
		try (Connection com = TestConnection.getConnection();) {
			String sql4 = "select count(*) from booking_detail";
			// String sql4 = "select " + b + "(*) from booking_detail";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {

				try (ResultSet rs4 = smt4.executeQuery();) {

					if (rs4.next()) {
						value = rs4.getInt("count(*)");
						logger.debug("count:" + value);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(ErrorMessages.INVALID_RESULTSET);
				}
			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
		return value;
	}

	public int findCostOfBooking(Booking b) {

		int res = 0;
		try (Connection com = TestConnection.getConnection();) {
			String sql5 = "select cost from booking_detail where (ship_id=? and journey_id=? and user_id=?)";
			try (PreparedStatement smt5 = com.prepareStatement(sql5);) {
				smt5.setInt(1, b.getShipId());
				smt5.setInt(2, b.getJourneyId());
				smt5.setInt(3, b.getUserId());
				System.out.println(sql5);

				try (ResultSet rs5 = smt5.executeQuery();) {
					if (rs5.next()) {
						res = rs5.getInt("cost");
						logger.debug("cost:" + rs5.getInt("cost"));
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(ErrorMessages.INVALID_RESULTSET + e);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CONNECTIONSTATEMENT);

		}
		return res;

	}

}
