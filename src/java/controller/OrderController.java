/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbaccess.DataAccessException;
import model.MenuItem;
import model.MenuService;
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
     * @throws DataAccessException  
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DataAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MenuService ms = new MenuService();
        
        try {
        
        List<MenuItem> order = new ArrayList();
        List<MenuItem> allMenuItems = ms.getAllMenuItems();


        
        
        double tax = 0;
        double finalBill = 0;
        double gratuity = 0;
        double bill = 0;
        
        String sTax = "";
        String sGratuity = "";
        String sFinalBill = "";
        String sBill = "";
        

            for (int i=0; i < allMenuItems.size(); i++ ){
            Object object1 = request.getParameter("menuEntry" + i);
                if (object1 != null){
                    order.add(allMenuItems.get(i));
                }
            }

            
            OrderCalculator oc = new OrderCalculator(order);
            bill = oc.getBill();
            gratuity = oc.getGratuity();
            tax = oc.getTax();
            finalBill = oc.getFinalBill();
            
            sBill = "" + bill;
            sTax = "" + tax;
            sGratuity = "" + gratuity;
            sFinalBill = "" + finalBill;
            
            request.setAttribute("order", order);
            request.setAttribute("bill", sBill);
            request.setAttribute("tax", sTax);
            request.setAttribute("gratuity", sGratuity);
            request.setAttribute("finalBill", sFinalBill);

        } catch (Exception e){
            
        }
        
        
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
        try {
            processRequest(request, response);
        } catch (DataAccessException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (DataAccessException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
