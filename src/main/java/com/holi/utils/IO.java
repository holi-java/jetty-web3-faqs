package com.holi.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by selonj on 16-8-24.
 */
public class IO {
  private static final int EOF = -1;
  private static final int KB = 1024;

  public static String content(URL url) throws IOException {
    return string(url.openStream());
  }

  public static String string(InputStream in) throws IOException {
    return new String(bytes(in));
  }

  public static byte[] bytes(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    write(in, out);
    return out.toByteArray();
  }

  public static void write(InputStream in, OutputStream out) throws IOException {
    byte[] buff = new byte[KB];
    for (int n; (n = in.read(buff)) != EOF; ) out.write(buff, 0, n);
  }
}
