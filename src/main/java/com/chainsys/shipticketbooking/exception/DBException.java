package com.chainsys.shipticketbooking.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DBException extends Exception {
	public DBException(String msg, Exception e) {
		super(msg,e);
	}

	public DBException(String string) {
		super(string);
	}

}