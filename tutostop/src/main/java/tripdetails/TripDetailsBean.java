package tripdetails;

public class TripDetailsBean {
	private int tripuid;
	private String startLocBean;
	private String finLocBean;
	private String tripTimeBean;
	private String priceBean;
	private String tripOwnerBean;
	private String totalPassengerBean;
	
	public int getTripuid() {
		return tripuid;
	}
	public void setTripuid(int tripuid) {
		this.tripuid = tripuid;
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
	public String getTripOwnerBean() {
		return tripOwnerBean;
	}
	public void setTripOwnerBean(String tripOwnerBean) {
		this.tripOwnerBean = tripOwnerBean;
	}
	public String getTotalPassengerBean() {
		return totalPassengerBean;
	}
	public void setTotalPassengerBean(String totalPassengerBean) {
		this.totalPassengerBean = totalPassengerBean;
	}
	@Override
	public String toString() {
		return "TripDetailsBean [tripuid=" + tripuid + ", startLocBean=" + startLocBean + ", finLocBean=" + finLocBean
				+ ", tripTimeBean=" + tripTimeBean + ", priceBean=" + priceBean + ", tripOwnerBean=" + tripOwnerBean
				+ ", totalPassengerBean=" + totalPassengerBean + "]";
	}
}
