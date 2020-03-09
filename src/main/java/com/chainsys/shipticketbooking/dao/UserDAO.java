package com.chainsys.shipticketbooking.dao;

import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.model.User;

public interface UserDAO {
	/*
	 * @SqlUpdate("insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)"
	 * ) void addUser(User a);
	 * 
	 * @SqlUpdate("update user_detail set contact_number=? where user_id=?") void
	 * updateUser(User a);
	 * 
	 * @SqlUpdate("delete from user_detail  where user_id=?") void deleteUser(User
	 * a);
	 * 
	 * @SqlUpdate("update user_detail set pass=? where user_id=?") void
	 * resetUser(User a);
	 * 
	 * 
	 */

	public boolean userExist(int userId, String password) throws DBException;

	public void saveUser(User a) throws DBException;// user

	public void updateUser(User a) throws DBException;// user

	public void deleteUser(User a) throws DBException;// admin

	public void passwordResetUser(User a) throws DBException;// user
}
