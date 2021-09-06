<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
       try{
              String name=(String)${param.n};
              String password=${param.p};
          
                  if(name.equals("pavan") && password.equals("p"))
                  {
                    out.println("you are successfully logged in!");
                    out.print("Hello,${sessionScop.name}");
                  }
                  else
                  {
                  out.println("invalid username or password");
                  out.print("Hello,${sessionScop.name}");
                
                  }                   
      }
      catch(Exception e)
      {
          out.print(e);
                  
      }
        %>
    </body>
</html>
