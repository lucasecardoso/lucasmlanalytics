
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
    "site_id",
    "title",
    "subtitle",
    "seller",
    "price",
    "currency_id",
    "available_quantity",
    "sold_quantity",
    "buying_mode",
    "listing_type_id",
    "stop_time",
    "condition",
    "permalink",
    "thumbnail",
    "accepts_mercadopago",
    "installments",
    "address",
    "shipping",
    "seller_address",
    "attributes",
    "differential_pricing",
    "original_price",
    "category_id",
    "official_store_id"
})
public class Result {

    @JsonProperty("id")
    private String id;
    @JsonProperty("site_id")
    private String siteId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private Object subtitle;
    @JsonProperty("seller")
    private Seller seller;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("currency_id")
    private String currencyId;
    @JsonProperty("available_quantity")
    private Integer availableQuantity;
    @JsonProperty("sold_quantity")
    private Integer soldQuantity;
    @JsonProperty("buying_mode")
    private String buyingMode;
    @JsonProperty("listing_type_id")
    private String listingTypeId;
    @JsonProperty("stop_time")
    private String stopTime;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("accepts_mercadopago")
    private Boolean acceptsMercadopago;
    @JsonProperty("installments")
    private Installments installments;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("shipping")
    private Shipping shipping;
    @JsonProperty("seller_address")
    private SellerAddress sellerAddress;
    @JsonProperty("attributes")
    private List<Object> attributes = new ArrayList<Object>();
    @JsonProperty("differential_pricing")
    private DifferentialPricing differentialPricing;
    @JsonProperty("original_price")
    private Object originalPrice;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("official_store_id")
    private Integer officialStoreId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The subtitle
     */
    @JsonProperty("subtitle")
    public Object getSubtitle() {
        return subtitle;
    }

    /**
     * 
     * @param subtitle
     *     The subtitle
     */
    @JsonProperty("subtitle")
    public void setSubtitle(Object subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 
     * @return
     *     The seller
     */
    @JsonProperty("seller")
    public Seller getSeller() {
        return seller;
    }

    /**
     * 
     * @param seller
     *     The seller
     */
    @JsonProperty("seller")
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The currencyId
     */
    @JsonProperty("currency_id")
    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * 
     * @param currencyId
     *     The currency_id
     */
    @JsonProperty("currency_id")
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * 
     * @return
     *     The availableQuantity
     */
    @JsonProperty("available_quantity")
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * 
     * @param availableQuantity
     *     The available_quantity
     */
    @JsonProperty("available_quantity")
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    /**
     * 
     * @return
     *     The soldQuantity
     */
    @JsonProperty("sold_quantity")
    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * 
     * @param soldQuantity
     *     The sold_quantity
     */
    @JsonProperty("sold_quantity")
    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * 
     * @return
     *     The buyingMode
     */
    @JsonProperty("buying_mode")
    public String getBuyingMode() {
        return buyingMode;
    }

    /**
     * 
     * @param buyingMode
     *     The buying_mode
     */
    @JsonProperty("buying_mode")
    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    /**
     * 
     * @return
     *     The listingTypeId
     */
    @JsonProperty("listing_type_id")
    public String getListingTypeId() {
        return listingTypeId;
    }

    /**
     * 
     * @param listingTypeId
     *     The listing_type_id
     */
    @JsonProperty("listing_type_id")
    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    /**
     * 
     * @return
     *     The stopTime
     */
    @JsonProperty("stop_time")
    public String getStopTime() {
        return stopTime;
    }

    /**
     * 
     * @param stopTime
     *     The stop_time
     */
    @JsonProperty("stop_time")
    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * 
     * @return
     *     The condition
     */
    @JsonProperty("condition")
    public String getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */
    @JsonProperty("condition")
    public void setCondition(String condition) {
        this.condition = condition;
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
     *     The thumbnail
     */
    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The acceptsMercadopago
     */
    @JsonProperty("accepts_mercadopago")
    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    /**
     * 
     * @param acceptsMercadopago
     *     The accepts_mercadopago
     */
    @JsonProperty("accepts_mercadopago")
    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    /**
     * 
     * @return
     *     The installments
     */
    @JsonProperty("installments")
    public Installments getInstallments() {
        return installments;
    }

    /**
     * 
     * @param installments
     *     The installments
     */
    @JsonProperty("installments")
    public void setInstallments(Installments installments) {
        this.installments = installments;
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
     *     The shipping
     */
    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * 
     * @param shipping
     *     The shipping
     */
    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * 
     * @return
     *     The sellerAddress
     */
    @JsonProperty("seller_address")
    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    /**
     * 
     * @param sellerAddress
     *     The seller_address
     */
    @JsonProperty("seller_address")
    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    @JsonProperty("attributes")
    public List<Object> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    @JsonProperty("attributes")
    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The differentialPricing
     */
    @JsonProperty("differential_pricing")
    public DifferentialPricing getDifferentialPricing() {
        return differentialPricing;
    }

    /**
     * 
     * @param differentialPricing
     *     The differential_pricing
     */
    @JsonProperty("differential_pricing")
    public void setDifferentialPricing(DifferentialPricing differentialPricing) {
        this.differentialPricing = differentialPricing;
    }

    /**
     * 
     * @return
     *     The originalPrice
     */
    @JsonProperty("original_price")
    public Object getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 
     * @param originalPrice
     *     The original_price
     */
    @JsonProperty("original_price")
    public void setOriginalPrice(Object originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 
     * @return
     *     The categoryId
     */
    @JsonProperty("category_id")
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The category_id
     */
    @JsonProperty("category_id")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The officialStoreId
     */
    @JsonProperty("official_store_id")
    public Integer getOfficialStoreId() {
        return officialStoreId;
    }

    /**
     * 
     * @param officialStoreId
     *     The official_store_id
     */
    @JsonProperty("official_store_id")
    public void setOfficialStoreId(Integer officialStoreId) {
        this.officialStoreId = officialStoreId;
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
