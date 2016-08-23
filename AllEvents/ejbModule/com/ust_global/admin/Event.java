/*
 * 
 * 
 * This is the Bean class for the AllEvents EJB Project 3.x
 * For the table ALLEVENTS
 * For the server side of the Auditorium project
 * Group 3
 * ALPHA 1133
 * 
 * */
package com.ust_global.admin;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 *
 *
 *SQL> desc allEvents
 *Name                                      Null?    Type
 *----------------------------------------- -------- ----------------------------
 *EVENTID                                   NOT NULL VARCHAR2(20)
 *EVENTNAME                                 NOT NULL VARCHAR2(30)
 *EVENTDATE                                 NOT NULL DATE
 *SEATSAVAILABLE                            NOT NULL VARCHAR2(10)
 *EVENTCATEGORY                             NOT NULL VARCHAR2(20)
 *TICKETPRICE                                        NUMBER(10,2)
 *SEATSTATUS                                         NUMBER
 *ALLSEATS                                           VARCHAR2(50)
 *
 * 
 * */

@Entity(name="AllEvents")

public class Event implements Serializable 
{
	private String eventId;
	private String eventName;
	private Date eventDate;
	private String eventCategory;
	private double ticketPrice;
	private String seatStatus;
	private String allSeats;
	
	
	@Id
	@Column(name="eventId")
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
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
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
	
}
