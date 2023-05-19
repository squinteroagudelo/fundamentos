package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.bean.BeanWithPropertiesImpl;
import com.springboot.fundamentos.bean.IBeanWithProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private int age;

    @Bean
    public IBeanWithProperties function(){
       return new BeanWithPropertiesImpl(name, lastName, age);
    }
}
