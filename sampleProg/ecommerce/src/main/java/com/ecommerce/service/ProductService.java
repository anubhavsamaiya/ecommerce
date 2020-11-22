package com.ecommerce.service;

import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@Service
public interface ProductService {
    @Nonnull
    List<Product> getAllProducts();

    @Nullable
    Page<Product> getAllProducts(@Nonnull Pageable pageable);

    @Nonnull
    List<ClientGroup> findGroupByClientName();

    @Nonnull
    List<ColorGroup> findGroupByProductColor();

    @Nonnull
    List<PriceGroup> findGroupByProductPrice();
}
