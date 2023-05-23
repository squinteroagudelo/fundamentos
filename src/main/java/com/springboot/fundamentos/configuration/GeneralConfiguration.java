package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.bean.BeanWithPropertiesImpl;
import com.springboot.fundamentos.bean.IBeanWithProperties;
import com.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private int age;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public IBeanWithProperties function(){
       return new BeanWithPropertiesImpl(name, lastName, age);
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .driverClassName(driver).build();
    }
}
