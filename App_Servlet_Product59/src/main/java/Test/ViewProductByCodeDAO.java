package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductByCodeDAO 
{
	public ArrayList<ProductBean> al= new ArrayList<ProductBean>();
	public ArrayList<ProductBean> getProduct(ProductBean pb)
	{
		try {
			Connection con= DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM Product59 WHERE code=?");
			ps.setString(1, pb.getCode());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				
				al.add(pb);  // adding the bean
			}// end of while
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}
}
