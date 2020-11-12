package org.hl7.fhir.r5.utils.client.network;

import kotlin.Pair;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.utils.client.ResourceFormat;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class FhirRequestBuilder {

  protected static final String DEFAULT_CHARSET = "UTF-8";

  private final Request.Builder httpRequest;
  private String resourceFormat = null;
  private byte[] payload = null;
  private List<Header> headers = Collections.emptyList();
  private String message = null;
  private int retryCount = 1;

  /**
   * The timeout quantity. Used in combination with {@link FhirRequestBuilder#timeoutUnit}.
   */
  private int timeout = 5;

  /**
   * Time unit for {@link FhirRequestBuilder#timeout}.
   */
  private TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;

  /**
   * {@link ToolingClientLogger} for log output.
   */
  private ToolingClientLogger logger = null;

  /**
   * The singleton instance of the HttpClient, used for all requests.
   */
  private static OkHttpClient okHttpClient;

  /**
   * We only ever want to have one copy of the HttpClient kicking around at any given time. If we need to make changes
   * to any configuration, such as proxy settings, timeout, caches, etc, we can do a per-call configuration through
   * the {@link OkHttpClient#newBuilder()} method. That will return a builder that shares the same connection pool,
   * dispatcher, and configuration with the original client.
   *
   * @return {@link OkHttpClient} instance
   */
  private OkHttpClient getHttpClient() {
    if (okHttpClient == null) {
      okHttpClient = new OkHttpClient();
    }
    return okHttpClient.newBuilder()
      .addInterceptor(new RetryInterceptor(retryCount))
      .connectTimeout(timeout, timeoutUnit)
      .writeTimeout(timeout, timeoutUnit)
      .readTimeout(timeout, timeoutUnit)
      .callTimeout(timeout, timeoutUnit)
      .build();
  }

  public FhirRequestBuilder(Request.Builder httpRequest) {
    this.httpRequest = httpRequest;
  }

  public FhirRequestBuilder withResourceFormat(String resourceFormat) {
    this.resourceFormat = resourceFormat;
    return this;
  }

  public FhirRequestBuilder withPayload(byte[] payload) {
    this.payload = payload;
    return this;
  }

  public FhirRequestBuilder withHeaders(List<Header> headers) {
    this.headers = headers;
    return this;
  }

  public FhirRequestBuilder withMessage(String message) {
    this.message = message;
    return this;
  }

  public FhirRequestBuilder withRetryCount(int retryCount) {
    this.retryCount = retryCount;
    return this;
  }

  public FhirRequestBuilder withLogger(ToolingClientLogger logger) {
    this.logger = logger;
    return this;
  }

  public FhirRequestBuilder withTimeout(int timeout, TimeUnit unit) {
    this.timeout = timeout;
    this.timeoutUnit = unit;
    return this;
  }

  protected Request buildRequest() {
    return httpRequest.build();
  }

  public <T extends Resource> ResourceRequest<T> execute() {
    formatHeaders(httpRequest, resourceFormat, null);
    setAuth(httpRequest);
//
//    try {
//      Response response = getHttpClient().newCall(httpRequest.build()).execute();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    HttpResponse.BodyHandler<byte[]> handler = HttpResponse.BodyHandlers.ofByteArray();
//    return getClient().sendAsync(httpRequestBuilder.build(), handler)
//      .thenComposeAsync(r -> tryResend(getClient(), httpRequestBuilder.build(), handler, retryCount, r, message))
//      .thenApply(response -> new ResourceRequest<>(unmarshalReference(response, resourceFormat),
//        response.statusCode(),
//        getLocationHeader(response)));

    return null;
  }

  public CompletableFuture<Bundle> executeAsBatch() {
//    formatHeaders(httpRequestBuilder, resourceFormat, null);
//    setAuth(httpRequestBuilder);
//
//    HttpResponse.BodyHandler<byte[]> handler = HttpResponse.BodyHandlers.ofByteArray();
//    return getClient().sendAsync(httpRequestBuilder.build(), handler)
//      .thenComposeAsync(r -> tryResend(getClient(), httpRequestBuilder.build(), handler, retryCount, r, message))
//      .thenApply(response -> unmarshalFeed(response, resourceFormat));
    return null;
  }

//  public <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
//                                                          HttpRequest request,
//                                                          HttpResponse.BodyHandler<T> handler,
//                                                          int count,
//                                                          HttpResponse<T> resp,
//                                                          String message) {
//    if (isSuccessful(resp)) {
//      return CompletableFuture.completedFuture(resp);
//    } else if (count >= retryCount) {
//      System.out.println("Retry count exceeded, (R5 / for " + message + ")");
//      throw new EFhirClientException("Error sending HTTP Post/Put Payload, retries exceeded...");
//    } else {
//      return client.sendAsync(request, handler)
//        .thenComposeAsync(r -> tryResend(client, request, handler, count + 1, r, message));
//    }
//    return null;
//  }


  /**
   * @param request
   * @param format
   * @param headers
   */
  protected static void formatHeaders(Request.Builder request, String format, Headers headers) {
    addDefaultHeaders(request);
    if (format != null) addResourceFormatHeaders(request, format);
    if (headers != null) addHeaders(request, headers);
  }

  /**
   * Adds necessary headers for all REST requests.
   * <li>User-Agent : hapi-fhir-tooling-client</li>
   * <li>Accept-Charset : {@link FhirRequestBuilder#DEFAULT_CHARSET}</li>
   *
   * @param request {@link Request.Builder} to add default headers to.
   */
  protected static void addDefaultHeaders(Request.Builder request) {
    request.addHeader("User-Agent", "hapi-fhir-tooling-client");
    request.addHeader("Accept-Charset", DEFAULT_CHARSET);
  }

  /**
   * Adds necessary headers for the given resource format provided.
   *
   * @param request {@link Request.Builder} to add default headers to.
   */
  protected static void addResourceFormatHeaders(Request.Builder request, String format) {
    request.addHeader("Accept", format);
    request.addHeader("Content-Type", format + ";charset=" + DEFAULT_CHARSET);
  }

  /**
   * Iterates through the passed in {@link Headers} and adds them to the provided {@link Request.Builder}.
   *
   * @param request {@link Request.Builder} to add headers to.
   * @param headers {@link Headers} to add to request.
   */
  protected static void addHeaders(Request.Builder request, Headers headers) {
    headers.forEach(header -> request.addHeader(header.getFirst(), header.getSecond()));
  }

  /**
   * Unmarshalls a resource from the response stream.
   *
   * @param response
   * @return
   */
  @SuppressWarnings("unchecked")
  protected <T extends Resource> T unmarshalReference(Response response, String format) {

    return null;
  }

  /**
   * Unmarshals Bundle from response stream.
   *
   * @param response
   * @return
   */
  protected Bundle unmarshalFeed(Response response, String format) {
    Bundle feed = null;

    return feed;
  }

  protected IParser getParser(String format) {
    if (StringUtils.isBlank(format)) {
      format = ResourceFormat.RESOURCE_XML.getHeader();
    }
    if (format.equalsIgnoreCase("json") || format.equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())) {
      return new JsonParser();
    } else if (format.equalsIgnoreCase("xml") || format.equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())) {
      return new XmlParser();
    } else {
      throw new EFhirClientException("Invalid format: " + format);
    }
  }

  private boolean hasError(OperationOutcome oo) {
    return (oo.getIssue().stream().anyMatch(issue -> issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR || issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL));
  }

  private void log(Response response) throws IOException {
    if (logger != null) {
      Iterator<Pair<String, String>> iterator = response.headers().iterator();
      List<String> headerList = Collections.emptyList();
      while (iterator.hasNext()) {
        Pair<String, String> pair = iterator.next();
        headerList.add(pair.getFirst() + ":" + pair.getSecond());
        iterator.next();
      }
      logger.logResponse(Integer.toString(response.code()), headerList, response.body().bytes());
    }
  }

  protected String getLocationHeader(Headers headers) {
    Map<String, List<String>> headerMap = headers.toMultimap();
    if (headerMap.containsKey("location")) {
      return headerMap.get("location").get(0);
    } else if (headerMap.containsKey("content-location")) {
      return headerMap.get("content-location").get(0);
    } else {
      return null;
    }
  }

  private void setAuth(Request.Builder requestBuilder) {
// TODO
//    if (password != null) {
//      try {
//        byte[] b = Base64.encodeBase64((username+":"+password).getBytes("ASCII"));
//        String b64 = new String(b, StandardCharsets.US_ASCII);
//        httpget.setHeader("Authorization", "Basic " + b64);
//      } catch (UnsupportedEncodingException e) {
//      }
//    }
//  }
  }

//  public HttpClient getClient() {

//    httpclient = new DefaultHttpClient();
//    HttpParams params = httpclient.getParams();
//    HttpConnectionParams.setConnectionTimeout(params, TIMEOUT_CONNECT);
//    HttpConnectionParams.setSoTimeout(params, timeout);
//    HttpConnectionParams.setSoKeepalive(params, true);
//    if(proxy != null) {
//      httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
//    }
//  }

}
