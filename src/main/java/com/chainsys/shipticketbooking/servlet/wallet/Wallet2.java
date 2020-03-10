package com.chainsys.shipticketbooking.servlet.wallet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.ServiceShipTicket;

@WebServlet("/Wallet2")
public class Wallet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//WalletAPI wallet = new WalletAPI();
		Logger logger = Logger.getInstance();
		ServiceShipTicket m4 = new ServiceShipTicket();
		int user_id=Integer.parseInt("userid");
		/*
		 * String name = request.getParameter("merchantId"); long contactNumber =
		 * Long.parseLong(request.getParameter("MobileNo")); float amount =
		 * Float.parseFloat(request.getParameter("amount"));
		 */
		logger.info(user_id);
		/*
		 * logger.info(name); logger.info(contactNumber); logger.info(amount);
		 */
	
		
	}

}
