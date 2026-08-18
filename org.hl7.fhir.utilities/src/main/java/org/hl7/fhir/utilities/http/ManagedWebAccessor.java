package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages access via a simple HTTP client for making requests to a server with no FHIR-specific code.
 */
public class ManagedWebAccessor extends ManagedWebAccessorBase<ManagedWebAccessor> {

  /** Retry count for the underlying client; null leaves {@link ManagedHTTPClient}'s default. */
  private Integer retries;

  public ManagedWebAccessor(Iterable<String> serverTypes, String userAgent, IHTTPAuthenticationProvider httpAuthHeaderProvider) {
    super(serverTypes, userAgent, httpAuthHeaderProvider);
  }

  /**
   * Overrides how many times the underlying client retries an unsuccessful response. Use 0 for a
   * request that must not be repeated - e.g. one carrying credentials, where a retry re-sends them
   * and an error response is usually permanent rather than transient.
   */
  public ManagedWebAccessor withRetries(int retries) {
    this.retries = retries;
    return this;
  }

  private Map<String, String> newHeaders(String urlString) throws IOException {
    URL url = URI.create(urlString).toURL();
    Map<String, String> headers = new HashMap<>(this.getHeaders());
    if (this.getHttpAuthHeaderProvider().canProvideHeaders(url)) {
      headers.putAll(this.getHttpAuthHeaderProvider().getHeaders(url));
    }
    if (getUserAgent() != null) {
      headers.put("User-Agent", getUserAgent());
    }
    return headers;
  }

  private ManagedHTTPClient setupManagedHTTPClient(String url) throws IOException {
    if (!ManagedWebAccess.inAllowedPaths(url)) {
      throw new IOException("The pathname '"+url+"' cannot be accessed by policy");
    }
    ManagedHTTPClient.ManagedHTTPClientBuilder builder = ManagedHTTPClient.builder();

    builder.authProvider(getHttpAuthHeaderProvider())
      .ssrfProtectionEnabled(isSSRFProtectionEnabled());

    if (retries != null) {
      builder.retries(retries);
    }

    List<HTTPHeader> headers = new ArrayList<>();

    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      headers.add(new HTTPHeader(entry.getKey(), entry.getValue()));
    }

    if (getUserAgent() != null) {
      headers.add(new HTTPHeader("User-Agent", getUserAgent()));
    }
    builder.headers(headers);
    return builder.build();
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);
  }

  public HTTPResult get(String url, String accept) throws IOException {
    return switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT -> setupManagedHTTPClient(url).get(url, accept);
      case MANAGED -> ManagedWebAccess.getAccessor().get(getServerTypes(), url, accept, newHeaders(url));
      case PROHIBITED -> throw new IOException("Access to the internet is not allowed by local security policy");
      default -> throw new IOException("Internal Error");
    };
  }

  public HTTPResult post(String url, byte[] content, String contentType) throws IOException {
    return post(url, content, contentType, null);
  }

  public HTTPResult post(String url, byte[] content, String contentType, String accept) throws IOException {
    return switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT -> setupManagedHTTPClient(url).post(url, contentType, content, accept);
      case MANAGED -> ManagedWebAccess.getAccessor().post(getServerTypes(), url, content, contentType, accept, newHeaders(url));
      case PROHIBITED -> throw new IOException("Access to the internet is not allowed by local security policy");
      default -> throw new IOException("Internal Error");
    };
  }

  public HTTPResult put(String url, byte[] content, String contentType) throws IOException {
    return put(url, content, contentType, null);
  }

  public HTTPResult put(String url, byte[] content, String contentType, String accept) throws IOException {
    return switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT -> setupManagedHTTPClient(url).put(url, contentType, content, accept);
      case MANAGED -> ManagedWebAccess.getAccessor().put(getServerTypes(), url, content, contentType, accept, newHeaders(url));
      case PROHIBITED -> throw new IOException("Access to the internet is not allowed by local security policy");
      default -> throw new IOException("Internal Error");
    };
  }
}
