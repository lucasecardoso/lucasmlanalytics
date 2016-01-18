/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.model.db;

/**
 *
 * @author Lucas
 */
public class SellerTypeIndicator {
    
    private int id;
    private int queryId;
    private int brandAm;
    private int normalAm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public int getBrandAm() {
        return brandAm;
    }

    public void setBrandAm(int brandAm) {
        this.brandAm = brandAm;
    }

    public int getNormalAm() {
        return normalAm;
    }

    public void setNormalAm(int normalAm) {
        this.normalAm = normalAm;
    }
    
    
}
