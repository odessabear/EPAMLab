package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements BeansValidator {

    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    public BeanB(){}

    @Override
    public String toString() {
        return "BeanB{" +
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

    private void otherCustomInitMethod(){
        System.out.println(this.getClass().getSimpleName() + " otherCustomInitMethod()");
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
