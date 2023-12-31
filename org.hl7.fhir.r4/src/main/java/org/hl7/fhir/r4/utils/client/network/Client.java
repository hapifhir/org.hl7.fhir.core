package org.hl7.fhir.r4.utils.client.network;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Client {
  
  

  public static final String DEFAULT_CHARSET = "UTF-8";
  private ToolingClientLogger logger;
  private FhirLoggingInterceptor fhirLoggingInterceptor;
  private int retryCount;
  private String base;
  
  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }


  public ToolingClientLogger getLogger() {
    return logger;
  }

  public void setLogger(ToolingClientLogger logger) {
    this.logger = logger;
    this.fhirLoggingInterceptor = new FhirLoggingInterceptor(logger);
  }

  public int getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(int retryCount) {
    this.retryCount = retryCount;
  }

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri, String resourceFormat,
      String message, long timeout) throws IOException {
    Request.Builder request = new Request.Builder().method("OPTIONS", null).url(optionsUri.toURL());

    return executeFhirRequest(request, resourceFormat, new Headers.Builder().build(), message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri, String resourceFormat,
      Headers headers, String message, long timeout) throws IOException {
    Request.Builder request = new Request.Builder().url(resourceUri.toURL());

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public int tester(int trytry) {
    return 5;
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      String message, long timeout) throws IOException {
    return issuePutRequest(resourceUri, payload, resourceFormat, new Headers.Builder().build(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      Headers headers, String message, long timeout) throws IOException {
    if (payload == null)
      throw new EFhirClientException("PUT requests require a non-null payload");
    RequestBody body = RequestBody.create(payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).put(body);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, String message, long timeout) throws IOException {
    return issuePostRequest(resourceUri, payload, resourceFormat, new Headers.Builder().build(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, Headers headers, String message, long timeout) throws IOException {
    if (payload == null)
      throw new EFhirClientException("POST requests require a non-null payload");
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri, int timeout) throws IOException {
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).delete();
    return executeFhirRequest(request, null, new Headers.Builder().build(), null, retryCount, timeout)
        .isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat, int timeout) throws IOException {
    Request.Builder request = new Request.Builder().url(resourceUri.toURL());

    return executeBundleRequest(request, resourceFormat, new Headers.Builder().build(), null, retryCount, timeout);
  }

  public Bundle issuePostFeedRequest(URI resourceUri, Map<String, String> parameters, String resourceName,
      Resource resource, String resourceFormat, int timeout) throws IOException {
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
    byte[] payload = ByteUtils.encodeFormSubmission(parameters, resourceName, resource, boundary);
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);

    return executeBundleRequest(request, resourceFormat, new Headers.Builder().build(), null, retryCount, timeout);
  }

  public Bundle postBatchRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout)
      throws IOException {
    if (payload == null)
      throw new EFhirClientException("POST requests require a non-null payload");
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);

    return executeBundleRequest(request, resourceFormat, new Headers.Builder().build(), message, retryCount, timeout);
  }

  public <T extends Resource> Bundle executeBundleRequest(Request.Builder request, String resourceFormat,
      Headers headers, String message, int retryCount, long timeout) throws IOException {
    return new FhirRequestBuilder(request, base).withLogger(fhirLoggingInterceptor).withResourceFormat(resourceFormat)
        .withRetryCount(retryCount).withMessage(message)
        .withHeaders(headers == null ? new Headers.Builder().build() : headers)
        .withTimeout(timeout, TimeUnit.MILLISECONDS).executeAsBatch();
  }

  public <T extends Resource> ResourceRequest<T> executeFhirRequest(Request.Builder request, String resourceFormat,
      Headers headers, String message, int retryCount, long timeout) throws IOException {
    return new FhirRequestBuilder(request, base).withLogger(fhirLoggingInterceptor).withResourceFormat(resourceFormat)
        .withRetryCount(retryCount).withMessage(message)
        .withHeaders(headers == null ? new Headers.Builder().build() : headers)
        .withTimeout(timeout, TimeUnit.MILLISECONDS).execute();
  }
}
