/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.model.response;

import com.google.gson.Gson;
import com.lucas.analytics.model.db.ConditionIndicator;
import com.lucas.analytics.model.db.Query;
import com.lucas.analytics.model.db.SellerTypeIndicator;
import com.lucas.analytics.model.db.TransactionAggregate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class QueryDetail {
    
    private Query query;
    private SellerTypeIndicator sellerTypeI;
    private ConditionIndicator conditionI;
    private List<TransactionAggregate> transactionAggregates = new ArrayList<>();
    
    public String getJson() {
        return new Gson().toJson(this);
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public SellerTypeIndicator getSellerTypeI() {
        return sellerTypeI;
    }

    public void setSellerTypeI(SellerTypeIndicator sellerTypeI) {
        this.sellerTypeI = sellerTypeI;
    }

    public List<TransactionAggregate> getTransactionAggregates() {
        return transactionAggregates;
    }

    public void setTransactionAggregates(List<TransactionAggregate> transactionAggregates) {
        this.transactionAggregates = transactionAggregates;
    }

    public ConditionIndicator getConditionI() {
        return conditionI;
    }

    public void setConditionI(ConditionIndicator conditionI) {
        this.conditionI = conditionI;
    }
    
    

    
}
