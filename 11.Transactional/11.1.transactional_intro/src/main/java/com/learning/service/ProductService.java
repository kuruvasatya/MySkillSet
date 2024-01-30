package com.learning.service;

import com.learning.dao.ProductRepository;
import com.learning.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import java.util.stream.IntStream;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * case1: when Exception propagates outside of the method annotated with @Transactional
     */
    @Transactional
    public void saveProductData() {
        IntStream.rangeClosed(1, 10).forEach((i) -> {
            if(i == 8)
                throw new RuntimeException("Exception occured");
            productRepository.insertData(new Product(i, "product" + i));
        });
    }

    /**
     * case2: when exception is handled with in method
     */
    @Transactional
    public void saveProductData1() {
        try {
            IntStream.rangeClosed(1, 10).forEach((i) -> {
                if (i == 8)
                    throw new RuntimeException("Exception occured");
                productRepository.insertData(new Product(i, "product" + i));
            });
        } catch (RuntimeException ex) {
                // handle exception
        }
    }

    /**
     * case2: by default @Transaction annotation roll back if there is Unchecked Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveProductData2() throws Exception {
        for(int i = 1; i<=10; i++){
            if (i == 8)
                throw new Exception("Exception occured");
            productRepository.insertData(new Product(i, "product" + i));
        };
    }

    public List<Product> getProductsData() {
        return productRepository.getProducts();
    }

    public void clearData() {
        productRepository.clearData();
    }
}
