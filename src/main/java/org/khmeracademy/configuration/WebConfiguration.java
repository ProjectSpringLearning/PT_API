package org.khmeracademy.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@Configuration
@PropertySource(value={"classpath:configuration.properties"})
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	private Environment environment;
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("MOL.dataSource.driverClassName"));
		dataSource.setUrl(environment.getProperty("MOL.dataSource.url"));
		dataSource.setUsername(environment.getProperty("MOL.dataSource.username"));
		dataSource.setPassword(environment.getProperty("MOL.dataSource.password"));
		System.out.println("CONNECTED");
		return dataSource;
	}
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory;
	}
}
