package com.chainsys.shipticketbooking.servlet.registration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.ShipDetail;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Ind")
public class Ind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceShipTicket m4 = new ServiceShipTicket();
		ShipDetail s = new ShipDetail();
		Logger logger = Logger.getInstance();
		String source = request.getParameter("sourceplace");
		String destination = request.getParameter("destinationplace");
		logger.info(source + "-" + destination);
		s.setSourcePlace(source);
		s.setDestinationPlace(destination);
		// ArrayList<ShipDetail> getShip(ShipDetail s)

		try {
			ArrayList<ShipDetail> value = m4.getShip(s);
			logger.info(value);
			request.setAttribute("id", value);
			RequestDispatcher dis = request.getRequestDispatcher("ind2.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// throw new ("exception");

			RequestDispatcher dis = request.getRequestDispatcher("ind.jsp");
			dis.forward(request, response);

		}
	}
}
