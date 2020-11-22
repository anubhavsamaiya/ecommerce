package com.ecommerce.config;

import com.ecommerce.controller.SearchController;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.SearchService;
import com.ecommerce.service.impl.ProductServiceImpl;
import com.ecommerce.service.impl.SearchServiceImpl;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean Configuration Class.
 *
 * @author ashish
 */
@Configuration
public class SearchConfig {

    @Bean
    public ProductService productService(@Autowired ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public SearchService searchService(ProductService productService,
                                       MapperFacade mapperFacade) {
        return new SearchServiceImpl(productService, mapperFacade);
    }

    @Bean
    public SearchController searchController(SearchService searchService) {
        return new SearchController(searchService);
    }

}
