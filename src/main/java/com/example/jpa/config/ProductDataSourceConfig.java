package com.example.jpa.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Configuration
@ConfigurationProperties("app.datasource.product")
public class ProductDataSourceConfig extends AbstractDataSourceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(JpaProperties properties, HibernateSettings settings) {
        return createEntityManagerFactory(properties, settings, productDataSource(), "com.example.jpa.entity.product");
    }

    @Bean
    public DataSource productDataSource() {
        return createDataSource();
    }

}
