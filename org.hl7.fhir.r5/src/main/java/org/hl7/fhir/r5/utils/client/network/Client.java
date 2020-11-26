package org.hl7.fhir.r5.utils.client.network;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {

  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final long DEFAULT_TIMEOUT = 5000;
  private String username;
  private String password;
  private ToolingClientLogger logger;
  private int retryCount;
  private long timeout = DEFAULT_TIMEOUT;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ToolingClientLogger getLogger() {
    return logger;
  }

  public void setLogger(ToolingClientLogger logger) {
    this.logger = logger;
  }

  public int getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(int retryCount) {
    this.retryCount = retryCount;
  }

  public long getTimeout() {
    return timeout;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri,
                                                                     String resourceFormat,
                                                                     String message,
                                                                     long timeout) throws IOException {
    Request.Builder request = new Request.Builder()
      .method("OPTIONS", null)
      .url(optionsUri.toURL());

    return executeFhirRequest(request, resourceFormat, null, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri,
                                                                         String resourceFormat,
                                                                         String message,
                                                                         long timeout) throws IOException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());

    return executeFhirRequest(request, resourceFormat, null, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 String message,
                                                                 long timeout) throws IOException {
    return issuePutRequest(resourceUri, payload, resourceFormat, null, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 Headers headers,
                                                                 String message,
                                                                 long timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("PUT requests require a non-null payload");
    RequestBody body = RequestBody.create(payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .put(body);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri,
                                                                  byte[] payload,
                                                                  String resourceFormat,
                                                                  String message,
                                                                  long timeout) throws IOException {
    return issuePostRequest(resourceUri, payload, resourceFormat, null, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri,
                                                                  byte[] payload,
                                                                  String resourceFormat,
                                                                  Headers headers,
                                                                  String message,
                                                                  long timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri) throws IOException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .delete();
    return executeFhirRequest(request, null, null, null, retryCount, timeout).isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) throws IOException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());

    return executeBundleRequest(request, resourceFormat, null, null, retryCount, timeout);
  }

  public Bundle issuePostFeedRequest(URI resourceUri,
                                     Map<String, String> parameters,
                                     String resourceName,
                                     Resource resource,
                                     String resourceFormat) throws IOException {
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
    byte[] payload = ByteUtils.encodeFormSubmission(parameters, resourceName, resource, boundary);
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);

    return executeBundleRequest(request, resourceFormat, null, null, retryCount, timeout);
  }

  public Bundle postBatchRequest(URI resourceUri,
                                 byte[] payload,
                                 String resourceFormat,
                                 String message,
                                 int timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);

    return executeBundleRequest(request, resourceFormat, null, message, retryCount, timeout);
  }

  protected <T extends Resource> Bundle executeBundleRequest(Request.Builder request,
                                                             String resourceFormat,
                                                             Headers headers,
                                                             String message,
                                                             int retryCount,
                                                             long timeout) throws IOException {
    return new FhirRequestBuilder(request)
      .withLogger(logger)
      .withResourceFormat(resourceFormat)
      .withRetryCount(retryCount)
      .withMessage(message)
      .withHeaders(headers == null ? new Headers.Builder().build() : headers)
      .withTimeout(timeout, TimeUnit.MILLISECONDS)
      .executeAsBatch();
  }

  protected <T extends Resource> ResourceRequest<T> executeFhirRequest(Request.Builder request,
                                                                       String resourceFormat,
                                                                       Headers headers,
                                                                       String message,
                                                                       int retryCount,
                                                                       long timeout) throws IOException {
    return new FhirRequestBuilder(request)
      .withLogger(logger)
      .withResourceFormat(resourceFormat)
      .withRetryCount(retryCount)
      .withMessage(message)
      .withHeaders(headers == null ? new Headers.Builder().build() : headers)
      .withTimeout(timeout, TimeUnit.MILLISECONDS)
      .execute();
  }

  /**
   * @deprecated It does not appear as though this method is actually being used. Will be removed in a future release
   * unless a case is made to keep it.
   */
  @Deprecated
  public Calendar getLastModifiedResponseHeaderAsCalendarObject(URLConnection serverConnection) {
    String dateTime = null;
    try {
      dateTime = serverConnection.getHeaderField("Last-Modified");
      SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("en", "US"));
      Date lastModifiedTimestamp = format.parse(dateTime);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(lastModifiedTimestamp);
      return calendar;
    } catch (ParseException pe) {
      throw new EFhirClientException("Error parsing Last-Modified response header " + dateTime, pe);
    }
  }
}
