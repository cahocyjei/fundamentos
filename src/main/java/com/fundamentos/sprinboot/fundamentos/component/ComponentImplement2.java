package com.fundamentos.sprinboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement2 implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola Mundo desde Component 2");
    }
}
