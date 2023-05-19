package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConf {
    @Bean
    public IMyBean myBeanOperation(){
        return new MyBeanAnotherImpl();
    }

    @Bean
    public IMyOperation myOperation() {
        return new MyOperationImpl();
    }

    @Bean
    public IMyBeanWithDependency myOperationWithDependency(IMyOperation myOperation) {
        return new MyBeanWithDependencyImpl(myOperation);
    }
}
