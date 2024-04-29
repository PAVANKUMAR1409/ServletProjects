package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllEmployeeDAO 
{
	public ArrayList<EmployeeBean> al= new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrieve()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Employee59");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				EmployeeBean eb= new EmployeeBean();
				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
				eb.setDsg(rs.getString(3));
				eb.setBsal(rs.getFloat(4));
				eb.setHra(rs.getFloat(5));
				eb.setDa(rs.getFloat(6));
				eb.setTa(rs.getFloat(7));
				
				al.add(eb);
				
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}
}
