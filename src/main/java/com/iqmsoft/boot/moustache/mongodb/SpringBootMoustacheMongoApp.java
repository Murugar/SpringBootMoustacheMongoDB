package com.iqmsoft.boot.moustache.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.iqmsoft.boot.moustache.mongodb.config.RestRepositoryConfig;
import com.iqmsoft.boot.moustache.mongodb.config.WebInterceptorConfig;
import com.iqmsoft.boot.moustache.mongodb.data.Profile;
import com.iqmsoft.boot.moustache.mongodb.data.ProfileRestRepository;

import java.util.stream.Stream;

@SpringBootApplication
@Import({
        RestRepositoryConfig.class,
        WebInterceptorConfig.class })
public class SpringBootMoustacheMongoApp {

    @Bean
    CommandLineRunner testData(ProfileRestRepository profiles) {

        return args -> Stream.of("One", "Two", "Three", "Four", "Five", "Six")
                .map(Profile::of)
                .forEach(profiles::save);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMoustacheMongoApp.class, args);
    }
}
