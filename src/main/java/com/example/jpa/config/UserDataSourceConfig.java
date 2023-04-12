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

@Configuration
@ConfigurationProperties("app.datasource.user")
public class UserDataSourceConfig extends AbstractDataSourceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(JpaProperties properties, HibernateSettings settings) {
        return createEntityManagerFactory(properties, settings, userDataSource(), "com.example.jpa.entity.user");
    }

    @Bean
    public DataSource userDataSource() {
        return createDataSource();
    }

}
