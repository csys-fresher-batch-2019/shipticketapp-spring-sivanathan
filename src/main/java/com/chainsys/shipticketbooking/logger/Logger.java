package com.chainsys.shipticketbooking.logger;

public class Logger {

	private Logger() {
	}

	public static Logger getInstance() {
		Logger logger = new Logger();
		return logger;
	}

	public void debug(Object message) {
		System.out.println(message);
	}

	public void input(Object message) {
		System.out.println(message);
	}

	public void info(Object message) {
		System.out.println(message);
	}

	public void error(Object message) {
		System.err.println(message);
	}

}
