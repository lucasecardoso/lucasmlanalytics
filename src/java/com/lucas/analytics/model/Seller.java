
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "power_seller_status",
    "car_dealer",
    "real_estate_agency",
    "tags"
})
public class Seller {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("power_seller_status")
    private Object powerSellerStatus;
    @JsonProperty("car_dealer")
    private Boolean carDealer;
    @JsonProperty("real_estate_agency")
    private Boolean realEstateAgency;
    @JsonProperty("tags")
    private List<Object> tags = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The powerSellerStatus
     */
    @JsonProperty("power_seller_status")
    public Object getPowerSellerStatus() {
        return powerSellerStatus;
    }

    /**
     * 
     * @param powerSellerStatus
     *     The power_seller_status
     */
    @JsonProperty("power_seller_status")
    public void setPowerSellerStatus(Object powerSellerStatus) {
        this.powerSellerStatus = powerSellerStatus;
    }

    /**
     * 
     * @return
     *     The carDealer
     */
    @JsonProperty("car_dealer")
    public Boolean getCarDealer() {
        return carDealer;
    }

    /**
     * 
     * @param carDealer
     *     The car_dealer
     */
    @JsonProperty("car_dealer")
    public void setCarDealer(Boolean carDealer) {
        this.carDealer = carDealer;
    }

    /**
     * 
     * @return
     *     The realEstateAgency
     */
    @JsonProperty("real_estate_agency")
    public Boolean getRealEstateAgency() {
        return realEstateAgency;
    }

    /**
     * 
     * @param realEstateAgency
     *     The real_estate_agency
     */
    @JsonProperty("real_estate_agency")
    public void setRealEstateAgency(Boolean realEstateAgency) {
        this.realEstateAgency = realEstateAgency;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
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
