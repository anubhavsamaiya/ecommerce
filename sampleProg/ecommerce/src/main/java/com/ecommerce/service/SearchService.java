package com.ecommerce.service;

import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;

import java.util.List;

public interface SearchService {
    List<ProductBO> searchAllProducts();

    List<ClientGroup> groupByClient();

    List<PriceGroup> groupByPrice();

    List<ColorGroup> groupByColor();
}
