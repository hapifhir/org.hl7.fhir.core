package org.hl7.fhir.utilities.http;

import org.checkerframework.checker.nullness.qual.NonNull;

public class URLUtil {
  public static @NonNull String getUrlWithNoCacheParam(String url) {
    return url.contains("?") ? url + "&nocache=" + System.currentTimeMillis() : url + "?nocache=" + System.currentTimeMillis();
  }
}
