package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Getter;
import lombok.Setter;

public class SimpleHTTPClient {

  private static final int MAX_REDIRECTS = 5;
  private static int counter = 1;

  private List<HTTPHeader> headers = new ArrayList<>();

  @Getter @Setter
  private HTTPAuthenticationMode authenticationMode;

  @Getter @Setter
  private String username;

  @Getter @Setter
  private String password;

  @Getter @Setter
  private String token;
  
  @Getter @Setter
  private String apiKey;
  
  public void addHeader(String name, String value) {
    headers.add(new HTTPHeader(name, value));
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);    
  }
  
  public HTTPResult get(String url, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    
    URL u = new URL(url);
//    boolean isSSL = url.startsWith("https://");
    
    // handling redirects - setInstanceFollowRedirects(true) doesn't handle crossing http to https

    Map<String, Integer> visited = new HashMap<>();
    HttpURLConnection c = null;
    boolean done = false;

    while (!done) {
      int times = visited.compute(url, (key, count) -> count == null ? 1 : count + 1);
      if (times > MAX_REDIRECTS)
        throw new IOException("Stuck in redirect loop");

      u = new URL(url);
      c = (HttpURLConnection) u.openConnection();
      c.setRequestMethod("GET");
      if (accept != null) {
        c.setRequestProperty("Accept", accept);
      }
      setHeaders(c);
      c.setInstanceFollowRedirects(false);

      switch (c.getResponseCode()) {
        case HttpURLConnection.HTTP_MOVED_PERM:
        case HttpURLConnection.HTTP_MOVED_TEMP:
        case 307:
        case 308: // Same as HTTP_MOVED_PERM, but does not allow changing the request method from POST to GET
          String location = c.getHeaderField("Location");
          location = URLDecoder.decode(location, "UTF-8");
          URL base = new URL(url);
          URL next = new URL(base, location);  // Deal with relative URLs
          url = next.toExternalForm();
          continue;
        default:
          done = true;
      }
    }
    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(),  c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }

  private void setHeaders(HttpURLConnection c) {
    if (headers != null) {
      for (HTTPHeader header : headers) {
        c.setRequestProperty(header.getName(), header.getValue());
      }
    }
    c.setConnectTimeout(15000);
    c.setReadTimeout(15000);
    setAuthenticationHeader(c);
  }

  private void setAuthenticationHeader(HttpURLConnection c) {
    String authHeaderValue = null;
    if (authenticationMode == HTTPAuthenticationMode.TOKEN) {
      authHeaderValue = "Bearer " + token;
    } else if (authenticationMode == HTTPAuthenticationMode.BASIC) {
      String auth = username+":"+password;
      byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      authHeaderValue = "Basic " + new String(encodedAuth);
    } else if (authenticationMode == HTTPAuthenticationMode.APIKEY) {
      c.setRequestProperty("Api-Key", apiKey);
    }

    if (authHeaderValue != null) {
      c.setRequestProperty("Authorization", authHeaderValue);
    }
  }

  public HTTPResult post(String url, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL u = new URL(url);
    HttpURLConnection c = (HttpURLConnection) u.openConnection();
    c.setDoOutput(true);
    c.setDoInput(true);
    c.setRequestMethod("POST");
    c.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      c.setRequestProperty("Accept", accept);
    }
    setHeaders(c);
    c.getOutputStream().write(content);
    c.getOutputStream().close();    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(), c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }

 
  public HTTPResult put(String url, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL u = new URL(url);
    HttpURLConnection c = (HttpURLConnection) u.openConnection();
    c.setDoOutput(true);
    c.setDoInput(true);
    c.setRequestMethod("PUT");
    c.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      c.setRequestProperty("Accept", accept);
    }
    setHeaders(c);
    c.getOutputStream().write(content);
    c.getOutputStream().close();    
    return new HTTPResult(url, c.getResponseCode(), c.getResponseMessage(), c.getRequestProperty("Content-Type"), TextFile.streamToBytes(c.getResponseCode() >= 400 ? c.getErrorStream() : c.getInputStream()));
  }

  public static int nextCounter() {
    return ++counter;
  }


}