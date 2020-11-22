package com.ecommerce.controller;


import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.service.SearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchControllerTest {

    @Mock
    private SearchService searchService;

    private SearchController testee;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        testee = new SearchController(searchService);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductBO> toBeReturned = Arrays.asList(
                product(1L, "product1"),
                product(2L, "product2"));

        doReturn(toBeReturned).when(searchService).searchAllProducts();
        ResponseEntity<List<ProductBO>> listResponseEntity = testee.searchAllProducts();
        Assert.assertEquals(toBeReturned, listResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());
    }

    @Test(expected = Exception.class)
    public void testGetAllProductsExceptions() {
        List<ProductBO> toBeReturned = Arrays.asList(
                product(1L, "product1"),
                product(2L, "product2"));

        doReturn(new Exception("error while processing")).when(searchService).searchAllProducts();
        testee.searchAllProducts();
    }

    @Test
    public void testGroupByClient() {
        List<ClientGroup> toBeReturned = Arrays.asList(
                clientGroup("client1", 999L),
                clientGroup("client2", 399L));

        doReturn(toBeReturned).when(searchService).groupByClient();
        ResponseEntity<List<ClientGroup>> listResponseEntity = testee.groupByClient();
        Assert.assertEquals(toBeReturned, listResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());

    }

    @Test
    public void testGroupByColor() {
        List<ColorGroup> toBeReturned = Arrays.asList(
                colorGroup("color1", 999L),
                colorGroup("color2", 399L));

        doReturn(toBeReturned).when(searchService).groupByColor();
        ResponseEntity<List<ColorGroup>> listResponseEntity = testee.groupByColor();
        Assert.assertEquals(toBeReturned, listResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());
    }

    @Test
    public void testGroupByPrice() {
        List<PriceGroup> toBeReturned = Arrays.asList(
                priceGroup(599L, 22L),
                priceGroup(299L, 33L));

        doReturn(toBeReturned).when(searchService).groupByPrice();
        ResponseEntity<List<PriceGroup>> listResponseEntity = testee.groupByPrice();
        Assert.assertEquals(toBeReturned, listResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());
    }

    public ProductBO product(Long id, String name) {
        ProductBO product = new ProductBO();
        product.setId(id);
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