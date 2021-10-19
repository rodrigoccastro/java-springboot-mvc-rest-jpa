package com.example.springboot;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
      
    @Bean
    public DataSource getDataSource() 
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost:1433;databaseName=familia");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("barnabe123");
        return dataSourceBuilder.build();
    }
}