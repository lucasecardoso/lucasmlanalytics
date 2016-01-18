/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class QueryController extends AbstractController implements AutoCloseable{
    
    public QueryController() throws SQLException {
        super("queries");
        createTable();
    }
    
    @Override
    protected final void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS queries ( "
                + " id int not null auto_increment, "
                + " user_id int, "
                + " query varchar(255), "
                + " primary key (id))";
        
        Statement stmt = conn.createStatement();
        
        stmt.execute(sql);
        
        stmt.close();
    }
    
    public Query add(String query, User user) throws SQLException {
        String sql = "INSERT INTO queries (user_id, query) "
                + " VALUES (?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, user.getId());
        stmt.setString(2, query);
        
        stmt.execute();
        
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        
        generatedKeys.first();
        
        Query q = new Query();
        q.setUserId(user.getId());
        q.setQuery(query);
        q.setId(generatedKeys.getInt(1));
        
        stmt.close();
        
        return q;
    }
    
    public Query getByQueryValue(User user, String queryValue) throws SQLException {
        String sql = "SELECT * FROM queries WHERE query = ? and user_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, queryValue);
        stmt.setInt(2, user.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        rs.first();
        
        Query q = new Query();
        
        q.setId(rs.getInt("id"));
        q.setQuery(rs.getString("query"));
        
        return q;
    }
    
    public List<Query> getByUser(User user) throws SQLException {
        
        String sql = "SELECT * FROM queries WHERE user_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, user.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        List<Query> queries = new ArrayList<>();
        
        while (rs.next()) {
            Query query = new Query();
            query.setId(rs.getInt("id"));
            query.setUserId(rs.getInt("user_id"));
            query.setQuery(rs.getString("query"));
            
            queries.add(query);
        }
        
        return queries;
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
