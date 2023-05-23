package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.service.UserService;
import com.springboot.fundamentos.usecase.GetUserImpl;
import com.springboot.fundamentos.usecase.IGetUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    IGetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}
