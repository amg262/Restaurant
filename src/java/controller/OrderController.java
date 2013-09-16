/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrderCalculator;

/**
 *
 * @author agunn1
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        OrderCalculator oc = new OrderCalculator();
        
        String sBill = "";
        String sTax = "";
        String sGratuity = "";
        String sFinalBill = "";
        
        String entree;
        String side;
        String drink;
        
        double tax;
        double gratuity;
        double finalBill;
        double bill;
        
        List en = new ArrayList();
        List si = new ArrayList();
        List dr = new ArrayList();
        
        entree = request.getParameter("entree");
        side = request.getParameter("side");
        drink = request.getParameter("drink");
        
        try {
            en = oc.getEntree(entree);
            si = oc.getSides(side);
            dr = oc.getDrinks(drink);
            
            bill = oc.getBill();
            gratuity = oc.getGratuity();
            tax = oc.getTax();
            finalBill = oc.getFinalBill();
            
            sBill = "" + bill;
            sGratuity = "" + gratuity;
            sTax =  "" + tax;
            sFinalBill = "" + finalBill;

        } catch (Exception e){
            
        }
 
        
        request.setAttribute("entree", en);
        request.setAttribute("side", si);
        request.setAttribute("drink", dr);
        request.setAttribute("bill", sBill);
        request.setAttribute("gratuity", sGratuity);
        request.setAttribute("tax", sTax);
        request.setAttribute("finalBill", sFinalBill);
        
        RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
        view.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
