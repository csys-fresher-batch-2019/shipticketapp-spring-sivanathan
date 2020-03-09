package com.chainsys.shipticketbooking.dao;

import java.util.ArrayList;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.Journey;

public interface JourneyDAO {
	public void saveJourney(Journey a) throws DBException;// user work

	public void updateJourney(Journey a) throws DBException;// admin work

	public void deleteJourney(Journey a) throws DBException;// admin work

	public ArrayList<Journey> findAllJourney(int a) throws DBException;// user work
}
