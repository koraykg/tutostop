package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReserveInsertAssignmentDao 
{	
	public void ReserveTripDao(int tripuid, String userName, String passengerBaggage, String possBoardPoint) 
	{
		String sql = "insert into tripassignment (tripuid, PassengerFirstName, PassengerLastName, TripPartDate, PassengerBaggage, PossibleBoardingPoint, UserName) VALUES(?, (select uname from login where username=?),(select lastname from login where username=?), SYSDATE(), ?, ?, ?)" ;
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("ReserveTripDAO sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			st.setString(2, userName);
			st.setString(3, userName);
			st.setString(4, passengerBaggage);
			st.setString(5, possBoardPoint);
			st.setString(6, userName);
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
