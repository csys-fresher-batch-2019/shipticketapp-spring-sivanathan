package com.chainsys.shipticketbooking.servlet.wallet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.wallet.WalletAPI;
@WebServlet("/Wallet")
public class Wallet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		WalletAPI wallet = new WalletAPI();
		String name = request.getParameter("merchantId");
		long contactNumber = Long.parseLong(request.getParameter("MobileNo"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		System.out.println(name);
		System.out.println(contactNumber);
		System.out.println(amount);
		wallet.paywallet(contactNumber, name, amount);

	}

}
