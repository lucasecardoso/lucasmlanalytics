/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics;

import com.lucas.analytics.controller.QueryController;
import com.lucas.analytics.controller.SellerTypeController;
import com.lucas.analytics.controller.TransAggregateController;
import com.lucas.analytics.controller.UserController;
import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Main {
    public static void main(String[] args) {
        try {
            
            QueryController qc = new QueryController();
            UserController uc = new UserController();
            
            User test = uc.getUserByName("test");
            
            List<Query> queries = qc.getByUser(test);
            
            SellerTypeController sc = new SellerTypeController();
            
            TransAggregateController tc = new TransAggregateController();
            
            //tc.add(queries.get(0), "test_seller", 20, 15, 5);
            
            System.out.println(tc.getByQuery(queries.get(0)).get(0).getTotal());
            //sc.addIndicator(queries.get(0), 2, 8);
            
            //System.out.println(sc.getIndicatorByQuery(queries.get(0)).getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
