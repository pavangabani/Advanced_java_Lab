import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class test extends JFrame implements ActionListener
{
	JButton bn,bp,bc,bs;
	JLabel lid,lname,lsalary,lcontact,lemail;
	JTextField tid,tname,tsalary,tcontact,temail;

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	test()
		{
			setLayout(new FlowLayout());

			bn=new JButton("NEXT");
			bp=new JButton("PREVIOUS");
			bc=new JButton("CLEAR");
			bs=new JButton("SUBMIT");

			lid=new JLabel("Enter Your Id No:");
			lname=new JLabel("Enter Your Name:");
			lsalary=new JLabel("Enter Salary:");
			lcontact=new JLabel("Enter Your Phone No:");
			lemail=new JLabel("Enter Your Emailaddress:");

			tid=new JTextField(10);
			tname=new JTextField(10);
			tsalary=new JTextField(10);
			tcontact=new JTextField(10);
			temail=new JTextField(10);
			

			add(lid);
			add(tid);
			add(lname);
			add(tname);
			add(lsalary);
			add(tsalary);
			add(lcontact);
			add(tcontact);
			add(lemail);
			add(temail);
			add(bn);
			add(bp);
			add(bs);
			add(bc);

			bn.addActionListener(this);
			bp.addActionListener(this);
			bs.addActionListener(this);
			bc.addActionListener(this);

			setSize(300,300);
			setVisible(true);

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
				st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
                rs=st.executeQuery("select * from emp"); 
				rs.absolute(1);
			}
			catch(Exception ae){System.out.println("Error : "+ae);}
		}
public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==bn)
		{
			try
				{
					int eid=Integer.parseInt(tid.getText());
					rs.absolute(eid);
					rs.next();
					String id=rs.getString(1);
                    String name=rs.getString(2);
                    String salary=rs.getString(3);
                    String contact=rs.getString(4);
                    String email=rs.getString(5); 
					
					tid.setText(id);
					tname.setText(name);
					tcontact.setText(contact);
					tsalary.setText(salary);
					temail.setText(email);
					
				}
			catch(Exception ae){System.out.println("Error : "+ae);}
		}
	if(e.getSource()==bp)
		{
			try
			{
					int eid=Integer.parseInt(tid.getText());
					rs.absolute(eid);
					rs.previous();
					String id=rs.getString(1);
                    String name=rs.getString(2);
                    String salary=rs.getString(3);
                    String contact=rs.getString(4);
                    String email=rs.getString(5); 
					
					tid.setText(id);
					tname.setText(name);
					tcontact.setText(contact);
					tsalary.setText(salary);
					temail.setText(email);
			}
			catch(Exception ae){System.out.println("Error : "+ae);}
		}

	if(e.getSource()==bc)
		{
			try
			{
					tid.setText(" ");
					tname.setText(" ");
					tcontact.setText(" ");
					tsalary.setText(" ");
					temail.setText(" ");
			}
			catch(Exception ae){System.out.println("Error : "+ae);}
		}
	if(e.getSource()==bs)
		{
			String query="INSERT INTO emp(id,name,salary,contact,email) VALUES(?,?,?,?,?)";
			try
			{
				pst=conn.prepareStatement(query);
				pst.setInt(1,Integer.parseInt(tid.getText()));
				pst.setString(2,tname.getText());
				pst.setInt(3,Integer.parseInt(tsalary.getText()));
				pst.setString(4,tcontact.getText());
				pst.setString(5,temail.getText());
				pst.executeUpdate();
			}
			catch(Exception ae){System.out.println("Error : "+ae);}
		}
	}
}
public class emp
{
	public static void main(String s[])
	{
		test t=new test();
	}
}