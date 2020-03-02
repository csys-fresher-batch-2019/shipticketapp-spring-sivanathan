package com.chainsys.shipticketbooking.mail;

import java.io.IOException;

public class SendMail {
	public static void main(String[] args) throws IOException {

		SendSmsIml.send("sivanathan011198@gmail.com", "8608872041", "sivanathan1998@gmail.com",
				" Your Application is ordered ", "stay tuned for further update", 1001);
	}
}