package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static Connection getConnection() throws Exception {
		Logger logger = Logger.getInstance();
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
			// "system", "oracle");
			// it is used to communicate with url
			con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "sivanathan", "sivanathan");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
		}

		return con;
	}// ctrl+shift+o to add all import
	/*
	 * public static Jdbi getJdbi() { Jdbi jdbi=null; Connection connection; try {
	 * connection = getConnection(); jdbi=Jdbi.create(connection);
	 * jdbi.installPlugin(new SqlObjectPlugin()); } catch (Exception e) { throw new
	 * RuntimeException(e); }
	 * 
	 * return jdbi; }
	 */
}
