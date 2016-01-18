/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.SellerTypeIndicator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class SellerTypeController extends AbstractController {

    
    public SellerTypeController() throws SQLException {
        super("seller_type_indicator");
        createTable();
    }
    
    @Override
    protected final void createTable() throws SQLException {
         String sql = "CREATE TABLE IF NOT EXISTS seller_type_indicator ( "
                + " id int not null auto_increment, "
                + " query_id int, "
                + " brand_am int,"
                + " normal_am int, "
                + " primary key (id, query_id))";
        
        Statement stmt = conn.createStatement();
        
        stmt.execute(sql);
        
        stmt.close();
    }
    
    
    public SellerTypeIndicator add(Query query, int brandAm, int normalAm) throws SQLException {
        String sql = "INSERT INTO seller_type_indicator (query_id, brand_am, normal_am) "
                + "VALUES (?, ?, ?)";
        
        System.out.println(sql);
        
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, query.getId());
        stmt.setInt(2, brandAm);
        stmt.setInt(3, normalAm);
        
        SellerTypeIndicator sti = new SellerTypeIndicator();
        
        stmt.execute();
        
        sti.setBrandAm(brandAm);
        sti.setNormalAm(normalAm);
        sti.setId(getGeneratedKey(stmt));
        
        return sti;
    }
    
    public SellerTypeIndicator getByQuery(Query query) throws SQLException {
        
        String sql = "SELECT * FROM seller_type_indicator WHERE query_id = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, query.getId());
        
        ResultSet rs = stmt.executeQuery();
        SellerTypeIndicator result = null;
        
        if (rs.first()) {
            result = new SellerTypeIndicator();
            result.setId(rs.getInt("id"));
            result.setBrandAm(rs.getInt("brand_am"));
            result.setNormalAm(rs.getInt("normal_am"));
            result.setQueryId(rs.getInt("query_id"));
        }
        
        return result;
    }
}
