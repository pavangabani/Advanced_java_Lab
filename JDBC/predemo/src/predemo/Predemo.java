/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hp
 */
public class Predemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
