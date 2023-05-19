package com.ojas.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.ojas.spring")
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUsername(environment.getProperty("uname"));
		dataSource.setPassword(environment.getProperty("pwd"));
		return dataSource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(){
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		return jdbcTemplate;
	}

}
