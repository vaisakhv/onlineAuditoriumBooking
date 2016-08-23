package com.ust_global.admin;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EventsBean
 */
@Stateless
public class EventsBean implements EventsBeanRemote 
{

    /**
     * Default constructor. 
     */
    public EventsBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(name="AllEventsUnit")
    EntityManager entityManager;
    
	@Override
	public Event createEvent(Event event) 
	{
		if(event!=null)
		{
			entityManager.persist(event);
		}
		return event;
	}

	@Override
	public void cancelEvent(String eventID) 
	{
		Event event=entityManager.find(Event.class, eventID);
		if(event!=null)
		{
			entityManager.remove(event);
		}
	}

	@Override
	public Event searchEvent(String eventId) 
	{
		Event event=entityManager.find(Event.class, eventId);
		return event;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> allEvents() 
	{
		List<Event> allEvents=entityManager.createQuery("From AllEvents").getResultList();
		
		return allEvents;
	}

	@Override
	public Event updateEvent(String eventId, String eventName, Date eventDate,
			String eventCategory,  String seatStatus, double ticketPrice,String allSeats) 
	{
		Event event=entityManager.find(Event.class, eventId);
		if(event!=null)
		{
			event.setEventId(eventId);
			event.setEventName(eventName);
			event.setEventCategory(eventCategory);
			event.setEventDate(eventDate);
			event.setTicketPrice(ticketPrice);
			event.setSeatStatus(seatStatus);//the status of the seats 
			event.setAllSeats(allSeats);//all seats that are available for the specified event
			entityManager.persist(event);
		}
		return null;
	}

	

}
