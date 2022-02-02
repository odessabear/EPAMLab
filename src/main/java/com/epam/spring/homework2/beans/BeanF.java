package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;

public class BeanF implements BeansValidator {

    private String name;
    private int value;


    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
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
