package org.hl7.fhir.dstu3.utils.client.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.dstu3.formats.IParser;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.utils.ResourceUtilities;
import org.hl7.fhir.dstu3.utils.client.EFhirClientException;
import org.hl7.fhir.dstu3.utils.client.ResourceFormat;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.MimeType;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.settings.FhirSettings;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FhirRequestBuilder {

  protected static final String HTTP_PROXY_USER = "http.proxyUser";
  protected static final String HTTP_PROXY_PASS = "http.proxyPassword";
  protected static final String HEADER_PROXY_AUTH = "Proxy-Authorization";
  protected static final String LOCATION_HEADER = "location";
  protected static final String CONTENT_LOCATION_HEADER = "content-location";
  protected static final String DEFAULT_CHARSET = "UTF-8";
  /**
   * The singleton instance of the HttpClient, used for all requests.
   */
  private static OkHttpClient okHttpClient;
  private final Request.Builder httpRequest;
  private String resourceFormat = null;
  private Headers headers = null;
  private String message = null;
  private int retryCount = 1;
  /**
   * The timeout quantity. Used in combination with {@link FhirRequestBuilder#timeoutUnit}.
   */
  private long timeout = 5000;
  /**
   * Time unit for {@link FhirRequestBuilder#timeout}.
   */
  private TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;
  /**
   * {@link ToolingClientLogger} for log output.
   */
  private ToolingClientLogger logger = null;
  private String source;

  public FhirRequestBuilder(Request.Builder httpRequest, String source) {
    this.httpRequest = httpRequest;
    this.source = source;
  }

  /**
   * Adds necessary default headers, formatting headers, and any passed in {@link Headers} to the passed in
   * {@link okhttp3.Request.Builder}
   *
   * @param request {@link okhttp3.Request.Builder} to add headers to.
   * @param format  Expected {@link Resource} format.
   * @param headers Any additional {@link Headers} to add to the request.
   */
  protected static void formatHeaders(Request.Builder request, String format, Headers headers) {
    addDefaultHeaders(request, headers);
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
  protected static void addDefaultHeaders(Request.Builder request, Headers headers) {
    if (headers == null || !headers.names().contains("User-Agent")) {
      request.addHeader("User-Agent", "hapi-fhir-tooling-client");
    }
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
    if (headers != null) {
      headers.forEach(header -> request.addHeader(header.getFirst(), header.getSecond()));
    }
  }

  /**
   * Returns true if any of the {@link org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent} within the
   * provided {@link OperationOutcome} have an {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity} of
   * {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity#ERROR} or
   * {@link org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity#FATAL}
   *
   * @param oo {@link OperationOutcome} to evaluate.
   * @return {@link Boolean#TRUE} if an error exists.
   */
  protected static boolean hasError(OperationOutcome oo) {
    return (oo.getIssue().stream()
      .anyMatch(issue -> issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR
        || issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL));
  }

  /**
   * Extracts the 'location' header from the passes in {@link Headers}. If no value for 'location' exists, the
   * value for 'content-location' is returned. If neither header exists, we return null.
   *
   * @param headers {@link Headers} to evaluate
   * @return {@link String} header value, or null if no location headers are set.
   */
  protected static String getLocationHeader(Headers headers) {
    Map<String, List<String>> headerMap = headers.toMultimap();
    if (headerMap.containsKey(LOCATION_HEADER)) {
      return headerMap.get(LOCATION_HEADER).get(0);
    } else if (headerMap.containsKey(CONTENT_LOCATION_HEADER)) {
      return headerMap.get(CONTENT_LOCATION_HEADER).get(0);
    } else {
      return null;
    }
  }

  /**
   * We only ever want to have one copy of the HttpClient kicking around at any given time. If we need to make changes
   * to any configuration, such as proxy settings, timeout, caches, etc, we can do a per-call configuration through
   * the {@link OkHttpClient#newBuilder()} method. That will return a builder that shares the same connection pool,
   * dispatcher, and configuration with the original client.
   * </p>
   * The {@link OkHttpClient} uses the proxy auth properties set in the current system properties. The reason we don't
   * set the proxy address and authentication explicitly, is due to the fact that this class is often used in conjunction
   * with other http client tools which rely on the system.properties settings to determine proxy settings. It's easier
   * to keep the method consistent across the board. ...for now.
   *
   * @return {@link OkHttpClient} instance
   */
  protected OkHttpClient getHttpClient() {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    
    if (okHttpClient == null) {
      okHttpClient = new OkHttpClient();
    }

    Authenticator proxyAuthenticator = getAuthenticator();

    return okHttpClient.newBuilder()
      .addInterceptor(new RetryInterceptor(retryCount))
      .connectTimeout(timeout, timeoutUnit)
      .writeTimeout(timeout, timeoutUnit)
      .readTimeout(timeout, timeoutUnit)
      .proxyAuthenticator(proxyAuthenticator)
      .build();
  }

  @Nonnull
  private static Authenticator getAuthenticator() {
    return (route, response) -> {
      final String httpProxyUser = System.getProperty(HTTP_PROXY_USER);
      final String httpProxyPass = System.getProperty(HTTP_PROXY_PASS);
      if (httpProxyUser != null && httpProxyPass != null) {
        String credential = Credentials.basic(httpProxyUser, httpProxyPass);
        return response.request().newBuilder()
          .header(HEADER_PROXY_AUTH, credential)
          .build();
      }
      return response.request().newBuilder().build();
    };
  }

  public FhirRequestBuilder withResourceFormat(String resourceFormat) {
    this.resourceFormat = resourceFormat;
    return this;
  }

  public FhirRequestBuilder withHeaders(Headers headers) {
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

  public FhirRequestBuilder withTimeout(long timeout, TimeUnit unit) {
    this.timeout = timeout;
    this.timeoutUnit = unit;
    return this;
  }

  protected Request buildRequest() {
    return httpRequest.build();
  }

  public <T extends Resource> ResourceRequest<T> execute() throws IOException {
    formatHeaders(httpRequest, resourceFormat, headers);
    final Request request = httpRequest.build();
    log(request.method(), request.url().toString(), request.headers(), request.body() != null ? request.body().toString().getBytes() : null);
    Response response = getHttpClient().newCall(request).execute();
    T resource = unmarshalReference(response, resourceFormat);
    return new ResourceRequest<T>(resource, response.code(), getLocationHeader(response.headers()));
  }

  public Bundle executeAsBatch() throws IOException {
    formatHeaders(httpRequest, resourceFormat, null);
    final Request request = httpRequest.build();
    log(request.method(), request.url().toString(), request.headers(), request.body() != null ? request.body().toString().getBytes() : null);

    Response response = getHttpClient().newCall(request).execute();
    return unmarshalFeed(response, resourceFormat);
  }

  /**
   * Unmarshalls a resource from the response stream.
   */
  @SuppressWarnings("unchecked")
  protected <T extends Resource> T unmarshalReference(Response response, String format) {
    T resource = null;
    OperationOutcome error = null;

    if (response.body() != null) {
      try {
        byte[] body = response.body().bytes();
        log(response.code(), response.headers(), body);
        resource = (T) getParser(format).parse(body);
        if (resource instanceof OperationOutcome && hasError((OperationOutcome) resource)) {
          error = (OperationOutcome) resource;
        }
      } catch (IOException ioe) {
        throw new EFhirClientException("Error reading Http Response from "+source+": " + ioe.getMessage(), ioe);
      } catch (Exception e) {
        throw new EFhirClientException("Error parsing response message from "+source+": " + e.getMessage(), e);
      }
    }

    if (error != null) {
      throw new EFhirClientException("Error from server: " + ResourceUtilities.getErrorDescription(error), error);
    }

    return resource;
  }

  /**
   * Unmarshalls Bundle from response stream.
   */
  protected Bundle unmarshalFeed(Response response, String format) {
    Bundle feed = null;
    OperationOutcome error = null;
    try {
      byte[] body = response.body().bytes();
      log(response.code(), response.headers(), body);
      String contentType = response.header("Content-Type");
      if (body != null) {
        if (contentType.contains(ResourceFormat.RESOURCE_XML.getHeader()) || contentType.contains(ResourceFormat.RESOURCE_JSON.getHeader()) || contentType.contains("text/xml+fhir")) {
          Resource rf = getParser(format).parse(body);
          if (rf instanceof Bundle)
            feed = (Bundle) rf;
          else if (rf instanceof OperationOutcome && hasError((OperationOutcome) rf)) {
            error = (OperationOutcome) rf;
          } else {
            throw new EFhirClientException("Error reading server response: a resource was returned instead");
          }
        }
      }
    } catch (IOException ioe) {
      throw new EFhirClientException("Error reading Http Response from "+source+": "+ioe.getMessage(), ioe);
    } catch (Exception e) {
      throw new EFhirClientException("Error parsing response message from "+source+":"+e.getMessage(), e);
    }
    if (error != null) {
      throw new EFhirClientException("Error from "+source+": " + ResourceUtilities.getErrorDescription(error), error);
    }
    return feed;
  }

  /**
   * Returns the appropriate parser based on the format type passed in. Defaults to XML parser if a blank format is
   * provided...because reasons.
   * <p>
   * Currently supports only "json" and "xml" formats.
   *
   * @param format One of "json" or "xml".
   * @return {@link JsonParser} or {@link XmlParser}
   */
  protected IParser getParser(String format) {
    if (StringUtils.isBlank(format)) {
      format = ResourceFormat.RESOURCE_XML.getHeader();
    }
    MimeType mt = new MimeType(format);
    if (mt.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_JSON.getHeader())) {
      return new JsonParser();
    } else if (mt.getBase().equalsIgnoreCase(ResourceFormat.RESOURCE_XML.getHeader())) {
      return new XmlParser();
    } else {
      throw new EFhirClientException("Invalid format: " + format);
    }
  }

  /**
   * Logs the given {@link Request}, using the current {@link ToolingClientLogger}. If the current
   * {@link FhirRequestBuilder#logger} is null, no action is taken.
   *
   * @param method  HTTP request method
   * @param url request URL
   * @param requestHeaders {@link Headers} for request
   * @param requestBody Byte array request
   */
  protected void log(String method, String url, Headers requestHeaders, byte[] requestBody) {
    if (logger != null) {
      List<String> headerList = new ArrayList<>(Collections.emptyList());
      Map<String, List<String>> headerMap = requestHeaders.toMultimap();
      headerMap.keySet().forEach(key -> headerMap.get(key).forEach(value -> headerList.add(key + ":" + value)));

      logger.logRequest(method, url, headerList, requestBody);
    }

  }

  /**
   * Logs the given {@link Response}, using the current {@link ToolingClientLogger}. If the current
   * {@link FhirRequestBuilder#logger} is null, no action is taken.
   *
   * @param responseCode    HTTP response code
   * @param responseHeaders {@link Headers} from response
   * @param responseBody    Byte array response
   */
  protected void log(int responseCode, Headers responseHeaders, byte[] responseBody) {
    if (logger != null) {
      List<String> headerList = new ArrayList<>(Collections.emptyList());
      Map<String, List<String>> headerMap = responseHeaders.toMultimap();
      headerMap.keySet().forEach(key -> headerMap.get(key).forEach(value -> headerList.add(key + ":" + value)));

      try {
        logger.logResponse(Integer.toString(responseCode), headerList, responseBody);
      } catch (Exception e) {
        System.out.println("Error parsing response body passed in to logger ->\n" + e.getLocalizedMessage());
      }
    }
//    else { // TODO fix logs
//      System.out.println("Call to log HTTP response with null ToolingClientLogger set... are you forgetting to " +
//        "initialize your logger?");
//    }
  }
}
