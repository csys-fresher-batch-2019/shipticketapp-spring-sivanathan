package com.chainsys.booking;

import com.chainsys.util.DBException;

public interface BookingDAO {

	public void addBooking(Booking b) throws DBException;// user work

	public void updateBooking(Booking b) throws DBException;// admin work

	public void deleteBooking(Booking b) throws DBException;// user work

	public int book(Booking b) throws DBException;

	public int count() throws DBException;// admin work

}
