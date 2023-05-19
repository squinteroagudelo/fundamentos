package com.springboot.fundamentos.bean;

public class MyBeanAnotherImpl implements IMyBean {
    @Override
    public void print() {
        System.out.println("Hello World from onother my bean impl");
    }
}
