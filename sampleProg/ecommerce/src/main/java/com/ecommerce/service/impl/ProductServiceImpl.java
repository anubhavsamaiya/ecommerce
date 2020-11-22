package com.ecommerce.service.impl;

import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Nonnull
    private ProductRepository repository;

    public ProductServiceImpl(@Nonnull ProductRepository repository) {
        this.repository = requireNonNull(repository, "repository must not be null!!");
    }


    @Nonnull
    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Nullable
    @Override
    public Page<Product> getAllProducts(@Nonnull Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Nonnull
    @Override
    public List<ClientGroup> findGroupByClientName() {
        return repository.groupByClientName();
    }

    @Nonnull
    @Override
    public List<ColorGroup> findGroupByProductColor() {
        return repository.groupByColor();
    }

    @Nonnull
    @Override
    public List<PriceGroup> findGroupByProductPrice() {
        return repository.groupByPrice();
    }
}
