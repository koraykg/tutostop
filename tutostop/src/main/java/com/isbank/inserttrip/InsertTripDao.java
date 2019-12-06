package com.isbank.inserttrip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTripDao 
{	
	public void insertTrip(String startLocation, String finishLocation, String tripDateTime, String price, String uname) 
	{
		String sql = "insert into tripannouncement (startLocation, finishLocation, tripdatetime, price, tripowner, status, passengernumber) VALUES(UPPER(?), UPPER(?), ?, ?, ?, 'open', 0)" ;
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, startLocation);
			st.setString(2, finishLocation);
			st.setString(3, tripDateTime);
			st.setString(4, price);
			st.setString(5, uname);
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
