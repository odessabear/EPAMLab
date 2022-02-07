package com.epam.spring.homework2;

import com.epam.spring.homework2.config.FirstBeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(FirstBeansConfig.class);

        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("Bean name: " + beanDefinitionName);
            System.out.println("Bean definition: " + applicationContext.getBeanDefinition(beanDefinitionName));
        }

        applicationContext.close();
    }
}
