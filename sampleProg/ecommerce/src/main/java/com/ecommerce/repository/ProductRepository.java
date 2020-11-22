package com.ecommerce.repository;

import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Query("select new com.ecommerce.entity.ClientGroup(p.client.name as name, "
            + "min(p.price) as minPrice, "
            + "max(p.price) as maxPrice, "
            + "count(p.productID) as productCount, "
            + "sum(p.stock) as sumQuantitiy, "
            + "avg(p.price) as avgPrice) "
            + "from Product p "
            + "group by p.client.name")
    List<ClientGroup> groupByClientName();

    @Query("select new com.ecommerce.entity.PriceGroup(p.price , "
            + "count(p.productID) as productCount, "
            + "sum(p.stock) as sumQuantitiy ) "
            + "from Product p "
            + "group by p.price")
    List<PriceGroup> groupByPrice();

    @Query("select new com.ecommerce.entity.ColorGroup(p.color , "
            + "min(p.price) as minPrice, "
            + "max(p.price) as maxPrice, "
            + "count(p.productID) as productCount, "
            + "sum(p.stock) as sumQuantitiy, "
            + "avg(p.price) as avgPrice) "
            + "from Product p "
            + "group by p.color")
    List<ColorGroup> groupByColor();
}
