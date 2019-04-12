package com.we.sdk.memsap.config;

import com.we.sdk.memsap.handler.UserLoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAdapterConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginHandlerInterceptor userLoginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 判断用户是否登录的拦截器
        registry.addInterceptor(userLoginHandlerInterceptor)
                .addPathPatterns("/**/background/**","/saveOrder2");

 /*               .excludePathPatterns("/user/toForget", "/user/forget", "/user/toLogin*", "/user/login*",
                        "/user/toRegister*", "/user/register*", "/error", "/css/**", "/img/**", "/js/**", "/font-awesome/**", "/**.ico");
*/
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/toRegister").setViewName("/register");
        registry.addViewController("/user/toForget").setViewName("/forget");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }*/

}