package ods.employer.roles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ods.employer.employer;

public class SCANNER2 extends JFrame
{
	private JPanel contentPane;
	private JTextArea jTextArea1;
	private JButton FIND;
	private JButton BACK;
	private JTextField textfield;
	public SCANNER2()
	{
		super();
		userinterface();
		this.setVisible(true);
	}
	public void userinterface()
	{
		textfield = new JTextField(40);		
		jTextArea1 = new JTextArea();
		FIND = new JButton();
		FIND.setBackground(new Color(42, 43, 74));
		FIND.setForeground(new Color(233, 219, 219));
		FIND.setText("FIND EMPLOYEE");
		BACK = new JButton();
		BACK.setBackground(new Color(42, 43, 74));
		BACK.setForeground(new Color(233, 219, 219));
		BACK.setText("BACK");
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));
		addComponent(contentPane, FIND, 250,0,150,40);
		addComponent(contentPane, textfield, 0, 0, 250, 40);
		addComponent(contentPane, BACK, 250, 40, 150, 40);
		this.setTitle("SCANNER 2 PAGE");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(400, 346));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FIND.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				finder(textfield.getText());
				
			}
		});
		BACK.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				back();
				
			}
		});

	}
	private void back()
	{
		new employer();
	}
	private void finder(String employee)
	{
		addComponent(contentPane, jTextArea1, 0, 80, 400, 300);
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			String query = "select first_name from student_employee where UID = "+Integer.parseInt(employee)+" AND Position_id IN (select position_id from position_jobs where position_id = 'S2')";
			ResultSet rs = stmt.executeQuery(query);
			String employeename = "";
			while(rs.next())
			{
				employeename = rs.getString("first_Name");
			}
			if(employeename!= "")
			{
				jTextArea1.append("\n EMPLOYEE_NAME: "+employeename+"\n");
				ResultSet rs1 = stmt.executeQuery("select Time_Sheet_Id from clocker where Student_employee_uid = '"+Integer.parseInt(employee)+"'");
				String timesheetid = "";
				while(rs1.next())
					{
					timesheetid = rs1.getString("Time_Sheet_Id");
					jTextArea1.append(timesheetid+": ");
					}
					ResultSet rs2 = stmt.executeQuery("select time_start_date, time_end_date from time_sheet where time_sheet_id = '"+timesheetid+"'");
						while(rs2.next())
						{
						String time_start_date = rs2.getString("time_start_date");
						String time_end_date = rs2.getString("time_end_date");
						jTextArea1.append(time_start_date+" to "+time_end_date+"\n");
						}
					ResultSet rs3 = stmt.executeQuery("select clock_in, clock_out, timediff(clock_out, clock_in) from clocker where student_employee_uid = "+Integer.parseInt(employee)+"");
					jTextArea1.append("RECENT LOG DETAILS"+"\n");
					while(rs3.next())
					{
						jTextArea1.append(rs3.getString("clock_in")+" - "+rs3.getString("clock_out")+" : WORKED FOR "+rs3.getString("timediff(clock_out, clock_in)")+" SECONDS");
					}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "RE-CHECK "+employee+" POSITION");
			}

		}
		catch(Exception e)
		{
			System.out.println("PROBLEM WITH CONNECTION: "+e);
		}
	}
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}

		new SCANNER2();
		
	}

}
