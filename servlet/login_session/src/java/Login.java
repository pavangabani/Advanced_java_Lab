/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import javax.servlet.http.*;  

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Hp
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      try{
              response.setContentType("text/html;charset=UTF-8");
              PrintWriter out = response.getWriter();
              request.getRequestDispatcher("link.html").include(request,response);
              String name=request.getParameter("n");
              String password=request.getParameter("p");
              
              Class.forName("com.mysql.jdbc.Driver");  
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
              
              Statement stmt=(Statement)con.createStatement();  
              ResultSet rs=stmt.executeQuery("select * from ulogin");
              int a=0;
              while(rs.next())
              {
                  if(name.equals(rs.getString(1)) && password.equals(rs.getString(2)))
                  {
                    out.println("you are successfully logged in!");
                    HttpSession session=request.getSession();
                    session.setAttribute("name", name);
                 
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
          PrintWriter out = response.getWriter();
          out.print(e);
                  
      }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
