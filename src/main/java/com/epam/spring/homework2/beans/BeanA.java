package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements BeansValidator, InitializingBean, DisposableBean {

    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanA{" +
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

    @Override
    public void destroy(){
        System.out.println("From BeanA DisposableBean.destroy() method");
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println("From BeanA InitializingBean.afterPropertiesSet() method");
    }
}
