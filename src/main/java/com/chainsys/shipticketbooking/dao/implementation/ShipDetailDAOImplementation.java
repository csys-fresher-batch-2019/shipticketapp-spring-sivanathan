package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.shipticketbooking.dao.ShipDetailDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.ShipDetail;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class ShipDetailDAOImplementation implements ShipDetailDAO {
	// Logger logger = Logger.getInstance();
	private static final Logger LOGGER = LoggerFactory.getLogger(ShipDetailDAOImplementation.class);
	// Connection com = null;

	public void saveShipDetail(ShipDetail s) throws DBException {
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "insert into ship_detail(ship_id,ship_name,source_place,destination_place,total_no_of_seats,classes,amount) values(?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, s.getShipId());
				statement.setString(2, s.getShipName());
				statement.setString(3, s.getSourcePlace());
				statement.setString(4, s.getDestinationPlace());
				statement.setInt(5, s.getNoOfSeats());
				statement.setString(6, s.getClasses());
				statement.setInt(7, s.getAmount());

				// logger.info(sql);

				int row = statement.executeUpdate();

				LOGGER.info("NO OF ROWS INSERTED:" + row);

			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
			}

		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public void updateShipDetail(ShipDetail s) throws DBException {

		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "update ship_detail set total_no_of_seats=? where ship_id=?";

			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, s.getNoOfSeats());
				statement.setInt(2, s.getShipId());

				// logger.info(sql);

				int row = statement.executeUpdate();
				LOGGER.info("NO OF ROWS UPDATED:" + row);
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

	public void deleteShipDetail(ShipDetail s) throws DBException {

		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "delete from ship_detail  where ship_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				statement.setInt(1, s.getShipId());
//				logger.info(sql);

				int row = statement.executeUpdate();
				LOGGER.info("NO OF ROWS DELETED:" + row);

			}

			catch (SQLException e) {
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

	public ArrayList<ShipDetail> findAllShipDetailWithSourceAndDestination(ShipDetail s) throws DBException {

		// ResultSet rs = null;
		ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "select amount,classes,source_place,destination_place,ship_id,ship_name from ship_detail where(source_place=? and destination_place=?)";
			// String sql3 = "select source_place,destination_place from ship_detail where
			// ship_id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {

				statement.setString(1, s.getSourcePlace());
				statement.setString(2, s.getDestinationPlace());
				{
					try (ResultSet result = statement.executeQuery();) {
						while (result.next()) {
							ShipDetail ship = new ShipDetail();
							ship.setAmount(result.getInt("amount"));
							ship.setClasses(result.getString("classes"));
							ship.setSourcePlace(result.getString("source_place"));
							ship.setDestinationPlace(result.getString("destination_place"));
							ship.setShipId(result.getInt("ship_id"));
							ship.setShipName(result.getString("ship_name"));
							// ship.setNoOfSeats(rs.getInt("total_no_of_seats"));
							list.add(ship);

						}
					} catch (SQLException e) {
						// e.printStackTrace();
						LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
						// throw new DBException(ErrorMessages.INVALID_RESULTSET);
						// logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
						throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
					}

					// ArrayList<ShipDetail> list=new ArrayList<ShipDetail>();

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
		return list;
	}

	public void distinctShip(String s) throws DBException {
		// PreparedStatement smt4 = null;
		// ResultSet rs4 = null;
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select distinct(" + s + ") as classes from ship_detail";
			try (PreparedStatement statement = connection.prepareStatement(sql);) {
				try (ResultSet result = statement.executeQuery();) {
					while (result.next()) {

						LOGGER.info(result.getString("classes"));
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
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}

	}

	public ArrayList<ShipDetail> findAllShip() throws DBException {

		// ResultSet rs1 = null;
		ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "select amount,classes,source_place,destination_place,ship_id,ship_name,total_no_of_seats from ship_detail";
			// String sql3 = "select source_place,destination_place from ship_detail where
			// ship_id=?";
			try (Statement statement = connection.createStatement();) {
				try (ResultSet result = statement.executeQuery(sql);) {
					// logger.debug(result);

					while (result.next()) {
						ShipDetail ship = new ShipDetail();
						ship.setAmount(result.getInt("amount"));
						ship.setClasses(result.getString("classes"));
						ship.setSourcePlace(result.getString("source_place"));
						ship.setDestinationPlace(result.getString("destination_place"));
						ship.setShipId(result.getInt("ship_id"));
						ship.setShipName(result.getString("ship_name"));
						ship.setNoOfSeats(result.getInt("total_no_of_seats"));
						list.add(ship);

					}
				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					// throw new DBException(ErrorMessages.INVALID_RESULTSET);
					// logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
				}

			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_CREATESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_CREATESTATEMENT, e);
			}

		} catch (SQLException | DBException e) {
//			e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return list;
	}

	public ArrayList<ShipDetail> routeShip() throws DBException {

		// ResultSet rs1 = null;
		ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
		try (Connection connection = ConnectionUtil.getConnection();) {

			String sql = "select route_place from ship_route";
			// String sql3 = "select source_place,destination_place from ship_detail";
			// String sql3 = "select source_place,destination_place from ship_detail where
			// ship_id=?";
			try (Statement statement = connection.createStatement();) {
				try (ResultSet result = statement.executeQuery(sql);) {
					// logger.debug(result);

					while (result.next()) {
						ShipDetail ship = new ShipDetail();

						ship.setRoutePlace(result.getString("route_place"));

						list.add(ship);

					}
				} catch (SQLException e) {
					// e.printStackTrace();

					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET, e);
				}

			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_CREATESTATEMENT, e);
				throw new DBException(ErrorMessages.INVALID_CREATESTATEMENT, e);
			}

		} catch (SQLException | DBException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return list;
	}

}