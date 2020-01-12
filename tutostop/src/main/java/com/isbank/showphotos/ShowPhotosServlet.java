package com.isbank.showphotos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isbank.uploadphotos.ShowPhotosService;

@WebServlet("/ShowPhotosServlet")
public class ShowPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowPhotosService photoService = new ShowPhotosService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ShowPhotosServlet doGet metodu içine girildi.");
		int tripuid = Integer.parseInt(request.getParameter("tripuid"));
		
		System.out.println("Fotosu gösterilmek istenen gezi id'si: " + tripuid);
		System.out.println("gezide bulunan toplam foto sayısı: " + photoService.retrievePhotos(tripuid).size());
		
        request.setAttribute("photoList", photoService.retrievePhotos(tripuid));
        request.getRequestDispatcher("/ViewTripPhotos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}