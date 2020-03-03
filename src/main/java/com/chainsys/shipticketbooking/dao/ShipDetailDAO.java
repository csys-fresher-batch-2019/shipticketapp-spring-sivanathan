package com.chainsys.shipticketbooking.dao;

import java.util.ArrayList;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.ShipDetail;

public interface ShipDetailDAO {

	public void addShip(ShipDetail s) throws DBException;// admin work

	public void updateShip(ShipDetail s) throws DBException;// admin work

	public void deleteShip(ShipDetail s) throws DBException;// admin work

	public ArrayList<ShipDetail> getShip(ShipDetail s) throws DBException;// user work

	public ArrayList<ShipDetail> Ship() throws DBException;// user work

	public void distinctShip(String s) throws DBException;// used for differentiate in classes in sql //user work
	
}
