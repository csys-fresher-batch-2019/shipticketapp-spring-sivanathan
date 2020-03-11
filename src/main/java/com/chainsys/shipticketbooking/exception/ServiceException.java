package com.chainsys.shipticketbooking.exception;

import java.io.IOException;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	public ServiceException(String msg, DBException e) {
		super(msg, e);
	}

	public ServiceException(String adminLoginFailed, ValidatorException e) {
		// TODO Auto-generated constructor stub
		super(e);
	}

	public ServiceException(String noDataFound, IOException e) {
		super(e);
	}
}
