package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReserveUpdateTripDao 
{	
	public void ReserveUpdateTrip(int tripuid) 
	{
		String sql = "UPDATE tripannouncement SET passengernumber = (SELECT count(*) as col1  FROM tripassignment WHERE tripuid = ?)  WHERE tripuid = ?";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("ReserveUpdateTripDao sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			st.setInt(2, tripuid);
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
