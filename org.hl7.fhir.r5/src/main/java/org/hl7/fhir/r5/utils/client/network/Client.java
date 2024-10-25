package org.hl7.fhir.r5.utils.client.network;

import lombok.Getter;
import lombok.Setter;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.HTTPRequest;
import org.hl7.fhir.utilities.http.HTTPHeader;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {

  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final long DEFAULT_TIMEOUT = 5000;
  @Getter @Setter
  private ToolingClientLogger logger;

  @Setter @Getter
  private int retryCount;
  @Setter @Getter
  private long timeout = DEFAULT_TIMEOUT;

  @Setter @Getter
  private String base;

  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri,
                                                                     String resourceFormat,
                                                                     String message,
                                                                     long timeout) throws IOException {
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder()
      .method("OPTIONS", null)
      .url(optionsUri.toURL());
      */
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
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());

     */
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.GET);

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
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
    if (payload == null) throw new EFhirClientException(0, "PUT requests require a non-null payload");
   /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .put(body);
*/
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.PUT)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));

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
    if (payload == null) throw new EFhirClientException(0, "POST requests require a non-null payload");
    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(getContentTypeWithDefaultCharset(resourceFormat)), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);
*/
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));

    return executeFhirRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  public boolean issueDeleteRequest(URI resourceUri) throws IOException {
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .delete();
     */
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.DELETE);
    return executeFhirRequest(request, null, Collections.emptyList(), null, retryCount, timeout).isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) throws IOException {
    /*FIXME delete once refactor is done
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL());
    */
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
    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(getContentTypeWithDefaultCharset(resourceFormat)), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);
*/
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));
    return executeBundleRequest(request, resourceFormat, Collections.emptyList(), null, retryCount, timeout);
  }

  public Bundle postBatchRequest(URI resourceUri,
                                 byte[] payload,
                                 String resourceFormat,
                                 Iterable<HTTPHeader> headers,
                                 String message,
                                 int timeout) throws IOException {
    if (payload == null) throw new EFhirClientException(0, "POST requests require a non-null payload");
    /*FIXME delete once refactor is done
    RequestBody body = RequestBody.create(MediaType.parse(resourceFormat + ";charset=" + DEFAULT_CHARSET), payload);
    Request.Builder request = new Request.Builder()
      .url(resourceUri.toURL())
      .post(body);
    */
    HTTPRequest request = new HTTPRequest()
      .withUrl(resourceUri.toURL())
      .withMethod(HTTPRequest.HttpMethod.POST)
      .withBody(payload)
      .withContentType(getContentTypeWithDefaultCharset(resourceFormat));
    return executeBundleRequest(request, resourceFormat, headers, message, retryCount, timeout);
  }

  private static String getContentTypeWithDefaultCharset(String resourceFormat) {
    return resourceFormat + ";charset=" + DEFAULT_CHARSET;
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
