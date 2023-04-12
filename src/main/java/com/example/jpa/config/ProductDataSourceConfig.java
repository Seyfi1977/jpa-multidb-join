package com.example.jpa.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(JpaProperties properties, HibernateSettings settings) {
        return createEntityManagerFactory(properties, settings, productDataSource(), "com.example.jpa.entity.product");
    }

    @Bean
    public DataSource productDataSource() {
        return createDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
            JpaProperties jpaProperties) {
        DataSource dataSource = createDataSource(
                env.getProperty("spring.datasource.product.url"),
                env.getProperty("spring.datasource.product.username"),
                env.getProperty("spring.datasource.product.password"),
                env.getProperty("spring.datasource.product.driver-class-name")
        );
        return createEntityManagerFactory(dataSource, "com.example.jpa.entity.product", jpaProperties);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
            JpaProperties jpaProperties) {
        DataSource dataSource = createDataSource(
                env.getProperty("spring.datasource.product.url"),
                env.getProperty("spring.datasource.product.username"),
                env.getProperty("spring.datasource.product.password"),
                env.getProperty("spring.datasource.product.driver-class-name")
        );
        return createEntityManagerFactory(dataSource, "com.example.jpa.entity.product", jpaProperties);
    }
}
