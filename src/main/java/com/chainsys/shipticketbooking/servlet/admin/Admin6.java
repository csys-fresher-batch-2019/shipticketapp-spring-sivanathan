package com.chainsys.shipticketbooking.servlet.admin;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.model.ShipDetail;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Admin6")
public class Admin6 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceShipTicket m1 = new ServiceShipTicket();
		ShipDetail u1 = new ShipDetail();
		String name = request.getParameter("shipname");
		int shipId = Integer.parseInt(request.getParameter("shipid"));
		String classes = request.getParameter("classes");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int seats = Integer.parseInt(request.getParameter("totalnoofseats"));
		String source = request.getParameter("sourceplace");
		String destination = request.getParameter("destinationplace");
		// String email = request.getParameter("email");

		System.out.println(u1);
		// System.out.println(password);
		u1.setAmount(amount);
		u1.setClasses(classes);
		u1.setDestinationPlace(destination);
		u1.setNoOfSeats(seats);
		u1.setShipId(shipId);
		u1.setShipName(name);
		u1.setSourcePlace(source);

		try {
			m1.addShip(u1);
			// response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("admin6.jsp");
		}

	}

}
