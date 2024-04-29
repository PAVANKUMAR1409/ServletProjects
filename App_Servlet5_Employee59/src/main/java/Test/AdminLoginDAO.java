package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
{
	public AdminBean ab=null;
	public AdminBean login(String uN,String pW) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM EmpAdmin59 WHERE uname=? and pword=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ab=new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddress(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setPhno(Long.parseLong(rs.getString(7)));
			}
		}catch(Exception e) {e.printStackTrace();}
		return ab;
	}
}
