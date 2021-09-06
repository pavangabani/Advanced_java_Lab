/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callablemysql;

import java.sql.*;

/**
 *
 * @author Hp
 */
public class Callablemysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {  
  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
  
CallableStatement stmt=con.prepareCall("{call insertR(?,?)}");  
stmt.setInt(1,1011);  
stmt.setString(2,"");  
stmt.execute();  
  
System.out.println("success");  
          
} 
    
}
