package com.learning;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "com.learning")
public class SpringJDBC {

    @Bean(name = "defaultDataSource")
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3307/myskillset_jdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean(name = "hikariDataSource")
    public HikariDataSource getHikariDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3307/myskillset_jdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaximumPoolSize(2);
        return ds;
    }

    public static void main(String args[]) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJDBC.class);
        CustomerService s = context.getBean(CustomerService.class);
        System.out.println(s.getCustomers());
    }
}
