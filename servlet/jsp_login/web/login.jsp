<%-- 
    Document   : login
    Created on : 8 Apr, 2021, 11:52:14 AM
    Author     : Hp
--%>
<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
                  try{
            out.print("<a href='register.html'>Register</a><br><a href='login.html'>Login</a><br>");
              String name=request.getParameter("n");
              String password=request.getParameter("p");
              
              Class.forName("com.mysql.jdbc.Driver");  
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
              
              Statement stmt=(Statement)con.createStatement();  
              ResultSet rs=stmt.executeQuery("select * from emp1");
              int a=0;
              while(rs.next())
              {
                  if(name.equals(rs.getString(1)) && password.equals(rs.getString(2)))
                  {
                    out.println("you are successfully logged in!");
                    Cookie ck[]=request.getCookies();
                    
                    for(int i=0;i<ck.length;i++)
                    {  
                          out.print("<br>"+ck[i].getName()+" "+ck[i].getValue());
                    }
                    
                    
                    a=1;
                    break;
                  }
                  
              }
              if(a!=1)
              {
                  out.println("invalid username or password");
                  request.getRequestDispatcher("login.html").include(request,response);
              }
              out.close();
      }
      catch(Exception e)
      {
          out.print(e);
                  
      }
        %>
    </body>
</html>
