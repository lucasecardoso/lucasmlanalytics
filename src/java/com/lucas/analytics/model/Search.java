
package com.lucas.analytics.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
        
        
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "site_id",
    "query",
    "paging",
    "results",
    "secondary_results",
    "related_results",
    "sort",
    "available_sorts",
    "filters",
    "available_filters"
})
public class Search {

    @JsonProperty("site_id")
    private String siteId;
    @JsonProperty("query")
    private String query;
    @JsonProperty("paging")
    private Paging paging;
    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("secondary_results")
    private List<Object> secondaryResults = new ArrayList<Object>();
    @JsonProperty("related_results")
    private List<Object> relatedResults = new ArrayList<Object>();
    @JsonProperty("sort")
    private Sort sort;
    @JsonProperty("available_sorts")
    private List<AvailableSort> availableSorts = new ArrayList<AvailableSort>();
    @JsonProperty("filters")
    private List<Filter> filters = new ArrayList<Filter>();
    @JsonProperty("available_filters")
    private List<AvailableFilter> availableFilters = new ArrayList<AvailableFilter>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The siteId
     */
    @JsonProperty("site_id")
    public String getSiteId() {
        return siteId;
    }

    /**
     * 
     * @param siteId
     *     The site_id
     */
    @JsonProperty("site_id")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * 
     * @return
     *     The query
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The paging
     */
    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    /**
     * 
     * @param paging
     *     The paging
     */
    @JsonProperty("paging")
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    /**
     * 
     * @return
     *     The results
     */
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * 
     * @return
     *     The secondaryResults
     */
    @JsonProperty("secondary_results")
    public List<Object> getSecondaryResults() {
        return secondaryResults;
    }

    /**
     * 
     * @param secondaryResults
     *     The secondary_results
     */
    @JsonProperty("secondary_results")
    public void setSecondaryResults(List<Object> secondaryResults) {
        this.secondaryResults = secondaryResults;
    }

    /**
     * 
     * @return
     *     The relatedResults
     */
    @JsonProperty("related_results")
    public List<Object> getRelatedResults() {
        return relatedResults;
    }

    /**
     * 
     * @param relatedResults
     *     The related_results
     */
    @JsonProperty("related_results")
    public void setRelatedResults(List<Object> relatedResults) {
        this.relatedResults = relatedResults;
    }

    /**
     * 
     * @return
     *     The sort
     */
    @JsonProperty("sort")
    public Sort getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    @JsonProperty("sort")
    public void setSort(Sort sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The availableSorts
     */
    @JsonProperty("available_sorts")
    public List<AvailableSort> getAvailableSorts() {
        return availableSorts;
    }

    /**
     * 
     * @param availableSorts
     *     The available_sorts
     */
    @JsonProperty("available_sorts")
    public void setAvailableSorts(List<AvailableSort> availableSorts) {
        this.availableSorts = availableSorts;
    }

    /**
     * 
     * @return
     *     The filters
     */
    @JsonProperty("filters")
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * 
     * @return
     *     The availableFilters
     */
    @JsonProperty("available_filters")
    public List<AvailableFilter> getAvailableFilters() {
        return availableFilters;
    }

    /**
     * 
     * @param availableFilters
     *     The available_filters
     */
    @JsonProperty("available_filters")
    public void setAvailableFilters(List<AvailableFilter> availableFilters) {
        this.availableFilters = availableFilters;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    

}
