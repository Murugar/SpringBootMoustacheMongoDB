package com.iqmsoft.boot.moustache.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iqmsoft.boot.moustache.mongodb.web.infrastructure.interceptor.ContextPathInterceptor;

@Configuration
@ComponentScan(basePackageClasses = ContextPathInterceptor.class)
public class WebInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ContextPathInterceptor contextPathInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(contextPathInterceptor);
    }
}
