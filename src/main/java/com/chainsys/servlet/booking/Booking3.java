package com.chainsys.servlet.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.booking.Booking;
import com.chainsys.seatavailavility.SeatAvailability;
import com.chainsys.util.ServiceShipTicket;

@WebServlet("/Booking3")
public class Booking3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter(); 
		
		ServiceShipTicket s1=new ServiceShipTicket();
		
		Booking b1=new Booking();
		Booking b3=new Booking();
		SeatAvailability b2=new SeatAvailability();
		
		int shipId=Integer.parseInt(request.getParameter("shipid"));
		System.out.println(shipId);
		
		int journeyId=Integer.parseInt(request.getParameter("journeyid"));
		System.out.println(journeyId);
		
		int cost=Integer.parseInt(request.getParameter("cost_per_ticket"));
		System.out.println(cost);
		
		String status=request.getParameter("status");
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
		
		b2.setShipNo(shipId);
		b2.setBookingSeats(seat);
		b2.setuserNo(user_id);
		b2.setjourneyNo(journeyId);
		b2.setCost(cost);
		b2.setTicketStatus(status);
		
		System.out.println(b2);
		
		b3.setShipId(shipId);
		b3.setJourneyId(journeyId);
		b3.setUserId(user_id);
	
		System.out.println(b3);
		
		if(aseat>seat)
		{
		try {
			s1.addBooking(b1);
			s1.procedure(b2);
			int total_amount =s1.book(b3);
			request.setAttribute("total", total_amount);
			out.print("booking selection is successful");
			//request.setAttribute("statement", value);
			//request.setAttribute(name, o);
			RequestDispatcher dispatcher = request.getRequestDispatcher("total3.jsp");
			//request.SendRedirect("total.jsP");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		else
		{
			response.sendRedirect("booking3.jsp?errorMessage=Invalid booking");
		}

	}
	}


