package com.project.shipticket.admin.admin7;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.model.Journey;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Admin7")
public class Admin7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceShipTicket m1 = new ServiceShipTicket();
		Journey u1 = new Journey();

		int shipId = Integer.parseInt(request.getParameter("shipid"));

		int journeyid = Integer.parseInt(request.getParameter("journeyid"));
		
		String source = request.getParameter("sourceplace");
		LocalDate sourceplace = LocalDate.parse(source);
		
		String destination = request.getParameter("destinationplace");
		LocalDate destinationplace = LocalDate.parse(destination);
		System.out.println(source + destination);		
		u1.setDestinationDate(destinationplace);;
		u1.setSourceDate(sourceplace);;
		u1.setJourneyId(journeyid);;
		u1.setShipId(shipId);
		System.out.println(u1);
		try {
			m1.addJourney(u1);
			//response.sendRedirect("admin8.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
	}

}
