package com.isbank.unreserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnReserveDeleteAssignmentDao 
{	
	public void UnReserveTripDao(int tripuid, String userName) 
	{
		String sql = "DELETE FROM tripassignment where tripuid = ? and UserName = ?" ;
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("UnReserveTripDAO sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			st.setString(2, userName);
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
