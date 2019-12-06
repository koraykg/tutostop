package com.isbank.profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProfileTripsAsPassengerDao {
	public List<ProfileTripBean> showTripAsPassenger(String userName) {

		System.out.println("profiletripsdao'ya giriş yapıldı");
		String sql = "select * from tripannouncement where tripuid in (select tripuid from mydb.tripassignment where UserName= ?); ";//tarih kontrolü de buraya sonradan eklenmeli.
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("jdbc bağlantısı gerçekleştirildi");
		List<ProfileTripBean> tripList=new ArrayList<ProfileTripBean>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			rs = st.executeQuery();

			while (rs.next()) {
				String startLocBean = rs.getString("startLocation");
				String finLocBean = rs.getString("finishLocation");
				String tripTimeBean = rs.getString("tripDateTime");
				String priceBean = rs.getString("price");
				ProfileTripBean showYourTripBean=new ProfileTripBean();
				showYourTripBean.setStartLocBean(startLocBean);
				showYourTripBean.setFinLocBean(finLocBean);
				showYourTripBean.setTripTimeBean(tripTimeBean);
				showYourTripBean.setPriceBean(priceBean);
				tripList.add(showYourTripBean);
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
