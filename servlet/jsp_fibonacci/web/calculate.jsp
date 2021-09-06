<%-- 
    Document   : calculate
    Created on : 8 Apr, 2021, 10:57:34 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <br>
        Output:
        <br>
        <%
            int n1=0,n2=1,n3,i;
            out.print(n1+" "+n2);
            String count=request.getParameter("no");
            int count1=Integer.parseInt(count);
            for(i=2;i<count1;++i)  
            {    
              n3=n1+n2;    
              out.print(" "+n3);    
              n1=n2;    
              n2=n3;    
            } 
        %>
    </body>
</html>
