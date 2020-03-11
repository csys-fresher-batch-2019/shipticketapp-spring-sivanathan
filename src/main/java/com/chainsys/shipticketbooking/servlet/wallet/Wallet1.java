package com.chainsys.shipticketbooking.servlet.wallet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Wallet1")
public class Wallet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// WalletAPI wallet = new WalletAPI();
		Logger logger = Logger.getInstance();
		ServiceShipTicket m4 = new ServiceShipTicket();
		SeatAvailability seat = new SeatAvailability();

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		logger.info(user_id);
		int transaction_id = Integer.parseInt(request.getParameter("transaction_id"));
		logger.info(transaction_id);

		String name = request.getParameter("status");
		logger.info(name);
		String error = request.getParameter("errorMessages");

		logger.info(error);
		seat.setUserNo(user_id);
		if (error.equalsIgnoreCase("null")) {
			try {

				m4.findamount(seat);
				PrintWriter out = response.getWriter();
				out.write("SUCCESSFULLY BOOKED");
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// m4.findamount(seat);

	}
}