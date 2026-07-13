package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
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
    final URL exampleInvalidUrl = URI.create(EXAMPLE_INVALID_REDIRECTED).toURL();

    IHTTPAuthenticationProvider authenticationProvider = Mockito.mock(IHTTPAuthenticationProvider.class);
    //Until the last hop, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }
    final SimpleHTTPClient httpClient = new SimpleHTTPClient(authenticationProvider);

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
    doReturn(Map.of("Authorization", "Bearer thatToken")).when(authenticationProvider).getHeaders(exampleInvalidUrl);

    //Until the last hop, use the built authentication
    for (int i = 0; i < urlArgs.length - 1; i++) {
      doReturn(true).when(authenticationProvider).canProvideHeaders(urls[i].url());
      doReturn(Map.of("Authorization", "Bearer thisToken")).when(authenticationProvider).getHeaders(urls[i].url());
    }

    final SimpleHTTPClient httpClient = new SimpleHTTPClient(authenticationProvider);

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

  private void assertServerSentRedirects(int length) throws InterruptedException {
    assertThat(server.getRequestCount()).isEqualTo(length);

    for (int i = 0; i < length; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

}
