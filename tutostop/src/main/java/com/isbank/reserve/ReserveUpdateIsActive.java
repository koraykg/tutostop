package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReserveUpdateIsActive 
{	
	public void UpdateIsActive (String userName) 
	{
		String sql = "UPDATE login SET AnyReservedTrip =1  where username = ? ;";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("ReserveUpdateIsActive sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
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
