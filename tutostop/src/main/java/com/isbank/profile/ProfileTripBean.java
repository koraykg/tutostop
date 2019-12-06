package com.isbank.profile;

public class ProfileTripBean {
	private String driverName;
	private String startLocBean;
	private String finLocBean;
	private String tripTimeBean;
	private String priceBean;
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getStartLocBean() {
		return startLocBean;
	}
	public void setStartLocBean(String startLocBean) {
		this.startLocBean = startLocBean;
	}
	public String getFinLocBean() {
		return finLocBean;
	}
	public void setFinLocBean(String finLocBean) {
		this.finLocBean = finLocBean;
	}
	public String getTripTimeBean() {
		return tripTimeBean;
	}
	public void setTripTimeBean(String tripTimeBean) {
		this.tripTimeBean = tripTimeBean;
	}
	public String getPriceBean() {
		return priceBean;
	}
	public void setPriceBean(String priceBean) {
		this.priceBean = priceBean;
	}
	@Override
	public String toString() {
		return "ProfileTripBean [driverName=" + driverName + ", startLocBean=" + startLocBean + ", finLocBean="
				+ finLocBean + ", tripTimeBean=" + tripTimeBean + ", priceBean=" + priceBean + "]";
	}	
}
