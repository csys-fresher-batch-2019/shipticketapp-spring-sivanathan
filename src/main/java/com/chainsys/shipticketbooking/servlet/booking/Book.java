package com.chainsys.shipticketbooking.servlet.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.Booking;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Logger logger = Logger.getInstance();
		ServiceShipTicket s1 = new ServiceShipTicket();
		Booking b1 = new Booking();

		int shipId = Integer.parseInt(request.getParameter("shipId"));
		logger.info(shipId);

		int journeyId = Integer.parseInt(request.getParameter("journeyid"));
		logger.info(journeyId);

		int cost = Integer.parseInt(request.getParameter("cost_per_ticket"));
		logger.info(cost);

		String status = request.getParameter("ticket_status");
		logger.info(status);

		int user_id = Integer.parseInt(request.getParameter("userid"));
		logger.info(user_id);

		int seat = Integer.parseInt(request.getParameter("bookingseats"));
		logger.info(seat);

		int aseat = Integer.parseInt(request.getParameter("availableseats"));
		logger.info(aseat);

		b1.setShipId(shipId);
		b1.setJourneyId(journeyId);
		b1.setCost(cost);
		b1.setStatus(status);
		b1.setUserId(user_id);
		b1.setBookingSeats(seat);

		logger.info(b1);

		try {
			s1.addBooking(b1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("total.jsp");
			// request.SendRedirect("total.jsP");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("book.jsp");
		}

	}

}
