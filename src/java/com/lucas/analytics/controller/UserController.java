/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller;

import com.lucas.analytics.conf.Constants;
import com.lucas.analytics.conf.PasswordHash;
import com.lucas.analytics.model.db.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
public class UserController implements AutoCloseable {
    
    Connection conn;
    
    public UserController() throws SQLException {
        System.out.println(Constants.getJdbcUrl());
        this.conn = DriverManager.getConnection(Constants.getJdbcUrl());
        
        createTable();
    }
    
    private void createTable() throws SQLException {
        
        Statement st = conn.createStatement();
        
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + " id int not null auto_increment, "
                + " username varchar(255), "
                + " pass varchar(512), "
                + " primary key (id, username))";
        
        
        st.execute(sql);
        
        st.close();
    }
    
    public User getUserByName(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, username);
        
        ResultSet result = stmt.executeQuery();
        
        User user = new User();
        
        if (!result.next())
            return null;
        
        user.setId(result.getInt("id"));
        user.setUsername(result.getString("username"));
        user.setPassword(result.getString("pass"));
        
        stmt.close();
        
        return user;
    }
    
    public boolean addUser(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        
        if (getUserByName(username) != null)
            return false;
        
        String sql = "INSERT INTO users (username, pass) "
                + "VALUES ( ?, ?) ";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, username);
        stmt.setString(2, PasswordHash.createHash(password));
        
        stmt.execute();
        
        stmt.close();
        
        return true;
    }
    
    public boolean checkUserLogin(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        User user = getUserByName(username);
        
        if (user == null)
            return false;
        
        return PasswordHash.validatePassword(password, user.getPassword());
    }
    
    @Override
    public void close() {
        if (conn == null)
            return;
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
