package com.chainsys.shipticketbooking.dao;

import java.util.ArrayList;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.ShipDetail;

public interface ShipDetailDAO {

	public void saveShipDetail(ShipDetail s) throws DBException;// admin work

	public void updateShipDetail(ShipDetail s) throws DBException;// admin work

	public void deleteShipDetail(ShipDetail s) throws DBException;// admin work

	public ArrayList<ShipDetail> findAllShipDetailWithSourceAndDestination(ShipDetail s) throws DBException;// user work

	public ArrayList<ShipDetail> findAllShip() throws DBException;// user work

	public void distinctShip(String s) throws DBException;// used for differentiate in classes in sql //user work
	
	public ArrayList<ShipDetail> routeShip() throws DBException;
	
}
