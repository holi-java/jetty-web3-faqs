package com.holi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.holi.utils.IO.content;
import static com.holi.utils.Strings.join;
import static com.holi.utils.Urls.paths;
import static com.holi.utils.Urls.url;
import static java.util.Collections.list;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by selonj on 16-8-23.
 */
public class EmbeddedJettyServerTest {

  private final Server server = new Server(10000);

  @Before public void startup() throws Exception {
    server.setStopAtShutdown(true);
    server.setHandler(runAsWebApplication());
    server.start();
  }

  private Handler runAsWebApplication() throws IOException, URISyntaxException {
    WebAppContext context = new WebAppContext();
    context.setWar("src/main/webapp");
    enableSpringWebApplicationInitializerDiscovering(context);
    return context;
  }

  private void enableSpringWebApplicationInitializerDiscovering(WebAppContext context) throws IOException, URISyntaxException {
    context.setExtraClasspath(join(paths(classesOutputDirs()), ";"));
    context.setConfigurations(new Configuration[] {
        new WebInfConfiguration(),
        new AnnotationConfiguration()
    });
  }

  private List<URL> classesOutputDirs() throws IOException, URISyntaxException {
    return list(Thread.currentThread().getContextClassLoader().getResources(""));
  }

  @Test public void springApplicationInitializerDiscovered() throws Exception {
    assertThat(get("/touch"), equalTo("success"));
  }

  @After public void shutdown() throws Exception {
    server.stop();
  }

  private String get(String uri) throws IOException {
    return content(url("http://localhost:10000" + uri));
  }
}
