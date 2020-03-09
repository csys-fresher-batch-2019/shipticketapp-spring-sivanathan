package com.chainsys.shipticketbooking.dao;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.Booking;

public interface BookingDAO {

	public void saveBooking(Booking b) throws DBException;// user work

	public void updateBooking(Booking b) throws DBException;// admin work

	public void deleteBooking(Booking b) throws DBException;// user work

	public int findCostOfBooking(Booking b) throws DBException;

	public int countOfBooking() throws DBException;// admin work

}
