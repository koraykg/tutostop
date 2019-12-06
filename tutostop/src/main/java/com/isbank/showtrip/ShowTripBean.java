package com.isbank.showtrip;

public class ShowTripBean {
	private String startLocBean;
	private String finLocBean;
	private String tripTimeBean;
	private String priceBean;
	private int tripuid;
	
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
		public int getTripuid() {
		return tripuid;
	}
	public void setTripuid(int tripuid) {
		this.tripuid = tripuid;
	}
	
	@Override
	public String toString() {
		return "ShowTripBean [startLocBean=" + startLocBean + ", finLocBean=" + finLocBean + ", tripTimeBean="
				+ tripTimeBean + ", priceBean=" + priceBean + ", tripuid=" + tripuid + "]";
	}

	
}
