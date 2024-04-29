package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditDAO 
{
	public int k=0;
	public int update(UserBean ub,String uN,String pW)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement
				("UPDATE UserReg59 SET fname=?,lname=?,addr=?,mid=?,phno=? WHERE  uname=? and pword=?");
			ps.setString(1, ub.getfName());
			ps.setString(2,ub.getlName());
			ps.setString(3, ub.getAddress());
			ps.setString(4, ub.getmId());
			ps.setLong(5,ub.getPhno());
			ps.setString(6, uN);
			ps.setString(7, pW);
			
			k= ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
