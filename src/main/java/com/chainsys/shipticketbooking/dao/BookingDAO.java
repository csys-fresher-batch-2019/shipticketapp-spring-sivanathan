package com.chainsys.shipticketbooking.dao;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.Booking;

public interface BookingDAO {

	public void addBooking(Booking b) throws DBException;// user work

	public void updateBooking(Booking b) throws DBException;// admin work

	public void deleteBooking(Booking b) throws DBException;// user work

	public int book(Booking b) throws DBException;

	public int count() throws DBException;// admin work

}
