/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.db.servlet;

import com.google.gson.Gson;
import com.lucas.analytics.controller.ConditionController;
import com.lucas.analytics.controller.QueryController;
import com.lucas.analytics.controller.SellerTypeController;
import com.lucas.analytics.controller.TransAggregateController;
import com.lucas.analytics.controller.ml.SearchController;
import com.lucas.analytics.controller.UserController;
import com.lucas.analytics.controller.ml.MlaUserController;
import com.lucas.analytics.model.mlauser.MlaUser;
import com.lucas.analytics.model.Result;
import com.lucas.analytics.model.Search;
import com.lucas.analytics.model.db.ConditionIndicator;
import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.SellerTypeIndicator;
import com.lucas.analytics.model.db.TransactionAggregate;
import com.lucas.analytics.model.response.QueryDetail;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
public class SearchServlet extends HttpServlet {

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
                UserController uc = new UserController();
                TransAggregateController tc = new TransAggregateController();
                SellerTypeController stc = new SellerTypeController();
                ConditionController cc = new ConditionController()) {

            QueryDetail result = null;
            
            if (request.getParameter("new").equals("Y")) {
                Query insertedQuery = qc.add(request.getParameter("query"), uc.getUserByName(request.getParameter("username")));

                result = searchFromRemote(insertedQuery, tc, stc, cc);
            } else {
                Query query = qc.getByQueryValue(uc.getUserByName(request.getParameter("username")), request.getParameter("query"));
                
                if (request.getParameter("session").equals("new")) {
                    
                    System.out.println("It's a new session, deleting old indicators...");
                    tc.deleteByQuery(query);
                    stc.deleteByQuery(query);
                    cc.deleteByQuery(query);
                    
                    result = searchFromRemote(query, tc, stc, cc);
                } else {
                    
                    result = new QueryDetail();
                    
                    List<TransactionAggregate> taList = tc.getByQuery(query);
                    SellerTypeIndicator sti = stc.getByQuery(query);
                    ConditionIndicator ci = cc.getByQuery(query);
                    
                    result.setConditionI(ci);
                    result.setQuery(query);
                    result.setSellerTypeI(sti);
                    result.setTransactionAggregates(taList);
                    
                    result = searchFromRemote(query, tc, stc, cc);
                }
            }
            
            response.setContentType("application/json");
            response.getWriter().write(new Gson().toJson(result));

        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private QueryDetail searchFromRemote(Query query, TransAggregateController tc, SellerTypeController stc, ConditionController cc) throws SQLException, IOException {
        Search s = SearchController.getSearch(query.getQuery());
        QueryDetail result = new QueryDetail();

        int brandAm = 0;
        int normalAm = 0;
        int newItems = 0;
        int usedItems = 0;

        List<MlaUser> userList = new ArrayList<>();

        for (Result r : s.getResults()) {
            userList.add(MlaUserController.getUser(r.getSeller().getId()));
            
            if (r.getCondition() == null)
                continue;
            
            if (r.getCondition().equals("new")) {
                newItems++;
            } else {
                usedItems++;
            }
        }

        for (MlaUser u : userList) {
            if (u.getUserType() == null)
                continue;
            
            if (u.getUserType().equals("brand")) {
                brandAm++;
            } else {
                normalAm++;
            }

            result.getTransactionAggregates().add(tc.add(query, u));
        }

        result.setSellerTypeI(stc.add(query, brandAm, normalAm));
        result.setConditionI(cc.add(query, newItems, usedItems));
        result.setQuery(query);

        return result;
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
