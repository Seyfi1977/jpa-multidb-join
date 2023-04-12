package com.example.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("app.datasource.user")
public class UserDataSourceConfig extends AbstractDataSourceConfig {

    @Autowired
    private Environment env;
    private static final String USER_PU = "userPU";

    @Bean
    @ConfigurationProperties("spring.jpa.user")
    public JpaProperties userJpaProperties() {
        return new JpaProperties();
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            JpaProperties userJpaProperties) {

        return createEntityManagerFactory(
                userDataSource(),
                "user",
                userJpaProperties);
    }

    @Bean
    public DataSource userDataSource() {
        return createDataSource(
                env.getProperty("user.datasource.url"),
                env.getProperty("user.datasource.username"),
                env.getProperty("user.datasource.password"),
                env.getProperty("user.datasource.driver-class-name"));
    }


}
