package com.isbank.tripdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PassengerDao {
	public List<PassengerBean> RetrievePassengers(int tripuid) {

		System.out.println("PassengerDao'ya giriş yapıldı");
		String sql = "SELECT * FROM tripassignment  where tripuid = ?;";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("PassengerDao jdbc bağlantısı gerçekleştirildi");
		List<PassengerBean> passengerList=new ArrayList<PassengerBean>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			rs = st.executeQuery();

			while (rs.next()) {
				String passengerName = rs.getString("PassengerFirstName");
				PassengerBean showPassengerBean=new PassengerBean();
				showPassengerBean.setPassenger(passengerName);
				passengerList.add(showPassengerBean);
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println("PassengerDao jdbc bağlantısı kapatıldı.");
		for (int i = 0; i < passengerList.size(); i++) {
			System.out.println(passengerList.get(i));
		}
		return passengerList;
	}
}
