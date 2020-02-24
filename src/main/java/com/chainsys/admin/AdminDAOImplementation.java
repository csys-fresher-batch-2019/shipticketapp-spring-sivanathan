package com.chainsys.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.util.ErrorMessages;
import com.chainsys.util.Logger;
import com.chainsys.util.TestConnection;

public class AdminDAOImplementation implements AdminDAO {

	public boolean AdminLogin(int adminId, String pass)

	{	Logger logger = Logger.getInstance();

		try(Connection con = TestConnection.getConnection();) {
			try(Statement stmt = con.createStatement();){
			
			String sql="select pass_word from AdminRegister where Admin_id=(select Admin_id from AdminRegister where Admin_id='"+adminId+"')";
			ResultSet rs1 = stmt.executeQuery(sql);
if(rs1.next())
{
String password=rs1.getString("pass_word");

if (pass.equals(password))
{
return true;
}
}

} 
		catch (Exception e) {
			e.printStackTrace();
			logger.error(ErrorMessages.INVALID_PREPARESTATEMENT);
			//logger.error("Exception"+e);
		}
		}catch(Exception e)
			{
			e.printStackTrace();
			logger.error(ErrorMessages.CONNECTION_FAILURE);
			}
		return false;
}
}



