package com.ecommerce.entity;

import java.util.Objects;

public class PriceGroup {
    private Long price;
    private Long productCount;
    private Long sumQuantity;

    public PriceGroup() {
    }

    public PriceGroup(Long price, Long productCount, Long sumQuantity) {
        this.price = price;
        this.productCount = productCount;
        this.sumQuantity = sumQuantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceGroup)) return false;
        PriceGroup that = (PriceGroup) o;
        return price.equals(that.price) &&
                productCount.equals(that.productCount) &&
                sumQuantity.equals(that.sumQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productCount, sumQuantity);
    }
}
