package com.retailx.config;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public GsonBuilder getGsonBuilder(){
        return new GsonBuilder();
    }

    @Bean
    public ViewResolver urlBasedViewResolver()
    {
        InternalResourceViewResolver res = new InternalResourceViewResolver();
        res.setPrefix("/WEB-INF/views/");
        res.setSuffix(".jsp");

        return res;
    }

}
