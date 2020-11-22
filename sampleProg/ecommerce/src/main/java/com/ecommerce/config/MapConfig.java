package com.ecommerce.config;


import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.Product;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean Configuration Class.
 *
 * @author ashish
 */
@Configuration
public class MapConfig {

    @Bean
    MapperFacade mapperFacade(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Product.class, ProductBO.class)
                .field("productID", "id").byDefault().register();

        return mapperFactory.getMapperFacade();
    }

}
