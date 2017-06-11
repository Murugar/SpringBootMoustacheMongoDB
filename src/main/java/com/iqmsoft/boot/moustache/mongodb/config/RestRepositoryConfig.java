package com.iqmsoft.boot.moustache.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.iqmsoft.boot.moustache.mongodb.data.Profile;

@Configuration
@ComponentScan(basePackageClasses = Profile.class)
public class RestRepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Profile.class);
    }
}
