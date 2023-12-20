package com.learning.SpringDataJPA.service;

import com.learning.SpringDataJPA.dao.ProductRepository;
import com.learning.SpringDataJPA.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init(){
        List<Product> products = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Product("product" +i, new Random().nextInt(100), new Random().nextDouble(100)))
                .collect(Collectors.toList());
        this.productRepository.saveAll(products);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsSorted(String field) {
        if(field == null)
            return productRepository.findAll();
        return productRepository.findAll(Sort.by(Sort.Order.asc(field)));
    }

    public Page<Product> getAllProductsUsingPaging(int offset, int size) {
        return productRepository.findAll(PageRequest.of(offset, size));
    }
}
