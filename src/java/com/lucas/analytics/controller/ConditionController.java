/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.model.db.ConditionIndicator;
import com.lucas.analytics.model.db.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class ConditionController extends AbstractController {

    public ConditionController() throws SQLException {
        super("condition_indicator");
        createTable();
    }

    @Override
    protected final void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + table + " ("
                + "id int not null auto_increment, "
                + "query_id int, "
                + "new_items int, "
                + "used_items int, "
                + "primary key (id, query_id))";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.execute();
        
        stmt.close();
    }
    
    public ConditionIndicator add(Query query, int newItems, int usedItems) throws SQLException {
        
        String sql = "INSERT INTO " + table + " (query_id, new_items, used_items) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, query.getId());
        stmt.setInt(2, newItems);
        stmt.setInt(3, usedItems);
        
        stmt.execute();
        
        ConditionIndicator ci = new ConditionIndicator();
        ci.setId(getGeneratedKey(stmt));
        ci.setNewItems(newItems);
        ci.setUsedItems(usedItems);
        ci.setQueryId(query.getId());
        
        return ci;
    }
    
    public ConditionIndicator getByQuery(Query query) throws SQLException {
        
        String sql = "SELECT * FROM " + table + " WHERE query_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        System.out.println("Query id: " + query.getId());
        
        stmt.setInt(1, query.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        rs.first();
        
        ConditionIndicator ci = new ConditionIndicator();
        ci.setId(rs.getInt("id"));
        ci.setNewItems(rs.getInt("new_items"));
        ci.setQueryId(rs.getInt("query_id"));
        ci.setUsedItems(rs.getInt("used_items"));
        
        return ci;
    }
    
}
