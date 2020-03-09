package com.chainsys.shipticketbooking.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Admin5")
public class Admin5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceShipTicket m4 = new ServiceShipTicket();
		SeatAvailability a = new SeatAvailability();
		int sid = Integer.parseInt(request.getParameter("shipid"));
		// int jid = Integer.parseInt(request.getParameter("journeyid"));
		int seat = Integer.parseInt(request.getParameter("availableseats"));
		a.setShipId(sid);
		// a.setJourneyId(jid);
		a.setAvailabilitySeats(seat);
		try {
			m4.update(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("admin5.jsp");
		}

	}

}
