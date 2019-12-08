package tripdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TripDetailsDao {
	public List<TripDetailsBean> ShowTripDetails(int tripuid) {

		System.out.println("TripDetailsDao'ya giriş yapıldı");
		String sql = "SELECT tripuid, startLocation, finishLocation, tripDateTime, price, passengernumber, tripowner FROM tripannouncement  where tripuid=?;";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		System.out.println("TripDetailsDao jdbc bağlantısı gerçekleştirildi");
		List<TripDetailsBean> tripList=new ArrayList<TripDetailsBean>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			rs = st.executeQuery();

			while (rs.next()) {
				int tripUid = rs.getInt("tripuid");
				String startLocBean = rs.getString("startLocation");
				String finLocBean = rs.getString("finishLocation");
				String tripTimeBean = rs.getString("tripDateTime");
				String priceBean = rs.getString("price");
				String totalPassenger = rs.getString("passengernumber");
				String tripOwner = rs.getString("tripowner");
				TripDetailsBean showDetailedTripBean=new TripDetailsBean();
				showDetailedTripBean.setTripuid(tripUid);
				showDetailedTripBean.setStartLocBean(startLocBean);
				showDetailedTripBean.setFinLocBean(finLocBean);
				showDetailedTripBean.setTripTimeBean(tripTimeBean);
				showDetailedTripBean.setPriceBean(priceBean);
				showDetailedTripBean.setTotalPassengerBean(totalPassenger);
				showDetailedTripBean.setTripOwnerBean(tripOwner);
				tripList.add(showDetailedTripBean);
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
