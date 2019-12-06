package com.isbank.inserttrip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

/**
 * Servlet implementation class InsertTripServlet
 */
@WebServlet("/InsertTripServlet")
public class InsertTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		
		String startLocation = request.getParameter("staloc");
		String finishLocation = request.getParameter("finloc");
		String tripDateTime = request.getParameter("tripdatetime");
		String price = request.getParameter("price");
		String tripOwner = (String) session.getAttribute("username");
		String tripOwnerEmail = (String) session.getAttribute("EMailInfo");
		
		InsertTripDao dao = new InsertTripDao();
		dao.insertTrip(startLocation, finishLocation, tripDateTime, price, tripOwner);
		
		InsertTripEmailDao daoEmail = new InsertTripEmailDao();
		try {
			daoEmail.SendInsertTripEmail(startLocation, finishLocation, tripDateTime, tripOwnerEmail );
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
	}
}