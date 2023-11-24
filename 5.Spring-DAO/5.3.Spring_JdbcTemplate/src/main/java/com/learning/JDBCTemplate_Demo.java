package com.learning;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.learning")
public class JDBCTemplate_Demo {

    @Bean
    public HikariDataSource getDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3307/myskillset_jdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public JdbcTemplate getJDBCTemplate(HikariDataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCTemplate_Demo.class);
        CustomerService service = context.getBean(CustomerService.class);

        // truncate table
        service.truncateTable();

        // batch insert
        List<Customer> customerList = Arrays.asList( new Customer[]{ new Customer(1, "satya"),
                new Customer(2, "ganesh"),
                new Customer(3, "Kuruva"),
                new Customer(4,"meow")
        });
        service.insertMultipleCustomers(customerList);

        System.out.println("there are " + service.getCustomersCount() + " customers in DB");
        int id = 1;
        System.out.println("Customer with id " + id + " is " + service.getCustomerNameBasedOnId(id));
        System.out.println("Customer with id " + id + " is" + service.getCustomerBasedOnId(id));
        System.out.println("Printing all customers1 \n" + service.getAllCustomers1());
        System.out.println("Printing all customers2 \n" + service.getAllCustomers2());

        // create
        Customer c = new Customer(99, "ram");
        service.insertCustomer(c);
        System.out.println(service.getAllCustomers1());

        // update
        service.updateCustomerName(99, "rapo");
        System.out.println(service.getAllCustomers1());

        // delete
        service.deleteCustomer(99);
        System.out.println(service.getAllCustomers1());

        System.out.println("Printing all customers using resultset extractor"  + service.getAllCustomers3());


        List<Customer> customerListUpdated = Arrays.asList( new Customer[]{ new Customer(1, "satyaUpdated"),
                new Customer(2, "ganeshUpdated"),
                new Customer(3, "KuruvaUpdated"),
                new Customer(4, "meowUpdated")
        });
        service.batchUpdate(customerListUpdated);

        System.out.println("after batch update " + service.getAllCustomers3());
    }
}
