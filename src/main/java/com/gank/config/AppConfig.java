package com.gank.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.net.MalformedURLException;

@Configuration
public class AppConfig {

    public static final String SQL_QUERIES = "sqlQueries";

    @Bean(name = SQL_QUERIES)
    public PropertiesFactoryBean sqlImportacao() throws MalformedURLException {
        PropertiesFactoryBean p = new PropertiesFactoryBean();
        p.setLocation(new ClassPathResource("sql-queries.xml"));
        return p;
    }
    
}
