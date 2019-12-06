package com.isbank.reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class ReservationEmailDao 
{	
	public void SendReservationEmail(String tripuid, String eMail) throws EmailException 
	{
		String sql = "SELECT * FROM tripannouncement where tripuid = ?" ;
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		String startLoc = null;
		String finLoc = null;
		String tripTime = null;
		ResultSet rs = null;
		System.out.println("ReservationEmailDao sınıfı çağrıldı.");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tripuid);
			rs = st.executeQuery();
			
			while (rs.next()) {
				startLoc = rs.getString("startLocation");
				finLoc = rs.getString("finishLocation");
				tripTime = rs.getString("tripDateTime");
			} 
			st.close(); 
	        con.close(); 
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthentication("tutostoptutom@gmail.com", "tutostop2019");
		email.setSSLOnConnect(true);
		email.setFrom("tutostoptutom@gmail.com");
		email.setSubject("ASSIGNMENT TO NEW ROAD TRIP!");
		email.setMsg("You are successfully added to the destination (from " + startLoc + " to " + finLoc + " at " + tripTime +"). Hope you have a good trip!");
		email.addTo(eMail);
		email.addCc("semakamisli@gmail.com");
		email.send();
	}
}
