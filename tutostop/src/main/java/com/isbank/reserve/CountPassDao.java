package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountPassDao {
	public int CountPassenger(int tripuid) {

		System.out.println("CountPassenger giriş yapıldı");
		String sql = "SELECT count(*) as col1  FROM tripassignment WHERE tripuid = ?";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		int passNumber = 0;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			rs = st.executeQuery();

			while (rs.next()) {
				String passNum = rs.getString("col1");
				passNumber = Integer.parseInt(passNum);
				System.out.println(passNumber + "is the total number of passenger for this trip.");
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return passNumber;
	}
}
