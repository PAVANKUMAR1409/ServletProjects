package Admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con;
	private DBConnection() {}
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(DBInfo.dburl,DBInfo.uName,DBInfo.pWord);
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon()
	{
		return con;
	}
}
