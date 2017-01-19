package com.gank.config;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DatasourceFactory {

	protected SingleConnectionDataSource createDataSource(String driverClassName, String url, String username,
                                                          String password, boolean autoCommit) {
		SingleConnectionDataSource dataSource = createDataSource(driverClassName, url, username, password);
		dataSource.setAutoCommit(autoCommit);
		return dataSource;
	}

	protected SingleConnectionDataSource createDataSource(String driverClassName, String url, String username,
                                                          String password) {
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
