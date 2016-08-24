# How to solving the embedded jetty server can't discover Spring WebApplicationInitializer?
 
1. Make the ApplicationInitializer implements **spring..WebApplicationInitializer** explicitly,because jetty **ClassInheritanceHandler** not extract inherited interfaces.  
 
```java
public class ApplicationInitializer 
    extends AbstractAnnotationConfigDispatcherServletInitializer
    implements WebApplicationInitializer{
  
}
``` 

2. Adding classes output dirs into jetty classpath,because jetty **WebInfConfiguration** only scan /WEB-INF/classes by default.

```java
private void enableSpringWebApplicationInitializerDiscovering(WebAppContext context) 
throws IOException, URISyntaxException {
  context.setExtraClasspath(join(paths(classesOutputDirs()), ";"));
  context.setConfigurations(new Configuration[] {
      new WebInfConfiguration(),
      new AnnotationConfiguration()
  });
}
```