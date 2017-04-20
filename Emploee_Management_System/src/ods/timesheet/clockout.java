package ods.timesheet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class clockout
{
	public clockout(String employee)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select UID from student_employee");
			boolean flag = false;
			while(rs.next())
			{
				String id = rs.getInt("UID")+"";
				if(employee.equals(id))
				{
					flag = true;
					String pin = JOptionPane.showInputDialog(null, "ENTER PIN:");
					ResultSet rs1 = stmt1.executeQuery("select pin from clocker where Student_employee_uid = '"+id+"'");
					while(rs1.next())
					{
					String employerpin = rs1.getString("pin");
					if(pin.toLowerCase().equals(employerpin.toLowerCase()))
					{
						String date=null, cin=null, cout=null;
						String query = "update clocker set date = CurDate(), clock_out = CurTime() where pin = '"+pin+"'";
						PreparedStatement ps = conn.prepareStatement(query);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "You've Clocked_out");
					}
					}
					ResultSet rs2 = stmt2.executeQuery("select timediff(clock_out, clock_in) from clocker where pin = '"+pin+"'");
					while(rs2.next())
					{
						//System.out.println(rs2.getString("timediff(clock_out, clock_in)"));
						JOptionPane.showMessageDialog(null, "YOU'VE WORKED FOR "+rs2.getString("timediff(clock_out, clock_in)") + "SECONDS");
					}
				}
			}
			if(flag == false)
			{
				JOptionPane.showMessageDialog(null, "RECORDS SHOWING YOU DON'T HAVE ACCESS: TRY AGAIN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}