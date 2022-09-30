package com.jang.cmm.config;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableSpringDataWebSupport
public class WebConfigs extends WebMvcConfigurationSupport {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }
    
    //다국어 메세지 소스 설정
    //https://seungwoo0429.tistory.com/24
    /*
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    */
    
    //
}

/*

에러 방지

java.lang.NoSuchMethodException: org.springframework.data.domain.Pageable.<init>()

	at java.lang.Class.getConstructor0(Class.java:3082) ~[na:1.8.0_161]

	at java.lang.Class.getDeclaredConstructor(Class.java:2178) ~[na:1.8.0_161]

	at

https://newvid.tistory.com/entry/Spring-boot-Pageable-NuSuchMethodException


*/