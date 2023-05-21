package com.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImpl implements IMyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    private IMyOperation myOperation;

    public MyBeanWithDependencyImpl(IMyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("...printWithDependency method!");
        int num = 3;
        System.out.printf("Sum: %d %n", myOperation.sum(num));
        System.out.println("Hello World from my bean whit dependency impl");
    }
}
