package com.holi.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by selonj on 16-8-24.
 */
public class Urls {

  public static URL url(String url) throws MalformedURLException {
    return new URL(url);
  }

  public static List<String> paths(List<URL> urls) {
    return urls.stream().map(Urls::path).collect(Collectors.toList());
  }

  public static String path(URL url) {
    return url.getPath();
  }
}
