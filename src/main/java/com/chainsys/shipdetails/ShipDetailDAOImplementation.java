package com.chainsys.shipdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.util.ErrorMessages;
import com.chainsys.util.Logger;
import com.chainsys.util.TestConnection;

public class ShipDetailDAOImplementation implements ShipDetailDAO {
	Logger logger = Logger.getInstance();
	// Connection com = null;

	public void addShip(ShipDetail s)  {
		try (Connection com = TestConnection.getConnection();) {

			String sql = "insert into ship_detail(ship_id,ship_name,source_place,destination_place,total_no_of_seats,classes,amount) values(?,?,?,?,?,?,?)";
			try (PreparedStatement smt = com.prepareStatement(sql);) {
				smt.setInt(1, s.getShipId());
				smt.setString(2, s.getShipName());
				smt.setString(3, s.getSourcePlace());
				smt.setString(4, s.getDestinationPlace());
				smt.setInt(5, s.getNoOfSeats());
				smt.setString(6, s.getClasses());
				smt.setInt(7, s.getAmount());

				logger.info(sql);

				int row = smt.executeUpdate();

				logger.info(row);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
	}

	public void updateShip(ShipDetail s) {

		try (Connection com = TestConnection.getConnection();) {

			String sql1 = "update ship_detail set total_no_of_seats=? where ship_id=?";

			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {
				smt1.setInt(1, s.getNoOfSeats());
				smt1.setInt(2, s.getShipId());

				logger.info(sql1);

				int row1 = smt1.executeUpdate();
				logger.info(row1);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}

	}

	public void deleteShip(ShipDetail s) {

		try (Connection com = TestConnection.getConnection();) {

			String sql2 = "delete from ship_detail  where ship_id=?";
			try (PreparedStatement smt2 = com.prepareStatement(sql2);) {
				smt2.setInt(1, s.getShipId());
				logger.info(sql2);

				int row2 = smt2.executeUpdate();
				logger.info(row2);

			}

			catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}

	}

	public ArrayList<ShipDetail> getShip(ShipDetail s) {

		ResultSet rs = null;
		ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
		try (Connection com = TestConnection.getConnection();) {

			String sql3 = "select * from ship_detail where(source_place=? and destination_place=?)";
			// String sql3 = "select source_place,destination_place from ship_detail where
			// ship_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) {

				smt3.setString(1, s.getSourcePlace());
				smt3.setString(2, s.getDestinationPlace());
				rs = smt3.executeQuery();
				// ArrayList<ShipDetail> list=new ArrayList<ShipDetail>();

				while (rs.next()) {
					ShipDetail ship = new ShipDetail();
					ship.setAmount(rs.getInt("amount"));
					ship.setClasses(rs.getString("classes"));
					ship.setSourcePlace(rs.getString("source_place"));
					ship.setDestinationPlace(rs.getString("destination_place"));
					ship.setShipId(rs.getInt("ship_id"));
					ship.setShipName(rs.getString("ship_name"));
					ship.setNoOfSeats(rs.getInt("total_no_of_seats"));
					list.add(ship);

				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}
		return list;
	}

	public void distinctShip(String s)  {
		// PreparedStatement smt4 = null;
		ResultSet rs4 = null;
		try (Connection com = TestConnection.getConnection();) {
			String sql4 = "select distinct(" + s + ") as classes from ship_detail";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {
				rs4 = smt4.executeQuery();
				while (rs4.next()) {

					logger.info(rs4.getString("classes"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE + e);
		}

	}

public ArrayList<ShipDetail> Ship() {

	ResultSet rs1 = null;
	ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
	try (Connection com = TestConnection.getConnection();) {

		String sql3 = "select * from ship_detail";
		// String sql3 = "select source_place,destination_place from ship_detail where
		// ship_id=?";
		try (Statement stm = com.createStatement();) {
			rs1 = stm.executeQuery(sql3);
			logger.debug(rs1);
			

			while (rs1.next()) {
				ShipDetail ship = new ShipDetail();
				ship.setAmount(rs1.getInt("amount"));
				ship.setClasses(rs1.getString("classes"));
				ship.setSourcePlace(rs1.getString("source_place"));
				ship.setDestinationPlace(rs1.getString("destination_place"));
				ship.setShipId(rs1.getInt("ship_id"));
				ship.setShipName(rs1.getString("ship_name"));
				ship.setNoOfSeats(rs1.getInt("total_no_of_seats"));
				list.add(ship);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_CREATESTATEMENT + e);
		}

	} catch (Exception e) {
		e.printStackTrace();
		logger.error(ErrorMessages.CONNECTION_FAILURE + e);
	}
	return list;
}

}