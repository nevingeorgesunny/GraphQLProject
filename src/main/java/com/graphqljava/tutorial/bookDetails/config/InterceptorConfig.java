package com.graphqljava.tutorial.bookDetails.config;

import com.graphqljava.tutorial.bookDetails.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author nevinsunny
 * date 02/03/23
 * time 4:21 PM
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final JwtInterceptor interceptor;

    public InterceptorConfig(JwtInterceptor interceptor) {
        this.interceptor = interceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.interceptor)
                .addPathPatterns("/**");

    }


}
