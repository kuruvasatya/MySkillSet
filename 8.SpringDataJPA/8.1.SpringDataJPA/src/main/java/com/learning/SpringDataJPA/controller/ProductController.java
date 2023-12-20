package com.learning.SpringDataJPA.controller;

import com.learning.SpringDataJPA.dto.APIResponse;
import com.learning.SpringDataJPA.entity.Product;
import com.learning.SpringDataJPA.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all-products")
    public APIResponse<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/all-products-sorted")
    public APIResponse<List<Product>> getAllProductsInSorted(@RequestParam(value = "sortby", required = true) String sortby) {
        List<Product> products = productService.getAllProductsSorted(sortby);
        return new APIResponse<>(products.size(), products);
    }

    @GetMapping("/products")
    public APIResponse<Page<Product>> getProductsUsingPagination(@RequestParam(value = "page_num", required = true) int pageNum,
                                                                 @RequestParam(value = "page_size", required = false, defaultValue = "10") int pageSize) {
        Page<Product> productPage = productService.getAllProductsUsingPaging(pageNum,pageSize);
        return new APIResponse<>(productPage.getSize(), productPage);
    }
}
