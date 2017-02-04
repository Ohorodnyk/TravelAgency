package com.softserve.edu.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic registration = container.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
