package ods.employer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

public class removeemployee extends JFrame
{
	private JLabel UID;
	private JLabel First_Name;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JTextField jtf5;
	private JLabel Last_Name;
	private JLabel Position_id;
	private JPanel contentPane;
	private JButton enroll;
	private JButton enroll1;
	private JButton getdetails;
	private JComboBox<String> emp;
	String employee;
	//private ArrayList<String> employees = new ArrayList<String>();
	public removeemployee()
	{
		super();
		get();
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
		getdetails.setText("GET DETAILS");
		getdetails.setBackground(new Color(42, 43, 74));
		getdetails.setForeground(new Color(233, 219, 219));		
		enroll1 = new JButton();
		enroll1.setText("BACK");
		enroll1.setBackground(new Color(42, 43, 74));
		enroll1.setForeground(new Color(233, 219, 219));
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));

		addComponent(contentPane, emp, 0,0,300,40);
		addComponent(contentPane, getdetails, 300,0,150,40);
		addComponent(contentPane, enroll1, 300,40,150,40);
		this.setTitle("EMPLOYEE-REMOVAL-FORM");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(500, 300));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getdetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userinterface(emp.getSelectedItem().toString());
			}
		});
		enroll1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				enroll1();
		
			}
		});


	}
	public void userinterface(String employee)
	{
		String[] name = employee.split(" ");
		String uid = "";
		String position_ID = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select UID, Position_id from student_employee where Last_Name = '"+name[name.length-1]+"'");
			while(rs.next())
			{
				uid = rs.getString("UID");
				position_ID = rs.getString("Position_id");
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		UID = new JLabel("UID: ");
		UID.setFont(new Font("Courier New",Font.BOLD,20));
		UID.setForeground(Color.CYAN);
		jtf1 = new JTextField(uid);
		First_Name = new JLabel("First_Name: ");
		First_Name.setFont(new Font("Courier New",Font.BOLD,20));
		First_Name.setForeground(Color.CYAN);
		jtf2 = new JTextField(name[0].toUpperCase());
		Last_Name = new JLabel("Last_Name: ");
		Last_Name.setFont(new Font("Courier New",Font.BOLD,20));
		Last_Name.setForeground(Color.CYAN);
		jtf3 = new JTextField(name[name.length-1].toUpperCase());
		Position_id = new JLabel("Position_Id: ");
		Position_id.setFont(new Font("Courier New",Font.BOLD,20));
		Position_id.setForeground(Color.CYAN);
		jtf4 = new JTextField(position_ID);
		enroll = new JButton();
		enroll.setText("FIRE");
		enroll.setBackground(new Color(42, 43, 74));
		enroll.setForeground(new Color(233, 219, 219));

	
		addComponent(contentPane, UID, 0,40,300,40);
		addComponent(contentPane, jtf1, 250, 45, 200, 30);
		addComponent(contentPane, First_Name, 0,80,300,40);
		addComponent(contentPane, jtf2, 250, 85, 200, 30);
		addComponent(contentPane, Last_Name, 0,120,300,40);
		addComponent(contentPane, jtf3, 250, 125, 200, 30);
		addComponent(contentPane, Position_id, 0,160,300,40);
		addComponent(contentPane, jtf4, 250, 165, 200, 30);
		addComponent(contentPane, enroll, 160,200,150,40);

		
		enroll.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				enroll(jtf1.getText(), jtf2.getText(), jtf3.getText(),jtf4.getText());
		
			}
		});

	}
	private void enroll1()
	{
		this.setVisible(false);
		new employer();
	}
	private void enroll(String employee1, String employee2, String employee3, String employee4)
	{
		
		int dialogoption = JOptionPane.showConfirmDialog(null, "CONFIRM FIRING "+employee2.toUpperCase());
		if(dialogoption == JOptionPane.YES_OPTION)
		{		
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			String query = "delete from student_employee where uid = ? and Last_name = ? and Position_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(employee1));
			ps.setString(2, employee3);
			ps.setString(3, employee4);
			ps.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println("PROBLEM WITH CONNECTION: "+e);
			}
		this.setVisible(false);
		new employer();
		}
		else
		{
			this.setVisible(false);
			new employer();
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

		new removeemployee();
		
	}

}
