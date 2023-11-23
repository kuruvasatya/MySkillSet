package com.learning;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

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
        System.out.println("there are " + service.getCustomersCount() + " customers in DB");
        int id = 1;
        System.out.println("Customer with id " + id + " is " + service.getCustomerNameBasedOnId(id));
    }
}
