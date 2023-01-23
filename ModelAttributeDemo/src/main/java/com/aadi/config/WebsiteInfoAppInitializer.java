package com.aadi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebsiteInfoAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class arr[] = {WebsiteInfoConfig.class};
        return arr;
    }

    @Override
    protected String[] getServletMappings() {
        String[] arr = {"/"};
        return  arr;
    }
}
