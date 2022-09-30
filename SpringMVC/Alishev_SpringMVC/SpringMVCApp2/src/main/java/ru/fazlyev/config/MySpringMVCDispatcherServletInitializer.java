package ru.fazlyev.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //этот метод нам не нужен
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //возвращается конфигурационный класс
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    //все запросы отправляются на dispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
