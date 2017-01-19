package com.gank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

public class ApplicationConfig {

    @Bean
    public DataSource dataSource(){

        // TODO Passar os dados de config para a Application.Properties

        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/processadados");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;

    }

}
