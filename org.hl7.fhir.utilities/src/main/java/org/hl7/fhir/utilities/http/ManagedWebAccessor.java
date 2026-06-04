package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages access via a simple HTTP client for making requests to a server with no FHIR-specific code.
 */
public class ManagedWebAccessor extends ManagedWebAccessorBase<ManagedWebAccessor> {

  public ManagedWebAccessor(Iterable<String> serverTypes, String userAgent, IHTTPAuthenticationProvider httpAuthHeaderProvider) {
    super(serverTypes, userAgent, httpAuthHeaderProvider);
  }
  
  private Map<String, String> newHeaders(String urlString) throws MalformedURLException {
    URL url = new URL(urlString);
    Map<String, String> headers = new HashMap<>(this.getHeaders());
    if (this.getHttpAuthHeaderProvider().canProvideHeaders(url)) {
      headers.putAll(this.getHttpAuthHeaderProvider().getHeaders(url));
    }
    if (getUserAgent() != null) {
      headers.put("User-Agent", getUserAgent());
    }
    return headers;
  }

  private SimpleHTTPClient setupSimpleHTTPClient(String url) throws IOException {
    if (!ManagedWebAccess.inAllowedPaths(url)) {
      throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
    }
    SimpleHTTPClient client = new SimpleHTTPClient(getHttpAuthHeaderProvider());

    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      client.addHeader(entry.getKey(), entry.getValue());
    }

    if (getUserAgent() != null) {
      client.addHeader("User-Agent", getUserAgent());
    }
    return client;
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);
  }

  public HTTPResult get(String url, String accept) throws IOException {
    return switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT -> {
        SimpleHTTPClient client = setupSimpleHTTPClient(url);
        yield client.get(url, accept);
      }
      case MANAGED ->  ManagedWebAccess.getAccessor().get(getServerTypes(), url, accept, newHeaders(url));
      case PROHIBITED -> throw new IOException("Access to the internet is not allowed by local security policy");
      default -> throw new IOException("Internal Error");
    };
  }

  public HTTPResult post(String url, byte[] content, String contentType) throws IOException {
    return post(url, content, contentType, null);
  }

  public HTTPResult post(String url, byte[] content, String contentType, String accept) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
    case DIRECT:
      SimpleHTTPClient client = setupSimpleHTTPClient(url);
      return client.post(url, contentType, content, accept);
    case MANAGED:
      return ManagedWebAccess.getAccessor().post(getServerTypes(), url, content, contentType, accept, newHeaders(url));
    case PROHIBITED:
      throw new IOException("Access to the internet is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public HTTPResult put(String url, byte[] content, String contentType) throws IOException {
    return put(url, content, contentType, null);
  }

  public HTTPResult put(String url, byte[] content, String contentType, String accept) throws IOException {
    return switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT -> {
        SimpleHTTPClient client = setupSimpleHTTPClient(url);
        yield client.put(url, contentType, content, accept);
      }
      case MANAGED ->
        ManagedWebAccess.getAccessor().put(getServerTypes(), url, content, contentType, accept, newHeaders(url));
      case PROHIBITED -> throw new IOException("Access to the internet is not allowed by local security policy");
      default -> throw new IOException("Internal Error");
    };
  }
}
