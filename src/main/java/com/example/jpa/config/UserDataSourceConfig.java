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

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(JpaProperties properties, HibernateSettings settings) {
        return createEntityManagerFactory(properties, settings, userDataSource(), "com.example.jpa.entity.user");
    }

    @Bean
    public DataSource userDataSource() {
        return createDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            JpaProperties jpaProperties) {
        DataSource dataSource = createDataSource(
                env.getProperty("spring.datasource.user.url"),
                env.getProperty("spring.datasource.user.username"),
                env.getProperty("spring.datasource.user.password"),
                env.getProperty("spring.datasource.user.driver-class-name")
        );
        return createEntityManagerFactory(dataSource, "com.example.jpa.entity.user", jpaProperties);
    }


}
