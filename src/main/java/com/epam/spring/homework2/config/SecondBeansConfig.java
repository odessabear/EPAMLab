package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.MyCustomBeanPostProcessor;
import com.epam.spring.homework2.beans.OtherBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;

public class SecondBeansConfig {

    @Bean
    public MyCustomBeanPostProcessor myCustomBenPostProcessor() {
        return new MyCustomBeanPostProcessor();
    }

    @Bean
    public static OtherBeanFactoryPostProcessor otherBeanFactoryPostProcessor() {
        return new OtherBeanFactoryPostProcessor();
    }
}
