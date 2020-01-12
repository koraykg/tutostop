package com.isbank.showphotos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ShowPhotosDao {
	public List<Photos> showPhotos(int tripuid) throws IOException {

		String sql = "select * from tripphotos where tripuid = ?";
		String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String username = "root";
		String password = "1122";
		List<Photos> photoList=new ArrayList<Photos>();
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tripuid);
			rs = st.executeQuery();
			
			/*
			int size =0;
			if (rs != null) 
			{
			  rs.last();    // moves cursor to the last row
			  size = rs.getRow(); // get row id 
			}
			
			for (int i = 0; i < size; i++) {
				System.out.println(rs.getString("col 1"));
			}*/
			
			while (rs.next()) {
                int photoUid = rs.getInt("photouid");
                System.out.println("photouid is: " + photoUid + ",");
                int tripUid = rs.getInt("tripuid");
                System.out.println("tripuid is " + tripUid);
                Blob blob = rs.getBlob("photo");
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                inputStream.close();
                outputStream.close();
                
                System.out.println("base64Image code is:" + base64Image);
                
                Photos photo = new Photos();
                photo.setPhotouid(photoUid);
                photo.setTripuid(tripUid);
                photo.setBase64Image(base64Image);
                photoList.add(photo);
            }          
             System.out.println("ShowPhotosDao içindeyiz. PhotoList'teki toplam foto sayısı:" + photoList.size());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	   
		return photoList;
	}
}
