package com.ust_global.admin;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//eventsRemote.updateEvent("01", "Aswin weds Aiswarya", sqlDate, "Wedding", "D26",1,2500.0);

public class TestEvents 
{
	public static void main(String[] args) throws NamingException 
	{
		Properties p=new Properties();
		p.put(Context.PROVIDER_URL,"localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		Context ctx=new InitialContext(p);
		
		EventsBeanRemote eventsRemote=(EventsBeanRemote) ctx.lookup("EventsBean/remote");
		
		java.util.Date utilDate=new java.util.Date(2016,9,23);
		long ms=utilDate.getTime();
		java.sql.Date sqlDate=new Date(ms);
		
//		Event event=new Event();
//		event.setEventId("01");
//		event.setEventName("Hari weds Anju");
//		event.setEventCategory("Wedding");
//		event.setEventDate(sqlDate);
//		event.setSeatsAvailable("D26");
//		event.setTicketPrice(250.00);
//		
///	eventsRemote.createEvent(event);
//		try
//		{
////			public Event updateEvent(String eventId, String eventName, Date eventDate,String eventCategory, String seatAvailble,int seatStatus ,double ticketPrice);
//
//			eventsRemote.updateEvent("01", "Clintu weds Anju", sqlDate, "Wedding", "D24", 1, 250.00);
//		}
//		catch (Exception e)
//		{
//			System.out.println("error");
//			e.printStackTrace();
//		}
		List<Event> all=eventsRemote.allEvents();
		for(Event ev:all)
		{
			System.out.println(ev.getEventId()+" "+ev.getEventName()+" "+ev.getSeatStatus()+" "+ev.getAllSeats());
		}
	}
}
