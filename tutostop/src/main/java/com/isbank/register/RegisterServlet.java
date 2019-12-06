package com.isbank.register;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("register dopost'a giriş yapıldı.");
		String uname 		= request.getParameter("name");
		String last_name 	= request.getParameter("last_name");
		String username 	= request.getParameter("username");
		String pass 		= request.getParameter("password");
		String address 		= request.getParameter("address");
		String contact 		= request.getParameter("contact");
		
		RegisterDao dao = new RegisterDao();
		dao.RegisterUser(uname, last_name, username, pass, address, contact);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}
}
