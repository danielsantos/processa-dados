package com.gank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.MissingResourceException;
import java.util.Properties;

public abstract class BaseRepository {

    private static final String SCHEMA_TAG = "#SCHEMA#";

    @Autowired
    @Qualifier(AppConfig.SQL_QUERIES)
    private Properties sqlQueries;
    
    protected String getQuery(String queryKey, String schema) {

        String rawQuery = sqlQueries.getProperty(queryKey);

        if (rawQuery == null)
            throw new MissingResourceException("Query nao encontrada para a chave: " + queryKey, null, queryKey);

        return rawQuery.replaceAll(SCHEMA_TAG, schema);
    }
    
}
