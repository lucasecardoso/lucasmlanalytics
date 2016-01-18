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
public class ConditionIndicator {
    
    private int id;
    private int queryId;
    private int newItems;
    private int usedItems;

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

    public int getNewItems() {
        return newItems;
    }

    public void setNewItems(int newItems) {
        this.newItems = newItems;
    }

    public int getUsedItems() {
        return usedItems;
    }

    public void setUsedItems(int usedItems) {
        this.usedItems = usedItems;
    }
    
    
}
