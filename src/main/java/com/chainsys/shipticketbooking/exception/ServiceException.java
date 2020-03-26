package com.chainsys.shipticketbooking.exception;

import java.io.IOException;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	public ServiceException(String msg, DBException e) {
		super(msg, e);
	}

	public ServiceException(String adminLoginFailed, ValidatorException e) {
		super(e);
	}

	public ServiceException(String noDataFound, IOException e) {
		super(e);
	}

	public ServiceException(String msg, ServiceException e) {
		super(e);
	}
}
