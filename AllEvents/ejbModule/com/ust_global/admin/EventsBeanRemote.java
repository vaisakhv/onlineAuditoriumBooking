package com.ust_global.admin;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;


@Remote
public interface EventsBeanRemote 
{

	public Event createEvent(Event event);
	public void cancelEvent(String eventID);
	public Event searchEvent(String eventId);
	public List<Event> allEvents();
	public Event updateEvent(String eventId, String eventName, Date eventDate,String eventCategory, String seatStatus ,double ticketPrice,String allSeats);
}
