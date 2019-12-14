package com.isbank.profile;

import java.util.ArrayList;
import java.util.List;

import com.isbank.tripdetails.PassengerBean;
import com.isbank.tripdetails.PassengerDao;
import com.isbank.tripdetails.TripDetailsBean;
import com.isbank.tripdetails.TripDetailsDao;

public class ProfileService {
	private List<ProfileTripBean> trips = new ArrayList<ProfileTripBean>();
	private List<TripDetailsBean> tripDetails = new ArrayList<TripDetailsBean>();
	private List<PassengerBean> passengerList = new ArrayList<PassengerBean>();
	
	public List<ProfileTripBean> retrieveYourTrips(String userName) {
		ProfileTripsDao dao = new ProfileTripsDao();
		trips = dao.showTrip(userName);
		return trips;
	}
	
	public List<ProfileTripBean> retrieveYourTripsAsPassenger(String userName) {
		ProfileTripsAsPassengerDao dao = new ProfileTripsAsPassengerDao();
		trips = dao.showTripAsPassenger(userName);
		return trips;
	}
	
	public List<TripDetailsBean> retrieveTripInfoDetails(int tripuid) {
		TripDetailsDao dao = new TripDetailsDao();
		tripDetails = dao.ShowTripDetails(tripuid);
		return tripDetails;
	}
	
	public List<PassengerBean> retrievePassengers(int tripuid) {
		PassengerDao dao = new PassengerDao();
		passengerList = dao.RetrievePassengers(tripuid);
		return passengerList;
	}
}
