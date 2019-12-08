package tripdetails;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isbank.profile.ProfileService;


@WebServlet("/TripDetails")
public class TripDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService tripService = new ProfileService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TripDetailServlet'e istek gönderildi doPost");
		int tripuid = Integer.parseInt(request.getParameter("tripuid"));
		
		request.setAttribute("propertyList", tripService.retrieveTripInfoDetails(tripuid));
		request.setAttribute("passengerList", tripService.retrievePassengers(tripuid));
		request.getRequestDispatcher("/TripDetails.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
