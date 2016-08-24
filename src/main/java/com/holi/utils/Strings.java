package com.holi.utils;

import java.util.List;

/**
 * Created by selonj on 16-8-24.
 */
public class Strings {
  public static String join(List<String> strings, String separator) {
    StringBuilder result = new StringBuilder();
    for (String string : strings) result.append(string).append(separator);
    return result.toString();
  }
}
