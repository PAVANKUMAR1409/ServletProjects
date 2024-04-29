package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO 
{
	public int k;
	public int delete(String eid)
	{
		try {
			Connection con= DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("DELETE FROM Employee59 WHERE eid=?");
			ps.setString(1, eid);
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
