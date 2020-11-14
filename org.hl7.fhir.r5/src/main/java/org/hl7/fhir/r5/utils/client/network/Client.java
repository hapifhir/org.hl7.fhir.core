package org.hl7.fhir.r5.utils.client.network;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class Client {

  private static boolean debugging = false;
  private static long DEFAULT_TIMEOUT = 5000;
  public static final String DEFAULT_CHARSET = "UTF-8";

  //  private HttpHost proxy;
//  private Proxy proxy = null;
  private String username;
  private String password;
  private ToolingClientLogger logger;
  private int retryCount;


//  public HttpHost getProxy() {
//    return proxy;
//  }
//
//  public void setProxy(HttpHost proxy) {
//    this.proxy = proxy;
//  }

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

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri,
                                                                     String resourceFormat,
                                                                     String message,
                                                                     long timeout) throws MalformedURLException {
    Request.Builder request = new Request.Builder()
      .method("OPTIONS", null)
      .url(optionsUri.toURL());

    return executeFhirRequest(request, resourceFormat, null, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri,
                                                                         String resourceFormat,
                                                                         String message,
                                                                         long timeout) throws MalformedURLException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());

    return executeFhirRequest(request, resourceFormat, null, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 String message,
                                                                 int timeout) throws MalformedURLException {
    return issuePutRequest(resourceUri, payload, resourceFormat, null, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 Headers headers,
                                                                 String message,
                                                                 int timeout) throws MalformedURLException {
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
                                                                  int timeout) throws MalformedURLException {
    return issuePostRequest(resourceUri, payload, resourceFormat, null, message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri,
                                                                  byte[] payload,
                                                                  String resourceFormat,
                                                                  Headers headers,
                                                                  String message,
                                                                  int timeout) throws MalformedURLException {
    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri) throws MalformedURLException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .delete();
    return executeFhirRequest(request, null, null, null, retryCount, DEFAULT_TIMEOUT).isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) throws MalformedURLException {
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());

    return executeBundleRequest(request, resourceFormat, null, null, retryCount, DEFAULT_TIMEOUT);
  }

  public Bundle postBatchRequest(URI resourceUri,
                                 byte[] payload,
                                 String resourceFormat,
                                 String message,
                                 int timeout) throws MalformedURLException {
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
                                                               long timeout) {
    return new FhirRequestBuilder(request)
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
                                                                       long timeout) {
    return new FhirRequestBuilder(request)
      .withResourceFormat(resourceFormat)
      .withRetryCount(retryCount)
      .withMessage(message)
      .withHeaders(headers == null ? new Headers.Builder().build() : headers)
      .withTimeout(timeout, TimeUnit.MILLISECONDS)
      .execute();
  }
}
