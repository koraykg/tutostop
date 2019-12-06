package com.isbank.profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileService {
	private List<ProfileTripBean> trips = new ArrayList<ProfileTripBean>();
	
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
}
