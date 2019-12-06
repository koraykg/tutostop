package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIsActivelyAssigned {
	public int isActiveAssignment(String userName) {

		String sql = "SELECT AnyReservedTrip FROM login WHERE username = ?;";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		int isActiveAssign = 0;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			rs = st.executeQuery();

			while (rs.next()) {
				isActiveAssign = Integer.parseInt(rs.getString("AnyReservedTrip"));
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return isActiveAssign;
	}
}
