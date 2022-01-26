package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:applicationH2.properties")
@Import(SecondBeansConfig.class)
public class FirstBeansConfig {

    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    @DependsOn("getBeanD")
    public BeanB getBeanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    @DependsOn({"getBeanB", "getBeanD"})
    public BeanC getBeanC() {
        return new BeanC();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    public BeanD getBeanD() {
        return new BeanD();
    }

    @Bean
    public BeanE getBeanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    BeanF getBeanF(){
        return new BeanF();
    }

}
