package com.chainsys.shipticketbooking.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@WebServlet("/Forget")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		{
			// UserDAOImplementation m4 = new UserDAOImplementation();
			ServiceShipTicket m4 = new ServiceShipTicket();
			User u1 = new User();
			PrintWriter out = response.getWriter();
			int user_id = Integer.parseInt(request.getParameter("userid"));
			// String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(user_id + "-" + password);
			u1.setUserId(user_id);
			u1.setPassword(password);

			try {
				m4.resetUser(u1);
				// System.out.println(value);

				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);

			}

			// go to next page
			catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("forget.jsp");
				// got to same page login.jsp request-forward
			}

		}
	}
}
