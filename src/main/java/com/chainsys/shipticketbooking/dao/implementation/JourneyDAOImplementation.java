package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.shipticketbooking.dao.JourneyDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.Journey;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class JourneyDAOImplementation implements JourneyDAO {
	Connection com = null;
	Logger logger = Logger.getInstance();

	public void saveJourney(Journey a) throws DBException {
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "insert into journey_detail(journey_id,source_date,destination_date,ship_id)values(?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a.getJourneyId());
				java.sql.Date date2 = java.sql.Date.valueOf(a.getSourceDate());
				statement.setDate(2, date2);
				java.sql.Date date3 = java.sql.Date.valueOf(a.getDestinationDate());
				statement.setDate(3, date3);
				statement.setInt(4, a.getShipId());
				// logger.debug(sql);
				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS INSERTED:" + row);
			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT,e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			//logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE,e);
		}
	}

	public void updateJourney(Journey a) throws DBException {
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "update journey_detail set destination_date=? where ship_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				java.sql.Date date4 = java.sql.Date.valueOf(a.getDestinationDate());
				statement.setDate(1, date4);
				statement.setInt(2, a.getShipId());
//				logger.debug(sql);

				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS UPDATED:" + row);
			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT,e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			//logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE,e);
		}
	}

	public void deleteJourney(Journey a) throws DBException {
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "delete from journey_detail  where ship_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a.getShipId());
//				logger.debug(sql);

				int row = statement.executeUpdate();
				logger.debug("NO OF ROWS DELETED:" + row);

			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT,e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			//logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE,e);
		}
	}

	public ArrayList<Journey> findAllJourney(int a) throws DBException {
		ArrayList<Journey> list = new ArrayList<Journey>();
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "select journey_id,source_date,destination_date,ship_id from journey_detail where ship_id =?";
			// String sql4 = "select * from journey_detail where destination_date between ?
			// and ?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, a);
				// logger.debug(sql);
				try (ResultSet result = statement.executeQuery();) {

					while (result.next()) {
						Journey journey = new Journey();
						journey.setJourneyId(result.getInt("journey_id"));
						journey.setSourceDate(result.getDate("source_date").toLocalDate());
						journey.setDestinationDate(result.getDate("destination_date").toLocalDate());
						journey.setShipId(result.getInt("ship_id"));
						list.add(journey);
						logger.debug(journey);

					}
				} catch (SQLException e) {
					e.printStackTrace();
					//logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET,e);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT,e);
			}
		} catch (SQLException | DBException e) {
			e.printStackTrace();
			//logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE,e);
		}
		return list;

	}

}