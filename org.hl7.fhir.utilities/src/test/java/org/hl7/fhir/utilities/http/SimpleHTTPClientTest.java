package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class SimpleHTTPClientTest {

  public static final String EXAMPLE_INVALID_REDIRECTED = "http://example.invalid/redirected";
  private MockWebServer server;

  @BeforeEach
  void setup() {
    setupMockServer();
  }

  void setupMockServer() {
    server = new MockWebServer();
  }

  @Test
  void testGetApplicationJson() throws IOException, InterruptedException {

    HttpUrl serverUrl = server.url("fhir/us/core/package-list.json?nocache=1724353440974");

    server.enqueue(
      new MockResponse()
        .setBody("Monkeys").setResponseCode(200)
    );

    SimpleHTTPClient http = new SimpleHTTPClient();

    HTTPResult res = http.get(serverUrl.url().toString(), "application/json");

    assertThat(res.getCode()).isEqualTo(200);

    RecordedRequest packageRequest = server.takeRequest();

    assert packageRequest.getRequestUrl() != null;
    assertThat(packageRequest.getRequestUrl().toString()).isEqualTo(serverUrl.url().toString());
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

    SimpleHTTPClient httpClient = new SimpleHTTPClient();

    HTTPResult res = httpClient.get(urls[0].url().toString(), "application/json");

    assertThat(res.getCode()).isEqualTo(200);
    assertThat(res.getContentAsString()).isEqualTo("Monkeys");
    assertServerSentRedirects(urlArgs.length);
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectNoProvidedAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    //Until the last connection, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }
    final SimpleHTTPClient httpClient = getHTTPClient(connections, authenticationProvider);

    assertThrows(UnknownHostException.class, () -> {
       httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    //Until the last connection, verify that the auth headers were set
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty(eq("Authorization"),eq("Bearer thisToken"));
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    //The last connection doesn't have a provider, so no headers should have been set
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Authorization"), anyString());
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());

    //The authentication provider should have asked if it could handle the url, but shouldn't have provided any headers
    verify(authenticationProvider, times(1)).canProvideHeaders(exampleInvalidUrl);
    verify(authenticationProvider, never()).getHeaders(exampleInvalidUrl);

    assertServerSentRedirects(urlArgs.length - 1);
  }


  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);

    doReturn(true).when(authenticationProvider).canProvideHeaders(exampleInvalidUrl);
    doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(exampleInvalidUrl);

    //Until the last connection, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }
    doReturn(true).when(authenticationProvider).canProvideHeaders(urls[urlArgs.length - 1].url());
    doReturn(Map.of("Authorization", "Bearer thatToken")).when(authenticationProvider).getHeaders(urls[urlArgs.length - 1].url());

    final SimpleHTTPClient httpClient = getHTTPClient(connections, authenticationProvider);

    assertThrows(UnknownHostException.class, () -> {
      httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty(eq("Authorization"),eq("Bearer thisToken"));
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1)).setRequestProperty(eq("Authorization"), eq("Bearer thatToken"));
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());

    //The authentication provider should have asked if it could handle the url and to provide the headers
    verify(authenticationProvider, times(1)).canProvideHeaders(exampleInvalidUrl);
    verify(authenticationProvider, times(1)).getHeaders(exampleInvalidUrl);

    assertServerSentRedirects(urlArgs.length - 1);
  }

  /**
   * Get a SimpleHTTPClient that adds any new connections to the passed list.
   * @param connections A list to update when new connections are created
   * @return A SimpleHTTPClient with default instantiation.
   */
  private static @NonNull SimpleHTTPClient getHTTPClient(List<HttpURLConnection> connections, IHTTPAuthenticationProvider authenticationProvider) {
    return new SimpleHTTPClient(authenticationProvider) {
      @Override
      protected HttpURLConnection getHttpConnection(URL url) throws IOException {
        HttpURLConnection connection = Mockito.spy(super.getHttpConnection(url));
        connections.add(connection);
        return connection;
      }
    };
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

  private HttpUrl @NonNull [] enqueueSameServerRedirectsLoop(int code, String[] urlArgs) {
    HttpUrl[] urls = new HttpUrl[urlArgs.length + 1];
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

  private void assertServerSentRedirects(int length) throws InterruptedException {
    assertThat(server.getRequestCount()).isEqualTo(length);

    for (int i = 0; i < length; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

}