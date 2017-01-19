package com.gank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration extends DatasourceFactory {

    /*
    @Value("${baseunificada.db2.driver}")
    private String driver;

    @Value("${baseunificada.db2.url}")
    private String url;

    @Value("${baseunificada.db2.user}")
    private String user;

    @Value("${baseunificada.db2.password}")
    private String password;

    @Value("${baseunificada.sql.qualifier}")
    private String schema;
    */

    @Bean
    public DataSource dsBU() {

        SingleConnectionDataSource ds = createDataSource("com.mysql.jdbc.Driver",
                                                         "jdbc:mysql://localhost:3306/processadados",
                                                         "root",
                "root");
        ds.setSuppressClose(true);
        return ds;
    }

    @Bean(name = "jdbcBU")
    public NamedParameterJdbcTemplate db2JdbcTemplate() {
        return new NamedParameterJdbcTemplate(dsBU());
    }

}
