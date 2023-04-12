package com.example.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Configuration
@ConfigurationProperties("app.datasource.product")
public class ProductDataSourceConfig extends AbstractDataSourceConfig {

    private static final String PRODUCT_PU = "ProductPU";
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties("spring.jpa.product")
    public JpaProperties productJpaProperties() {
        return new JpaProperties();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
            JpaProperties productJpaProperties) {

        return createEntityManagerFactory(
                productDataSource(),
                "product",
                productJpaProperties);
    }

    @Bean
    @Primary
    public DataSource productDataSource() {
        return createDataSource(
                env.getProperty("product.datasource.url"),
                env.getProperty("product.datasource.username"),
                env.getProperty("product.datasource.password"),
                env.getProperty("product.datasource.driver-class-name"));
    }



}
