package com.chainsys.servlet.booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.booking.Booking;
import com.chainsys.util.ServiceShipTicket;
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServiceShipTicket s1=new ServiceShipTicket();
		Booking b1=new Booking();
		
		int shipId=Integer.parseInt(request.getParameter("shipId"));
		System.out.println(shipId);
		
		int journeyId=Integer.parseInt(request.getParameter("journeyid"));
		System.out.println(journeyId);
		
		int cost=Integer.parseInt(request.getParameter("cost_per_ticket"));
		System.out.println(cost);
		
		String status=request.getParameter("ticket_status");
		System.out.println(status);
		
		int user_id=Integer.parseInt(request.getParameter("userid"));
		System.out.println(user_id);
		
		int seat=Integer.parseInt(request.getParameter("bookingseats"));
		System.out.println(seat);

		int aseat=Integer.parseInt(request.getParameter("availableseats"));
		System.out.println(aseat);

		
		b1.setShipId(shipId);
		b1.setJourneyId(journeyId);
		b1.setCost(cost);
		b1.setStatus(status);
		b1.setUserId(user_id);
		b1.setBookingSeats(seat);
		
		System.out.println(b1);
		
		try {
			s1.addBooking(b1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("total.jsp");
			//request.SendRedirect("total.jsP");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("book.jsp");
		}
		
	}

}
