package com.lazada.SellerPortal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SerllerPortalConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/registration.html").setViewName("registration");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/address.html").setViewName("address");
        registry.addViewController("/identity.html").setViewName("identity");
        registry.addViewController("/bank.html").setViewName("bank");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
    }
}
