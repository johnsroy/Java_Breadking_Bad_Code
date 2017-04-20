package ods.timesheet;

import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class clockin
{
	public clockin(String employee)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select UID from student_employee");
			ResultSet rs0 = stmt2.executeQuery("select Position_id from student_employee where UID = "+Integer.parseInt(employee)+"");
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
						String query = "update clocker set date = CurDate(), clock_in = CurTime() where pin = '"+pin+"'";
						PreparedStatement ps = conn.prepareStatement(query);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "You've Clocked_in");
					}
					}
					
				}
			}
			if(flag == false)
			{
				JOptionPane.showMessageDialog(null, "RECORDS SHOWING YOU DON'T HAVE ACCESS: TRY AGAIN");
			}
			while(rs0.next())
			{
				String pos = rs0.getString("Position_id");
				if(pos.equals("AA"))
				{
					new aa();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}