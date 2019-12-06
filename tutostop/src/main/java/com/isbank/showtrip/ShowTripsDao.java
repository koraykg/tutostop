package com.isbank.showtrip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ShowTripsDao {
	public List<ShowTripBean> showTrip(String startLocation, String finishLocation, String tripDateTime) {

		String sql = "select * from tripannouncement where startLocation = UPPER(?) and finishLocation = UPPER(?) and tripDateTime > ? and tripDateTime < DATE_ADD(?, INTERVAL 1 DAY) and status='open' ORDER BY tripDateTime ASC";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		List<ShowTripBean> tripList=new ArrayList<ShowTripBean>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, startLocation);
			st.setString(2, finishLocation);
			st.setString(3, tripDateTime);
			st.setString(4, tripDateTime);
			rs = st.executeQuery();

			while (rs.next()) {
				String startLocBean = rs.getString("startLocation");
				String finLocBean = rs.getString("finishLocation");
				String tripTimeBean = rs.getString("tripDateTime");
				String priceBean = rs.getString("price");
				int tripuid = rs.getInt("tripuid");
				ShowTripBean showTripBean=new ShowTripBean();
				showTripBean.setStartLocBean(startLocBean);
				showTripBean.setFinLocBean(finLocBean);
				showTripBean.setTripTimeBean(tripTimeBean);
				showTripBean.setPriceBean(priceBean);
				showTripBean.setTripuid(tripuid);
				System.out.println(tripuid);
				tripList.add(showTripBean);
			} 
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return tripList;
	}
}
