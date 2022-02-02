package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;
import org.springframework.beans.factory.annotation.Value;

public class BeanC implements BeansValidator {

    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    public BeanC(){}

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void customIntiMethod(){
        System.out.println(this.getClass().getSimpleName() + " customIntiMethod()");
    }

    private void customDestroyMethod(){
        System.out.println(this.getClass().getSimpleName() + " customDestroyMethod");
    }

    @Override
    public void validateBean() {
        System.out.println(this.getClass().getSimpleName() + " validateBean() method");
        if (name != null && value > 0){
            System.out.println(this.getClass().getSimpleName() + " is valid");
        }else {
            System.out.println(this.getClass().getSimpleName() + " is not valid");
        }
    }
}
