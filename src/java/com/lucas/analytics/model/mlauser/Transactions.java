
package com.lucas.analytics.model.mlauser;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "period",
    "total",
    "completed",
    "canceled",
    "ratings"
})
public class Transactions {

    @JsonProperty("period")
    private String period;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("completed")
    private Integer completed;
    @JsonProperty("canceled")
    private Integer canceled;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The period
     */
    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    /**
     * 
     * @param period
     *     The period
     */
    @JsonProperty("period")
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The completed
     */
    @JsonProperty("completed")
    public Integer getCompleted() {
        return completed;
    }

    /**
     * 
     * @param completed
     *     The completed
     */
    @JsonProperty("completed")
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    /**
     * 
     * @return
     *     The canceled
     */
    @JsonProperty("canceled")
    public Integer getCanceled() {
        return canceled;
    }

    /**
     * 
     * @param canceled
     *     The canceled
     */
    @JsonProperty("canceled")
    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    /**
     * 
     * @return
     *     The ratings
     */
    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * 
     * @param ratings
     *     The ratings
     */
    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
