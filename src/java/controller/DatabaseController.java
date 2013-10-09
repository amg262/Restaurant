/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DataAccessException;
import db.MenuItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuService;

/**
 *
 * @author Andy
 */
@WebServlet(name = "DatabaseController", urlPatterns = {"/DatabaseController"})
public class DatabaseController extends HttpServlet {

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
        
        String email = getServletContext().getInitParameter("webmaster");
        String driver = getServletContext().getInitParameter("driver");
        String path = getServletContext().getInitParameter("path");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");


        List<MenuItem> menuList = new ArrayList<>();
        MenuItem item = new MenuItem();
        MenuService ms = new MenuService(driver, path, username, password);
        //MenuService ms = new MenuService();

        String action = request.getParameter("action");
            

            try {
             
                if (action.equals("update")) {
                    
                    Object obj = request.getParameter("id");
                    Object obj2 = request.getParameter("name");
                    Object obj3 = request.getParameter("price");
                    
                    int id = Integer.valueOf(obj.toString());
                    String sId = obj.toString();
            
                    String name = obj2.toString();
                    double price = Double.valueOf(obj3.toString());

                    item.setMenuItemId(id);
                    item.setName(name);
                    item.setPrice(price);
                    ms.saveMenuItem(item);
                
                } else if (action.equals("getById")) {
                    Object obj = request.getParameter("id2");
                    String id = obj.toString();
                    item = ms.getMenuItemById(id);
                    
                } else if (action.equals("delete")) {
                    Object obj = request.getParameter("id3");
                    String id = obj.toString();
                    item = ms.getMenuItemById(id);
                    ms.deleteMenuItem(item);
                    
                } else if (action.equals("getAll")) {
                    menuList = ms.getAllMenuItems();
                }
            

            } catch (Exception e){
                
            }
            
            
            request.setAttribute("item", item);
            request.setAttribute("menuList", menuList);


        
        
        RequestDispatcher view = request.getRequestDispatcher("/admin.jsp");
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
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
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
