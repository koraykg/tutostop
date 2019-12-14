package com.isbank.tripdetails;

public class PassengerBean {
	private String Passenger;

	public String getPassenger() {
		return Passenger;
	}

	public void setPassenger(String passenger) {
		Passenger = passenger;
	}

	@Override
	public String toString() {
		return "PassengerBean [Passenger=" + Passenger + "]";
	}
}
