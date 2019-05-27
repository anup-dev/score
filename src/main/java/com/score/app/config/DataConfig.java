package com.score.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Anup on 27/5/19. Class defines DataSource configuration
 */

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Autowired
    private Environment env;

    private final Logger LOGGER = LoggerFactory.getLogger(DataConfig.class);

    /**
     * DataSource Bean definition
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create().type(DriverManagerDataSource.class)
                .build();
    }
}
