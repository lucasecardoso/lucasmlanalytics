/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.conf.Constants;
import com.lucas.analytics.model.db.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public abstract class AbstractController implements AutoCloseable {
    
    protected Connection conn;
    protected String table;
    
    public AbstractController(String tableName) throws SQLException {
        conn = DriverManager.getConnection(Constants.getJdbcUrl());
        table = tableName;
    }
    
    protected abstract void createTable() throws SQLException;
    
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        return stmt.execute();
    }
    
    protected int getGeneratedKey(Statement stmt) throws SQLException {
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        
        generatedKeys.first();
        
        return generatedKeys.getInt(1);
    }
    
    public int deleteByQuery(Query query) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE query_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, query.getId());
        
        return stmt.executeUpdate();
    }
    
    @Override
    public void close() {
        if (conn != null)
        {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QueryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
