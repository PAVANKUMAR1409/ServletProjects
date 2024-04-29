package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDAO 
{
	public int k=0;
	public int insert(CustomerBean cb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("INSERT INTO CustomerTab VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, cb.getuName());
			ps.setString(2, cb.getpWord());
			ps.setString(3, cb.getfName());
			ps.setString(4, cb.getlName());
			ps.setString(5, cb.getAddress());
			ps.setString(6, cb.getmId());
			ps.setLong(7, cb.getPhno());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}		
		return k;
	}
	
}
