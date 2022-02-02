package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements BeansValidator {

    private String name;
    private int value;


    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(this.getClass().getSimpleName() + " postConstruct() method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(this.getClass().getSimpleName() + " preDestroy() method");
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
