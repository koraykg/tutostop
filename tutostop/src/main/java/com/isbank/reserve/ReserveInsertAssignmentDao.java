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
		System.out.println("ReserveInsertAssignmentDao sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ReserveInsertAssignmentDao1");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("ReserveInsertAssignmentDao11");
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println("ReserveInsertAssignmentDao12");
			st.setInt(1, tripuid);
			System.out.println("ReserveInsertAssignmentDao13");
			st.setString(2, userName);
			System.out.println("ReserveInsertAssignmentDao14");
			st.setString(3, userName);
			System.out.println("ReserveInsertAssignmentDao15");
			st.setString(4, passengerBaggage);
			System.out.println("ReserveInsertAssignmentDao16");
			st.setString(5, possBoardPoint);
			System.out.println("ReserveInsertAssignmentDao18");
			st.setString(6, userName);
			System.out.println("ReserveInsertAssignmentDao19");
			st.executeUpdate();
			System.out.println("ReserveInsertAssignmentDao111");
			st.close();
			System.out.println("ReserveInsertAssignmentDao112");
	        con.close(); 
	        System.out.println("ReserveInsertAssignmentDao113");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ReserveInsertAssignmentDao2");
	}
}
