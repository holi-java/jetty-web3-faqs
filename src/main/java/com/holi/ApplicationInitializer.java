package com.holi;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by selonj on 16-8-23.
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
    implements WebApplicationInitializer {
  
  @Override protected Class<?>[] getRootConfigClasses() {
    return new Class[] {ApplicationConfig.class};
  }

  @Override protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  @Override protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
