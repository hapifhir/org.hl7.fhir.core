package org.hl7.fhir.r5.utils.client.network;

import okhttp3.OkHttpClient;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Client {

  private static boolean debugging = false;
  public static final int TIMEOUT_SOCKET = 5000;
  public static final int TIMEOUT_CONNECT = 1000;


  //  private HttpHost proxy;
//  private Proxy proxy = null;
  private int timeout = TIMEOUT_SOCKET;
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

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

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


  public <T extends Resource> ResourceRequest<T> issueOptionsRequest(URI optionsUri, String resourceFormat, String message, int timeout) {
//
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(optionsUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .method("OPTIONS", HttpRequest.BodyPublishers.noBody());
//
//    CompletableFuture<ResourceRequest<T>> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .withResourceFormat(resourceFormat)
//      .withMessage(message)
//      .execute();

    return null;//resourceRequest.join();
  }

  public <T extends Resource> ResourceRequest<T> issueGetResourceRequest(URI resourceUri, String resourceFormat, String message, int timeout) {


//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .GET();
//
//    CompletableFuture<ResourceRequest<T>> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .withResourceFormat(resourceFormat)
//      .withMessage(message)
//      .execute();

    return null;// (ResourceRequest<T>) resourceRequest.join();
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
    return issuePutRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePutRequest(URI resourceUri, byte[] payload, String resourceFormat, List<Header> headers, String message, int timeout) {
//    if (payload == null) throw new EFhirClientException("PUT requests require a non-null payload");
//
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .PUT(HttpRequest.BodyPublishers.ofByteArray(payload));
//
//    CompletableFuture<ResourceRequest<T>> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .withResourceFormat(resourceFormat)
//      .withMessage(message)
//      .withHeaders(headers)
//      .execute();

    return null;//resourceRequest.join();
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
    return issuePostRequest(resourceUri, payload, resourceFormat, Collections.emptyList(), message, timeout);
  }

  public <T extends Resource> ResourceRequest<T> issuePostRequest(URI resourceUri, byte[] payload, String resourceFormat, List<Header> headers, String message, int timeout) {
//    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");
//
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .POST(HttpRequest.BodyPublishers.ofByteArray(payload));
//
//    CompletableFuture<ResourceRequest<T>> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .withResourceFormat(resourceFormat)
//      .withMessage(message)
//      .withHeaders(headers)
//      .execute();

    return null;//resourceRequest.join();
  }

  public boolean issueDeleteRequest(URI resourceUri) {
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .DELETE();
//
//    CompletableFuture<ResourceRequest<Resource>> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .execute();

    return false;//resourceRequest.join().isSuccessfulRequest();
  }

  public Bundle issueGetFeedRequest(URI resourceUri, String resourceFormat) {
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .GET();
//
//    CompletableFuture<Bundle> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withResourceFormat(resourceFormat)
//      .executeAsBatch();

    return null;//resourceRequest.join();
  }

  public Bundle postBatchRequest(URI resourceUri, byte[] payload, String resourceFormat, String message, int timeout) {
//    if (payload == null) throw new EFhirClientException("POST requests require a non-null payload");
//
//    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//      .uri(resourceUri)
//      .timeout(Duration.of(timeout, ChronoUnit.SECONDS))
//      .POST(HttpRequest.BodyPublishers.ofByteArray(payload));
//
//    CompletableFuture<Bundle> resourceRequest = new FhirRequestBuilder(requestBuilder)
//      .withLogger(logger)
//      .withResourceFormat(resourceFormat)
//      .withMessage(message)
//      .executeAsBatch();

    return null;//resourceRequest.join();
  }


}
