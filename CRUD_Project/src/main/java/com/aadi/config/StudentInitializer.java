package com.aadi.config;

import com.aadi.controller.StudentController;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] classes = {StudentAppConfig.class};
        return classes;
    }

    @Override
    protected String[] getServletMappings() {
        String[] urlMappings = {"/"};
        return urlMappings;
    }
}
