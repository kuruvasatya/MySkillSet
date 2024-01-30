package com.learning;

import com.learning.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class Application {
    private static final String URL = "jdbc:mysql://localhost:3307/spring_transactional";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ProductService service = context.getBean(ProductService.class);
        service.clearData();

        try {
//            service.saveProductData();
//            service.saveProductData1();
            service.saveProductData2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Printing all the products available: ");
        service.getProductsData().stream().forEach(System.out::println);
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(URL, USER_NAME, PASSWORD);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
