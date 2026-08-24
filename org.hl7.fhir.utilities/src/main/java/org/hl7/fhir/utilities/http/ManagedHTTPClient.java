package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.http.okhttpimpl.LoggingInterceptor;
import org.hl7.fhir.utilities.http.okhttpimpl.NonPublicAddressRejectingDns;
import org.hl7.fhir.utilities.http.okhttpimpl.ProxyAuthenticator;
import org.hl7.fhir.utilities.http.okhttpimpl.RetryInterceptor;
import org.hl7.fhir.utilities.settings.FhirSettings;

import lombok.Builder;
import lombok.Getter;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * An HTTP client supporting simple GET, PUT, POST, DELETE, and OPTIONS operations with no
 * FHIR-specific code.
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
 *   Note: headers provided by {@code withHeader()} are always applied alongside these authentication headers.
 *   </li>
 *   <li>If {@code authenticationMode} is null or a HTTP 30x redirect to a different host occurs, the client will
 *   attempt to utilize the supplied {@code authProvider} implementation to resolve authentication and set headers for
 *   the new URL.
 *   See {@link IHTTPAuthenticationProvider}.</li>
 * </ol>
 * <p>
 * SSRF protection (when enabled) is enforced via {@link NonPublicAddressRejectingDns}: the address that is validated is the
 * exact address OkHttp connects to, so there is no separate resolution step for an attacker to exploit via DNS
 * rebinding.
 */
public class ManagedHTTPClient {

  private static final int MAX_REDIRECTS = 5;
  public static final String ACCEPT_HEADER_KEY = "Accept";
  private static int counter = 1;

  private static final long DEFAULT_TIMEOUT = 15000;
  private static final TimeUnit DEFAULT_TIMEOUT_UNIT = TimeUnit.MILLISECONDS;
  @Getter
  private final long timeout;

  @Getter
  private final TimeUnit timeoutUnit;

  private static final int DEFAULT_RETRIES = 1;

  @Getter
  private final int retries;

  @Getter
  private final List<HTTPHeader> headers;

  @Getter
  private final IHTTPAuthenticationProvider authProvider;

  @Getter
  private final boolean ssrfProtectionEnabled;

  @Getter
  private final ToolingClientLogger logger;

  private final OkHttpClient baseClient;
  private final OkHttpClient nonPublicAddressRejectingClient;

  /**
   * The single {@link OkHttpClient} every client built by this class is derived from, via
   * {@link OkHttpClient#newBuilder()}.
   * <p>
   * This exists so that connections are pooled and reused. A {@link ManagedHTTPClient} is
   * constructed per request by both {@link ManagedFhirWebAccessor#httpCall(HTTPRequest)} and
   * {@link ManagedWebAccessor}, so building each one's {@link OkHttpClient} with
   * {@code new OkHttpClient.Builder()} gave every request its own {@link okhttp3.ConnectionPool}.
   * A pool that is never consulted again cannot hand its connection to the next request, so each
   * request paid a fresh TCP and TLS handshake, and each just-used socket sat idle in an
   * unreachable pool until its 5 minute keep-alive expired - accumulating as CLOSE-WAIT once the
   * server timed it out first. Deriving from a shared client means the pool, dispatcher and
   * SSL socket factory are shared, which is what OkHttp requires for connection reuse: those are
   * part of the {@code Address} that pooled connections are keyed by.
   * <p>
   * Only connection infrastructure is shared. Timeouts and interceptors are still applied
   * per instance in {@link #buildBaseClient()} - neither participates in {@code Address}
   * equality, so they do not prevent reuse. Interceptors in particular must NOT be hoisted
   * here: {@link RetryInterceptor} holds a per-request retry counter that it never resets.
   */
  private static final OkHttpClient SHARED_CLIENT = new OkHttpClient.Builder()
    .proxyAuthenticator(new ProxyAuthenticator())
    .dns(Dns.SYSTEM)
    .followRedirects(false)
    .followSslRedirects(false)
    .build();

  /**
   * Shared because {@code Address} equality - and therefore connection reuse - compares the
   * {@link Dns} by identity for implementations that do not override {@code equals}. A new
   * instance per client would put every request on its own pool key even with a shared pool.
   * {@link NonPublicAddressRejectingDns} is stateless, so sharing one is safe.
   */
  private static final Dns SHARED_NON_PUBLIC_ADDRESS_REJECTING_DNS = new NonPublicAddressRejectingDns();

  @Builder
  private ManagedHTTPClient(Long timeout,
                            TimeUnit timeoutUnit,
                            Integer retries,
                            Collection<HTTPHeader> headers,
                            IHTTPAuthenticationProvider authProvider,
                            Boolean ssrfProtectionEnabled,
                            ToolingClientLogger logger) {
    this.timeout = timeout != null ? timeout : DEFAULT_TIMEOUT;
    this.timeoutUnit = timeoutUnit != null ? timeoutUnit : DEFAULT_TIMEOUT_UNIT;
    this.retries = retries != null ? retries : DEFAULT_RETRIES;
    this.headers = headers != null ? List.copyOf(new ArrayList<>(headers)) : Collections.emptyList();
    this.authProvider = authProvider;
    // Boxed so an unset builder value (null) defaults to true, rather than the primitive default of false.
    this.ssrfProtectionEnabled = ssrfProtectionEnabled == null || ssrfProtectionEnabled;
    this.logger = logger;
    this.baseClient = buildBaseClient();
    this.nonPublicAddressRejectingClient = buildNonPublicAddressRejectingClient(this.baseClient);
  }

  /**
   * @return An OkHTTPClient configured from our settings, but with no additional protocol or network blocking.
   */
  private OkHttpClient buildBaseClient() {
    OkHttpClient.Builder builder = SHARED_CLIENT.newBuilder()
      .addInterceptor(new RetryInterceptor(retries))
      .connectTimeout(timeout, timeoutUnit)
      .writeTimeout(timeout, timeoutUnit)
      .readTimeout(timeout, timeoutUnit);
    if (logger != null) {
      builder.addInterceptor(new LoggingInterceptor(logger));
    }
    return builder.build();
  }

  /**
   *
   * @param baseClient the base client to work from
   * @return A client derived from baseClient, sharing the same connection pool/dispatcher, but blocking non-https
   * and non-public servers.
   */
  private OkHttpClient buildNonPublicAddressRejectingClient(OkHttpClient baseClient) {
    OkHttpClient.Builder builder = baseClient.newBuilder()
      .dns(SHARED_NON_PUBLIC_ADDRESS_REJECTING_DNS);
    return builder.build();
  }

  public HTTPResult get(String url) throws IOException {
    return get(url, null, Collections.emptyList());
  }

  public HTTPResult get(String urlString, String acceptHeader) throws IOException {
    return get(urlString, acceptHeader, Collections.emptyList());
  }

  public HTTPResult get(String urlString, String acceptHeader, Iterable<HTTPHeader> headers) throws IOException {
    return execute("GET", URI.create(urlString), null, null, acceptHeader, headers);
  }

  public HTTPResult post(String urlString, String contentType, byte[] content, String accept) throws IOException {
    return post(urlString, contentType, content, accept, Collections.emptyList());
  }

  public HTTPResult post(String urlString, String contentType, byte[] content, String accept, Iterable<HTTPHeader> headers) throws IOException {
    return execute("POST", URI.create(urlString), contentType, content, accept, headers);
  }

  public HTTPResult put(String urlString, String contentType, byte[] content, String accept) throws IOException {
    return put(urlString, contentType, content, accept, Collections.emptyList());
  }

  public HTTPResult put(String urlString, String contentType, byte[] content, String accept, Iterable<HTTPHeader> headers) throws IOException {
    return execute("PUT", URI.create(urlString), contentType, content, accept, headers);
  }

  public HTTPResult delete(String url) throws IOException {
    return delete(url, null, Collections.emptyList());
  }

  public HTTPResult delete(String urlString, String acceptHeader) throws IOException {
    return delete(urlString, acceptHeader, Collections.emptyList());
  }

  public HTTPResult delete(String urlString, String acceptHeader, Iterable<HTTPHeader> headers) throws IOException {
    return execute("DELETE", URI.create(urlString), null, null, acceptHeader, headers);
  }

  public HTTPResult options(String url) throws IOException {
    return options(url, null, Collections.emptyList());
  }

  public HTTPResult options(String urlString, String acceptHeader) throws IOException {
    return options(urlString, acceptHeader, Collections.emptyList());
  }

  public HTTPResult options(String urlString, String acceptHeader, Iterable<HTTPHeader> headers) throws IOException {
    return execute("OPTIONS", URI.create(urlString), null, null, acceptHeader, headers);
  }

  private @NonNull HTTPResult execute(String requestMethod, URI originalUri, String contentType, byte[] content, String acceptHeader, Iterable<HTTPHeader> extraHeaders) throws IOException {
    if (FhirSettings.isProhibitNetworkAccess()) {
      throw new FHIRException("Network Access is prohibited in this context");
    }
    URI uri = originalUri;
    int redirects = 0;

    while (true) {
      if (++redirects > MAX_REDIRECTS) {
        throw new IOException("Stuck in redirect loop");
      }

      URL url = uri.toURL();
      HttpUrl httpUrl = HttpUrl.get(uri);
      boolean authCanHandle = authProvider != null && authProvider.canProvideHeaders(url);
      boolean privateNetworkAllowed = authProvider != null && authProvider.isPrivateNetworkAllowed(url);
      boolean skipNonPublicAddressCheck = !isSsrfProtectionEnabled() || privateNetworkAllowed;

      // Scheme is validated against the auth provider's own allow-list (which reflects a
      // configured server's allowHttp setting) rather than the blanket https-only check below -
      // allowHttp and privateNetworkAllowed are independent settings, so a configured server
      // permitted to use plain http must not be rejected here just because it isn't also
      // trusted to reach private network space.
      if (authCanHandle) {
        if (!authProvider.isProtocolAllowed(url)) {
          throw new IOException("URL does not use permitted protocol: " + url);
        }
      } else if (isSsrfProtectionEnabled()) {
        ManagedWebAccessUtils.throwExceptionIfNotAllowedScheme(uri);
      }

      if (!skipNonPublicAddressCheck) {
        // NonPublicAddressRejectingDns never runs for literal IP hosts (OkHttp bypasses Dns for
        // those), so they must be validated here instead. Validate httpUrl.host() - the exact,
        // bracket-free host OkHttp will connect to - not uri.getHost(), which returns IPv6
        // literals bracketed ("[::1]") and so is never recognized as a literal IP by Guava,
        // silently skipping this check for every IPv6 literal host.
        ManagedWebAccessUtils.throwExceptionIfLiteralIpAndNonPublicAddress(httpUrl.host());
      }

      Request request = buildRequest(requestMethod, httpUrl, contentType, content, acceptHeader, extraHeaders, authCanHandle ? url : null);
      OkHttpClient client = skipNonPublicAddressCheck ? baseClient : nonPublicAddressRejectingClient;

      try (Response response = client.newCall(request).execute()) {
        switch (response.code()) {
          case 301, 302, 307, 308 -> {
            String location = response.header("Location");
            if (location == null) {
              throw new IOException("Location header missing in " + response.code() + " redirect");
            }
            location = URLDecoder.decode(location, StandardCharsets.UTF_8);
            uri = uri.resolve(location); // Deal with relative URLs, resolved against the current hop
          }
          default -> {
            byte[] body = response.body().bytes();
            return new HTTPResult(uri.toString(), response.code(), response.message(), response.header("Content-Type"), body, toHTTPHeaders(response.headers()));
          }
        }
      }
    }
  }

  private Request buildRequest(String requestMethod, HttpUrl httpUrl, String contentType, byte[] content, String acceptHeader, Iterable<HTTPHeader> extraHeaders, URL authUrl) throws IOException {
    Request.Builder builder = new Request.Builder().url(httpUrl);
    for (HTTPHeader header : headers) {
      builder.header(header.getName(), header.getValue());
    }
    for (HTTPHeader header : extraHeaders) {
      builder.header(header.getName(), header.getValue());
    }
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
      case "DELETE", "OPTIONS" -> builder.method(requestMethod, null);
      default -> { /*DO NOTHING - defaults to GET*/ }
    }
    return builder.build();
  }

  private static Iterable<HTTPHeader> toHTTPHeaders(Headers headers) {
    List<HTTPHeader> result = new ArrayList<>();
    for (String name : headers.names()) {
      result.add(new HTTPHeader(name, headers.get(name)));
    }
    return result;
  }

  public static int nextCounter() {
    return ++counter;
  }

}
