/**
 * 
 * This is the POJO class for JSF 1.x
 * For the front end of Auditorium project
 * Group 3
 * ALPHA 1133
 * 
 * 
 * */
 package com.ust_global;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ust_global.admin.EventsBeanRemote;
import com.ust_global.user.Ticket;
import com.ust_global.user.TicketBeanRemote;
import com.ust_global.user.User;

public class Event 
{
	private String eventId;
	private String eventName;
	private String eventDate;
	private String eventCategory;
	private double ticketPrice;
	private String seatStatus;
	private String allSeats;
	private int selectedSeat;
	private String[] selectedSeats;
	
	public String[] getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(String[] selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	private List<String> allSeatsList=new ArrayList<String>();
	private List<String> allAvailableSeats=new ArrayList<String>();
	private List<Integer> allSeatStatus=new ArrayList<Integer>();
	



	String msg = " ";
	public int getSelectedSeat() {
		return selectedSeat;
	}

	public void setSelectedSeat(int selectedSeat) {
		this.selectedSeat = selectedSeat;
	}

	long lastTicketNumber;
	

	
	public String createEvent() throws NamingException
	{
		
	
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		
		com.ust_global.admin.Event event=new com.ust_global.admin.Event();
		
		//updated with gregorian cal instead of util date
		String[] date=eventDate.split("-");
		int year=Integer.parseInt(date[2]);
		int month=Integer.parseInt(date[1]);
		int dayOfMonth=Integer.parseInt(date[0]);
		GregorianCalendar utilDate=new GregorianCalendar(year, month-1, dayOfMonth);
		long ms=utilDate.getTimeInMillis();
		java.sql.Date sqlDate=new Date(ms);
		//-----------------
		
		event.setEventId(getEventId());
		event.setEventName(getEventName());
		event.setEventCategory(getEventCategory());
		event.setEventDate(sqlDate);
		event.setAllSeats(getAllSeats());
		event.setTicketPrice(getTicketPrice());
		event.setSeatStatus(getSeatStatus());
		
		if(event!=null)
		{
			try
			{
				remote.createEvent(event);
				msg="";//success
			}
			catch (Exception e) 
			{
				//eventID already exists
				msg="";//fail
			}
		}
		else
			msg="";//fail
		return msg;
	}
	
	public String updateEvent() throws NamingException
	{
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		
		//updated with gregorian cal instead of util date
		String[] date=eventDate.split("-");
		int year=Integer.parseInt(date[2]);
		int month=Integer.parseInt(date[1]);
		int dayOfMonth=Integer.parseInt(date[0]);
		GregorianCalendar utilDate=new GregorianCalendar(year, month-1, dayOfMonth);
		long ms=utilDate.getTimeInMillis();
		java.sql.Date sqlDate=new Date(ms);
		//-----------------
		
		if(remote!=null)
		{
			try
			{
			remote.updateEvent(getEventId(), getEventName(),sqlDate , getEventCategory(),getSeatStatus(), getTicketPrice(),getAllSeats());
			}
			catch (Exception e) 
			{
				msg="";//fail
			}
		}
		else
			msg="";//fail
		return msg;
	}
	

	@SuppressWarnings("unused")
	public String viewAllEvents() throws NamingException
	{
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		
		if(remote!=null)
		{
			List<com.ust_global.admin.Event> allEvents=remote.allEvents();
			msg="";//success
		}
		else
			msg="";//fail
		return msg;
	}
	
	public String cancelEvent() throws NamingException
	{
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		
		if(remote!=null)
		{
			try
			{
				remote.cancelEvent(getEventId());
				msg="";//success
			}
			catch (Exception e)
			{
				msg="";//fail
			}
		}
		
		return msg;
	}
	
	public String searchEventById() throws NamingException
	{
		msg="";//fail
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		if(remote!=null)
		{
			com.ust_global.admin.Event event=remote.searchEvent(getEventId());
			if(event!=null)
			{
				msg="";//success
			}
		}
		return msg;	
	}
	
	public String bookATicket() throws NamingException
	{
		msg="";//fail
		
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		EventsBeanRemote remote = (EventsBeanRemote) ctx.lookup("EventsBean/remote");
		com.ust_global.admin.Event oneEvent=remote.searchEvent(getEventId());
		
		List tcktNumber=new ArrayList();
		TicketBeanRemote ticketRemote=(TicketBeanRemote) ctx.lookup("TicketBean/remote");
		List<Ticket> allTicket=ticketRemote.viewAll();
		for(Ticket t:allTicket)
		{
			long tNumber=t.getTicketNumber();
			tcktNumber.add(tNumber);
			lastTicketNumber=tNumber+1;
		}
		
		
		String allSeats=oneEvent.getAllSeats();//now seat has all seats for an event
		String[] seat=allSeats.split(",");
		String status=oneEvent.getSeatStatus();
		String[] statsuArray=status.split(",");
		/**
		 * if the user selects the 4th seat the element at 4th index in the allSeatStatus arraylist should be 1 instead of 0; 
		 * int selectedSeat is the index number of the seat in the arraylist of the availableSeats list
		 * 
		 * */
		
		for (int i = 0; i < selectedSeats.length; i++)
		{
			selectedSeat=Integer.parseInt(selectedSeats[i]);
			if(seat[selectedSeat].equals(0))//if the seat is available
			{
				String seats = null;
				seat[selectedSeat]="1";//it will be booked
				for (int j = 0; j < seat.length; j++) 
				{
					seats=seats+","+seat[j];
				}
				/**
				 * After updating the available seats list the new status is pushed to the db 
				 * */
				remote.updateEvent(oneEvent.getEventId(), oneEvent.getEventName(), oneEvent.getEventDate(), oneEvent.getEventCategory(), seats, oneEvent.getTicketPrice(),oneEvent.getAllSeats());
				TicketBeanRemote ticket=(TicketBeanRemote) ctx.lookup("TicketBean/remote");
				Ticket tckt=new Ticket();
				User user=new User();
				
				//updated with gregorian cal instead of util date
				String[] date=eventDate.split("-");
				int year=Integer.parseInt(date[2]);
				int month=Integer.parseInt(date[1]);
				int dayOfMonth=Integer.parseInt(date[0]);
				GregorianCalendar utilDate=new GregorianCalendar(year, month-1, dayOfMonth);
				long ms=utilDate.getTimeInMillis();
				java.sql.Date sqlDate=new Date(ms);
				//-----------------
		
				
				tckt.setEventId(getEventId());
				tckt.setEventName(getEventName());
				tckt.setSelectedDate(sqlDate);//updated date
				tckt.setUserName(user.getUserName());
				tckt.setTicketNumber(lastTicketNumber);
				tckt.setSeatNumber(seat[selectedSeat]);
				Ticket newTicket=ticket.createTicket(tckt);
				System.out.println(tckt.getEventId()+" "+tckt.getEventName()+" "+tckt.getSeatNumber()+" "+tckt.getTicketNumber()+" "+tckt.getUserName()+" "+tckt.getSelectedDate());
				if(newTicket!=null)
				{
					msg="";//success
				}
		}
	}
		return msg;
	}
	
	
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public String getAllSeats() {
		return allSeats;
	}

	public void setAllSeats(String allSeats) {
		this.allSeats = allSeats;
	}

	public List<String> getAllSeatsList() {
		return allSeatsList;
	}

	public void setAllSeatsList(List<String> allSeatsList) {
		this.allSeatsList = allSeatsList;
	}

	public List<Integer> getAllSeatStatus() {
		return allSeatStatus;
	}

	public void setAllSeatStatus(List<Integer> allSeatStatus) {
		this.allSeatStatus = allSeatStatus;
	}

	public List<String> getAllAvailableSeats() {
		return allAvailableSeats;
	}

	public void setAllAvailableSeats(List<String> allAvailableSeats) {
		this.allAvailableSeats = allAvailableSeats;
	}
	
	
	
}
