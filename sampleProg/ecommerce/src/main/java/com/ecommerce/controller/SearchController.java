package com.ecommerce.controller;

import com.ecommerce.datamodel.ProductBO;
import com.ecommerce.entity.ClientGroup;
import com.ecommerce.entity.ColorGroup;
import com.ecommerce.entity.PriceGroup;
import com.ecommerce.service.SearchService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Nonnull;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Search Controller.
 *
 * @author ashish
 */
@Controller
@RequestMapping("search")
public class SearchController {
    @Nonnull
    private SearchService searchService;

    /**
     * Constructor.
     *
     * @param searchService {@link SearchService} service to provide search feature
     */
    public SearchController(@Nonnull SearchService searchService) {
        this.searchService = requireNonNull(searchService, "searchService must not be null!!");
    }

    @RequestMapping(value = "allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductBO>> searchAllProducts() {
        return ResponseEntity.ok(searchService.searchAllProducts());
    }

    @RequestMapping(value = "groupbyclient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientGroup>> groupByClient() {
        return ResponseEntity.ok(searchService.groupByClient());
    }

    @RequestMapping(value = "groupbycolor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ColorGroup>> groupByColor() {
        return ResponseEntity.ok(searchService.groupByColor());
    }

    @RequestMapping(value = "groupbyprice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PriceGroup>> groupByPrice() {
        return ResponseEntity.ok(searchService.groupByPrice());
    }


    /**
     * Global Exception Handler for Search Controller.
     *
     * @return ResponseEntity with BadRequest StatusCode
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler() {
        return ResponseEntity.badRequest().body("Bad Request: Please try after some time or contact Administrator");
    }

}
