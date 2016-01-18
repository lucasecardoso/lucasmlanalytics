/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.TransactionAggregate;
import com.lucas.analytics.model.mlauser.MlaUser;
import com.lucas.analytics.model.mlauser.Transactions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class TransAggregateController extends AbstractController {

    public TransAggregateController() throws SQLException {
        super("transaction_aggregate");
        createTable();
    }

    @Override
    protected final void createTable() throws SQLException {
        
        String transSql = "CREATE TABLE IF NOT EXISTS " + table + " ("
                + "id int not null auto_increment, "
                + "query_id int not null, "
                + "seller_name varchar(512),"
                + "total int, "
                + "completed int, "
                + "failed int, "
                + "primary key (id))";
        
        
        Statement stmt = conn.createStatement();
        
        stmt.execute(transSql);
    }
    
    public TransactionAggregate add(Query query, MlaUser user) throws SQLException {
        
        String sql = "INSERT INTO " + table + " (query_id, seller_name, total, completed, failed) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        Transactions t = user.getSellerReputation().getTransactions();
        
        stmt.setInt(1, query.getId());
        stmt.setString(2, user.getNickname());
        stmt.setInt(3, t.getTotal());
        stmt.setInt(4, t.getCompleted());
        stmt.setInt(5, t.getCanceled());
        
        stmt.execute();
        
        TransactionAggregate ta = new TransactionAggregate();
        
        ta.setId(getGeneratedKey(stmt));
        ta.setQueryId(query.getId());
        ta.setTotal(t.getTotal());
        ta.setCompleted(t.getCompleted());
        ta.setFailed(t.getCanceled());
        ta.setSellerName(user.getNickname());
        
        stmt.close();
        
        return ta;
    }
    
    public int update(TransactionAggregate t) throws SQLException {
        
        String sql = "UPDATE " + table + " SET "
                + "seller_name = ? "
                + "total = ? "
                + "completed = ? "
                + "failed = ? "
                + "WHERE id = ? ";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, t.getSellerName());
        stmt.setInt(2, t.getTotal());
        stmt.setInt(3, t.getCompleted());
        stmt.setInt(4, t.getFailed());
        stmt.setInt(5, t.getId());
        
        int result = stmt.executeUpdate();
        
        stmt.close();
        
        return result;
    }
    
    public List<TransactionAggregate> getByQuery(Query query) throws SQLException {
        
        String sql = "SELECT * FROM " + table + " WHERE query_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, query.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        List<TransactionAggregate> aggregates = new ArrayList<>();
        
        while (rs.next()) {
            TransactionAggregate ta = new TransactionAggregate();
            ta.setId(rs.getInt("id"));
            ta.setCompleted(rs.getInt("completed"));
            ta.setFailed(rs.getInt("failed"));
            ta.setTotal(rs.getInt("total"));
            ta.setQueryId(query.getId());
            ta.setSellerName(rs.getString("seller_name"));
            
            aggregates.add(ta);
        }
        
        return aggregates;
    }
    
     
}
