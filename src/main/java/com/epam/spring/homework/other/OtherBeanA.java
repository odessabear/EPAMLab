package com.epam.spring.homework.other;

import com.epam.spring.homework.beans.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanA {

    private final BeanA beanA;

    public OtherBeanA(BeanA beanA) {
        this.beanA = beanA;
        System.out.println(this.getClass().getSimpleName() + " " + beanA.getClass().getSimpleName() + " was injected through the constructor");
    }
}
