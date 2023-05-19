package com.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentAnotherImpl implements IComponentDependency {
    @Override
    public void greet() {
        System.out.println("Hello World from another component!");
    }
}
