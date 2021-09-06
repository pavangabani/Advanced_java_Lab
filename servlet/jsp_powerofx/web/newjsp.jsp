<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
            String temp=request.getParameter("no1");
            int no1=Integer.parseInt(temp);
            
            temp =request.getParameter("no2");
            int no2=Integer.parseInt(temp);
            
            temp=request.getParameter("x");
            int x=Integer.parseInt(temp);
            
            long  ans=1;
            out.print("<table style='border: 1px solid black'>");
            out.print("<tr><td>Value</td><td>Answer</td><tr>");
            for(int i=no1;i<=no2;i++)
            {
               for(int j=0;j<x;j++)
               {
                   ans=ans*i;
               }
               
               out.print("<tr><td>"+i+"</td><td> "+ ans + "</td><tr>");
               ans=1;
            }
            out.print("</table>");
        %>
    </body>
</html>
