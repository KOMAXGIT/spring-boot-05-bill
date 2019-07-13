package com.menxuegu.springboot.config;

import com.menxuegu.springboot.component.MyLocaleResolver;
import com.menxuegu.springboot.intercepter.LoginHandlerIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfiger {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
      return   new WebMvcConfigurer() {
          @Override
          public void addInterceptors(InterceptorRegistry registry) {
              /**
               * 排除不需要拦截的请求路径
               */
              registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                      .excludePathPatterns("/","/index.html","/login")
                      .excludePathPatterns("/css/*","/img/*","/js/*");
          }

          public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");

            }

        };
    }

    /**
     * 自己的区域解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}