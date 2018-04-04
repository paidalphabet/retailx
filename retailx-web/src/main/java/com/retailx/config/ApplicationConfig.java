package com.retailx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public RestTemplate getTemplate() {
        RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(environment.getRequiredProperty("rest.baseurl")));
        return restTemplate;
    }
}
