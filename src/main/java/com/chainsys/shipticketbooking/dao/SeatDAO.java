package com.chainsys.shipticketbooking.dao;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.SeatAvailability;

public interface SeatDAO {

	public void add(SeatAvailability b) throws DBException;// admin work

	public void update(SeatAvailability b) throws DBException;// admin work

	public void delete(SeatAvailability b) throws DBException;// admin work

	public void procedure(SeatAvailability b) throws DBException;// procedure call

	public int costOfBooking(String b) throws DBException;

	public int seat(SeatAvailability b) throws DBException;

	public int Totalcost(int a, int b) throws DBException;

	// public void count(SeatAvailability b) throws Exception;

}
