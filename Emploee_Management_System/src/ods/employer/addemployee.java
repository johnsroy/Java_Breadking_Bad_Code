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

public class addemployee extends JFrame
{
	private JLabel UID;
	private JTextField textfield10;
	private JLabel First_Name;
	private JTextField textfield9;
	private JLabel Last_Name;
	private JTextField textfield8;
	private JLabel Middle_Name;
	private JTextField textfield7;
	private JLabel SSN;
	private JTextField textfield6;
	private JLabel Position_id;
	private JTextField textfield5;
	private JLabel Regular_Max_Hours;
	private JTextField textfield4;
	private JLabel Break_Max_Hours;
	private JTextField textfield3;
	private JLabel Department;
	private JTextField textfield2;
	private JLabel Join_Date;
	private JTextField textfield1;
	private JPanel contentPane;
	private JTextArea jTextArea1;
	private JButton enroll;
	private JButton enroll1;
	private JComboBox<String> dropdown;
	private JComboBox<String> dropdown1;
	private JComboBox<String> dropdown2;
	private JComboBox<String> dropdown3;
	public addemployee()
	{
		super();
		userinterface();
		this.setVisible(true);
	}
	public void userinterface()
	{
		String[] data = {"SCANNER 2","SCANNER 3","ADMINISTRATIVE ASSISTANT","PROCTOR", "BRIALLE SPECIALIST"};
		String[] hours = {"20", "28"};
		String[] department = {"TechCenter", "PROCTORING"};
		dropdown = new JComboBox<String>();
		dropdown1 = new JComboBox<String>();
		dropdown3 = new JComboBox<String>();
		dropdown2 = new JComboBox<String>();
		for(int i = 0; i<data.length; i++)
		{
		dropdown.addItem(data[i]);
		}
		for(int j = 0; j<hours.length; j++)
		{
			dropdown1.addItem(hours[j]);
			dropdown3.addItem(hours[j]);
		}
		for(int k = 0; k<department.length; k++)
		{
			dropdown2.addItem(department[k]);
		}
		UID = new JLabel("UID: ");
		UID.setFont(new Font("Courier New",Font.BOLD,20));
		UID.setForeground(Color.CYAN);
		textfield1 = new JTextField(20);
		First_Name = new JLabel("First Name: ");
		First_Name.setFont(new Font("Courier New",Font.BOLD,20));
		First_Name.setForeground(Color.CYAN);
		textfield2 = new JTextField(20);		
		Middle_Name = new JLabel("Middle Name: ");
		Middle_Name.setFont(new Font("Courier New",Font.BOLD,20));
		Middle_Name.setForeground(Color.CYAN);
		textfield3 = new JTextField(20);
		Last_Name = new JLabel("Last Name: ");
		Last_Name.setFont(new Font("Courier New",Font.BOLD,20));
		Last_Name.setForeground(Color.CYAN);
		textfield4 = new JTextField(20);
		SSN = new JLabel("SSN: ");
		SSN.setFont(new Font("Courier New",Font.BOLD,20));
		SSN.setForeground(Color.CYAN);
		textfield5 = new JTextField(20);
		Position_id = new JLabel("Position: ");
		Position_id.setFont(new Font("Courier New",Font.BOLD,20));
		Position_id.setForeground(Color.CYAN);
		Regular_Max_Hours = new JLabel("Regular Max Hours: ");
		Regular_Max_Hours.setFont(new Font("Courier New",Font.BOLD,20));
		Regular_Max_Hours.setForeground(Color.CYAN);
		Break_Max_Hours = new JLabel("Break Max Hours: ");
		Break_Max_Hours.setFont(new Font("Courier New",Font.BOLD,20));
		Break_Max_Hours.setForeground(Color.CYAN);
		Department = new JLabel("Department: ");
		Department.setFont(new Font("Courier New",Font.BOLD,20));
		Department.setForeground(Color.CYAN);
		Join_Date = new JLabel("Join Date: ");
		Join_Date.setFont(new Font("Courier New",Font.BOLD,20));
		Join_Date.setForeground(Color.CYAN);
		textfield10 = new JTextField(20);
		enroll = new JButton();
		enroll.setText("ENROLL");
		enroll.setBackground(new Color(42, 43, 74));
		enroll.setForeground(new Color(233, 219, 219));
		enroll1 = new JButton();
		enroll1.setText("BACK");
		enroll1.setBackground(new Color(42, 43, 74));
		enroll1.setForeground(new Color(233, 219, 219));
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(83, 90, 113));

		addComponent(contentPane, UID, 0,0,300,40);
		addComponent(contentPane, textfield1, 250, 5, 200, 30);
		addComponent(contentPane, First_Name, 0,40,300,40);
		addComponent(contentPane, textfield2, 250, 45, 200, 30);
		addComponent(contentPane, Last_Name, 0,80,300,40);
		addComponent(contentPane, textfield3, 250, 85, 200, 30);
		addComponent(contentPane, Middle_Name, 0,120,300,40);
		addComponent(contentPane, textfield4, 250, 125, 200, 30);
		addComponent(contentPane, SSN, 0,160,300,40);
		addComponent(contentPane, textfield5, 250, 165, 200, 30);
		addComponent(contentPane, Position_id, 0,200,300,40);
		addComponent(contentPane, dropdown, 250, 205, 200, 30);
		addComponent(contentPane, Regular_Max_Hours, 0,240,300,40);
		addComponent(contentPane, dropdown1, 250, 245, 200, 30);
		addComponent(contentPane, Break_Max_Hours, 0,280,300,40);
		addComponent(contentPane, dropdown3, 250, 285, 200, 30);
		addComponent(contentPane, Department, 0,320,300,40);
		addComponent(contentPane, dropdown2, 250, 325, 200, 30);
		addComponent(contentPane, Join_Date, 0,360,300,40);
		addComponent(contentPane, textfield10, 250, 365, 200, 30);
		addComponent(contentPane, enroll, 120,400,150,40);
		addComponent(contentPane, enroll1, 260,400,150,40);
		this.setTitle("EMPLOYEE-ENROLLMENT-FORM");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(500, 480));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		enroll.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {

				identify(textfield1.getText(), textfield2.getText(), textfield3.getText(),textfield5.getText());
				
			}
		});
		enroll1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {

enroll1();
				
			}
		});

	}
	private void enroll1()
	{
		this.setVisible(false);
		new employer();
	}
	private void identify(String uid, String fn, String ln, String ssn)
	{
		if(uid.isEmpty() || fn.isEmpty() || ln.isEmpty() || ssn.isEmpty())
		{
			if(uid.isEmpty())
			{
				textfield1.setText(JOptionPane.showInputDialog(null, "UID LEFT BLANK - ENTER UID"));
			}
			if(fn.isEmpty())
			{
				textfield2.setText(JOptionPane.showInputDialog(null, "FIRSTNAME LEFT BLANK - ENTER FIRST NAME"));
			}
			if(ln.isEmpty())
			{
				textfield3.setText(JOptionPane.showInputDialog(null, "LASTNAME LEFT BLANK - ENTER LAST NAME"));				
			}
			if(ssn.isEmpty())
			{
				textfield5.setText(JOptionPane.showInputDialog(null, "SSN LEFT BLANK - ENTER SSN"));				
				if(textfield5.getText().length() != 9)
				{
					textfield5.setText(JOptionPane.showInputDialog(null, "SSN SHOULD BE 9 DIGIT NUMBER"));				
				}

			}
		}
		else
		{
			if(ssn.length() != 9)
			{
				textfield5.setText(JOptionPane.showInputDialog(null, "SSN MUST BE 9 DIGIT NUMBER"));
			}
		}
			enroll(textfield1.getText(), textfield2.getText(), textfield3.getText(),textfield4.getText(),textfield5.getText(),dropdown.getSelectedItem().toString(),dropdown1.getSelectedItem().toString(),dropdown3.getSelectedItem().toString(),dropdown2.getSelectedItem().toString());
	}
	private void enroll(String employee1, String employee2, String employee3, String employee4, String employee5, String employee6, String employee7, String employee8, String employee9)
	{
		if(employee1.isEmpty() || employee2.isEmpty() || employee3.isEmpty() || employee5.isEmpty())
		{
		identify(employee1, employee2, employee3, employee5);	
		}
		else
		{
		if(employee6.equals("SCANNER 2"))
		{
			employee6 = "S2";
		}
		else if(employee6.equals("SCANNER 3"))
		{
			employee6 = "S3";
		}
		else if(employee6.equals("ADMINISTRATIVE ASSISTANT"))
		{
			employee6 = "AA";
		}
		else if(employee6.equals("PROCTOR"))
		{
			employee6 = "PR";
		}
		else if(employee6.equals("BRIALLE SPECIALIST"))
		{
			employee6 = "BS";
		}
		int dialog = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO HIRE "+employee2.toUpperCase());
		if(dialog == JOptionPane.YES_OPTION)
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
			String query = "insert into student_employee(UID, First_Name, Last_Name, Middle_Name, SSN, Position_id, Regular_Max_Hours, Break_Max_Hours, Department, Join_Date)"+"values(?,?,?,?,?,?,?,?,?,CurDate())";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, employee1);
			ps.setString(2, employee2);
			ps.setString(3, employee3);
			ps.setString(4, employee4);
			ps.setString(5, employee5);
			ps.setString(6, employee6);
			ps.setString(7, employee7);
			ps.setString(8, employee8);
			ps.setString(9, employee9);
			ps.executeUpdate();
			this.setVisible(false);
			new employer();
		}
		catch(Exception e)
		{
			System.out.println("PROBLEM WITH CONNECTION: "+e);
		}
		}
		else if(dialog == JOptionPane.CANCEL_OPTION || dialog == JOptionPane.NO_OPTION)
		{
			this.setVisible(false);
			new employer();
		}
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

		new addemployee();
		
	}

}
