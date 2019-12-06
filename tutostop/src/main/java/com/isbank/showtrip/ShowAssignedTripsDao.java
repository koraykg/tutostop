package com.isbank.showtrip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ShowAssignedTripsDao {
	public List<AssignedTripBean> ShowAssignedTrip(String userName) {

		System.out.println("ShowAssignedTripsDao giriş gerçekleşti. Ataması olan yolculukların tripuid'leri döndürülüyor.");
		String sql = "select tripuid from tripassignment where UserName = ?";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		List<AssignedTripBean> assignedTripList=new ArrayList<AssignedTripBean>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			rs = st.executeQuery();

			while (rs.next()) {
				int tripuid = rs.getInt("tripuid");
				AssignedTripBean showAssignedTripBean=new AssignedTripBean();
				showAssignedTripBean.setTripuid(tripuid);
				assignedTripList.add(showAssignedTripBean);
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		if(assignedTripList.isEmpty()) {
			System.out.println("kullanıcının tripassignment tablosunda bu aramaya yönelik ataması var mı?: " + assignedTripList.isEmpty() );
			AssignedTripBean emptyAssignedTripBean=new AssignedTripBean();
			emptyAssignedTripBean.setTripuid(-1);
			assignedTripList.add(emptyAssignedTripBean);
		}
		
		return assignedTripList;
	}
}
