package com.ecommerce.service.impl;

import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.impl.SearchServiceImpl;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchServiceImplTest {

    @Mock
    private ProductService productService;

    private SearchServiceImpl testee;

    @Before
    public void setUp() {
        initMocks(this);
        MapperFacade mapperFacade = mapperFacade();
        testee = new SearchServiceImpl(productService, mapperFacade);
    }

    @Test
    public void testSearchAllProducts() {
        List<Product> toBeReturned = Arrays.asList(
                product(1L, "product1"),
                product(2L, "product2"));

        doReturn(toBeReturned).when(productService).getAllProducts();

        List<ProductBO> productBOS = testee.searchAllProducts();

        Assert.assertEquals(1L, (long) (productBOS.get(0).getId()));
        Assert.assertEquals("product1", productBOS.get(0).getName());
        Assert.assertEquals(2L, (long) (productBOS.get(1).getId()));
        Assert.assertEquals("product2", productBOS.get(1).getName());
    }

    @Test
    public void testGroupByClient() {
        List<ClientGroup> toBeReturned = Arrays.asList(
                clientGroup("client1", 999L),
                clientGroup("client2", 399L));

        doReturn(toBeReturned).when(productService).findGroupByClientName();
        List<ClientGroup> clientGroups = testee.groupByClient();
        Assert.assertEquals(toBeReturned, clientGroups);
    }

    @Test
    public void testGroupByPrice() {
        List<PriceGroup> toBeReturned = Arrays.asList(
                priceGroup(599L, 22L),
                priceGroup(299L, 33L));

        doReturn(toBeReturned).when(productService).findGroupByProductPrice();
        List<PriceGroup> priceGroups = testee.groupByPrice();
        Assert.assertEquals(toBeReturned, priceGroups);

    }

    @Test
    public void testGroupByColor() {
        List<ColorGroup> toBeReturned = Arrays.asList(
                colorGroup("color1", 999L),
                colorGroup("color2", 399L));

        doReturn(toBeReturned).when(productService).findGroupByProductColor();
        List<ColorGroup> colorGroups = testee.groupByColor();
        Assert.assertEquals(toBeReturned, colorGroups);
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

    MapperFacade mapperFacade() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Product.class, ProductBO.class)
                .field("productID", "id").byDefault().register();

        return mapperFactory.getMapperFacade();
    }
}