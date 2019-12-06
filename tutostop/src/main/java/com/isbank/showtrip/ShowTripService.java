package com.isbank.showtrip;

import java.util.ArrayList;
import java.util.List;

import com.isbank.reserve.CountPassDao;

public class ShowTripService {
	private List<ShowTripBean> trips = new ArrayList<ShowTripBean>();
	
	public List<ShowTripBean> retrieveTrips(String startLocation, String finishLocation, String tripDateTime) {
		ShowTripsDao dao = new ShowTripsDao();
		trips = dao.showTrip(startLocation, finishLocation, tripDateTime);
		return trips;
	}
	
	private List<AssignedTripBean> AssignedTrips = new ArrayList<AssignedTripBean>();
	
	public List<AssignedTripBean> retrieveAssignedTrips(String userName) {
		ShowAssignedTripsDao dao = new ShowAssignedTripsDao();
		AssignedTrips = dao.ShowAssignedTrip(userName);
		return AssignedTrips;
	}
	
	public int retrievePassNum(int tripuid) {
		CountPassDao dao = new CountPassDao();
		int passengerNum = dao.CountPassenger(tripuid);
		return passengerNum;
	}
	
	public int RetrieveAssignedToRelatedTrip(int tripuid, String userName) {
		IsActivelyAssignedToRelatedTripDao dao = new IsActivelyAssignedToRelatedTripDao();
		int AssignmentToRelated = dao.RelatedTripAssignmentCheck(tripuid, userName);
		return AssignmentToRelated;
	}
	
	public void addTrips(ShowTripBean Trip) {
		trips.add(Trip);
	}
	
	public void deleteTrips(ShowTripBean Trip){
		trips.remove(Trip);
	}

}
