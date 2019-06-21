//package com.sucl.springbootfileupload.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.web.MultipartProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.Servlet;
//
///**
// * @author sucl
// * @since 2019/6/20
// */
//
//@Configuration
//@ConditionalOnClass({Servlet.class, StandardServletMultipartResolver.class,
//        MultipartConfigElement.class})
//@EnableConfigurationProperties(MultipartProperties.class)
//public class MultipartAutoConfiguration {
//
//    private final MultipartProperties multipartProperties;
//
//    public MultipartAutoConfiguration(MultipartProperties multipartProperties) {
//        this.multipartProperties = multipartProperties;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({MultipartConfigElement.class,
//            CommonsMultipartResolver.class})
//    public MultipartConfigElement multipartConfigElement() {
//        return this.multipartProperties.createMultipartConfig();
//    }
//
//    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
//    @ConditionalOnMissingBean(MultipartResolver.class)
//    public StandardServletMultipartResolver multipartResolver() {
//        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
//        multipartResolver.setResolveLazily(this.multipartProperties.isResolveLazily());
//        return multipartResolver;
//    }
//
//}
