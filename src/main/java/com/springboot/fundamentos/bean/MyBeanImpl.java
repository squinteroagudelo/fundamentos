package com.springboot.fundamentos.bean;

public class MyBeanImpl implements IMyBean {
    @Override
    public void print() {
        System.out.println("Hello World from my bean impl");
    }
}
