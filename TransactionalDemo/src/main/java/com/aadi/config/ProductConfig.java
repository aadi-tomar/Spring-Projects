package com.aadi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.aadi")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ProductConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/product", "root" , "root");
    }

    @Bean
    public TransactionManager getTransactionalManager( DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


}
