package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllProductsDAO
{
	public ArrayList<ProductBean> al= new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retrieve()
	{
		try {
			Connection con= DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM Product59");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				ProductBean pb= new ProductBean();
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
