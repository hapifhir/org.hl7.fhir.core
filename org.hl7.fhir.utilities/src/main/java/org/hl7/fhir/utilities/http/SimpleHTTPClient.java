package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Getter;
import lombok.Setter;

/**
 * An HTTP client supporting simple GET, PUT, POST operations with no FHIR-specific code.
 * <p>
 * This client manages authentication using the following logic:
 * <ol>
 *   <li>If {@code authenticationMode} is not null, it will use the class's internal fields to set the relevant HTTP
 *   authentication headers (see {@link HTTPAuthenticationMode}):
 *   <ul>
 *     <li>NONE - no authentication headers will be set</li>
 *     <li>BASIC - uses the username and password fields for basic authentication headers</li>
 *     <li>TOKEN - uses the token field for the token authentication header</li>
 *     <li>APIKEY - uses the apiKey field for the API key authentication header</li>
 *   </ul>
 *   Note: headers added via {@code addHeader()} are always applied alongside these authentication headers.
 *   </li>
 *   <li>If {@code authenticationMode} is null or a HTTP 30x redirect to a different host occurs, the client will
 *   attempt to utilize the supplied {@code authProvider} implementation to resolve authentication and set headers for
 *   the new URL.
 *   See {@link IHTTPAuthenticationProvider}.</li>
 * </ol>
 */
public class SimpleHTTPClient {

  private static final int MAX_REDIRECTS = 5;
  public static final String ACCEPT_HEADER_KEY = "Accept";
  private static int counter = 1;

  private final List<HTTPHeader> headers = new ArrayList<>();

  @Getter @Setter
  private final IHTTPAuthenticationProvider authProvider;

  public SimpleHTTPClient() {
    this(null);
  }

  public SimpleHTTPClient(IHTTPAuthenticationProvider authProvider) {
    this.authProvider = authProvider;
  }

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
    URL originalUrl = new URL(urlString);
    URL url = originalUrl;

    while (!done) {
      int times = visited.compute(urlString, (key, count) -> count == null ? 1 : count + 1);
      if (times > MAX_REDIRECTS)
        throw new IOException("Stuck in redirect loop");

      connection = getHttpGetConnection(url, accept);

      //(connection.getResponseCode() implicitly establishes the connection)
      switch (connection.getResponseCode()) {
        case HttpURLConnection.HTTP_MOVED_PERM,
             HttpURLConnection.HTTP_MOVED_TEMP,
             307,
             308: // Same as HTTP_MOVED_PERM, but does not allow changing the request method from POST to GET
          String location = connection.getHeaderField("Location");
          if (location == null) {
            throw new IOException("Location header missing in " + connection.getResponseCode() + " redirect");
          }
          location = URLDecoder.decode(location, StandardCharsets.UTF_8);

          url = new URL(originalUrl, location);  // Deal with relative URLs
          continue;
        default:
          done = true;
      }
    }
    return new HTTPResult(urlString, connection.getResponseCode(), connection.getResponseMessage(),  connection.getRequestProperty("Content-Type"), FileUtilities.streamToBytes(connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream()));
  }

  protected HttpURLConnection getHttpConnection(URL url) throws IOException {
    return (HttpURLConnection) url.openConnection();
  }

  private HttpURLConnection getHttpGetConnection(URL url, String accept) throws IOException {
    HttpURLConnection connection = getHttpConnection(url);
    connection.setRequestMethod("GET");
    if (accept != null) {
      connection.setRequestProperty(ACCEPT_HEADER_KEY, accept);
    }
    setHeaders(connection);
    connection.setInstanceFollowRedirects(false);
    return connection;
  }

  private void setHeaders(HttpURLConnection connection) {
    connection.setConnectTimeout(15000);
    connection.setReadTimeout(15000);
    URL url = connection.getURL();
    if (authProvider != null && authProvider.canProvideHeaders(url)) {
      Map<String, String> providedHeaders = authProvider.getHeaders(url);
      if (providedHeaders != null) {
        for (Map.Entry<String, String> entry : providedHeaders.entrySet()) {
          connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
      }
    }
  }


  public HTTPResult post(String urlString, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    HttpURLConnection connection = getHttpConnection(new URL(urlString));
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", contentType);
    if (accept != null) {
      connection.setRequestProperty(ACCEPT_HEADER_KEY, accept);
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

    HttpURLConnection connection = getHttpConnection(new URL(urlString));
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestMethod("PUT");
    connection.setRequestProperty("Content-type", contentType);
    if (accept != null) {
      connection.setRequestProperty(ACCEPT_HEADER_KEY, accept);
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