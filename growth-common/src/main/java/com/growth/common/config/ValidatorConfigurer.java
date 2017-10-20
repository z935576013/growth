package com.growth.common.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class ValidatorConfigurer {

    
    @Bean
    public Validator getValidator(){
        return new LocalValidatorFactoryBean();
    }
}
