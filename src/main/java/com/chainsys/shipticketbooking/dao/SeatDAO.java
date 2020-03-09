package com.chainsys.shipticketbooking.dao;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.SeatAvailability;

public interface SeatDAO {

	public void addSeatAvailability(SeatAvailability b) throws DBException;// admin work

	public void updateSeatAvailability(SeatAvailability b) throws DBException;// admin work

	public void deleteSeatAvailability(SeatAvailability b) throws DBException;// admin work

	public void procedure(SeatAvailability b) throws DBException;// procedure call

	public int costOfBooking(String b) throws DBException;

	public int findAvailableSeats(SeatAvailability b) throws DBException;

	public int findTotalcost(int a, int b) throws DBException;
	
	public void findTicketStatusAndCost(SeatAvailability b)throws DBException;

	// public void count(SeatAvailability b) throws Exception;

}
