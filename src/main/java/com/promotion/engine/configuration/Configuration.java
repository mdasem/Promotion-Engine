package com.promotion.engine.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"products", "promotions"})
public class Configuration {
    @JsonProperty("products")
    private List<ProductConfiguration> products;
    @JsonProperty("promotions")
    private List<PromotionConfiguration> promotions;

    public List<ProductConfiguration> getProducts() {
        return products;
    }

    public List<PromotionConfiguration> getPromotions() {
        return promotions;
    }
}
