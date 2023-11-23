package com.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 1. get the count of users
    public int getCustomersCount() {
        return jdbcTemplate.queryForObject("select count(*) from customer", Integer.class);
    }

    // 2. prepared query
    public String getCustomerNameBasedOnId(int id) {
        String sql = "select name from customer where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
    }
}
