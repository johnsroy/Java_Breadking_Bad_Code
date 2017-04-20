package ods;

import java.awt.Color;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import ods.employee.employee;
import ods.employer.employer;


public class main extends JFrame
{
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JPanel contentPane;
	//creating a constructor.
		public main()
		{
			// calling super class
			super();
			//calling method initializeComponent.
			initializeComponent();
			//making JFrame visibility to true.
			this.setVisible(true);
		}
		
	//method: initializeComponent.	
		private void initializeComponent()
		{
			String message = "";
			// label image.
			JLabel bckimge = new JLabel(new ImageIcon("img.jpg"));
			//bckimge.setLayout(new FlowLayout());
			try
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsproject", "root", "sourish");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select message from message");
				while(rs.next())
				{
					message = rs.getString("message");
				}
				rs.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			jTextArea1 = new JTextArea();
			jTextArea1.setEditable(false);
			jScrollPane1 = new JScrollPane();
			if(message != "")
			{
				jTextArea1.setFont(new Font("Courier New",Font.BOLD,20));
				jTextArea1.setForeground(Color.BLACK);
				jTextArea1.setText(message);

			}
			jButton1 = new JButton();
			jButton2 = new JButton();
			jButton3 = new JButton();
			jButton4 = new JButton();
			jButton5 = new JButton();
			jButton6 = new JButton();

			//calling contentpane.
			contentPane = (JPanel)this.getContentPane();
			jScrollPane1.setViewportView(jTextArea1);
			
			//setting background and foreground colors from buttons.
			jButton1.setBackground(new Color(42, 43, 74));
			jButton1.setForeground(new Color(233, 219, 219));
			jButton1.setText("EMPLOYEE");
			jButton2.setBackground(new Color(42, 43, 74));
			jButton2.setForeground(new Color(233, 219, 219));
			jButton2.setText("EMPLOYER");
			
			contentPane.setLayout(null);
			contentPane.setBackground(new Color(83, 90, 113));
			//addComponent(contentPane, bckimge, 26,29,290,230);
			//addComponent(contentPane, bckimge1, 0,3,750,150);
			
			//calling method addComponent.
			//contentpane, button/field, horizontal spacing, vertical spacing, width, height.
			addComponent(contentPane, bckimge, 0,0,180,180);
			addComponent(contentPane, jScrollPane1, 5, 180, 345, 100);
			addComponent(contentPane, jButton1, 200,17,153,51);
			addComponent(contentPane, jButton2, 200,110,152,52);

			//setting title, location, size for frame.
			this.setTitle("DISABILITY SERVICES OFFICE");
			this.setLocation(new Point(0, -1));
			this.setSize(new Dimension(400, 346));
			//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//adding action listener to the button.
			
			jButton1.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent arg0) 
				{
					//calling employee button
					employeebutton(arg0);
				}
			});  // jbutton1 action-listener ends
			
			//adding action listener to the button.
			jButton2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg1)
				{
					//initializing string "name".
					String name = "Rahul Singh";

					//initializing dialog box to str.
					String str = JOptionPane.showInputDialog(null, "IDENTIFICATION REQUIRED");
					
					//verifying dialog box text with name.
					if (str.toLowerCase().matches(name.toLowerCase()))
					{
						//calling employer button method and passing args1 as arguments.
						employerbutton(arg1);
					} //if condition ends.
					
					else
						JOptionPane.showMessageDialog(null, "you don't have access"); //error message
				} // else close
			}); // jbutton2 action-listener ends.
		} //ends initialize component method.

		//addcomponent method takes container, component, dimensions.
		private void addComponent(Container container,Component c,int x,int y,int width,int height)
		{
			c.setBounds(x,y,width,height);
			container.add(c);
		}
		//employee button method
		private void employeebutton(ActionEvent arg0)
		{
			new employee();
		}
		//employer button method
		private void employerbutton(ActionEvent arg1)
		{
			new employer();
		}
		
		//main method begins
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
		
			//calling constructor.
			new main();
	}
}
