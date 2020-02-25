package com.chainsys.seatavailavility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.util.ErrorMessages;
import com.chainsys.util.Logger;
import com.chainsys.util.SendSmsIml;
import com.chainsys.util.TestConnection;

public class SeatDAOImplementation implements SeatDAO {
	Logger logger = Logger.getInstance();

	public void add(SeatAvailability a) {

		// Connection com = null;
		// PreparedStatement smt1 = null;
		try (Connection com = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql1 = "insert into seat_availability(ship_id,journey_id,available_seat) values(?,?,?)";
			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {

				smt1.setInt(1, a.getShipId());
				smt1.setInt(3, a.getAvailabilitySeats());
				smt1.setInt(2, a.getJourneyId());

				logger.debug(sql1);

				int row = smt1.executeUpdate();
				logger.debug(row);

			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public void update(SeatAvailability a) {

		// Connection com = null;
		// PreparedStatement smt2 = null;
		try (Connection com = TestConnection.getConnection();) {

			String sql2 = "update seat_availability set available_seat=? where ship_id=? ";
			try (PreparedStatement smt2 = com.prepareStatement(sql2);) {
				smt2.setInt(1, a.getAvailabilitySeats());
				smt2.setInt(2, a.getShipId());
				// smt2.setInt(3, a.getJourneyId());
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

	public void delete(SeatAvailability a) {
		// PreparedStatement smt3 = null;

		// Connection com = null;
		try (Connection com = TestConnection.getConnection();) {
			String sql3 = "delete from seat_availability  where ship_id=? and journey_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) {
				// smt3 = com.prepareStatement(sql3);
				smt3.setInt(1, a.getShipId());
				smt3.setInt(2, a.getJourneyId());
				logger.debug(sql3);

				int row2 = smt3.executeUpdate();
				logger.debug(row2);

			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public void procedure(SeatAvailability b) {
		String value = "ordered";
		try (Connection com = TestConnection.getConnection();) {
			String sql4 = "call TICKET_BOOKING(?,?,?,?,?,?)";
			try (CallableStatement stmt = com.prepareCall(sql4);) {

				stmt.setInt(1, b.getuserNo());
				stmt.setInt(2, b.getShipNo());
				stmt.setInt(3, b.getjourneyNo());
				stmt.setInt(4, b.getBookingSeats());
				stmt.setString(5, b.getTicketStatus());
				stmt.setInt(6, b.getCost());

				logger.debug(b);
				stmt.execute();
				
				// System.out.println(b.getTicketStatus());

				String sql = "select ticket_status,cost from booking_detail where user_id = ?";
				try (PreparedStatement smt4 = com.prepareStatement(sql);) {
					// smt4 = com.prepareStatement(sql);
					smt4.setInt(1, b.getuserNo());
					{
						try (ResultSet value1 = smt4.executeQuery();) {

							logger.debug(sql4);
							if (value1.next()) {
								logger.debug("status:" + value1.getString("ticket_status"));
								logger.debug("total:" + value1.getInt("cost"));
								String sqlselect = "select email from user_detail where user_id in (select user_id from booking_detail where ticket_status='ordered' and user_id=?)";
								try (PreparedStatement stm = com.prepareStatement(sqlselect);) {
									stm.setInt(1, b.getuserNo());
									ResultSet value2 = stm.executeQuery();
									//logger.debug(value2);
									
									String email = "";
									//System.out.println("!!");
									if (value2.next()) {
										email = value2.getString("email");
										logger.debug("emailID:" + email);

										if (value1.getString("ticket_status").equalsIgnoreCase(value)) {
											SendSmsIml.send("sivanathan011198@gmail.com", "8608872041", email,
													" Your Application is ordered ", "stay tuned for further update",
													b.getuserNo());
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
									logger.error(ErrorMessages.INVALID_CREATESTATEMENT + e);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error(ErrorMessages.INVALID_RESULTSET);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_CALLABLESTATEMENT + e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public int costOfBooking(String b) {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection com = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql4 = "select " + b + "(cost)as cost from booking_detail";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {
				// smt4 = com.prepareStatement(sql4);

				try (ResultSet rs4 = smt4.executeQuery();) {
					if (rs4.next()) {
						cost = rs4.getInt("cost");
						logger.debug("cost:" + cost);
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
		return cost;
	}

	@Override
	public int seat(SeatAvailability b) {
		int seats = 0;
		try (Connection com = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql8 = "select available_seat from seat_availability where (ship_id =? and journey_id =?)";

			try (PreparedStatement smt8 = com.prepareStatement(sql8);) {
				// smt4 = com.prepareStatement(sql4);
				smt8.setInt(1, b.getShipId());
				System.out.println(b.getShipId());
				smt8.setInt(2, b.getJourneyId());
				System.out.println(b.getJourneyId());
				try (ResultSet rs8 = smt8.executeQuery();) {
					System.out.println(sql8);
					if (rs8.next()) {
						seats = rs8.getInt("available_seat");
						logger.debug("availableseat:" + seats);
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
		return seats;

	}

	public int Totalcost(int a, int b) {
		// PreparedStatement smt4 = null;
		int cost = 0;
		// Connection com = null;
		try (Connection com = TestConnection.getConnection();) {
			// com = TestConnection.getConnection();
			String sql4 = "select cost from booking_detail where (journey_id=? and ship_id=?)";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {
				// smt4 = com.prepareStatement(sql4);
				smt4.setInt(1, a);
				smt4.setInt(2, b);
				try (ResultSet rs4 = smt4.executeQuery();) {
					while (rs4.next()) {
						cost = rs4.getInt("cost");

						logger.debug("cost:" + cost);
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
		return cost;
	}

}
