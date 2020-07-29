package com.intertech.cix.generic;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;


public class CustomMessageSource extends ReloadableResourceBundleMessageSource {

    public CustomMessageSource() {
        super();
    }

    public String getMessage(String messageCode){
        return  this.getMessage(messageCode,null, LocaleContextHolder.getLocale());
    }
}
