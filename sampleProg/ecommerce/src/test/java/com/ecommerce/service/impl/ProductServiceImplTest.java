package com.ecommerce.service.impl;

import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;


public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductServiceImpl testee;

    @Before
    public void setUp() {
        initMocks(this);
        testee = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testGetAllProductsWithData() {
        List<Product> toBeReturned = Arrays.asList(
                product(1L, "product1"),
                product(2L, "product2"));

        doReturn(toBeReturned).when(productRepository).findAll();

        List<Product> allProducts = testee.getAllProducts();

        Assert.assertEquals(toBeReturned, allProducts);
    }

    @Test
    public void testGetAllProductsWithoutData() {
        doReturn(Collections.emptyList()).when(productRepository).findAll();

        List<Product> allProducts = testee.getAllProducts();

        Assert.assertEquals(Collections.emptyList(), allProducts);
    }

    @Test
    public void testFindGroupByClientNameWithData() {
        List<ClientGroup> toBeReturned = Arrays.asList(
                clientGroup("client1", 999L),
                clientGroup("client2", 399L));

        doReturn(toBeReturned).when(productRepository).groupByClientName();

        List<ClientGroup> clientGroups = testee.findGroupByClientName();

        Assert.assertEquals(toBeReturned, clientGroups);
    }

    @Test
    public void testFindGroupByClientNameWithoutData() {
        doReturn(Collections.emptyList()).when(productRepository).groupByClientName();

        List<ClientGroup> clientGroups = testee.findGroupByClientName();

        Assert.assertEquals(Collections.emptyList(), clientGroups);
    }

    @Test
    public void testFindGroupByProductColorWithData() {
        List<ColorGroup> toBeReturned = Arrays.asList(
                colorGroup("color1", 999L),
                colorGroup("color2", 399L));

        doReturn(toBeReturned).when(productRepository).groupByColor();

        List<ColorGroup> colorGroups = testee.findGroupByProductColor();

        Assert.assertEquals(toBeReturned, colorGroups);
    }

    @Test
    public void testFindGroupByProductColorWithoutData() {
        doReturn(Collections.emptyList()).when(productRepository).groupByColor();

        List<ColorGroup> colorGroups = testee.findGroupByProductColor();

        Assert.assertEquals(Collections.emptyList(), colorGroups);
    }


    @Test
    public void testFindGroupByProductPriceWithData() {
        List<PriceGroup> toBeReturned = Arrays.asList(
                priceGroup(599L, 22L),
                priceGroup(299L, 33L));

        doReturn(toBeReturned).when(productRepository).groupByPrice();

        List<PriceGroup> priceGroups = testee.findGroupByProductPrice();

        Assert.assertEquals(toBeReturned, priceGroups);
    }

    @Test
    public void testFindGroupByProductPriceWithoutData() {
        doReturn(Collections.emptyList()).when(productRepository).groupByPrice();

        List<PriceGroup> priceGroups = testee.findGroupByProductPrice();

        Assert.assertEquals(Collections.emptyList(), priceGroups);
    }

    public Product product(Long id, String name) {
        Product product = new Product();
        product.setProductID(id);
        product.setName(name);
        return product;
    }

    public ClientGroup clientGroup(String name, Long maxPrice) {
        ClientGroup clientGroup = new ClientGroup();
        clientGroup.setName(name);
        clientGroup.setMaxPrice(maxPrice);
        return clientGroup;
    }

    public ColorGroup colorGroup(String color, Long maxPrice) {
        ColorGroup colorGroup = new ColorGroup();
        colorGroup.setColor(color);
        colorGroup.setMaxPrice(maxPrice);
        return colorGroup;
    }

    public PriceGroup priceGroup(Long price, Long productCount) {
        PriceGroup priceGroup = new PriceGroup();
        priceGroup.setPrice(price);
        priceGroup.setProductCount(productCount);
        return priceGroup;
    }
}