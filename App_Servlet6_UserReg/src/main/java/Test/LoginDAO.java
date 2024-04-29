package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO
{
	public UserBean ub=null;
	public UserBean login(String un,String pw) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement
					("SELECT * FROM UserReg59 WHERE uname=? and pword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ub= new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return ub;
	}
}
