package com.ust_global.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="selectedEvents")
public class Event	implements Serializable 
{
	/* Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 TICKETNUMBER                              NOT NULL NUMBER
 USERNAME                                  NOT NULL VARCHAR2(20)
 EVENTNAME                                 NOT NULL VARCHAR2(20)
 SELECTEDDATE                              NOT NULL VARCHAR2(20)
 SEATNUMBER                                NOT NULL VARCHAR2(20)
 EVENTID								   NOT NULL VARCHAR2(20)
*/
	private long ticketNumber;
	private String userName;
	private String eventName;
	private String selectedDate;
	private String seatNumber;
	@Id
	@Column(name="ticketId")
	public long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
