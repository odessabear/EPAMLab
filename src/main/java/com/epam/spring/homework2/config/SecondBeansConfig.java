package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.MyCustomBenPostProcessor;
import com.epam.spring.homework2.beans.OtherBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epam.spring.homework2.beans")
public class SecondBeansConfig {

    @Bean
    public MyCustomBenPostProcessor myCustomBenPostProcessor() {
        return new MyCustomBenPostProcessor();
    }

    @Bean
    public static OtherBeanFactoryPostProcessor otherBeanFactoryPostProcessor() {
        return new OtherBeanFactoryPostProcessor();
    }
}
