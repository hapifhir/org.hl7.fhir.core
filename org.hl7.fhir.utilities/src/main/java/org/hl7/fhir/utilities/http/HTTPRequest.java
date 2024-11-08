package org.hl7.fhir.utilities.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

@AllArgsConstructor
public class HTTPRequest {

  public HTTPRequest() {
    url = null;
    method = HttpMethod.GET;
    body = null;
    contentType = null;
    headers = Collections.emptyList();
  }

  public enum HttpMethod {
    GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH
  }

  @Getter @Nullable
  private final URL url;

  public HTTPRequest withUrl(URL url) {
    return new HTTPRequest(url, method, body, contentType, headers);
  }

  public HTTPRequest withUrl(String url)  {
    try {
      return withUrl(new URL(url));
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Invalid URL: " + url, e);
    }
  }

  @With @Getter
  private final HttpMethod method;

  @With @Getter @Nullable
  private final byte[] body;

  @With @Getter @Nullable
  private final String contentType;

  @With @Getter @Nonnull
  private final Iterable<HTTPHeader> headers;
}
