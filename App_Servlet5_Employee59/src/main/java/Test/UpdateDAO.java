package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO 
{
	public int k=0;
	public int update(EmployeeBean eb)
	{
		try {
			Connection con= DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement
					("update Employee59 set bsal=?,hra=?,da=?,totsal=? where eid=?");
					//update Employee59 set bsal=80000,hra=50,da=50,totsal=90000 where eid='e19';
			ps.setFloat(1, eb.getBsal());
			ps.setFloat(2, eb.getHra());
			ps.setFloat(3, eb.getDa());
			ps.setFloat(4, eb.getTa());
			ps.setString(5, eb.getId());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
