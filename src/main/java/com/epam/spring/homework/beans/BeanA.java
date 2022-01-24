package com.epam.spring.homework.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanA {

    public BeanA() {
        System.out.println(this.getClass().getSimpleName());
    }
}
