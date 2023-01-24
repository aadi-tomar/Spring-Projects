package com.aadi.Controller;

import com.aadi.config.ProductConfig;
import com.aadi.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);

        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductInfo();
        context.registerShutdownHook();
        context.close();
    }
}
