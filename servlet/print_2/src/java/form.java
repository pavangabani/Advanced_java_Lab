/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikunj
 */
public class form extends HttpServlet {

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
        processRequest(request, response);
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