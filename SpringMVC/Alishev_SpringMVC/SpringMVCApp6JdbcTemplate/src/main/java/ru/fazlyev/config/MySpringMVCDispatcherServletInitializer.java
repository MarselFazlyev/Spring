package ru.fazlyev.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

    //конфигурация фильтра для филльтрации поля _method и использования @PatchMapping,@DeleteMapping и прочих HTTP методов.
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null,true,"/*");
    }
}
