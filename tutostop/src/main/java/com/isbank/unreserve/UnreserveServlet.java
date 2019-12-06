package com.isbank.unreserve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Unreserve")
public class UnreserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("--------------------------UnReserve Servlet doGet giriş yapıldı-----------------------------------");
		int tripuid = Integer.parseInt(request.getParameter("tripuid"));
		System.out.println("unreserve edilmek istenen yolculuğun tripuid değer: " + tripuid);
		String userName = (String) session.getAttribute("username");
		
		UnReserveDeleteAssignmentDao dao = new UnReserveDeleteAssignmentDao();
		dao.UnReserveTripDao(tripuid, userName);
			
		UnreserveUpdateTripDao daoUpdate = new UnreserveUpdateTripDao();
		daoUpdate.UnReserveUpdateTrip(tripuid);
			
	    response.sendRedirect("UnAssign.jsp");	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
