package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO
{
	public int d=0;
	public int delete(String code) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("DELETE FROM Product WHERE code=?");
			ps.setString(1, code);
			d=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return d;
	}
}
