package com.learning;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Service
public class CustomerService {

    @Autowired @Qualifier("defaultDataSource")
    DataSource dataSource;

    @Autowired
    HikariDataSource hikariDataSource;

    List<Customer> getCustomers()  {
        ArrayList<Customer> customers = new ArrayList();

        // lot of boiler plate code
        // each time we need to get connection object
        // each time we need to create prepare statement
        // handle exception using try catch

        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = hikariDataSource.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("select * from customer");
            while (rs.next()) {
                customers.add(new Customer(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException exception) {
            System.out.println("Exception Occurred");
        } finally {
            // boiler plate code again,
            // need to take care of closing all opened connection
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customers;
    }
}
