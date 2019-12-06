package com.isbank.profile;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService tripService = new ProfileService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ProfileServlet'e istek gönderildi doPost");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		
		request.setAttribute("propertyList", tripService.retrieveYourTrips(userName));
		request.setAttribute("passengerList", tripService.retrieveYourTripsAsPassenger(userName));
		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
