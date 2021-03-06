package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.shipticketbooking.dao.SeatDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;

import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class SeatDAOImplementation implements SeatDAO {
	// Logger logger = Logger.getInstance();
	private static final Logger LOGGER = LoggerFactory.getLogger(SeatDAOImplementation.class);

	public void addSeatAvailability(SeatAvailability a) throws DBException {

		// Connection com = null;
		// PreparedStatement smt1 = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "insert into seat_availability(ship_id,journey_id,available_seat) values(?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				statement.setInt(1, a.getShipId());
				statement.setInt(3, a.getAvailabilitySeats());
				statement.setInt(2, a.getJourneyId());

				// logger.debug(sql);

				int row = statement.executeUpdate();
				LOGGER.debug("NO OF ROWS INSERTED:" + row);

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

	public void updateSeatAvailability(SeatAvailability a) throws DBException {

		// Connection com = null;
		// PreparedStatement smt2 = null;
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "update seat_availability set available_seat=? where ship_id=? ";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a.getAvailabilitySeats());
				statement.setInt(2, a.getShipId());
				// smt2.setInt(3, a.getJourneyId());
				// logger.debug(sql);

				int row = statement.executeUpdate();
				LOGGER.debug("NO OF ROWS UPDATED:" + row);
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

	public void deleteSeatAvailability(SeatAvailability a) throws DBException {
		// PreparedStatement smt3 = null;

		// Connection com = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "delete from seat_availability  where ship_id=? and journey_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt3 = com.prepareStatement(sql3);
				statement.setInt(1, a.getShipId());
				statement.setInt(2, a.getJourneyId());
				// logger.debug(sql);

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

	public String getEmail(int userId) throws DBException {
		String email = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sqlselect = "select email from user_detail where user_id in (select user_id from booking_detail where ticket_status='ordered' and user_id=?)";
			try (PreparedStatement stm = connection.prepareStatement(sqlselect);) {
				stm.setInt(1, userId);
				try (ResultSet value = stm.executeQuery();) {
//				String email = "";
					// System.out.println("!!");
					if (value.next()) {
						email = value.getString("email");
						LOGGER.debug("emailID:" + email);

					}
				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
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
		return email;
	}

	public boolean findTicketStatusAndCost(SeatAvailability b) throws DBException {
		boolean validation = false;
		// String value = "ordered";
		String sql = "select ticket_status,cost from booking_detail where user_id = ?";
		// logger.info(sql);
		try (Connection connection = ConnectionUtil.getConnection();) {
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql);
				statement.setInt(1, b.getUserNo());
				{
					try (ResultSet result = statement.executeQuery();) {

						// logger.debug(sql);
						if (result.next()) {
							LOGGER.debug("status:" + result.getString("ticket_status"));
							LOGGER.debug("total:" + result.getInt("cost"));
							// String sqlselect = "select email from user_detail where user_id in (select
							// user_id from booking_detail where ticket_status='ordered' and user_id=?)";

							/*
							 * try (PreparedStatement stm = connection.prepareStatement(sqlselect);) {
							 * stm.setInt(1, b.getUserNo()); // logger.info(sqlselect); ResultSet value =
							 * stm.executeQuery(); // logger.debug(value2);
							 * 
							 * String email = ""; // System.out.println("!!"); if (value.next()) { email =
							 * value.getString("email"); logger.debug("emailID:" + email);
							 */
							validation = result.getString("ticket_status").equalsIgnoreCase("ordered");

							// new ServiceShipTicket().sendMail(validation, email, b.getUserNo());
							/*
							 * if (validation) { SendSmsIml.send("sivanathan011198@gmail.com", "8608872041",
							 * email, " Your Application is ordered ", "stay tuned for further update",
							 * b.getUserNo()); }
							 */
						}
						/*
						 * } catch (SQLException e) { e.printStackTrace(); //
						 * logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e); throw new
						 * DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e); }
						 */
						// getEmail(b.getUserNo());
					} catch (SQLException e) {
						// e.printStackTrace();
						LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
						// logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
						throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
					}
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
		return validation;

	}

	public void procedure(SeatAvailability b) throws DBException {
		// String value = "ordered";
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "call TICKET_BOOKING(?,?,?,?,?,?)";
			try (CallableStatement statement = connection.prepareCall(sql);) {

				statement.setInt(1, b.getUserNo());
				statement.setInt(2, b.getShipNo());
				statement.setInt(3, b.getJourneyNo());
				statement.setInt(4, b.getBookingSeats());
				statement.setString(5, b.getTicketStatus());
				statement.setInt(6, b.getCost());

				// LOGGER.debug(b);
				statement.execute();
				// findTicketStatusAndCost(b);
				// System.out.println(b.getTicketStatus());

				/*
				 * String sql =
				 * "select ticket_status,cost from booking_detail where user_id = ?"; try
				 * (PreparedStatement smt4 = com.prepareStatement(sql);) { // smt4 =
				 * com.prepareStatement(sql); smt4.setInt(1, b.getuserNo()); { try (ResultSet
				 * value1 = smt4.executeQuery();) {
				 * 
				 * logger.debug(sql4); if (value1.next()) { logger.debug("status:" +
				 * value1.getString("ticket_status")); logger.debug("total:" +
				 * value1.getInt("cost")); String sqlselect =
				 * "select email from user_detail where user_id in (select user_id from booking_detail where ticket_status='ordered' and user_id=?)"
				 * ; try (PreparedStatement stm = com.prepareStatement(sqlselect);) {
				 * stm.setInt(1, b.getuserNo()); ResultSet value2 = stm.executeQuery(); //
				 * logger.debug(value2);
				 * 
				 * String email = ""; // System.out.println("!!"); if (value2.next()) { email =
				 * value2.getString("email"); logger.debug("emailID:" + email);
				 * 
				 * if (value1.getString("ticket_status").equalsIgnoreCase(value)) {
				 * SendSmsIml.send("sivanathan011198@gmail.com", "8608872041", email,
				 * " Your Application is ordered ", "stay tuned for further update",
				 * b.getuserNo()); } } } catch (Exception e) { e.printStackTrace();
				 * logger.error(ErrorMessages.INVALID_CREATESTATEMENT + e); } } } catch
				 * (Exception e) { e.printStackTrace();
				 * logger.error(ErrorMessages.INVALID_RESULTSET); } } } catch (Exception e) {
				 * e.printStackTrace(); logger.error(ErrorMessages.INVALID_PREPARESTATEMENT +
				 * e); } }
				 */ } catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_CALLABLESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_CALLABLESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_CALLABLESTATEMENT, e);
			}
		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public int costOfBooking(String b) throws DBException {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "select " + b + "(cost)as cost from booking_detail";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql4);

				try (ResultSet result = statement.executeQuery();) {
					if (result.next()) {
						cost = result.getInt("cost");
						LOGGER.debug("cost:" + cost);
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
//			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.INVALID_CONNECTIONSTATEMENT, e);
		}
		return cost;
	}

	@Override
	public int findAvailableSeats(SeatAvailability b) throws DBException {
		int seats = 0;
		try (Connection connection = ConnectionUtil.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "select available_seat from seat_availability where (ship_id =? and journey_id =?)";

			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql4);
				statement.setInt(1, b.getShipId());
				// System.out.println(b.getShipId());
				statement.setInt(2, b.getJourneyId());
				// System.out.println(b.getJourneyId());
				try (ResultSet result = statement.executeQuery();) {
					// System.out.println(sql);
					if (result.next()) {
						seats = result.getInt("available_seat");
						LOGGER.debug("availableseat:" + seats);
					}

				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// throw new Exception(ErrorMessages.INVALID_RESULTSET);
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
		return seats;

	}

	public int findTotalcost(int a, int b) throws DBException {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "select cost from booking_detail where (journey_id=? and ship_id=?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql4);
				statement.setInt(1, a);
				statement.setInt(2, b);
				try (ResultSet result = statement.executeQuery();) {
					while (result.next()) {
						cost = result.getInt("cost");

						LOGGER.debug("cost:" + cost);
					}

				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// throw new Exception(ErrorMessages.INVALID_RESULTSET);
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
		return cost;
	}

}
