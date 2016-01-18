/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.db.servlet;

import com.lucas.analytics.controller.ConditionController;
import com.lucas.analytics.controller.QueryController;
import com.lucas.analytics.controller.SellerTypeController;
import com.lucas.analytics.controller.TransAggregateController;
import com.lucas.analytics.model.db.Query;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class DeleteServlet extends HttpServlet {

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
        
        try (QueryController qc = new QueryController(); 
                SellerTypeController stc = new SellerTypeController();
                TransAggregateController tc = new TransAggregateController();
                ConditionController cc = new ConditionController()) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String queryStr = request.getParameter("query");
            
            qc.delete(id);
            
            Query query = new Query();
            query.setId(id);
            query.setQuery(queryStr);
            
            stc.deleteByQuery(query);
            tc.deleteByQuery(query);
            cc.deleteByQuery(query);
            
            response.getWriter().print("OK");
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            ex.printStackTrace();
            response.getWriter().print("NOK");
        } catch (NumberFormatException ex) {
            System.out.println("NFE");
            response.getWriter().print("NFE");
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
