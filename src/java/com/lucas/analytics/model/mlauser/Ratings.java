
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
    "positive",
    "negative",
    "neutral"
})
public class Ratings {

    @JsonProperty("positive")
    private Double positive;
    @JsonProperty("negative")
    private Integer negative;
    @JsonProperty("neutral")
    private Double neutral;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The positive
     */
    @JsonProperty("positive")
    public Double getPositive() {
        return positive;
    }

    /**
     * 
     * @param positive
     *     The positive
     */
    @JsonProperty("positive")
    public void setPositive(Double positive) {
        this.positive = positive;
    }

    /**
     * 
     * @return
     *     The negative
     */
    @JsonProperty("negative")
    public Integer getNegative() {
        return negative;
    }

    /**
     * 
     * @param negative
     *     The negative
     */
    @JsonProperty("negative")
    public void setNegative(Integer negative) {
        this.negative = negative;
    }

    /**
     * 
     * @return
     *     The neutral
     */
    @JsonProperty("neutral")
    public Double getNeutral() {
        return neutral;
    }

    /**
     * 
     * @param neutral
     *     The neutral
     */
    @JsonProperty("neutral")
    public void setNeutral(Double neutral) {
        this.neutral = neutral;
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
