package com.ecommerce.service.impl;

import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.SearchService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
    @Nonnull
    private ProductService productService;

    @Nonnull
    private MapperFacade mapperFacade;

    public SearchServiceImpl(@Nonnull ProductService productService,
                             @Nonnull MapperFacade mapperFacade) {
        this.productService = requireNonNull(productService, "productService must not be null!!");
        this.mapperFacade = requireNonNull(mapperFacade, "mapperFacade must not be null!!");
    }

    @Override
    public List<ProductBO> searchAllProducts() {
        return productService.getAllProducts()
                .stream()
                .map(this::mapProduct)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientGroup> groupByClient() {
        return productService.findGroupByClientName();
    }

    @Override
    public List<PriceGroup> groupByPrice() {
        return productService.findGroupByProductPrice();
    }

    @Override
    public List<ColorGroup> groupByColor() {
        return productService.findGroupByProductColor();
    }

    ProductBO mapProduct(Product product) {
        return mapperFacade.map(product, ProductBO.class);
    }

}
