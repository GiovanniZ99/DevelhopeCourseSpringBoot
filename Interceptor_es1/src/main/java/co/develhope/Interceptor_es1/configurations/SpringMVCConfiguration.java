package co.develhope.Interceptor_es1.configurations;

import co.develhope.Interceptor_es1.interceptors.ApiLoggingInterceptor;
import co.develhope.Interceptor_es1.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Autowired
    ApiLoggingInterceptor apiLoggingInterceptor;
    @Autowired
    LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor).addPathPatterns("/time");
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy");
    }
}
