package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentProductDAO 
{
	public int k=0;
	public int payment(String code,int quantity) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("UPDATE Product SET qty=? WHERE code=?");
			ps.setInt(1,quantity);
			ps.setString(2, code);
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
	
}
