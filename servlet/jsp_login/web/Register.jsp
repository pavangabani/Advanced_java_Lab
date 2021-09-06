<%@ page import="java.sql.*"%>
<html>
<body>
<%
  try {
 out.print("<a href='register.html'>Register</a><br><a href='login.html'>Login</a><br>");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan", "root", "");
    PreparedStatement ps=con.prepareStatement("insert into emp1 values(?,?,?,?)");
    String name=request.getParameter("t1");
    String pass=request.getParameter("t2");
    String contact=request.getParameter("t3");
    String email=request.getParameter("t4");
    
   Cookie ck=new Cookie("email",email);
   response.addCookie(ck);
   
   Cookie ck1=new Cookie("contact",contact);
   response.addCookie(ck1);
  
    ps.setString(1, name);
    ps.setString(2, pass);
    ps.setString(3, contact);
    ps.setString(4, email);
    
    int i=ps.executeUpdate();  
    if(i>0)
    {
        out.print("succussfully Registered");
    }

  }
  catch(Exception e) { 
    out.println(e);
  }
%>

</body>
</html>
