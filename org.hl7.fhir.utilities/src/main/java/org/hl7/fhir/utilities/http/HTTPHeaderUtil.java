package org.hl7.fhir.utilities.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTPHeaderUtil {

  public static final String USER_AGENT = "User-Agent";


  public static Map<String, List<String>> getMultimap(Iterable<HTTPHeader> headers) {
    Map<String, List<String>> result = new HashMap<>();
    if (headers != null) {
      for (HTTPHeader header : headers) {
        List<String> values = result.getOrDefault(header.getName(), new ArrayList<>());
        values.add(header.getValue());
        result.put(header.getName(), values);
      }
    }
    return result;
  }

  public static Iterable<String> getHeaders(Iterable<HTTPHeader> headers, String key) {
    List<String> result = new ArrayList<>();
    if (headers != null) {
      for (HTTPHeader header : headers) {
        if (header.getName().equalsIgnoreCase(key)) {
          result.add(header.getValue());
        }
      }
    }
    return result;
  }

  public static String getSingleHeader(Iterable<HTTPHeader> headers, String key) {
    for (HTTPHeader header : headers) {
      if (header.getName().equalsIgnoreCase(key)) {
        return header.getValue();
      }
    }
    return null;
  }

  public static boolean hasHeader(Iterable<HTTPHeader> headers, String s) {
    return getSingleHeader(headers, s) != null;
  }
}
