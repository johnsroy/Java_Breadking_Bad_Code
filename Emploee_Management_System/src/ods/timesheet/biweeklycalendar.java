package ods.timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class biweeklycalendar 
{
	static String uid = "";
	public biweeklycalendar(String uid)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select time_end_date from time_sheet where time_end_date = CurDate()-1");
		while(rs.next())
		{
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String toString()
	{
		String data = "YOU'RE UID IS "+uid;
		return data;
	}
}
