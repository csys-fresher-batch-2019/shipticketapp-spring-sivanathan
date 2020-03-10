package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chainsys.shipticketbooking.dao.AdminDAO;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class AdminDAOImplementation implements AdminDAO {

	public boolean adminExist(int adminId, String pass) throws DBException

	{
		Logger logger = Logger.getInstance();

		try (Connection connection = ConnectionUtil.getConnection();) {
			try (Statement stmt = connection.createStatement();) {

				String sql = "select pass_word from AdminRegister where Admin_id=" + adminId + "";
				try (ResultSet resultset = stmt.executeQuery(sql);) {
					if (resultset.next()) {
						String password = resultset.getString("pass_word");

						if (pass.equals(password)) {
							return true;
						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
					//logger.error(ErrorMessages.INVALID_RESULTSET + "" + e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET,e);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_CREATESTATEMENT,e);
				// logger.error("Exception"+e);
			}
		} catch (DBException | SQLException e) {
			e.printStackTrace();
			//logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE,e);
		}
		return false;
	}
}
