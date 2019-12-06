package com.isbank.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao 
{	
	public void RegisterUser(String uname, String last_name, String user_name, String pass, String address, String contact) 
	{
		String sql = "INSERT INTO login (uname, pass, lastname, username, address, contactNo) VALUES (?,?,?,?,?,?)";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		
		System.out.println("reigster dao içindeyiz");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			st.setString(3, last_name);
			st.setString(4, user_name);
			st.setString(5, address);
			st.setString(6, contact);
			st.executeUpdate();
			st.close(); 
	        con.close();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
