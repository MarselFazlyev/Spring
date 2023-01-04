package ru.fazlyev.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;


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

    //конфигурация фильтра для фильтрации поля _method и использования @PatchMapping, @DeleteMapping и прочих HTTP методов.
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerCharacterEncodingFilter(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null,true,"/*");
    }

    //настройки для отображения русского языка в представлениях
    private void registerCharacterEncodingFilter(ServletContext aContext) {
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistration.Dynamic characterEncoding = aContext.addFilter("characterEncoding",characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes,true,"/*");
    }
}
