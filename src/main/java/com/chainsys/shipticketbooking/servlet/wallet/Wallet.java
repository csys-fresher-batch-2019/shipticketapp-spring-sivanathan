package com.chainsys.shipticketbooking.servlet.wallet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.shipticketbooking.logger.Logger;
import com.chainsys.shipticketbooking.wallet.WalletAPI;

@WebServlet("/Wallet")
public class Wallet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		WalletAPI wallet = new WalletAPI();
		Logger logger = Logger.getInstance();

		int user_id = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("merchantId");
		long contactNumber = Long.parseLong(request.getParameter("MobileNo"));
		float amount = Float.parseFloat(request.getParameter("amount"));

		logger.info(name);
		logger.info(contactNumber);
		logger.info(amount);

		// {transactionId=183, status=SUCCESS, errorMessage=null}
		// Object resultMap=(Object)wallet.paywallet(contactNumber, name, amount);

		try {
			Map<String, Object> resultMap = wallet.paywallet(contactNumber, name, amount);

			Integer transactionId = (Integer) resultMap.get("transactionId");
			logger.info(transactionId);

			String status = (String) resultMap.get("status");
			logger.info(status);

			String error = (String) resultMap.get("error");
			logger.info(error);

			// HttpSession session = request.getSession();
			request.setAttribute("api1", transactionId);
			request.setAttribute("api2", status);
			request.setAttribute("api3", error);

			RequestDispatcher dispatcher = request.getRequestDispatcher("wallet1.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect("wallet1.jsp");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
