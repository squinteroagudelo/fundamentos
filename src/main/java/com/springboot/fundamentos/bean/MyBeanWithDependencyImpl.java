package com.springboot.fundamentos.bean;

public class MyBeanWithDependencyImpl implements IMyBeanWithDependency {

    IMyOperation myOperation;

    public MyBeanWithDependencyImpl(IMyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int num = 3;
        System.out.printf("Sum: %d %n", myOperation.sum(num));
        System.out.println("Hello World from my bean whit dependency impl");
    }
}
