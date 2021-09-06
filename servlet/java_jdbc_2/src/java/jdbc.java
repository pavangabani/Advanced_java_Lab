import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.*;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


// Import Database Connection Class file; 

// Servlet Name 
@WebServlet("/jdbc") 
public class jdbc extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		try { 
                       response.setContentType("text/html");  
                       PrintWriter out = response.getWriter();  
      
                       ServletConfig config=getServletConfig();  
                       String driver=config.getInitParameter("driver");  
                       out.print("Driver is: "+driver); 
                                   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formjdbc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=30%>");
            out.println("<tr>");
            out.println("<th>Parameter</th>");
            out.println("<th>Details</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Item number</td>");
            out.println("<td>" + request.getParameter("t1") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Quantity</td>");
            out.println("<td>" + request.getParameter("t2") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Price each</td>");
            out.println("<td>" + request.getParameter("t3") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>First name</td>");
            out.println("<td>" + request.getParameter("t4") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Last name</td>");
            out.println("<td>" + request.getParameter("t5") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Middle Initial</td>");
            out.println("<td>" + request.getParameter("t6") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Shipping address</td>");
            out.println("<td>" + request.getParameter("t7") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Credit card type</td>");
            out.println("<td>" + request.getParameter("credit card") + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Credit card number</td>");
            out.println("<td>" + request.getParameter("t8") + "</td>");
            out.println("</tr>");
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");       

			// Initialize the database 
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");  

			// Create a SQL query to insert data into demo table 
			// demo table consists of two columns, so two '?' is used 
			PreparedStatement st = con.prepareStatement("insert into shop values(?,?,?,?,?,?,?,?)"); 

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 							
			st.setString(1, request.getParameter("t1")); 
			st.setString(2, request.getParameter("t2")); 
                        st.setString(3, request.getParameter("t3")); 
                        st.setString(4, request.getParameter("t4")); 
                        st.setString(5, request.getParameter("t5")); 
                        st.setString(6, request.getParameter("t6")); 
                        st.setString(7, request.getParameter("t7")); 
                        st.setString(8, request.getParameter("t8")); 

			// Execute the insert command using executeUpdate() 
			// to make changes in database 
			st.executeUpdate(); 

			// Close all the connections 
			st.close(); 
			con.close(); 

			// Get a writer pointer 
			// to display the successful result 
	    
		} 
		catch (Exception e) { 
                    PrintWriter out = response.getWriter(); 
			out.println(e);
		} 
	} 
} 
