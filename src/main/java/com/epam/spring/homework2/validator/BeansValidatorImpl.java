package com.epam.spring.homework2.validator;

import com.epam.spring.homework2.beans.ParentBean;

public class BeansValidatorImpl implements BeansValidator {
    @Override
    public void validateBean(ParentBean bean) {
        if (bean.getName() == null || bean.getValue() < 0){
            System.out.println("Bean: " + bean.getName() + " and " + bean.getValue() + " is not valid");
        }else {
            System.out.println("Bean: " + bean.getName() + " and " + bean.getValue() + " complies with requirements");
        }
    }
}
