package com.chainsys.shipticketbooking.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/UpdateContactNumber")
public class UpdateContactNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceShipTicket m4 = new ServiceShipTicket();
		User a = new User();
		Logger logger = Logger.getInstance();
		// PrintWriter out=response.getWriter();
		int user_id = Integer.parseInt(request.getParameter("userid"));
		// String email = request.getParameter("email");
		long contactnumber = Long.parseLong(request.getParameter("contactnumber"));
		logger.info(user_id + "-" + contactnumber);
		a.setContactNumber(contactnumber);
		a.setUserId(user_id);
		try {
			m4.updateUser(a);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("updatecontact.jsp");
			throw new ServletException(ErrorMessages.INVALID_SERVLET,e);
			
		}
	}

}
