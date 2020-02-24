package com.chainsys.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.shipdetails.ShipDetail;
import com.chainsys.util.ServiceShipTicket;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UserDAOImplementation m4 = new UserDAOImplementation();
		ServiceShipTicket m4=new ServiceShipTicket();
		PrintWriter out=response.getWriter();
		int user_id=Integer.parseInt(request.getParameter("userid"));
		//String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(user_id + "-" + password);
		try {
			boolean value = m4.User(user_id,password);
			System.out.println(value);
			if(value)
					{
				HttpSession session=request.getSession();
				session.setAttribute("logged", user_id);
				out.print("logging successful");
				ArrayList<ShipDetail> value1=  m4.Ship();
				System.out.println(value1);
				
				HttpSession session1=request.getSession();
				session1.setAttribute("ship",value1);
				RequestDispatcher dispatcher= request.getRequestDispatcher("next.jsp");
				dispatcher.forward(request, response);
				
				
				//response.sendRedirect("next.jsp");
				
				}
			else {
				response.sendRedirect("login.jsp?errorMessage=Invalid login");
				//out.print("logging successful");
				/*HttpSession s=request.getSession();
				RequestDispatcher a=request.getRequestDispatcher("login.jsp");
				a.forward(request, response);*/
			}
				
			
			//go to next page
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
			//got to same page login.jsp request-forward
		}
	}

	
}
