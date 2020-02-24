package com.chainsys.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.user.User;
import com.chainsys.util.ServiceShipTicket;

@WebServlet("/UpdateContactNumber")
public class UpdateContactNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceShipTicket m4=new ServiceShipTicket();
		User a=new User();
		//PrintWriter out=response.getWriter();
		int user_id=Integer.parseInt(request.getParameter("userid"));
		//String email = request.getParameter("email");
		long contactnumber = Long.parseLong(request.getParameter("contactnumber"));
		System.out.println(user_id + "-" + contactnumber);
		a.setContactNumber(contactnumber);
		a.setUserId(user_id);
		try {
			m4.updateUser(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("updatecontact.jsp");
		}
	}

}
