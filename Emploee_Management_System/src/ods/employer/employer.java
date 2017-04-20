package ods.employer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ods.employer.addemployee;
import ods.employer.roles.*;
import ods.employer.removeemployee;

public class employer extends JFrame
{
	private JLabel label;
	private JButton ADMINISTRATIVE_ASSISTANCE;
	private JButton BRIALLE_SPECIALIST;
	private JButton SCANNER3;
	private JButton SCANNER2;
	private JButton PROCTOR;
	private JButton ADDEMPLOYEE;
	private JButton REMOVEEMPLOYEE;
	private JButton MESSAGE;
	private JPanel contentPane;
	private JButton jButton1;
	private JPanel contentPane1;
	private JTextField textfield;
	private JLabel label1;
	
	public employer()
	{
		super();
		employerinterface();
		this.setVisible(true);
	}
	
	public void employerinterface()
	{
		label = new JLabel("DISABILITY SERVICES OFFICE");
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
		
		this.setTitle("St. Thomas' College pf Engineering & Tech");
		this.setLocation(new Point(0, -1));
		this.setSize(new Dimension(400, 346));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ADMINISTRATIVE_ASSISTANCE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ADMINISTRATIVE_ASSISTANCE();
				
			}
		});
		BRIALLE_SPECIALIST.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BRIALLE_SPECIALIST();				
			}
		});
		SCANNER2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SCANNER2();
			}
		});
		SCANNER3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SCANNER3();
			}
		});
		PROCTOR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PROCTOR();
			}
		});
		ADDEMPLOYEE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next();		
			}
		});
		REMOVEEMPLOYEE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next1();		
			}
		});
		MESSAGE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				message();		
			}
		});
	}
	private void message()
	{
		String message = JOptionPane.showInputDialog(null, "TYPE MESSAGE");
		if(message != null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
				PreparedStatement ps = conn.prepareStatement("insert into message(message) values (?)");
				ps.setString(1, message);
				ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	private void next1()
	{
		this.setVisible(false);
		new removeemployee();
	}
	private void next()
	{
		this.setVisible(false);
		new addemployee();
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

		new employer();
		
	}

}
