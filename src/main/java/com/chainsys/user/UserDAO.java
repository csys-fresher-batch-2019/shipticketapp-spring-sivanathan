package com.chainsys.user;

import com.chainsys.util.DBException;

public interface UserDAO {
/*
	@SqlUpdate("insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)")
	void addUser(User a);
	
	@SqlUpdate("update user_detail set contact_number=? where user_id=?")
	void updateUser(User a);
	
	@SqlUpdate("delete from user_detail  where user_id=?")
	void deleteUser(User a);
	
	@SqlUpdate("update user_detail set pass=? where user_id=?")
	void resetUser(User a);
	
	
	*/
	
	public boolean User(int userId, String password) throws DBException;

	public void addUser(User a) throws DBException;//user

	public void updateUser(User a) throws DBException;//user

	public void deleteUser(User a) throws DBException;//admin

	public void resetUser(User a) throws DBException;//user
}
