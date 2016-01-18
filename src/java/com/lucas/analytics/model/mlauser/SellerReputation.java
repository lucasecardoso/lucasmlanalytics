
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
    "level_id",
    "power_seller_status",
    "transactions"
})
public class SellerReputation {

    @JsonProperty("level_id")
    private String levelId;
    @JsonProperty("power_seller_status")
    private Object powerSellerStatus;
    @JsonProperty("transactions")
    private Transactions transactions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The levelId
     */
    @JsonProperty("level_id")
    public String getLevelId() {
        return levelId;
    }

    /**
     * 
     * @param levelId
     *     The level_id
     */
    @JsonProperty("level_id")
    public void setLevelId(String levelId) {
        this.levelId = levelId;
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
     *     The transactions
     */
    @JsonProperty("transactions")
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * 
     * @param transactions
     *     The transactions
     */
    @JsonProperty("transactions")
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
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
