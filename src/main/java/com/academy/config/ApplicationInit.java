package com.academy.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer{

    public ApplicationInit() {
        super();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
