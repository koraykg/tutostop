package com.isbank.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginGetUserEmail {

	public String GetUserEmail(String uname) {

		System.out.println("LoginGetUserInfo dao sınıfına giriş yapıldı.");
		String sql = "select * from login where username = ?";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		String userInfoEmail = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			rs = st.executeQuery();

			while (rs.next()) {
				userInfoEmail = rs.getString("EMail");
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return userInfoEmail;
	}
}
