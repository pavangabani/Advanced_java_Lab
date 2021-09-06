package javaapplication3;
import java.sql.*;
import java.util.Scanner;
public class JavaApplication3 
{
    public static void main(String[] args) 
    {
       Scanner input=new Scanner(System.in);
       Scanner input1=new Scanner(System.in);
       int i=1;
       try
       {
	   Class.forName("com.mysql.jdbc.Driver");
           Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
           Statement st=c.createStatement();

           while(i==1){
         
           System.out.println("Query : ");
           String q=input1.nextLine();
           
           st.executeUpdate(q);
           ResultSet rs=st.executeQuery("select * from login");
           while(rs.next()) 
           {
                System.out.print("ID : "+rs.getString("id")+", ");
                System.out.print("NAME : "+rs.getString("name")+", ");
                System.out.print("CITY : "+rs.getString("city")+", ");
                System.out.print("EMAIL ID : "+rs.getString("emailid")+", ");
                System.out.print("CONTACT : "+rs.getString("contact")+", ");
                System.out.print("SALARY: "+rs.getString("salary"));
                System.out.println("");
                
            }
           System.out.print("Enter 1 for enter query & 0 for quit :");
           i=input.nextInt();
           }
	}
	catch(Exception e)
	{
			System.out.println("Error : " +e);
	}
    }
    
}
//INSERT INTO login VALUES(1,'Mautik','bhavnagar','mautik@gmail.com','4356782310',10)
//UPDATE login set name='donda' where ID=1
//delete from login where id=1