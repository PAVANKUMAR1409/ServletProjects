package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployeeDAO
{
	public int k=0;
	public int insert(EmployeeBean eb) {
			
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Employee59 values(?,?,?,?,?,?,?)");
			ps.setString(1, eb.getId());
			ps.setString(2, eb.getName());
			ps.setString(3, eb.getDsg());
			ps.setFloat(4, eb.getBsal());
			ps.setFloat(5, eb.getHra());
			ps.setFloat(6, eb.getDa());
			ps.setFloat(7, eb.getTa());
			
			k=ps.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
