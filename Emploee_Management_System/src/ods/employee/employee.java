package ods.employee;

import java.awt.Color;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.sql.*;

import ods.timesheet.biweeklycalendar;
import ods.timesheet.clockin;
import ods.timesheet.clockout;

public class employee extends JFrame
{
	static JLabel label;
	static JLabel label1;
	static JTextField jTextField1;
	static JButton TIME_IN;
	static JButton SETPIN;
	static JButton JOBROLE;
	static JButton TIME_OUT;
	static JButton BI_WEEKLY_CALENDAR;
	static JPanel contentPane;
	static boolean click;
	public employee()
	{
		//calling super class.
		super();
		//calling method employee interface.
		employeeinterface();
		//making frame visible true
		this.setVisible(true);
	}
	
	private void employeeinterface()
	{
		label = new JLabel("ENTER U_ID");
		label.setFont(new Font("Courier New",Font.BOLD,20));
		label.setForeground(Color.CYAN);
		label1 = new JLabel("UNIVERSITY_ID: U00******");
		label1.setFont(new Font("Courier New",Font.BOLD,20));
		label1.setForeground(Color.CYAN);
		jTextField1 = new JTextField(10);
		TIME_IN = new JButton();
		TIME_OUT = new JButton();
		SETPIN = new JButton();
		JOBROLE = new JButton();
		BI_WEEKLY_CALENDAR = new JButton();
		//contentpane adding to container. 
		contentPane = (JPanel)this.getContentPane();
		//setting background and foreground colors and text for buttons.
		TIME_IN.setBackground(new Color(42, 43, 74));
		TIME_IN.setForeground(new Color(233, 219, 219));
		TIME_IN.setText("CLOCK_IN");
		SETPIN.setBackground(new Color(42, 43, 74));
		SETPIN.setForeground(new Color(233, 219, 219));
		SETPIN.setText("SET-PIN");
		JOBROLE.setBackground(new Color(42, 43, 74));
		JOBROLE.setForeground(new Color(233, 219, 219));
		JOBROLE.setText("VIEW-TASK");
		TIME_OUT.setBackground(new Color(42, 43, 74));
		TIME_OUT.setForeground(new Color(233, 219, 219));
		TIME_OUT.setText("CLOCK_OUT");
		BI_WEEKLY_CALENDAR.setBackground(new Color(42, 43, 74));
		BI_WEEKLY_CALENDAR.setForeground(new Color(233, 219, 219));
		BI_WEEKLY_CALENDAR.setText("HOME");
		//setting background for container.
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));
		//calling add component method and adding content-pane - container, fields/text/buttons, horizontal space, vertical space, width, height.
		addComponent(contentPane, label, 0, 5, 150, 50);
		addComponent(contentPane, jTextField1, 150, 15, 140, 30);
		addComponent(contentPane, TIME_IN, 0,60,153,51);
		addComponent(contentPane, TIME_OUT, 155,60,153,51);
		addComponent(contentPane, SETPIN, 0,250, 180, 55);
		addComponent(contentPane, JOBROLE, 0,190, 180, 55);
		addComponent(contentPane, BI_WEEKLY_CALENDAR, 190,250,180, 55);
		
		//setting title, location, size for frame.
		this.setTitle("St. Thomas' College of Engineering & Tech");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(400, 346));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	TIME_IN.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			try {
				if(!jTextField1.getText().isEmpty())
				{
				new clockin(jTextField1.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR UID");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	TIME_OUT.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			if(!jTextField1.getText().isEmpty())
			{
			try {
				new clockout(jTextField1.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			}
			else
			{
				JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR UID");
			}

		}
	});

	BI_WEEKLY_CALENDAR.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			bwc();
		}
	});
	SETPIN.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			pin(jTextField1.getText());
		}
	});
	JOBROLE.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) 
		{
			view(jTextField1.getText());
		}
	});

	}
private void bwc()
{
	this.setVisible(false);
	new ods.main();
}
	private void view(String uid)
	{
		if(!uid.isEmpty())
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement(); // smt variable will help in executing the queries
			String message = "";
			ResultSet rs = stmt.executeQuery("select task, jobroles from tasks where uid = "+Integer.parseInt(uid)+"");
			//rs variable stores the query result 
			while(rs.next())
			{
				message = rs.getString("task")+" -- "+ rs.getString("jobroles");
			}
			if(message != "")
			{
			JOptionPane.showMessageDialog(null, message);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "YOU'VE NOT ASSIGNED ANY TASK CONTACT ADMINISTRATIVE ASSISTANT");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR UID");
		}
	}
	private void pin(String uid) {
		if(!uid.isEmpty())
		{
		try {
			String ssn = JOptionPane.showInputDialog(null, "ENTER YOUR SSN");
			String Lastname = JOptionPane.showInputDialog(null, "ENTER YOUR LASTNAME");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			boolean flag = false;
			ResultSet rs = stmt.executeQuery(
					"select clocker_id from clocker where student_employee_uid = (select uid from student_employee where uid = "
							+ Integer.parseInt(uid) + " and last_name = '" +Lastname+ "' and SSN = "+Integer.parseInt(ssn)+")");
			String cid = "";
			while(rs.next())
			{
				flag = true;
				cid = rs.getString("clocker_id");
			}
			ResultSet rs1 = stmt1.executeQuery("select time_sheet_id from time_sheet where time_start_date < CurDate() and time_end_date > CurDate()");
			String ts = "";
			while(rs1.next())
			{
				ts = rs1.getString("time_sheet_id");
			}
			if(cid == "")
			{
				Random rn = new Random();
				cid = "c"+rn.nextInt(50 - 1 + 1) + 1;
				//String tid = "w"+rn.nextInt(50-1 + 1) + 1;
				PreparedStatement ps1 = conn.prepareStatement("insert into clocker(clocker_id, Student_employee_uid, pin, date, clock_in, clock_out, Time_Sheet_Id) values (?,?,?,?,?,?,?)");
				ps1.setString(1, cid);
				ps1.setString(2, uid);
				ps1.setString(3, "****");
				ps1.setString(4, null);
				ps1.setString(5, null);
				ps1.setString(6, null);
				ps1.setString(7, ts);
				ps1.executeUpdate();
				new employee();
			}
			String pin = "";
			if(flag == true)
			{
			pin = JOptionPane.showInputDialog(null,"ENTER PIN");
			String pincheck = JOptionPane.showInputDialog(null,"CONFIRM PIN");

			if(pin.equals(pincheck))
			{
				pin = pin;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "PIN DOESN'T MATCH");
			new employee();				
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "PLEASE CHECK YOUR DETAILS");
				new employee();
			}

			String query = "update clocker set pin = '" + pin + "' where clocker_id = '" + cid + "'";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR UID");
		}
	}
	BufferedReader clockreader = null;
	BufferedWriter clockwriter = null;
	static String line = null;

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
			System.out.println("Failed loading: ");
			System.out.println(ex);
		}
	new employee();
	}
}
