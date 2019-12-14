package com.isbank.tripdetails;

public class TripDetailsPhotoBean {
	private int tripuid;
	private String title;
	public int getTripuid() {
		return tripuid;
	}
	public void setTripuid(int tripuid) {
		this.tripuid = tripuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "TripDetailsPhotoBean [tripuid=" + tripuid + ", title=" + title + "]";
	}
	
	
}
