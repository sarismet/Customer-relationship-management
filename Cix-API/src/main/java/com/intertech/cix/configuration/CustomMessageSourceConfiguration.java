package com.intertech.cix.configuration;

import com.intertech.cix.generic.CustomMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class CustomMessageSourceConfiguration {

    @Bean
    public CustomMessageSource customMessageSource(){
        CustomMessageSource a = new CustomMessageSource();
        a.setBasename("classpath:messages");
        a.setDefaultEncoding("UTF-8");
        a.setUseCodeAsDefaultMessage(true);
        return  a;
    }
}
