package com.isbank.uploadphotos;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTripPhotosDao 
{	
	public String insertTrip(InputStream inputStream, String message, int tripuid) 
	{
		String sql = "insert into tripphotos (tripuid, photo) VALUES(?,?)" ;
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                st.setInt(1, tripuid);
                st.setBlob(2, inputStream);
            }
			int rs = st.executeUpdate();
			
			if (rs > 0) {
                message = "File uploaded and saved into database";
            }
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			message = "ERROR: " + e.getMessage();
			e.printStackTrace();
		} 
		
		return message;
	}
}
