package com.isbank.showtrip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowTripsServlet")
public class ShowTripsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowTripService tripService = new ShowTripService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String startLocation = request.getParameter("staloc");
		String finishLocation = request.getParameter("finloc");
		String tripDateTime = request.getParameter("tripdatetime");
		
		
		String passengerBaggage = request.getParameter("PassengerBaggage");
		String possibleBoardingPoint = request.getParameter("PossibleBoardingPoint");
		String userName = (String) session.getAttribute("username");
		request.getSession().setAttribute("PassengerBaggage", passengerBaggage);
		request.getSession().setAttribute("PossibleBoardingPoint", possibleBoardingPoint);
		
		request.setAttribute("propertyList", tripService.retrieveTrips(startLocation, finishLocation, tripDateTime));
		//lookfortrip formuyla beraber, olası yolculukları listeledir ve propertylist attribute'una atadık.
		
		request.setAttribute("activeList", tripService.retrieveAssignedTrips(userName));
		//kullanıcının aktif olarak atanmış olduğu yolculukların tripuid'sini getirir. 
		
		System.out.println("---------------Assigned Trip List Outputs-------------------------------------");
		System.out.println("Assigned Trips listsize: " + (tripService.retrieveAssignedTrips(userName)).size());
		System.out.println("Assigned Trips listesinin elemanları yazdırılıyor.");
		
		System.out.println(tripService.retrieveAssignedTrips(userName));
		
		System.out.println("Assigned Trip List Outputs Yazdırıldı.");
		System.out.println("----------------------BİTTİ-----------------------------------------");
		
		System.out.println("---------------Aranan Gezilerin Listesi-------------------------------------");
		System.out.println("Assigned Trips listsize: " + (tripService.retrieveAssignedTrips(userName)).size());
		System.out.println("Assigned Trips listesinin elemanları yazdırılıyor.");
		
		System.out.println(tripService.retrieveTrips(startLocation, finishLocation, tripDateTime));
		System.out.println("Assigned Trip List Outputs Yazdırıldı.");
		System.out.println("---------------------BİTTİ------------------------------------------");
		
		
		request.getRequestDispatcher("/ShowWantedTrips.jsp").forward(request, response);
	}
}