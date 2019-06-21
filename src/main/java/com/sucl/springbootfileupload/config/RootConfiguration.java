package com.sucl.springbootfileupload.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

/**
 * @author sucl
 * @since 2019/6/19
 */
@Configuration
public class RootConfiguration {

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setResolveLazily(true);
        return commonsMultipartResolver;
    }

    /**
     * 这个导致在不适用@EnableWebMvc时，commonsMultipartResolver无法正常处理附件，只能通过request part处理，也就是StandardServletMultipartResolver
     * 的处理模式
     * @return
     */
//    @Bean
    public MultipartConfigElement multipartConfigElement() {
//        return this.multipartProperties.createMultipartConfig();
        return new MultipartConfigElement("");
    }
}
