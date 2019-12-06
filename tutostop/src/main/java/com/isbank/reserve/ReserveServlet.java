package com.isbank.reserve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

import com.isbank.showtrip.ShowTripService;


@WebServlet("/Reserve")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowTripService passNumService = new ShowTripService();
	private ShowTripService isActivelyAssignToRelatedTripService = new ShowTripService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Reserve Servlet doGet giriş yapıldı");
		HttpSession session = request.getSession();
		int tripuid = Integer.parseInt(request.getParameter("tripuid"));
		System.out.println("reserve edilmek istenen yolculuğun tripuid değer: " + tripuid);
		System.out.println(session.getAttribute("PassengerBaggage"));
		String passengerBaggage = (String) session.getAttribute("PassengerBaggage");
		String possBoardPoint = (String) session.getAttribute("PossibleBoardingPoint");
		String userName = (String) session.getAttribute("username");
		String EMailInfo = (String) session.getAttribute("EMailInfo");
		
		System.out.println(passengerBaggage  + " " + possBoardPoint  + " " + tripuid + " " + userName );
		
		int passNumber = passNumService.retrievePassNum(tripuid);
		System.out.println("yolcu sayisi:" + passNumber);
		
		int isActivelyAssignToRelatedTrip = isActivelyAssignToRelatedTripService.RetrieveAssignedToRelatedTrip(tripuid, userName);
		System.out.println("isActivelyAssignToRelatedTrip değeri:" + isActivelyAssignToRelatedTrip);
		
		
		if (passNumber > 4) {												//yolcusu olmak istenen ilana önceden 4 kişi rezerve ettiyse, kabul edilmez
			System.out.println("yolcu siniri dolmustur. bu sebeple ekleme yapilamamistir.");
			response.sendRedirect("NoSuccessAssign.jsp");
		} else {															// yukarıdaki koşullar sağlanmazsa, o yolculuğa ataması yapılır.
			ReserveInsertAssignmentDao dao = new ReserveInsertAssignmentDao();
			dao.ReserveTripDao(tripuid, userName, passengerBaggage, possBoardPoint);
			
			ReserveUpdateTripDao daoUpdate = new ReserveUpdateTripDao();
			daoUpdate.ReserveUpdateTrip(tripuid);
			
			ReservationEmailDao daoEmail = new ReservationEmailDao();
			try {
				daoEmail.SendReservationEmail(request.getParameter("tripuid"), EMailInfo);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ReserveUpdateIsActive daoUpdateIsActive = new ReserveUpdateIsActive();
			daoUpdateIsActive.UpdateIsActive(userName);	
			
			System.out.println("reservasyon yapma konusunda bir sakinca yoktur.");
	        response.sendRedirect("SuccessAssign.jsp");	
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
