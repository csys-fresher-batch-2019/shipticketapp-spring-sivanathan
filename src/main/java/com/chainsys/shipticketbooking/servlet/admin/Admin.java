package com.chainsys.shipticketbooking.servlet.admin;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.shipticketbooking.service.ServiceShipTicket;
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServiceShipTicket m4 = new ServiceShipTicket();

		int id = Integer.parseInt(request.getParameter("admin_id"));
		String password = request.getParameter("password");
		System.out.println(id + "-" + password);
		
		try {
			boolean value = m4.AdminLogin(id,password);
			System.out.println(value);
			
			int value1=m4.count();
			System.out.println(value1);
			HttpSession session1=request.getSession();
			session1.setAttribute("count", value1);
			
			if(value)
					{
				HttpSession session=request.getSession();
				RequestDispatcher dispatcher= request.getRequestDispatcher("admin1.jsp");
				//session.setAttribute("email", email);
				//s.setAttribute("password", password);
				dispatcher.forward(request, response);
				//response.sendRedirect("next.jsp");
				}
			else {
				response.sendRedirect("admin.jsp?errorMessage=Invalid admin login");
				//response.sendRedirect("admin.jsp");
				/*HttpSession s=request.getSession();
				RequestDispatcher a=request.getRequestDispatcher("login.jsp");
				a.forward(request, response);*/
			}
				
			
			//go to next page
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admin.jsp");
			//got to same page login.jsp request-forward
		}
	}

	
}
