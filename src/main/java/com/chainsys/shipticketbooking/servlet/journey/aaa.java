package com.chainsys.shipticketbooking.servlet.journey;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/aaa")
public class aaa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ServiceShipTicket m1 = new ServiceShipTicket();
		SeatAvailability u1 = new SeatAvailability();
		Logger logger = Logger.getInstance();
		int value1 = 10202;
		int value2 = 10707;

		int booking = Integer.parseInt(request.getParameter("booking"));// 2020-01-01\
		HttpSession session = request.getSession();
		session.setAttribute("journey", booking);

		logger.info(booking);

		int shipId = Integer.parseInt(request.getParameter("shipid"));
		logger.info(shipId);

		HttpSession session1 = request.getSession();
		session1.setAttribute("shipid", shipId);

		u1.setShipId(shipId);
		u1.setJourneyId(booking);

		if (value1 == booking) {
			try {
				int availableseats = m1.seat(u1);
				session.setAttribute("seats", availableseats);
				RequestDispatcher dispatcher = request.getRequestDispatcher("booking1.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (value2 == booking) {
			try {
				int availableseats = m1.seat(u1);
				session.setAttribute("seats", availableseats);
				RequestDispatcher dispatcher = request.getRequestDispatcher("booking2.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("aaa.jsp");
			}

		}
	}
}