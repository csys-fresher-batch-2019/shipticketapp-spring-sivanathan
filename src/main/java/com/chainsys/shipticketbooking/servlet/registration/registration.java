package com.chainsys.shipticketbooking.servlet.registration;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ServiceShipTicket m1 = new ServiceShipTicket();
		User u1 = new User();
		String name = request.getParameter("name");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String date = request.getParameter("dob");// 2020-01-01\
		LocalDate dob = LocalDate.parse(date);
		long contactNumber = Long.parseLong(request.getParameter("contactnumber"));
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		System.out.println(u1);
		// System.out.println(password);
		u1.setUserId(userId);
		u1.setUserName(name);
		u1.setDateOfBirth(dob);
		u1.setContactNumber(contactNumber);
		u1.setGender(gender);
		u1.setPassword(password);
		u1.setEmail(email);

		try {
			m1.addUser(u1);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("register.jsp");
		}

	}
}