package com.springboot.fundamentos.bean;

public class BeanWithPropertiesImpl implements IBeanWithProperties {

    private String name;
    private String lastName;
    private int age;

    public BeanWithPropertiesImpl(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String function() {
        return name + " " + lastName + ", " + age + " years old.";
    }
}
