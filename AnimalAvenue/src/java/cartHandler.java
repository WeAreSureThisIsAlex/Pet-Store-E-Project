/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.*;
import Data.Access;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author Alexander Lawton
 */
@WebServlet(urlPatterns = {"/cartHandler"})
public class cartHandler extends HttpServlet {

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
        //Declarations
        HttpSession S = request.getSession();
        
        //check to see if Cart exists in Session and whether or not a Customer is logged in
        if (S.getAttribute("c1")==null) {
            RequestDispatcher rd = request.getRequestDispatcher("customer_login.html");
            rd.forward(request, response);
        }
        else {
            if (S != null && S.getAttribute("cart") == null) {
                Cart sessionCart = new Cart();
                if (S != null & S.getAttribute("c1") != null) {
                    Customer C = (Customer) S.getAttribute("c1");
                    sessionCart = new Cart(C.getId(), new ItemList());
                }
                S.setAttribute("cart", sessionCart);
            }
        
            Cart cart = (Cart) S.getAttribute("cart");
        
            //Add Selected Item to Cart (add statements)
            int sku = Integer.parseInt(request.getParameter("action"));
            Product P = new Product();
            P.selectDB(sku);
            cart.addItem(new Item(P, 1));
        
            //Update Cart in Session
            S.setAttribute("cart", cart);
        
            //Redirect to Cart page
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
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
