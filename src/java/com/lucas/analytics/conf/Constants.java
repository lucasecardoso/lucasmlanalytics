/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.conf;

/**
 *
 * @author Lucas
 */
public class Constants {

    public static final String DB_USERNAME = "lucas";
    public static final String DB_PASSWORD = "K0ukakukidoutai";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "lucas";
    public static final String DB_HOSTNAME = "localhost";

    public static String getJdbcUrl() {
        String dbName = System.getProperty("RDS_DB_NAME");
        String userName = System.getProperty("RDS_USERNAME");
        String password = System.getProperty("RDS_PASSWORD");
        String hostname = System.getProperty("RDS_HOSTNAME");
        String port = System.getProperty("RDS_PORT");

//        return "jdbc:mysql://" + DB_HOSTNAME + ":" +
//            DB_PORT + "/" + DB_NAME + "?user=" + DB_USERNAME + "&password=" + DB_PASSWORD;
        
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" +
            port + "/" + dbName + "?user=" + userName + "&password=" + password;
        
        return jdbcUrl;
    }
}
