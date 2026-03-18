package org.hl7.fhir.utilities.http;

import okhttp3.*;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.okhttpimpl.LoggingInterceptor;
import org.hl7.fhir.utilities.http.okhttpimpl.ProxyAuthenticator;
import org.hl7.fhir.utilities.http.okhttpimpl.RetryInterceptor;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

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
  private static OkHttpClient okHttpClient;

  private long timeout;
  private TimeUnit timeoutUnit;
  private int retries;
  private ToolingClientLogger logger;
  private LoggingInterceptor loggingInterceptor;

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
    this.loggingInterceptor = new LoggingInterceptor(logger);
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

        RequestBody body = requestWithAuthorizationHeaders.getBody() == null ? null : RequestBody.create(requestWithAuthorizationHeaders.getBody());
        Request.Builder requestBuilder = new Request.Builder()
          .url(requestWithAuthorizationHeaders.getUrl())
          .method(requestWithAuthorizationHeaders.getMethod().name(), body);

        for (HTTPHeader header : requestWithAuthorizationHeaders.getHeaders()) {
          requestBuilder.addHeader(header.getName(), header.getValue());
        }
        OkHttpClient okHttpClient = getOkHttpClient();

        if (!ManagedWebAccess.inAllowedPaths(requestWithAuthorizationHeaders.getUrl().toString())) {
          throw new IOException("The pathname '" + requestWithAuthorizationHeaders.getUrl().toString() + "' cannot be accessed by policy");
        }
        Response response = okHttpClient.newCall(requestBuilder.build()).execute();
        return getHTTPResult(response);
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

  private HTTPResult getHTTPResult(Response execute) throws IOException {
    return new HTTPResult(execute.request().url().toString(), execute.code(), execute.message(), execute.header("Content-Type"), execute.body() != null && execute.body().contentLength() != 0 ? execute.body().bytes() : null, getHeadersFromResponse(execute));
  }

  private Iterable<HTTPHeader> getHeadersFromResponse(Response response) {
    List<HTTPHeader> headers = new ArrayList<>();
    for (String name : response.headers().names()) {
      headers.add(new HTTPHeader(name, response.header(name)));
    }
    return headers;
  }

  private OkHttpClient getOkHttpClient() {
    if (okHttpClient == null) {
      okHttpClient = new OkHttpClient();
    }
    OkHttpClient.Builder builder = okHttpClient.newBuilder();
    if (logger != null) builder.addInterceptor(loggingInterceptor);
    builder.addInterceptor(new RetryInterceptor(retries));
    builder.proxyAuthenticator(new ProxyAuthenticator());
    return builder.connectTimeout(timeout, timeoutUnit)
      .writeTimeout(timeout, timeoutUnit)
      .readTimeout(timeout, timeoutUnit).build();
  }

}
