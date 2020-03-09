package com.chainsys.shipticketbooking.dao;


import com.chainsys.shipticketbooking.exception.DBException;

public interface AdminDAO {
//	public boolean admin(int adminId,String passWord );
	// public void administration(int adminId,String passWord );
	public boolean adminExist(int adminId, String pass) throws DBException;
}
