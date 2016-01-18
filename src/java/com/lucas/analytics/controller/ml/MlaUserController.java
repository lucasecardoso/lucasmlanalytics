/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller.ml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.analytics.model.mlauser.MlaUser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Lucas
 */
public class MlaUserController {
    
    private static final String baseUrl = "https://api.mercadolibre.com/users/";
    
    public static MlaUser getUser(int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        String targetUrl = baseUrl + id;
        
        String json = Request.Get(targetUrl).execute().returnContent().asString();
        
        return mapper.readValue(json, MlaUser.class);
    }
}
