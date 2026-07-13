package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

  @Getter
  private final IHTTPAuthenticationProvider authProvider;

  private final OkHttpClient client;

  public SimpleHTTPClient() {
    this(null);
  }

  public SimpleHTTPClient(IHTTPAuthenticationProvider authProvider) {
    this.authProvider = authProvider;
    this.client = new OkHttpClient.Builder()
      .followRedirects(false)
      .followSslRedirects(false)
      .connectTimeout(Duration.ofSeconds(15))
      .readTimeout(Duration.ofSeconds(15))
      .build();
  }

  public void addHeader(String name, String value) {
    headers.add(new HTTPHeader(name, value));
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null);
  }

  public HTTPResult get(String urlString, String acceptHeader) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    return execute("GET", URI.create(urlString), null, null, acceptHeader);
  }

  public HTTPResult post(String urlString, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    return execute("POST", URI.create(urlString), contentType, content, accept);
  }

  public HTTPResult put(String urlString, String contentType, byte[] content, String accept) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    return execute("PUT", URI.create(urlString), contentType, content, accept);
  }

  private @NonNull HTTPResult execute(String requestMethod, URI originalUri, String contentType, byte[] content, String acceptHeader) throws IOException {
    URI uri = originalUri;
    int redirects = 0;

    while (true) {
      if (++redirects > MAX_REDIRECTS) {
        throw new IOException("Stuck in redirect loop");
      }

      URL url = uri.toURL();
      boolean authCanHandle = authProvider != null && authProvider.canProvideHeaders(url);

      Request request = buildRequest(requestMethod, uri, contentType, content, acceptHeader, authCanHandle ? url : null);

      try (Response response = client.newCall(request).execute()) {
        switch (response.code()) {
          case 301, 302, 307, 308 -> {
            String location = response.header("Location");
            if (location == null) {
              throw new IOException("Location header missing in " + response.code() + " redirect");
            }
            location = URLDecoder.decode(location, StandardCharsets.UTF_8);
            uri = originalUri.resolve(location); // Deal with relative URLs
          }
          default -> {
            byte[] body = response.body() == null ? null : response.body().bytes();
            return new HTTPResult(uri.toString(), response.code(), response.message(), response.header("Content-Type"), body);
          }
        }
      }
    }
  }

  private Request buildRequest(String requestMethod, URI uri, String contentType, byte[] content, String acceptHeader, URL authUrl) throws IOException {
    Request.Builder builder = new Request.Builder().url(HttpUrl.get(uri));
    if (acceptHeader != null) {
      builder.header(ACCEPT_HEADER_KEY, acceptHeader);
    }
    if (authUrl != null) {
      Map<String, String> providedHeaders = authProvider.getHeaders(authUrl);
      if (providedHeaders != null) {
        for (Map.Entry<String, String> entry : providedHeaders.entrySet()) {
          builder.header(entry.getKey(), entry.getValue());
        }
      }
    }
    switch (requestMethod) {
      case "POST", "PUT" -> builder.method(requestMethod, RequestBody.create(content, contentType == null ? null : MediaType.parse(contentType)));
      default -> { /*DO NOTHING - defaults to GET*/ }
    }
    return builder.build();
  }

  public static int nextCounter() {
    return ++counter;
  }

}
