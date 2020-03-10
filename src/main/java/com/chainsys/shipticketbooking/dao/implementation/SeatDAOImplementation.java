package com.chainsys.shipticketbooking.dao.implementation;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.shipticketbooking.dao.SeatDAO;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.mail.SendSmsIml;
import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.util.TestConnection;

public class SeatDAOImplementation implements SeatDAO {
	Logger logger = Logger.getInstance();

	public void addSeatAvailability(SeatAvailability a) {

		// Connection com = null;
		// PreparedStatement smt1 = null;
		try (Connection connection = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "insert into seat_availability(ship_id,journey_id,available_seat) values(?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				statement.setInt(1, a.getShipId());
				statement.setInt(3, a.getAvailabilitySeats());
				statement.setInt(2, a.getJourneyId());

				// logger.debug(sql);

				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS INSERTED:" + row);

			} catch (SQLException e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
	}

	public void updateSeatAvailability(SeatAvailability a) {

		// Connection com = null;
		// PreparedStatement smt2 = null;
		try (Connection connection = TestConnection.getConnection();) {

			String sql = "update seat_availability set available_seat=? where ship_id=? ";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a.getAvailabilitySeats());
				statement.setInt(2, a.getShipId());
				// smt2.setInt(3, a.getJourneyId());
				// logger.debug(sql);

				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS UPDATED:" + row);
			} catch (SQLException e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
	}

	public void deleteSeatAvailability(SeatAvailability a) {
		// PreparedStatement smt3 = null;

		// Connection com = null;
		try (Connection connection = TestConnection.getConnection();) {
			String sql = "delete from seat_availability  where ship_id=? and journey_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt3 = com.prepareStatement(sql3);
				statement.setInt(1, a.getShipId());
				statement.setInt(2, a.getJourneyId());
				// logger.debug(sql);

				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS DELETED:" + row);

			} catch (SQLException e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
	}

	public void findTicketStatusAndCost(SeatAvailability b) {
		// String value = "ordered";
		String sql = "select ticket_status,cost from booking_detail where user_id = ?";
		// logger.info(sql);
		try (Connection connection = TestConnection.getConnection();) {
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql);
				statement.setInt(1, b.getuserNo());
				{
					try (ResultSet result = statement.executeQuery();) {

						// logger.debug(sql);
						if (result.next()) {
							logger.debug("status:" + result.getString("ticket_status"));
							logger.debug("total:" + result.getInt("cost"));
							String sqlselect = "select email from user_detail where user_id in (select user_id from booking_detail where ticket_status='ordered' and user_id=?)";

							try (PreparedStatement stm = connection.prepareStatement(sqlselect);) {
								stm.setInt(1, b.getuserNo());
								// logger.info(sqlselect);
								ResultSet value = stm.executeQuery();
								// logger.debug(value2);

								String email = "";
								// System.out.println("!!");
								if (value.next()) {
									email = value.getString("email");
									logger.debug("emailID:" + email);

									if (result.getString("ticket_status").equalsIgnoreCase("ordered")) {
										SendSmsIml.send("sivanathan011198@gmail.com", "8608872041", email,
												" Your Application is ordered ", "stay tuned for further update",
												b.getuserNo());
									}
								}
							} catch (SQLException | IOException e) {
								e.printStackTrace();
								logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}

	}

	public void procedure(SeatAvailability b) {
		// String value = "ordered";
		try (Connection connection = TestConnection.getConnection();) {
			String sql = "call TICKET_BOOKING(?,?,?,?,?,?)";
			try (CallableStatement statement = connection.prepareCall(sql);) {

				statement.setInt(1, b.getuserNo());
				statement.setInt(2, b.getShipNo());
				statement.setInt(3, b.getjourneyNo());
				statement.setInt(4, b.getBookingSeats());
				statement.setString(5, b.getTicketStatus());
				statement.setInt(6, b.getCost());

				logger.debug(b);
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
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_CALLABLESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
	}

	public int costOfBooking(String b) {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection connection = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "select " + b + "(cost)as cost from booking_detail";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql4);

				try (ResultSet result = statement.executeQuery();) {
					if (result.next()) {
						cost = result.getInt("cost");
						logger.debug("cost:" + cost);
					}

				} catch (SQLException e) {
					e.printStackTrace();
					logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					// throw new Exception(ErrorMessages.INVALID_RESULTSET);
				}
			} catch (SQLException e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
		return cost;
	}

	@Override
	public int findAvailableSeats(SeatAvailability b) {
		int seats = 0;
		try (Connection connection = TestConnection.getConnection();) {
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
						logger.debug("availableseat:" + seats);
					}

				} catch (SQLException e) {
					e.printStackTrace();
					// throw new Exception(ErrorMessages.INVALID_RESULTSET);
					logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
				}
			} catch (SQLException e) {

				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
		return seats;

	}

	public int findTotalcost(int a, int b) {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection connection = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql = "select cost from booking_detail where (journey_id=? and ship_id=?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				// smt4 = com.prepareStatement(sql4);
				statement.setInt(1, a);
				statement.setInt(2, b);
				try (ResultSet result = statement.executeQuery();) {
					while (result.next()) {
						cost = result.getInt("cost");

						logger.debug("cost:" + cost);
					}

				} catch (SQLException e) {
					e.printStackTrace();
					// throw new Exception(ErrorMessages.INVALID_RESULTSET);
					logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
				}
			} catch (SQLException e) {

				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
			}
		} catch (SQLException | DBException e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
		}
		return cost;
	}

}
