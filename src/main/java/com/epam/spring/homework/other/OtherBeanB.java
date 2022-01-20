package com.epam.spring.homework.other;

import com.epam.spring.homework.beans.BeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanB {
    private BeanB beanB;

    @Autowired
    public void setBeanB(BeanB beanB) {
        System.out.println(this.getClass().getSimpleName() + " " + beanB.getClass().getSimpleName() + " was injected through the setter method");

    }
}
