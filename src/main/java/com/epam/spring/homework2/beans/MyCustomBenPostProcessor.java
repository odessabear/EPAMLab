package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomBenPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(bean.getClass().getSimpleName() + " postProcessBeforeInitialization() method");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getSimpleName() + " postProcessAfterInitialization() method");
        if (bean instanceof BeansValidator) {
            ((BeansValidator) bean).validateBean();
        }
        return bean;
    }
}
