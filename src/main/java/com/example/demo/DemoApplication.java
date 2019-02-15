package com.example.demo;

import com.example.demo.aspect.resoler.InfoResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

/**
 * 统计
 * @author yeoman
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
//        super.addArgumentResolvers(argumentResolvers);
//        argumentResolvers.add(new InfoResolver());
//
//    }

}
