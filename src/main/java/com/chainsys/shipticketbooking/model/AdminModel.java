package com.chainsys.shipticketbooking.model;

import lombok.Data;

@Data
public class AdminModel {
	private int adminId;
	private String adminName;
	private String emailId;
	private String passWord;
}
