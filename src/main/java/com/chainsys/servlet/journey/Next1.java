package com.chainsys.servlet.journey;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.seatavailavility.SeatAvailability;
import com.chainsys.util.ServiceShipTicket;


@WebServlet("/Next1")
public class Next1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int value1 = 10202;
		int value2 = 10707;
		int value3=10303;
		int value4=10808;
		int value5=10404;
		int value6=10707;
		int value7=10505;
		int value8=10606;
		
		ServiceShipTicket m4=new ServiceShipTicket();
		SeatAvailability u1 = new SeatAvailability();
		
		int journey=Integer.parseInt(request.getParameter("journeyid"));
		System.out.println(journey);
		
		HttpSession session5 = request.getSession();
		session5.setAttribute("name", journey);
		
		int shipId=Integer.parseInt(request.getParameter("shipid"));
		System.out.println(shipId);

		HttpSession session6 = request.getSession();
		session6.setAttribute("sid", shipId);
		
		u1.setJourneyId(journey);
		u1.setShipId(shipId);
		
		
		
		try {
			int cost=m4.Totalcost(shipId, journey);
			System.out.println(cost);
			HttpSession session9 = request.getSession();
			session9.setAttribute("cost", cost);
			int availableseats=m4.seat(u1);
			System.out.println(availableseats);
			HttpSession session1 = request.getSession();
			session1.setAttribute("seats", availableseats);
			RequestDispatcher dispatcher = request.getRequestDispatcher("booking1.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("next1.jsp");
		}
		
		
		
	}
}