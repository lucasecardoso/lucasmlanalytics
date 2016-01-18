/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.analytics.controller.ml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.analytics.model.Search;
import java.io.IOException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author Lucas
 */
public class SearchController {
    
    private static final String baseUrl = "https://api.mercadolibre.com/sites/MLA/search";
    
    public static Search getSearch(String query) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        String noWhitespace = query.replace(" ", "+");
        
        String targetUrl = baseUrl + "?q=" + StringEscapeUtils.escapeHtml4(noWhitespace) + "&limit=10";
        
        System.out.println("targetUrl: " + targetUrl);
        
        return mapper.readValue(Request.Get(targetUrl).execute().returnContent().asString(), Search.class);
   }
}
