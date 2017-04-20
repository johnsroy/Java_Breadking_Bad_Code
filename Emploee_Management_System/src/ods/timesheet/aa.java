package ods.timesheet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ods.employee.employee;

public class aa extends JFrame
{
	private JButton getdetails;
	private JButton get1;
	private JPanel contentPane;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel contentPane1;
	private JTextArea textfield;
	private JLabel label1;
	private JComboBox<String> emp;
	private JComboBox<String> task;
	public aa()
	{
		super();
		get();
		// 	employerinterface();
		this.setVisible(true);
	}
	public void get()
	{
		emp = new JComboBox<String>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select First_Name, Last_Name from student_employee");
			while(rs.next())
			{
				//employees.add(rs.getString("First_Name")+" "+rs.getString("Last_Name"));
				emp.addItem(rs.getString("First_Name")+" "+rs.getString("Last_Name"));
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getdetails = new JButton();
		getdetails.setText("SELECT");
		getdetails.setBackground(new Color(42, 43, 74));
		getdetails.setForeground(new Color(233, 219, 219));
		get1 = new JButton();
		get1.setText("BACK");
		get1.setBackground(new Color(42, 43, 74));
		get1.setForeground(new Color(233, 219, 219));
				
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));

		addComponent(contentPane, getdetails, 300,0,150,40);
		addComponent(contentPane, get1, 300,40,150,40);
		addComponent(contentPane, emp, 0,0,300,40);
		this.setTitle("TASK-ASSIGN-SHEET");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(450, 200));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getdetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userinterface(emp.getSelectedItem().toString());
			}
		});

		get1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			get1();
			}
		});

	}
	private void get1()
	{
		this.setVisible(false);
		new employee();
	}
	private void userinterface(final String employee)
	{
		textfield = new JTextArea();
		jButton2 = new JButton();
		jButton2.setText("ASSIGN");
		jButton2.setBackground(new Color(42, 43, 74));
		jButton2.setForeground(new Color(233, 219, 219));
		try
		{
			task = new JComboBox<String>();
			String[] words = employee.split(" ");

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select task from position_jobs where job_role = (select position_id from student_employee where Last_Name = '"+words[words.length-1]+"')");
			while(rs.next())
			{
				String jobrole = rs.getString("task");
				if(jobrole.equals("SC"))
				{
					jobrole = "SCANNING";
				}
				else if(jobrole.equals("ED"))
				{
					jobrole = "EDITING";
				}
				else if(jobrole.equals("RE"))
				{
					jobrole = "RECOGNIZING";
				}
				else if(jobrole.equals("PA"))
				{
					jobrole = "PARTING";
				}
				else if(jobrole.equals("PR"))
				{
					jobrole = "PROCTORING";
				}
				else if(jobrole.equals("BU"))
				{
					jobrole = "BURNING";
				}
				else if(jobrole.equals("BS"))
				{
					jobrole = "BRAILLE";
				}
				else if(jobrole.equals("TA"))
				{
					jobrole = "TAGGING";
				}
				task.addItem(jobrole);
			}
			addComponent(contentPane, textfield, 0, 45, 290, 40);
			addComponent(contentPane, task, 290,45,150,40);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		addComponent(contentPane, jButton2, 150,90,150,40);
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next(textfield.getText(), task.getSelectedItem().toString(), employee);
			}
		});
	}
	private void next(String book, String position, String employee)
	{
		String[] words = employee.split(" ");
		boolean flag = false;
		try
		{
			String uid = "";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select uid from student_employee where last_name = '"+words[words.length-1]+"'");
			while(rs.next())
			{
				uid = rs.getString("uid");
			}
			ResultSet rs1 = stmt.executeQuery("select uid from tasks");
			while(rs1.next())
			{
				String uid1 = rs1.getString("uid");
				if(uid.equals(uid1))
				{
					flag = true;
				}
			}
			if(flag != true)
			{
			String query = "insert into tasks (uid, task, jobroles, date) values (?,?,?,CurDate())";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(uid));
			ps.setString(2, book);
			ps.setString(3, position);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "ASSIGNED SUCCESSFULLY");

			}
			else
			{
				String query = "update tasks set task = ?, date = CurDate() where uid = "+Integer.parseInt(uid)+"";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, book);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "ASSIGNED SUCCESSFULLY");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	private void employerinterface()
	{
		label = new JLabel("OFFICE OF DISABILITY SERVICES");
		label.setFont(new Font("Courier New",Font.BOLD,18));
		label.setForeground(Color.CYAN);
		ADMINISTRATIVE_ASSISTANCE = new JButton();
		BRIALLE_SPECIALIST = new JButton();
		SCANNER3 = new JButton();
		SCANNER2 = new JButton();
		ADDEMPLOYEE = new JButton();
		REMOVEEMPLOYEE = new JButton();
		PROCTOR = new JButton();
		MESSAGE = new JButton();
		contentPane = (JPanel)this.getContentPane();
		ADMINISTRATIVE_ASSISTANCE.setBackground(new Color(42, 43, 74));
		ADMINISTRATIVE_ASSISTANCE.setForeground(new Color(233, 219, 219));
		ADMINISTRATIVE_ASSISTANCE.setText("ADMINISTRATIVE ASSISTANCE");
		BRIALLE_SPECIALIST.setBackground(new Color(42, 43, 74));
		BRIALLE_SPECIALIST.setForeground(new Color(233, 219, 219));
		BRIALLE_SPECIALIST.setText("BRIALLE SPECIALIST");
		ADDEMPLOYEE.setBackground(new Color(42, 43, 74));
		ADDEMPLOYEE.setForeground(new Color(233, 219, 219));
		ADDEMPLOYEE.setText("ADD-EMPLOYEE");
		REMOVEEMPLOYEE.setBackground(new Color(42, 43, 74));
		REMOVEEMPLOYEE.setForeground(new Color(233, 219, 219));
		REMOVEEMPLOYEE.setText("REMOVE-EMPLOYEE");
		MESSAGE.setBackground(new Color(42, 43, 74));
		MESSAGE.setForeground(new Color(233, 219, 219));
		MESSAGE.setText("DISPLAY-MESSAGE");
		SCANNER3.setBackground(new Color(42, 43, 74));
		SCANNER3.setForeground(new Color(233, 219, 219));
		SCANNER3.setText("SCANNER 3");
		SCANNER2.setBackground(new Color(42, 43, 74));
		SCANNER2.setForeground(new Color(233, 219, 219));
		SCANNER2.setText("SCANNER 2");
		PROCTOR.setBackground(new Color(42, 43, 74));
		PROCTOR.setForeground(new Color(233, 219, 219));
		PROCTOR.setText("PROCTOR");
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));
		addComponent(contentPane, label, 0, 5, 340, 50);
		addComponent(contentPane, ADMINISTRATIVE_ASSISTANCE, 0,60,210,40);
		addComponent(contentPane, BRIALLE_SPECIALIST, 0,110,210,40);
		addComponent(contentPane, SCANNER3, 0,160,210, 40);
		addComponent(contentPane, SCANNER2, 0,210,210, 40);
		addComponent(contentPane, PROCTOR, 0,260,210, 40);
		addComponent(contentPane, ADDEMPLOYEE, 250,60,150, 40);
		addComponent(contentPane, REMOVEEMPLOYEE, 250,150,150, 40);
		addComponent(contentPane, MESSAGE, 250,250,150, 40);
		
		this.setTitle("WRIGHT STATE UNIVERSITY - TECHNOLOGY CENTER");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(400, 346));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MESSAGE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				message();		
			}
		});
	}
	*/
	private void message()
	{
		String message = JOptionPane.showInputDialog(null, "TYPE MESSAGE");
		if(message != null)
		{
			
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

		new aa();
		
	}

}
