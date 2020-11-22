package com.ecommerce.entity;

import java.util.Objects;

public class ColorGroup {
    private String color;
    private Long minPrice;
    private Long maxPrice;
    private Long productCount;
    private Long sumQuantity;
    private Double avgPrice;

    public ColorGroup() {
    }

    public ColorGroup(String color, Long minPrice, Long maxPrice, Long productCount, Long sumQuantity, Double avgPrice) {
        this.color = color;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.productCount = productCount;
        this.sumQuantity = sumQuantity;
        this.avgPrice = avgPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Long getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(Long sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorGroup)) return false;
        ColorGroup that = (ColorGroup) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(minPrice, that.minPrice) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(productCount, that.productCount) &&
                Objects.equals(sumQuantity, that.sumQuantity) &&
                Objects.equals(avgPrice, that.avgPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, minPrice, maxPrice, productCount, sumQuantity, avgPrice);
    }
}
