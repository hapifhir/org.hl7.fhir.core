package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.checkerframework.checker.nullness.qual.NonNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ManagedHTTPClientTest {

  public static final String EXAMPLE_INVALID_REDIRECTED = "http://example.invalid/redirected";
  private MockWebServer server;

  @BeforeEach
  void setup() {
    server = new MockWebServer();
  }

  @Test
  void testGetApplicationJson() throws IOException, InterruptedException {

    HttpUrl serverUrl = server.url("fhir/us/core/package-list.json?nocache=1724353440974");

    server.enqueue(
      new MockResponse()
        .setBody("Monkeys").setResponseCode(200)
    );

    ManagedHTTPClient http = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

    HTTPResult res = http.get(serverUrl.url().toString(), "application/json");

    assertThat(res.getCode()).isEqualTo(200);

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertThat(packageRequest.getRequestUrl().toString()).hasToString(serverUrl.url().toString());
    assertThat(packageRequest.getMethod()).isEqualTo("GET");
    assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");

  }

  public static Stream<Arguments> getRedirectArgs() {
    return Stream.of(
      Arguments.of(301, new String[]{"url1", "url2"}),
      Arguments.of(301, new String[]{"url1", "url2", "url3"}),
      Arguments.of(301, new String[]{"url1", "url2", "url3", "url4"}),
      Arguments.of(302, new String[]{"url1", "url2"}),
      Arguments.of(302, new String[]{"url1", "url2", "url3"}),
      Arguments.of(302, new String[]{"url1", "url2", "url3", "url4"}),
      Arguments.of(307, new String[]{"url1", "url2"}),
      Arguments.of(307, new String[]{"url1", "url2", "url3"}),
      Arguments.of(307, new String[]{"url1", "url2", "url3", "url4"}),
      Arguments.of(308, new String[]{"url1", "url2"}),
      Arguments.of(308, new String[]{"url1", "url2", "url3"}),
      Arguments.of(308, new String[]{"url1", "url2", "url3", "url4"})
    );
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectsGet(int code, String[] urlArgs) throws IOException, InterruptedException {

    HttpUrl[] urls = new HttpUrl[urlArgs.length];
    for (int i = 0; i < urlArgs.length; i++) {
      urls[i] = server.url(urlArgs[i]);
      if (i > 0) {
        server.enqueue(
          new MockResponse()
            .setResponseCode(code)
            .setBody("Pumas")
            .addHeader("Location", urls[i].url().toString()));
      }
    }
    server.enqueue(
      new MockResponse()
        .setBody("Monkeys").setResponseCode(200)
    );

    ManagedHTTPClient httpClient = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

    HTTPResult res = httpClient.get(urls[0].url().toString(), "application/json");

    assertThat(res.getCode()).isEqualTo(200);
    assertThat(res.getContentAsString()).isEqualTo("Monkeys");
    assertServerSentRedirects(urlArgs.length);
  }

  private void assertServerSentRedirects(int length) throws InterruptedException {
    assertThat(server.getRequestCount()).isEqualTo(length);

    for (int i = 0; i < length; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

  @Test
  void testRelativeRedirectResolvesAgainstCurrentHopNotOriginalUrl() throws IOException {
    MockWebServer serverB = new MockWebServer();
    try {
      serverB.start();
      HttpUrl hop2Url = serverB.url("hop2");

      // Hop 1 (on `server`): redirects to hop 2 on a different origin (serverB).
      server.enqueue(
        new MockResponse()
          .setResponseCode(302)
          .addHeader("Location", hop2Url.url().toString()));
      // A "poison" response: only consumed if the bug regresses and the relative redirect below
      // is wrongly resolved against `server`'s origin (the original request) instead of
      // serverB's (the current hop) - which would send a third request back to `server`.
      server.enqueue(new MockResponse().setResponseCode(200).setBody("WRONG-SERVER"));

      // Hop 2 (on serverB): redirects with a *relative* Location. This must resolve against
      // serverB's own origin, not `server`'s.
      serverB.enqueue(
        new MockResponse()
          .setResponseCode(302)
          .addHeader("Location", "/final"));
      serverB.enqueue(new MockResponse().setResponseCode(200).setBody("Success"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("start").url().toString(), "application/json");

      assertThat(res.getCode()).isEqualTo(200);
      assertThat(res.getContentAsString()).isEqualTo("Success");
      assertThat(server.getRequestCount()).isEqualTo(1); // only the initial request
      assertThat(serverB.getRequestCount()).isEqualTo(2); // hop2, then the relative redirect target
    } finally {
      serverB.shutdown();
    }
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectNoProvidedAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final URL exampleInvalidUrl = URI.create(EXAMPLE_INVALID_REDIRECTED).toURL();

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    //Until the last hop, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(true).when(authenticationProvider).isProtocolAllowed(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }
    final ManagedHTTPClient httpClient = ManagedHTTPClient.builder().authProvider(authenticationProvider).ssrfProtectionEnabled(false).build();

    assertThrows(UnknownHostException.class, () -> httpClient.get(urls[0].url().toString(), "application/json"));

    //Until the last hop, verify that the auth headers were sent
    for (int i = 0; i < urlArgs.length - 1; i++) {
      RecordedRequest recordedRequest = server.takeRequest();
      assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Bearer thisToken");
      assertThat(recordedRequest.getHeader("Api-Key")).isNull();
    }
    assertThat(server.getRequestCount()).isEqualTo(urlArgs.length - 1);

    //The authentication provider should have asked if it could handle the url, but shouldn't have provided any headers
    verify(authenticationProvider, times(1)).canProvideHeaders(exampleInvalidUrl);
    verify(authenticationProvider, never()).getHeaders(exampleInvalidUrl);
  }


  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final URL exampleInvalidUrl = URI.create(EXAMPLE_INVALID_REDIRECTED).toURL();

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);

    doReturn(true).when(authenticationProvider).canProvideHeaders(exampleInvalidUrl);
    doReturn(true).when(authenticationProvider).isProtocolAllowed(exampleInvalidUrl);
    doReturn(Map.of("Authorization", "Bearer thatToken")).when(authenticationProvider).getHeaders(exampleInvalidUrl);

    //Until the last hop, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(true).when(authenticationProvider).isProtocolAllowed(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }

    final ManagedHTTPClient httpClient = ManagedHTTPClient.builder().authProvider(authenticationProvider).ssrfProtectionEnabled(false).build();

    assertThrows(UnknownHostException.class, () -> httpClient.get(urls[0].url().toString(), "application/json"));

    for (int i = 0; i < urlArgs.length - 1; i++) {
      RecordedRequest recordedRequest = server.takeRequest();
      assertThat(recordedRequest.getHeader("Authorization")).isEqualTo("Bearer thisToken");
      assertThat(recordedRequest.getHeader("Api-Key")).isNull();
    }
    assertThat(server.getRequestCount()).isEqualTo(urlArgs.length - 1);

    //The authentication provider should have asked if it could handle the url and to provide the headers,
    //even though the request against that url ultimately fails to resolve
    verify(authenticationProvider, times(1)).canProvideHeaders(exampleInvalidUrl);
    verify(authenticationProvider, times(1)).getHeaders(exampleInvalidUrl);
  }

  private HttpUrl @NonNull [] enqueueSameServerRedirectsExceptLast(int code, String[] urlArgs) {
    HttpUrl[] urls = new HttpUrl[urlArgs.length];
    for (int i = 0; i < urlArgs.length; i++) {
      if (i < urlArgs.length - 1) {
        urls[i] = server.url(urlArgs[i]);
      } else {
        urls[i] = HttpUrl.parse(EXAMPLE_INVALID_REDIRECTED);
      }

      if (i > 0) {
        server.enqueue(
          new MockResponse()
            .setResponseCode(code)
            .setBody("Pumas")
            .addHeader("Location", urls[i].url().toString()));
      }
    }
    return urls;
  }

  @Nested
  class Retries {

    @Test
    void singleFailureThenSuccessIsRetriedOnce() throws IOException, InterruptedException {
      server.enqueue(new MockResponse().setResponseCode(500).setBody("Server Error"));
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("resource").url().toString(), "application/json");

      assertThat(res.getCode()).isEqualTo(200);
      assertThat(res.getContentAsString()).isEqualTo("Monkeys");
      assertThat(server.getRequestCount()).isEqualTo(2);
    }

    @Test
    void exhaustingDefaultRetriesReturnsLastFailureResponse() throws IOException, InterruptedException {
      server.enqueue(new MockResponse().setResponseCode(500).setBody("Server Error 1"));
      server.enqueue(new MockResponse().setResponseCode(500).setBody("Server Error 2"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("resource").url().toString(), "application/json");

      // Default retries is 1, i.e. 2 total attempts; once both fail, the last failure response is
      // returned rather than retried indefinitely or thrown.
      assertThat(res.getCode()).isEqualTo(500);
      assertThat(res.getContentAsString()).isEqualTo("Server Error 2");
      assertThat(server.getRequestCount()).isEqualTo(2);
    }

    @Test
    void zeroRetriesMeansExactlyOneAttempt() throws IOException, InterruptedException {
      server.enqueue(new MockResponse().setResponseCode(500).setBody("Server Error"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().retries(0).ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("resource").url().toString(), "application/json");

      assertThat(res.getCode()).isEqualTo(500);
      assertThat(server.getRequestCount()).isEqualTo(1);
    }

    @Test
    void configuredRetryCountIsHonoured() throws IOException, InterruptedException {
      int retries = 3;
      for (int i = 0; i < retries; i++) {
        server.enqueue(new MockResponse().setResponseCode(503).setBody("Unavailable"));
      }
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().retries(retries).ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("resource").url().toString(), "application/json");

      assertThat(res.getCode()).isEqualTo(200);
      assertThat(server.getRequestCount()).isEqualTo(retries + 1);
    }

    @Test
    void redirectResponseIsNotTreatedAsFailureNeedingRetry() throws IOException, InterruptedException {
      HttpUrl target = server.url("target");
      server.enqueue(
        new MockResponse()
          .setResponseCode(302)
          .addHeader("Location", target.url().toString()));
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      ManagedHTTPClient httpClient = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

      HTTPResult res = httpClient.get(server.url("start").url().toString(), "application/json");

      assertThat(res.getCode()).isEqualTo(200);
      // One request per hop - if redirects were (mis)treated as retryable failures, the initial
      // hop alone would consume both queued responses before the client ever saw the redirect.
      assertThat(server.getRequestCount()).isEqualTo(2);
    }
  }

  @Nested
  class SsrfProtection {

    @FunctionalInterface
    interface HttpCall {
      HTTPResult apply(ManagedHTTPClient client, String url) throws IOException;
    }

    static Stream<Arguments> httpMethods() {
      return Stream.of(
        Arguments.of("GET", (HttpCall) (client, url) -> client.get(url, "application/json")),
        Arguments.of("PUT", (HttpCall) (client, url) -> client.put(url, "text/plain", "body".getBytes(), "application/json")),
        Arguments.of("POST", (HttpCall) (client, url) -> client.post(url, "text/plain", "body".getBytes(), "application/json"))
      );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("httpMethods")
    void blocksLoopbackWhenProtectionEnabled(String method, HttpCall call) {
      String url = server.url("resource").url().toString();
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(true).build();

      assertThrows(IOException.class, () -> call.apply(client, url));
      assertThat(server.getRequestCount()).isZero();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("httpMethods")
    void allowsLoopbackWhenProtectionDisabled(String method, HttpCall call) throws IOException {
      String url = server.url("resource").url().toString();
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();

      HTTPResult res = call.apply(client, url);

      assertThat(res.getCode()).isEqualTo(200);
      assertThat(server.getRequestCount()).isEqualTo(1);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("httpMethods")
    void blocksLoopbackWhenAuthProviderCanProvideHeadersButPrivateNetworkNotAllowed(String method, HttpCall call) throws IOException {
      String url = server.url("resource").url().toString();
      URL expectedUrl = URI.create(url).toURL();
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys")); // consumed only if wrongly allowed

      IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
      doReturn(true).when(authenticationProvider).canProvideHeaders(expectedUrl);
      doReturn(true).when(authenticationProvider).isProtocolAllowed(expectedUrl);
      doReturn(Map.of()).when(authenticationProvider).getHeaders(expectedUrl);
      // isPrivateNetworkAllowed left at its Mockito default (false): being able to supply auth
      // headers for a server must not, by itself, exempt it from SSRF protection - only an
      // explicit isPrivateNetworkAllowed(true) should.

      ManagedHTTPClient client = ManagedHTTPClient.builder().authProvider(authenticationProvider).ssrfProtectionEnabled(true).build();

      assertThrows(IOException.class, () -> call.apply(client, url));
      assertThat(server.getRequestCount()).isZero();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("httpMethods")
    void allowsLoopbackWhenAuthProviderAllowsPrivateNetwork(String method, HttpCall call) throws IOException {
      String url = server.url("resource").url().toString();
      URL expectedUrl = URI.create(url).toURL();
      server.enqueue(new MockResponse().setResponseCode(200).setBody("Monkeys"));

      IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
      doReturn(true).when(authenticationProvider).canProvideHeaders(expectedUrl);
      doReturn(true).when(authenticationProvider).isProtocolAllowed(expectedUrl);
      doReturn(true).when(authenticationProvider).isPrivateNetworkAllowed(expectedUrl);
      doReturn(Map.of()).when(authenticationProvider).getHeaders(expectedUrl);

      ManagedHTTPClient client = ManagedHTTPClient.builder().authProvider(authenticationProvider).ssrfProtectionEnabled(true).build();

      HTTPResult res = call.apply(client, url);

      assertThat(res.getCode()).isEqualTo(200);
      assertThat(server.getRequestCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
      "http://169.254.169.254/",        // AWS/GCP/Azure IMDS
      "http://10.0.0.1/",               // RFC1918 site-local
      "http://[::1]/",                  // IPv6 loopback
      "file:///etc/passwd",             // non-http(s) scheme
      "http://metadata.google.internal/" // explicitly blocked host
    })
    void blocksVariousNonPublicUrlsWhenProtectionEnabled(String url) {
      ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(true).build();

      assertThrows(IOException.class, () -> client.get(url, "application/json"));
      assertThrows(IOException.class, () -> client.put(url, "text/plain", "body".getBytes(), "application/json"));
      assertThrows(IOException.class, () -> client.post(url, "text/plain", "body".getBytes(), "application/json"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
      "https://[::1]/",              // IPv6 loopback, bracketed as java.net.URI/HttpUrl require
      "https://[fd00::1]/",          // IPv6 unique local address (ULA)
      "https://[::ffff:10.0.0.1]/"   // IPv4-mapped IPv6 literal embedding a private IPv4 address
    })
    void blocksIpv6LiteralNonPublicUrlsWhenProtectionEnabled(String url) {
      // Regression test: java.net.URI.getHost() returns IPv6 literals bracketed ("[::1]"), which
      // Guava's InetAddresses does not recognize as a literal IP - validating that instead of
      // HttpUrl.host() (bracket-free) let every IPv6 literal host bypass the SSRF check entirely,
      // since OkHttp also never invokes the configured Dns for a literal IP host.
      ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(true).build();

      assertThrows(IOException.class, () -> client.get(url, "application/json"));
    }

    @Test
    void blocksRedirectFromPublicUrlToNonPublicAddress() throws UnknownHostException {
      String initialUrl = server.url("start").url().toString();
      // Redirect target is still the same, genuinely loopback MockWebServer instance (not mocked
      // below), so the real ssrf check legitimately blocks it, and a missing/broken re-check
      // would make this request actually succeed instead of failing with an unrelated network
      // error - keeping the test an unambiguous signal for the behavior under test. It's given a
      // different host string ("127.0.0.1" instead of MockWebServer's default "localhost") so
      // that OkHttp treats it as a distinct connection needing its own DNS lookup, rather than
      // reusing the initial hop's already-open, already-validated connection - reusing that
      // connection would be a legitimate byproduct of it never re-resolving DNS, not a gap in the
      // SSRF check.
      String redirectTarget = "https://127.0.0.1:" + server.getPort() + "/redirected";

      server.enqueue(
        new MockResponse()
          .setResponseCode(302)
          .addHeader("Location", redirectTarget));
      server.enqueue(
        new MockResponse().setResponseCode(200).setBody("Monkeys")); // consumed only if the redirect is wrongly allowed

      ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(true).build();

      // The initial URL is genuinely a loopback MockWebServer address too, so simulate it being
      // public (pretend the address check passes for it) to isolate the behavior under test: that
      // the redirect target's address is independently, and really, re-resolved and re-checked -
      // by NonPublicAddressRejectingDns, not by a one-time check that's discarded before connecting.
      //
      // Both hops resolve the same hostname ("localhost"), which this environment resolves to
      // more than one address (IPv4 and IPv6 loopback) - NonPublicAddressRejectingDns validates every
      // address the lookup returns, so the bypass below must exempt exactly the initial hop's
      // addresses (however many that is here) and nothing more, or a leftover exemption would
      // wrongly swallow the redirect target's re-check too.
      int initialHopAddressCount = InetAddress.getAllByName(Objects.requireNonNull(HttpUrl.parse(initialUrl)).host()).length;
      AtomicInteger remainingBypasses = new AtomicInteger(initialHopAddressCount);
      try (MockedStatic<ManagedWebAccessUtils> mocked = mockStatic(ManagedWebAccessUtils.class, Mockito.CALLS_REAL_METHODS)) {
        // The default policy now requires https, but MockWebServer serves plain http here and
        // ManagedHTTPClient has no seam to configure trust for a test certificate. Since the
        // initial hop's checks are already faked out below to isolate the redirect target as the
        // thing under test, fake past its scheme too - matched by exact URI so the (real, https)
        // redirect target's own scheme check is unaffected.
        mocked.when(() -> ManagedWebAccessUtils.throwExceptionIfNotAllowedScheme(URI.create(initialUrl)))
          .thenAnswer(invocation -> null);
        mocked.when(() -> ManagedWebAccessUtils.throwExceptionIfNonPublicAddress(any(InetAddress.class), anyString()))
          .thenAnswer(invocation -> {
            if (remainingBypasses.getAndUpdate(n -> n > 0 ? n - 1 : n) > 0) {
              return null; // pretend this address, from the initial hop's resolution, is public
            }
            return invocation.callRealMethod(); // every later resolution is genuinely checked
          });

        assertThatThrownBy(() -> client.get(initialUrl, "application/json"))
          .isInstanceOf(IOException.class)
          .hasMessageContaining("non-public address");
      }

      // The initial request went through; the redirect was blocked before a second connection was made.
      assertThat(server.getRequestCount()).isEqualTo(1);
    }
  }

  @Nested
  class ConnectionReuse {

    /**
     * Callers construct a {@link ManagedHTTPClient} per request (see
     * {@link ManagedFhirWebAccessor#httpCall(HTTPRequest)} and {@link ManagedWebAccessor}), so
     * separately-built clients must still share a connection pool. When they did not, every
     * request paid a fresh TCP + TLS handshake and left its socket to rot in an unreachable pool
     * until the keep-alive expired, which showed up as an ever-growing pile of CLOSE-WAIT sockets
     * against a terminology server.
     * <p>
     * MockWebServer numbers requests within a connection: a sequence number of 0 means the request
     * opened a new connection. If the pool is shared, only the very first request should be 0.
     */
    @Test
    void separatelyBuiltClientsReuseTheSameConnection() throws IOException, InterruptedException {
      int requestCount = 5;
      for (int i = 0; i < requestCount; i++) {
        server.enqueue(new MockResponse().setBody("Monkeys").setResponseCode(200));
      }
      String url = server.url("some/path").url().toString();

      for (int i = 0; i < requestCount; i++) {
        // A new client each time, exactly as the per-request callers do.
        ManagedHTTPClient client = ManagedHTTPClient.builder().ssrfProtectionEnabled(false).build();
        assertThat(client.get(url, "application/json").getCode()).isEqualTo(200);
      }

      assertThat(server.getRequestCount()).isEqualTo(requestCount);
      int newConnections = 0;
      for (int i = 0; i < requestCount; i++) {
        if (server.takeRequest().getSequenceNumber() == 0) {
          newConnections++;
        }
      }
      assertThat(newConnections)
        .as("every request opened its own connection - the connection pool is not being shared")
        .isEqualTo(1);
    }
  }

}