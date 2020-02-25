package com.chainsys.booking;

import java.time.LocalDateTime;
//import java.util.Date;

public class Booking {

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public int getBookingSeats() {
		return bookingSeats;
	}

	public void setBookingSeats(int bookingSeats) {
		this.bookingSeats = bookingSeats;
	}

	public LocalDateTime getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDateTime dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	private int shipId;
	private int bookingId;
	private int userId;
	private int journeyId;
	private int bookingSeats;
	private LocalDateTime dateOfBooking;
	private String status;
	private int cost;
}
