package com.chainsys.shipticketbooking.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.shipticketbooking.dao.AdminDAO;
import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.util.ConnectionUtil;

public class AdminDAOImplementation implements AdminDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDAOImplementation.class);

	public boolean adminExist(int adminId, String pass) throws DBException

	{
		// Logger logger = Logger.getInstance();

		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select pass_word from AdminRegister where Admin_id=?";
			try (PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setInt(1, adminId);

				try (ResultSet resultset = stmt.executeQuery();) {
					if (resultset.next()) {
						String password = resultset.getString("pass_word");

						if (pass.equals(password)) {
							return true;
						}
					}

				} catch (SQLException e) {
					// e.printStackTrace();
					LOGGER.error(ErrorMessages.INVALID_RESULTSET, e);
					throw new DBException(ErrorMessages.INVALID_RESULTSET, e);

				}
			} catch (SQLException e) {
				// e.printStackTrace();
				LOGGER.error(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error(ErrorMessages.INVALID_CREATESTATEMENT + "" + e);
				throw new DBException(ErrorMessages.INVALID_PREPARESTATEMENT, e);
				// logger.error("Exception"+e);
			}
		} catch (DBException | SQLException e) {
			// e.printStackTrace();
			LOGGER.error(ErrorMessages.CONNECTION_FAILURE, e);
			// logger.error(ErrorMessages.CONNECTION_FAILURE + "" + e);
			throw new DBException(ErrorMessages.CONNECTION_FAILURE, e);
		}
		return false;
	}
}
