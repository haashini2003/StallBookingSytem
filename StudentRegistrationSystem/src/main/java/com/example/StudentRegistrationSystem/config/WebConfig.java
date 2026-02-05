package com.example.StudentRegistrationSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // serve anything from src/main/resources/static/** -> /**
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
