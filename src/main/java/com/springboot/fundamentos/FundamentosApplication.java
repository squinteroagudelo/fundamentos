package com.springboot.fundamentos;

import com.springboot.fundamentos.bean.IBeanWithProperties;
import com.springboot.fundamentos.bean.IMyBean;
import com.springboot.fundamentos.bean.IMyBeanWithDependency;
import com.springboot.fundamentos.component.IComponentDependency;
import com.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final IComponentDependency componentDependency;
    private final IMyBean myBean;
    private final IMyBeanWithDependency myBeanWithDependency;
    private IBeanWithProperties beanWithProperties;
    private final UserPojo userPojo;

    public FundamentosApplication(@Qualifier("componentAnotherImpl") IComponentDependency componentDependency, IMyBean myBean, IMyBeanWithDependency myBeanWithDependency, IBeanWithProperties beanWithProperties, UserPojo userPojo) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.beanWithProperties = beanWithProperties;
        this.userPojo = userPojo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.greet();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        System.out.println(beanWithProperties.function());
        System.out.printf("User info%nemail: %s%nPassword: %s%nAge: %d%n", userPojo.getEmail(), userPojo.getPassword(), userPojo.getAge());
    }
}
