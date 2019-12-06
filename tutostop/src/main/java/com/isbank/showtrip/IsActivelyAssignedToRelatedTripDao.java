package com.isbank.showtrip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsActivelyAssignedToRelatedTripDao {
	public int RelatedTripAssignmentCheck(int tripuid,String userName) {
		
		System.out.println("IsActivelyAssignedToRelatedTripDao giriş yapıldı");

		String sql = "select 1 from tripassignment where exists (SELECT * FROM tripassignment WHERE tripuid = ? and UserName = ?);";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		int isActivelyAssignRelatedTrip = 0;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			st.setString(2, userName);
			rs = st.executeQuery();

			while (rs.next()) {
				isActivelyAssignRelatedTrip = rs.getInt("1");
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		System.out.println("IsActivelyAssignedToRelatedTripDao sorgusundan dönen isActivelyAssignRelatedTrip değeri : " + isActivelyAssignRelatedTrip);
		
		return isActivelyAssignRelatedTrip;
	}
}
