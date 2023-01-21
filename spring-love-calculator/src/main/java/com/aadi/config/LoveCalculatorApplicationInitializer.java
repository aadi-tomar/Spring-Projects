package com.aadi.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LoveCalculatorApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
//implements WebApplicationInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class arr[] = {LoveCalculatorAppConfig.class};
        return arr;
    }

    @Override
    protected String[] getServletMappings() {

        String[] arr = {"/"};
        return  arr;
    }

    /*

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

          Reading dispacher servlet configuration from xml file


        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");


        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(LoveCalculatorAppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        //dispatcherServlet.
        ServletRegistration.Dynamic myCustomDispatcherServlet =servletContext.addServlet("dispatcher", dispatcherServlet);
        myCustomDispatcherServlet.setLoadOnStartup(1);
        myCustomDispatcherServlet.addMapping("/home/*");

    }
    */
}
