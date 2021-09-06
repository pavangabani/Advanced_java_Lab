package preparest;
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class predemo
{
    public static void main(String[] args) 
    {

       try
       {
	   Class.forName("com.mysql.jdbc.Driver");
           Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");  
    
            PreparedStatement stmt=c.prepareStatement("select * from ulogin");  
            ResultSet rs=stmt.executeQuery();  
           while(rs.next()) 
           {
                System.out.print("ID : "+rs.getString("id")+", ");
                System.out.print("NAME : "+rs.getString("name")+", ");
                System.out.println("");
                
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