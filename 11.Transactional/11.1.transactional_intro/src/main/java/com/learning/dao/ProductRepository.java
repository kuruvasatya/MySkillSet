package com.learning.dao;

import com.learning.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public  ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertData(Product product) {
        String sql = "Insert into Product values(? ,?)";
        Object args[] = new Object[] {product.getId(), product.getName()};
        this.jdbcTemplate.update(sql, args);
        System.out.println("Product inserted ...");
    }

    public List<Product> getProducts() {
        String sql = "Select * from Product";
        RowMapper<Product> rm = (rs, rn) -> {
            return new Product(rs.getInt(1), rs.getString(2));
        };
        return jdbcTemplate.query(sql, rm);
    }

    public void clearData() {
        String sql = "truncate table Product";
        jdbcTemplate.execute(sql);
    }
}
