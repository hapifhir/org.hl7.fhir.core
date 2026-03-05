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
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Getter;
import lombok.Setter;

public class SimpleHTTPClient {

  private static final int MAX_REDIRECTS = 5;
  private static int counter = 1;

  private final List<HTTPHeader> headers = new ArrayList<>();

  @Getter @Setter
  private AuthProvider authprovider;

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
  
  public HTTPResult get(String urlString, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }

    Map<String, Integer> visited = new HashMap<>();
    HttpURLConnection connection = null;
    boolean done = false;
    boolean useHeadersFromThis = true;
    while (!done) {
      int times = visited.compute(urlString, (key, count) -> count == null ? 1 : count + 1);
      if (times > MAX_REDIRECTS)
        throw new IOException("Stuck in redirect loop");

      connection = getGetConnection(urlString, accept, useHeadersFromThis);

      //(connection.getResponseCode() implicitly establishes the connection)
      switch (connection.getResponseCode()) {
        case HttpURLConnection.HTTP_MOVED_PERM,
             HttpURLConnection.HTTP_MOVED_TEMP,
             307,
             308: // Same as HTTP_MOVED_PERM, but does not allow changing the request method from POST to GET
          String location = connection.getHeaderField("Location");
          location = URLDecoder.decode(location, "UTF-8");

          URL base = new URL(urlString);
          URL next = new URL(base, location);  // Deal with relative URLs

          if (isNotSameHost(base, next)) {
            useHeadersFromThis = false;
          }

          urlString = next.toExternalForm();
          continue;
        default:
          done = true;
      }
    }
    
    return new HTTPResult(urlString, connection.getResponseCode(), connection.getResponseMessage(),  connection.getRequestProperty("Content-Type"), FileUtilities.streamToBytes(connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream()));
  }

  private boolean isNotSameHost(URL base, URL next) {
    return !base.getHost().equals(next.getHost());
  }

  private HttpURLConnection getGetConnection(String urlString, String accept, boolean useHeadersFromThis) throws IOException {
    URL url = new URL(urlString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    if (accept != null) {
      connection.setRequestProperty("Accept", accept);
    }
    setHeaders(connection, useHeadersFromThis);
    connection.setInstanceFollowRedirects(false);
    return connection;
  }

  private void setHeaders(HttpURLConnection connection) {
    setHeaders(connection, true);
  }

  private void setHeaders(HttpURLConnection connection, boolean useHeadersFromThis) {

    connection.setConnectTimeout(15000);
    connection.setReadTimeout(15000);
    if (useHeadersFromThis) {
      setAuthenticationHeadersFromThis(connection);

      for (HTTPHeader header : headers) {
        connection.setRequestProperty(header.getName(), header.getValue());
      }
    } else if (authprovider != null) {
      setAuthenticationHeadersFromProvider(connection);

      URL url = connection.getURL();
      Map<String, String> providedHeaders = authprovider.getHeaders(url);
      for (Map.Entry<String, String> entry : providedHeaders.entrySet()) {
        connection.setRequestProperty(entry.getKey(), entry.getValue());
      }
    }
  }

  private void setAuthenticationHeadersFromProvider(HttpURLConnection connection) {
    if (authprovider == null) {
      return;
    }
    URL url = connection.getURL();
    HTTPAuthenticationMode authenticationMode = authprovider.getHTTPAuthenticationMode(url);
    if (authenticationMode == null) {
      return;
    }
    switch (authenticationMode) {
      case TOKEN -> {
        String providedToken = authprovider.getToken(url);
        connection.setRequestProperty("Authorization", "Bearer " + providedToken);
      }
      case BASIC -> {
        String providedUsername = authprovider.getUsername(url);
        String providedPassword = authprovider.getPassword(url);
        String auth = providedUsername + ":" + providedPassword;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        connection.setRequestProperty("Authorization", "Basic " + new String(encodedAuth));
      }
      case APIKEY -> {
        String providedAPIKey = authprovider.getAPIKey(url);
        connection.setRequestProperty("Api-Key", providedAPIKey);
      }
      default -> { /* do nothing */ }
    }
  }

  private void setAuthenticationHeadersFromThis(HttpURLConnection connection) {
    if (authenticationMode == null) {
      return;
    }
    switch (authenticationMode) {
      case TOKEN -> connection.setRequestProperty("Authorization", "Bearer " + token);
      case BASIC -> {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        connection.setRequestProperty("Authorization", "Basic " + new String(encodedAuth));
      }
      case APIKEY -> connection.setRequestProperty("Api-Key", apiKey);
      default -> { /* do nothing */}
    }
  }

  public HTTPResult post(String urlString, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL url = new URL(urlString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", contentType);
    if (accept != null) {
      connection.setRequestProperty("Accept", accept);
    }
    setHeaders(connection);
    connection.getOutputStream().write(content);
    connection.getOutputStream().close();
    return new HTTPResult(urlString, connection.getResponseCode(), connection.getResponseMessage(), connection.getRequestProperty("Content-Type"), FileUtilities.streamToBytes(connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream()));
  }

 
  public HTTPResult put(String urlString, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URL url = new URL(urlString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestMethod("PUT");
    connection.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      connection.setRequestProperty("Accept", accept);
    }
    setHeaders(connection);
    connection.getOutputStream().write(content);
    connection.getOutputStream().close();
    return new HTTPResult(urlString, connection.getResponseCode(), connection.getResponseMessage(), connection.getRequestProperty("Content-Type"), FileUtilities.streamToBytes(connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream()));
  }

  public static int nextCounter() {
    return ++counter;
  }


}