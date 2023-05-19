package com.springboot.fundamentos;

import com.springboot.fundamentos.bean.IMyBean;
import com.springboot.fundamentos.bean.IMyBeanWithDependency;
import com.springboot.fundamentos.component.IComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final IComponentDependency componentDependency;
    private final IMyBean myBean;
    private final IMyBeanWithDependency myBeanWithDependency;

    public FundamentosApplication(@Qualifier("componentAnotherImpl") IComponentDependency componentDependency, IMyBean myBean, IMyBeanWithDependency myBeanWithDependency) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.greet();
        myBean.print();
        myBeanWithDependency.printWithDependency();
    }
}