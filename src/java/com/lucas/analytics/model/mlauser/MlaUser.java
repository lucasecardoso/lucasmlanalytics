
package com.lucas.analytics.model.mlauser;

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
    "nickname",
    "registration_date",
    "country_id",
    "address",
    "user_type",
    "tags",
    "logo",
    "points",
    "site_id",
    "permalink",
    "seller_reputation",
    "buyer_reputation",
    "status"
})
public class MlaUser {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("registration_date")
    private String registrationDate;
    @JsonProperty("country_id")
    private String countryId;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("tags")
    private List<String> tags = new ArrayList<String>();
    @JsonProperty("logo")
    private Object logo;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("site_id")
    private String siteId;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("seller_reputation")
    private SellerReputation sellerReputation;
    @JsonProperty("buyer_reputation")
    private BuyerReputation buyerReputation;
    @JsonProperty("status")
    private Status status;
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
     *     The nickname
     */
    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     * @param nickname
     *     The nickname
     */
    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     * @return
     *     The registrationDate
     */
    @JsonProperty("registration_date")
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * 
     * @param registrationDate
     *     The registration_date
     */
    @JsonProperty("registration_date")
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * 
     * @return
     *     The countryId
     */
    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

    /**
     * 
     * @param countryId
     *     The country_id
     */
    @JsonProperty("country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The userType
     */
    @JsonProperty("user_type")
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType
     *     The user_type
     */
    @JsonProperty("user_type")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The logo
     */
    @JsonProperty("logo")
    public Object getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    @JsonProperty("logo")
    public void setLogo(Object logo) {
        this.logo = logo;
    }

    /**
     * 
     * @return
     *     The points
     */
    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

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
     *     The permalink
     */
    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    /**
     * 
     * @param permalink
     *     The permalink
     */
    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * 
     * @return
     *     The sellerReputation
     */
    @JsonProperty("seller_reputation")
    public SellerReputation getSellerReputation() {
        return sellerReputation;
    }

    /**
     * 
     * @param sellerReputation
     *     The seller_reputation
     */
    @JsonProperty("seller_reputation")
    public void setSellerReputation(SellerReputation sellerReputation) {
        this.sellerReputation = sellerReputation;
    }

    /**
     * 
     * @return
     *     The buyerReputation
     */
    @JsonProperty("buyer_reputation")
    public BuyerReputation getBuyerReputation() {
        return buyerReputation;
    }

    /**
     * 
     * @param buyerReputation
     *     The buyer_reputation
     */
    @JsonProperty("buyer_reputation")
    public void setBuyerReputation(BuyerReputation buyerReputation) {
        this.buyerReputation = buyerReputation;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
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
