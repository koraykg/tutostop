package com.isbank.showphotos;

public class Photos {
	private String base64Image;
	private int photouid;
	private int tripuid;
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public int getPhotouid() {
		return photouid;
	}
	public void setPhotouid(int photouid) {
		this.photouid = photouid;
	}
	public int getTripuid() {
		return tripuid;
	}
	public void setTripuid(int tripuid) {
		this.tripuid = tripuid;
	}
	
	@Override
	public String toString() {
		return "Photos [base64Image=" + base64Image + ", photouid=" + photouid + ", tripuid=" + tripuid + "]";
	}
}
