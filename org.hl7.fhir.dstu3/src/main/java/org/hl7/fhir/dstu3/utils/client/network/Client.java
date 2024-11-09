package org.hl7.fhir.dstu3.utils.client.network;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;

import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPRequest;

public class Client {

  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final long DEFAULT_TIMEOUT = 5000;
  private ToolingClientLogger logger;
  private int retryCount;
  private long timeout = DEFAULT_TIMEOUT;
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

    HTTPRequest request = new HTTPRequest()
      .withUrl(optionsUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.OPTIONS);

    return executeFhirRequest(request, resourceFormat, Collections.emptyList(), message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri,
                                                                         String resourceFormat,
                                                                         Iterable<HTTPHeader> headers,
                                                                         String message,
                                                                         long timeout) throws IOException {
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.GET);
    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public int tester(int trytry) {
    return 5;
  }
  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 String message,
                                                                 long timeout) throws IOException {
    return issuePutRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri,
                                                                 byte[] payload,
                                                                 String resourceFormat,
                                                                 Iterable<HTTPHeader> headers,
                                                                 String message,
                                                                 long timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("PUT requests require a non-null payload");

    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.PUT)
      .withBody(payload);
    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri,
                                                                  byte[] payload,
                                                                  String resourceFormat,
                                                                  String message,
                                                                  long timeout) throws IOException {
    return issuePostRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri,
                                                                  byte[] payload,
                                                                  String resourceFormat,
                                                                  Iterable<HTTPHeader> headers,
                                                                  String message,
                                                                  long timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");

    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload);
    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri) throws IOException {
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.DELETE);
    return executeFhirRequest(request, null, Collections.emptyList(), null, retryCount, timeout).isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) throws IOException {
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.GET);
    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), null, retryCount, timeout);
  }

  public Bundle issuePostFeedRequest(URI resourceUri,
                                     Map<String, String> parameters,
                                     String resourceName,
                                     Resource resource,
                                     String resourceFormat) throws IOException {
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
    byte[] payload = ByteUtils.encodeFormSubmission(parameters, resourceName, resource, boundary);

    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload);

    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), null, retryCount, timeout);
  }

  public Bundle postBatchRequest(URI resourceUri,
                                 byte[] payload,
                                 String resourceFormat,
                                 String message,
                                 int timeout) throws IOException {
    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");

    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload);
    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), message, retryCount, timeout);
  }

  public <T extends Resource> Bundle executeBundleRequest(HTTPRequest request,
                                                             String resourceFormat,
                                                             Iterable<HTTPHeader> headers,
                                                             String message,
                                                             int retryCount,
                                                             long timeout) throws IOException {
    return new FhirRequestBuilder(request, base)
      .withLogger(logger)
      .withResourceFormat(resourceFormat)
      .withRetryCount(retryCount)
      .withMessage(message)
      .withHeaders(headers == null ? Collections.emptyList() : headers)
      .withTimeout(timeout, TimeUnit.MILLISECONDS)
      .executeAsBatch();
  }

  public <T extends Resource> ResourceRequest<T> executeFhirRequest(HTTPRequest request,
                                                                    String resourceFormat,
                                                                    Iterable<HTTPHeader> headers,
                                                                    String message,
                                                                    int retryCount,
                                                                    long timeout) throws IOException {
    return new FhirRequestBuilder(request, base)
      .withLogger(logger)
      .withResourceFormat(resourceFormat)
      .withRetryCount(retryCount)
      .withMessage(message)
      .withHeaders(headers == null ? Collections.emptyList() : headers)
      .withTimeout(timeout, TimeUnit.MILLISECONDS)
      .execute();
  }
}
