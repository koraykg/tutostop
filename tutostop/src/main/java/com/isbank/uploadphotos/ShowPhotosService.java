package com.isbank.uploadphotos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.isbank.showphotos.Photos;
import com.isbank.showphotos.ShowPhotosDao;

public class ShowPhotosService {
	private List<Photos> photoList = new ArrayList<Photos>();
	
	public List<Photos> retrievePhotos(int tripuid) throws IOException {
		System.out.println("ShowPhotosService içindeyiz: tripuid = " + tripuid);
		ShowPhotosDao dao = new ShowPhotosDao();
		photoList = dao.showPhotos(tripuid);
		return photoList;
	}
	
		public void addTrips(Photos photo) {
		photoList.add(photo);
	}
	
	public void deleteTrips(Photos photo){
		photoList.remove(photo);
	}
}
