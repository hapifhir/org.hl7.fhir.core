package org.hl7.fhir.r4b.utils.client.network;

import lombok.Getter;
import lombok.Setter;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.FhirRequest;
import org.hl7.fhir.utilities.http.HTTPHeader;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {

  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final long DEFAULT_TIMEOUT = 5000;
  @Getter
  private ToolingClientLogger logger;
  private FhirLoggingInterceptor fhirLoggingInterceptor;
  @Setter
  @Getter
  private int retryCount;
  @Setter
  @Getter
  private long timeout = DEFAULT_TIMEOUT;
  //private byte[] payload;
  @Setter @Getter
  private String base;

  public void setLogger(ToolingClientLogger logger) {
    this.logger = logger;
    this.fhirLoggingInterceptor = new FhirLoggingInterceptor(logger);
  }

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri, String resourceFormat,
      String message, long timeout) throws IOException {
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder().method("OPTIONS", null).url(optionsUri.toURL());
*/
    FhirRequest request = new FhirRequest()
      .withUrl(optionsUri.toURL())
      .withMethod(FhirRequest.HttpMethod.OPTIONS);
    return executeFhirRequest(request, resourceFormat, Collections.emptyList(), message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri, String resourceFormat,
      Iterable<HTTPHeader> headers, String message, long timeout) throws IOException {
/*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder().url(resourceUri.toURL());
*/
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.GET);
    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      String message, long timeout) throws IOException {
    return issuePutRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat,
      Iterable<HTTPHeader> headers, String message, long timeout) throws IOException {
    if (payload == null)
      throw new EFhirClientException("PUT requests require a non-null payload");
/*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).put(body);
*/
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.PUT)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, String message, long timeout) throws IOException {
    return issuePostRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload,
      String resourceFormat, Iterable<HTTPHeader> headers, String message, long timeout) throws IOException {
    if (payload == null)
      throw new EFhirClientException("POST requests require a non-null payload");

    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);
*/
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri) throws IOException {
   /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).delete();
    */
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.DELETE);
    return executeFhirRequest(request, null, Collections.emptyList(), null, retryCount, timeout)
        .isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) throws IOException {
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder().url(resourceUri.toURL());
    */
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.GET);
    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), null, retryCount, timeout);
  }

  public Bundle issuePostFeedRequest(URI resourceUri, Map<String, String> parameters, String resourceName,
      Resource resource, String resourceFormat) throws IOException {
    String boundary = "----WebKitFormBoundarykbMUo6H8QaUnYtRy";
    byte[] payload = ByteUtils.encodeFormSubmission(parameters, resourceName, resource, boundary);
    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);
*/
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));
    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), null, retryCount, timeout);
  }

  public Bundle postBatchRequest(URI resourceUri, byte[] payload, String resourceFormat, Iterable<HTTPHeader> headers,
      String message, int timeout) throws IOException {
    if (payload == null)
      throw new EFhirClientException("POST requests require a non-null payload");
    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder().url(resourceUri.toURL()).post(body);
*/
    FhirRequest request = new FhirRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(FhirRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));
    return executeBundleRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  private static String getContentTypeWithDefaultCharset(String resourceFormat) {
    return resourceFormat + ";charset=" + DEFAULT_CHARSET;
  }

  public <T extends Resource> Bundle executeBundleRequest(FhirRequest request, String resourceFormat,
                                                          Iterable<HTTPHeader> headers, String message, int retryCount, long timeout) throws IOException {
    return new FhirRequestBuilder(request, base).withLogger(fhirLoggingInterceptor).withResourceFormat(resourceFormat)
        .withRetryCount(retryCount).withMessage(message)
        .withHeaders(headers == null ? Collections.emptyList() : headers)
        .withTimeout(timeout, TimeUnit.MILLISECONDS).executeAsBatch();
  }

  public <T extends Resource> ResourceRequest<T> executeFhirRequest(FhirRequest request, String resourceFormat,
      Iterable<HTTPHeader> headers, String message, int retryCount, long timeout) throws IOException {
    return new FhirRequestBuilder(request, base).withLogger(fhirLoggingInterceptor).withResourceFormat(resourceFormat)
        .withRetryCount(retryCount).withMessage(message)
        .withHeaders(headers == null ? Collections.emptyList() : headers)
        .withTimeout(timeout, TimeUnit.MILLISECONDS).execute();
  }
}
