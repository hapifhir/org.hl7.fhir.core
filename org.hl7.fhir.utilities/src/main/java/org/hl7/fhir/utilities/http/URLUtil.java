package org.hl7.fhir.utilities.http;


import javax.annotation.Nonnull;

public class URLUtil {
  private URLUtil() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  public static @Nonnull String getUrlWithNoCacheParam(String url) {
    return url.contains("?") ? url + "&nocache=" + System.currentTimeMillis() : url + "?nocache=" + System.currentTimeMillis();
  }
}
