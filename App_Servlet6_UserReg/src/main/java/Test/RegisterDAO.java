package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO 
{
	public int k=0;
	public int register(UserBean ub)
	{
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("INSERT INTO UserReg59 VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getpWord());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getmId());
			ps.setLong(7, ub.getPhno());
			
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
