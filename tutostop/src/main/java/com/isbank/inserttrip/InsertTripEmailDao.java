package com.isbank.inserttrip;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class InsertTripEmailDao 
{	
	public void SendInsertTripEmail(String startLoc, String finLoc, String tripTime, String eMail ) throws EmailException 
	{
		
		System.out.println("InsertTripEmailDao sınıfı çağrıldı.");
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthentication("tutostoptutom@gmail.com", "tutostop2019");
		email.setSSLOnConnect(true);
		email.setFrom("tutostoptutom@gmail.com");
		email.setSubject("NEW ROAD TRIP ADDED!");
		email.setMsg("Your new road trip destination (from " + startLoc + " to " + finLoc + " at " + tripTime +") has been successfully added to our list. Hope you have a good trip!");
		email.addTo(eMail);
		email.send();
	}
}
