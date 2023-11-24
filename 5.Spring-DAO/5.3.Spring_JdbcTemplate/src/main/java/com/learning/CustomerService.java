package com.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Service
public class CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // [Read] get the count of users
    public int getCustomersCount() {
        return jdbcTemplate.queryForObject("select count(*) from customer", Integer.class);
    }

    // [Read with parameters] prepared query
    public String getCustomerNameBasedOnId(int id) {
        String sql = "select name from customer where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
    }

    // [Read Entire Object]
    public Customer getCustomerBasedOnId(int id) {
        // we are creating object of RowMapper Interface (Function interface)
        // it has a method mapRow(ResultSet rs, int rowNum)
        RowMapper<Customer> cm = (rs, rn) -> new Customer(rs.getInt(1), rs.getString(2));
        String sql = "select * from customer where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, cm);
    }

    public List<Map<String, Object>> getAllCustomers1() {
        String sql = "select * from customer";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Customer> getAllCustomers2() {
        String sql = "select * from customer";
        RowMapper<Customer> rm = (rs, rn) -> new Customer(rs.getInt(1), rs.getString(2));
        return jdbcTemplate.query(sql, rm);
    }

    // [Create]
    public void insertCustomer(Customer customer) {
        String sql = "insert into customer values (?, ?)";
//        jdbcTemplate.query(sql, Object ...args)
        jdbcTemplate.update(sql, customer.getId(), customer.getName());
        System.out.println("inserted record");
    }

    public void updateCustomerName(int id, String name) {
        String sql = "update customer set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void deleteCustomer(int id) {
        String sql = "delete from customer where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void truncateTable() {
        String sql = "truncate table customer";
        jdbcTemplate.update(sql);
    }

    public void insertMultipleCustomers(List<Customer> customers) {
        String sql = "Insert into Customer values(?, ?)";
        ArrayList<Object[]> args = new ArrayList();

        for(Customer c: customers) {
            Object[] object = new Object[] {c.getId(), c.getName()};
            args.add(object);
        }

        jdbcTemplate.batchUpdate(sql, args);
    }

    public List<Customer> getAllCustomers3() {
        String sql = "select * from customer";
        ResultSetExtractor<List<Customer>> re = (rs) -> {
            List<Customer> customers = new ArrayList<>();
            while(rs.next()) {
                customers.add(new Customer(rs.getInt(1), rs.getString(2)));
            }
            return customers;
        };

        return jdbcTemplate.query(sql, re);
    }

    @Transactional
    public void batchUpdate(List<Customer> customers) {
        String sql = "update customer set name = ? where id = ?";
        int[] status = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {
                ps.setString(1, customers.get(index).getName());
                ps.setInt(2, customers.get(index).getId());
            }

            @Override
            public int getBatchSize() {
                // how many times set values method should run
                return customers.size();
            }
        });
    }
}
