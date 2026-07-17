package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.ToolingClientLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManagedFhirWebAccessor extends ManagedWebAccessorBase<ManagedFhirWebAccessor> {

  /**
   * The singleton instance of the HttpClient, used for all requests.
   */
  private SimpleHTTPClient httpClient;

  private long timeout;
  private TimeUnit timeoutUnit;
  private int retries;
  private ToolingClientLogger logger;

  public ManagedFhirWebAccessor withTimeout(long timeout, TimeUnit timeoutUnit) {
    this.timeout = timeout;
    this.timeoutUnit = timeoutUnit;
    return this;
  }

  public ManagedFhirWebAccessor withRetries(int retries) {
    this.retries = retries;
    return this;
  }

  public ManagedFhirWebAccessor withLogger(ToolingClientLogger logger) {
    this.logger = logger;
    return this;
  }

  public ManagedFhirWebAccessor(String userAgent, IHTTPAuthenticationProvider authenticationProvider) {
    super(Arrays.asList("fhir"), userAgent, authenticationProvider);
    this.timeout = 5000;
    this.timeoutUnit = TimeUnit.MILLISECONDS;
  }

  protected HTTPRequest httpRequestWithDefaultHeaders(HTTPRequest request) {
    List<HTTPHeader> headers = new ArrayList<>();
    if (HTTPHeaderUtil.getSingleHeader(request.getHeaders(), HTTPHeaderUtil.USER_AGENT) == null
      && getUserAgent() != null) {
      headers.add(new HTTPHeader(HTTPHeaderUtil.USER_AGENT, getUserAgent()));
    }
    request.getHeaders().forEach(headers::add);
    return request.withHeaders(headers);
  }

  protected HTTPRequest requestWithAuthorizationHeaders(HTTPRequest httpRequest) {
    HTTPRequest requestWithDefaultHeaders = httpRequestWithDefaultHeaders(httpRequest);

    List<HTTPHeader> headers = new ArrayList<>();
    requestWithDefaultHeaders.getHeaders().forEach(headers::add);

    for (Map.Entry<String, String> entry : this.getHeaders().entrySet()) {
      headers.add(new HTTPHeader(entry.getKey(), entry.getValue()));
    }

    if (getHttpAuthHeaderProvider() != null && getHttpAuthHeaderProvider().canProvideHeaders(httpRequest.getUrl())) {
      for (Map.Entry<String, String> entry : getHttpAuthHeaderProvider().getHeaders(httpRequest.getUrl()).entrySet()) {
           headers.add(new HTTPHeader(entry.getKey(), entry.getValue()));
      }
    }
    return httpRequest.withHeaders(headers);
  }

  public HTTPResult httpCall(HTTPRequest httpRequest) throws IOException {
    switch (ManagedWebAccess.getAccessPolicy()) {
      case DIRECT: {
        HTTPRequest requestWithAuthorizationHeaders = requestWithAuthorizationHeaders(httpRequest);
        assert requestWithAuthorizationHeaders.getUrl() != null;
        String url = requestWithAuthorizationHeaders.getUrl().toString();

        if (!ManagedWebAccess.inAllowedPaths(url)) {
          throw new IOException("The pathname '" + url + "' cannot be accessed by policy");
        }

        SimpleHTTPClient client = getHttpClient();
        Iterable<HTTPHeader> headers = requestWithAuthorizationHeaders.getHeaders();
        String contentType = requestWithAuthorizationHeaders.getContentType();
        byte[] body = requestWithAuthorizationHeaders.getBody();

        return switch (requestWithAuthorizationHeaders.getMethod()) {
          case GET -> client.get(url, null, headers);
          case POST -> client.post(url, contentType, body, null, headers);
          case PUT -> client.put(url, contentType, body, null, headers);
          case DELETE -> client.delete(url, null, headers);
          case OPTIONS -> client.options(url, null, headers);
          case HEAD, PATCH -> throw new IOException("HTTP method " + requestWithAuthorizationHeaders.getMethod() + " is not supported");
        };
      }
      case MANAGED:
        HTTPRequest requestWithAuthorizationHeaders = requestWithAuthorizationHeaders(httpRequest);
        assert requestWithAuthorizationHeaders.getUrl() != null;
        return ManagedWebAccess.getFhirWebAccessor().httpCall(requestWithAuthorizationHeaders);
      case PROHIBITED:
        throw new IOException("Access to the internet is not allowed by local security policy");
      default:
        throw new IOException("Internal Error");
    }
  }

  private SimpleHTTPClient getHttpClient() {
    if (httpClient == null) {
      httpClient = SimpleHTTPClient.builder()
        .timeout(timeout)
        .timeoutUnit(timeoutUnit)
        .retries(retries)
        .logger(logger)
        .authProvider(getHttpAuthHeaderProvider())
        .ssrfProtectionEnabled(isSSRFProtectionEnabled())
        .build();
    }
    return httpClient;
  }

}
