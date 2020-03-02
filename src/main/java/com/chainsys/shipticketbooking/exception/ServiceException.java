package com.chainsys.shipticketbooking.exception;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	public ServiceException(String msg) {
		super(msg);
	}
}
