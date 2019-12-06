package com.isbank.login;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginTutostop")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		LoginService userInfo = new LoginService();
		
		
		if(dao.checkLogin(username, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			String eMailInfo = userInfo.retrieveUserEmail(username);
			if(eMailInfo != null) {
				session.setAttribute("EMailInfo", eMailInfo);
			} else {
				System.out.println("email bilgisi veritabanında bulunmamaktadır.");
			}
			
			request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
			System.out.println("Kullanıcı girişi başarıyla gerçekleştirildi.");
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//kullanıcı adı şifre uyumsuzluğu hatası yazdırılabilir.
		}
	}
}
