package com.isbank.uploadphotos;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.isbank.profile.ProfileService;

/*@WebServlet: marks this servlet so that the servlet container will load it at startup, and map it to the URL pattern /uploadServlet.
@MultipartConfig: indicates this servlet will handle multipart request. We restrict maximum size of the upload file up to 16 MB. */

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService tripService = new ProfileService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("UploadPhotosServlet'e istek gönderildi doPost");
		InputStream inputStream = null; // input stream of the upload file
		int tripuid = Integer.parseInt(request.getParameter("tripuid"));
		System.out.println("UploadPhotosServlet tripuid = " + tripuid);
		
		// obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        String message = null;  // message will be sent back to client
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        	
        
        InsertTripPhotosDao dao = new InsertTripPhotosDao();
        dao.insertTrip(inputStream, message, tripuid);
            
        // sets the message in request scope
        request.setAttribute("Message", message);
        request.setAttribute("tripuid",tripuid);
         
        request.setAttribute("tripuid", Integer.parseInt(request.getParameter("tripuid")));
		request.setAttribute("propertyList", tripService.retrieveTripInfoDetails(tripuid));
		request.setAttribute("passengerList", tripService.retrievePassengers(tripuid));
		request.getRequestDispatcher("/TripDetails.jsp").forward(request, response);
        }
	}

