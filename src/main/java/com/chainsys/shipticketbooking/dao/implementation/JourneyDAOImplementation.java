package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsys.shipticketbooking.dao.JourneyDAO;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.Journey;
import com.chainsys.shipticketbooking.util.TestConnection;

public class JourneyDAOImplementation implements JourneyDAO {
	Connection com = null;
	Logger logger = Logger.getInstance();

	public void saveJourney(Journey a) {
		try (Connection com = TestConnection.getConnection();) {

			String sql1 = "insert into journey_detail(journey_id,source_date,destination_date,ship_id)values(?,?,?,?)";
			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {
				smt1.setInt(1, a.getJourneyId());
				java.sql.Date date2 = java.sql.Date.valueOf(a.getSourceDate());
				smt1.setDate(2, date2);
				java.sql.Date date3 = java.sql.Date.valueOf(a.getDestinationDate());
				smt1.setDate(3, date3);
				smt1.setInt(4, a.getShipId());
				logger.debug(sql1);
				int row1 = smt1.executeUpdate();
				logger.debug(row1);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public void updateJourney(Journey a) {
		try (Connection com = TestConnection.getConnection();) {

			String sql2 = "update journey_detail set destination_date=? where ship_id=?";
			try (PreparedStatement smt2 = com.prepareStatement(sql2);) {
				java.sql.Date date4 = java.sql.Date.valueOf(a.getDestinationDate());
				smt2.setDate(1, date4);
				smt2.setInt(2, a.getShipId());
				logger.debug(sql2);

				int row2 = smt2.executeUpdate();
				logger.debug(row2);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public void deleteJourney(Journey a) {
		try (Connection com = TestConnection.getConnection();) {

			String sql3 = "delete from journey_detail  where ship_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) {
				smt3.setInt(1, a.getShipId());
				logger.debug(sql3);

				int row3 = smt3.executeUpdate();
				logger.debug(row3);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
		}
	}

	public ArrayList<Journey> findAllJourney(int a) {
		ArrayList<Journey> list = new ArrayList<Journey>();
		try (Connection com = TestConnection.getConnection();) {

			String sql4 = "select * from journey_detail where ship_id =?";
			// String sql4 = "select * from journey_detail where destination_date between ?
			// and ?";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {
				smt4.setInt(1, a);
				logger.debug(sql4);
				try (ResultSet rs4 = smt4.executeQuery();) {

					while (rs4.next()) {
						Journey journey = new Journey();
						journey.setJourneyId(rs4.getInt("journey_id"));
						journey.setSourceDate(rs4.getDate("source_date").toLocalDate());
						journey.setDestinationDate(rs4.getDate("destination_date").toLocalDate());
						journey.setShipId(rs4.getInt("ship_id"));
						list.add(journey);
						System.out.println(journey);

					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(ErrorMessages.INVALID_RESULTSET);
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
		}
		return list;

	}

}