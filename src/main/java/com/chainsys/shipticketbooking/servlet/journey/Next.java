package com.chainsys.shipticketbooking.servlet.journey;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.Journey;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Next")
public class Next extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceShipTicket m4 = new ServiceShipTicket();
		Logger logger = Logger.getInstance();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int ship = Integer.parseInt(request.getParameter("shipid"));
		logger.info(ship);
		try {
			ArrayList<Journey> value = m4.getJourney(ship);
			logger.info(value);
			HttpSession session = request.getSession();
			session.setAttribute("journey12", value);
			RequestDispatcher dis = request.getRequestDispatcher("next1.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("next.jsp");
			e.printStackTrace();
			throw new ServletException("Servlet exception", e);

		}

	}

}
