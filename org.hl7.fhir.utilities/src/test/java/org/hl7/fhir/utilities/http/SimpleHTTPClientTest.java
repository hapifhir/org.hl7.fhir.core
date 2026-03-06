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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
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
  void testRedirectNoAuthProvider(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();

    final SimpleHTTPClient httpClient = getHTTPClient(connections);


    httpClient.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
    httpClient.setToken("thisToken");
    assertThrows(UnknownHostException.class, () -> {
      httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty("Authorization","Bearer thisToken");
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Authorization"), anyString());
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());

    assertServerSentRedirects(urlArgs.length - 1);
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedNullAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();

    final SimpleHTTPClient httpClient = getHTTPClient(connections);

    AuthProvider myAuthProvider = Mockito.mock(AuthProvider.class);
    httpClient.setAuthprovider(myAuthProvider);
    httpClient.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
    httpClient.setToken("thisToken");
    assertThrows(UnknownHostException.class, () -> {
       httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty("Authorization","Bearer thisToken");
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Authorization"), anyString());
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);
    verify(myAuthProvider, times(1)).getHTTPAuthenticationMode(exampleInvalidUrl);
    verify(myAuthProvider, times(1)).getHeaders(exampleInvalidUrl);
    verify(myAuthProvider, never()).getAPIKey(any(URL.class));
    verify(myAuthProvider, never()).getUsername(any(URL.class));
    verify(myAuthProvider, never()).getPassword(any(URL.class));
    verify(myAuthProvider, never()).getToken(any(URL.class));

    assertServerSentRedirects(urlArgs.length - 1);
  }


  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedTokenAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);
    final SimpleHTTPClient httpClient = getHTTPClient(connections);

    AuthProvider myAuthProvider = Mockito.mock(AuthProvider.class);
    doReturn(HTTPAuthenticationMode.TOKEN).when(myAuthProvider).getHTTPAuthenticationMode(exampleInvalidUrl);
    doReturn("thatToken").when(myAuthProvider).getToken(exampleInvalidUrl);
    httpClient.setAuthprovider(myAuthProvider);
    httpClient.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
    httpClient.setToken("thisToken");
    assertThrows(UnknownHostException.class, () -> {
      httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty("Authorization","Bearer thisToken");
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1)).setRequestProperty("Authorization", "Bearer thatToken");
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());

    verify(myAuthProvider, times(1)).getHTTPAuthenticationMode(exampleInvalidUrl);
    verify(myAuthProvider, times(1)).getHeaders(exampleInvalidUrl);
    verify(myAuthProvider, never()).getAPIKey(any(URL.class));
    verify(myAuthProvider, never()).getUsername(any(URL.class));
    verify(myAuthProvider, never()).getPassword(any(URL.class));
    verify(myAuthProvider, times(1)).getToken(any(URL.class));

    assertServerSentRedirects(urlArgs.length - 1);
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedApiKeyAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);
    final SimpleHTTPClient httpClient = getHTTPClient(connections);

    AuthProvider myAuthProvider = Mockito.mock(AuthProvider.class);
    doReturn(HTTPAuthenticationMode.APIKEY).when(myAuthProvider).getHTTPAuthenticationMode(exampleInvalidUrl);
    doReturn("thatApiKey").when(myAuthProvider).getAPIKey(exampleInvalidUrl);
    httpClient.setAuthprovider(myAuthProvider);
    httpClient.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
    httpClient.setToken("thisToken");
    assertThrows(UnknownHostException.class, () -> {
      httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty("Authorization","Bearer thisToken");
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Authorization"), anyString());
    verify(connections.get(connections.size() - 1), times(1)).setRequestProperty("Api-Key", "thatApiKey");

    verify(myAuthProvider, times(1)).getHTTPAuthenticationMode(exampleInvalidUrl);
    verify(myAuthProvider, times(1)).getHeaders(exampleInvalidUrl);
    verify(myAuthProvider, times(1)).getAPIKey(exampleInvalidUrl);
    verify(myAuthProvider, never()).getUsername(any(URL.class));
    verify(myAuthProvider, never()).getPassword(any(URL.class));
    verify(myAuthProvider, never()).getToken(any(URL.class));

    assertServerSentRedirects(urlArgs.length - 1);
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  void testRedirectProvidedBasicAuth(int code, String[] urlArgs) throws IOException, InterruptedException {
    final HttpUrl[] urls = enqueueSameServerRedirectsExceptLast(code, urlArgs);
    final List<HttpURLConnection> connections = new ArrayList<>();
    final URL exampleInvalidUrl = new URL(EXAMPLE_INVALID_REDIRECTED);
    final SimpleHTTPClient httpClient = getHTTPClient(connections);

    AuthProvider myAuthProvider = Mockito.mock(AuthProvider.class);
    doReturn(HTTPAuthenticationMode.BASIC).when(myAuthProvider).getHTTPAuthenticationMode(exampleInvalidUrl);
    doReturn("thatUser").when(myAuthProvider).getUsername(exampleInvalidUrl);
    doReturn("thatPass").when(myAuthProvider).getPassword(exampleInvalidUrl);
    httpClient.setAuthprovider(myAuthProvider);
    httpClient.setAuthenticationMode(HTTPAuthenticationMode.TOKEN);
    httpClient.setToken("thisToken");
    assertThrows(UnknownHostException.class, () -> {
      httpClient.get(urls[0].url().toString(), "application/json");
    });

    assertThat(connections).hasSize(urlArgs.length);
    for (int i = 0; i < urlArgs.length - 1; i++) {
      verify(connections.get(i)).setRequestProperty("Authorization","Bearer thisToken");
      verify(connections.get(i), never()).setRequestProperty(eq("Api-Key"), anyString());
    }
    verify(connections.get(connections.size() - 1), times(1)).setRequestProperty("Authorization", getBasicAuth());
    verify(connections.get(connections.size() - 1), never()).setRequestProperty(eq("Api-Key"), anyString());

    verify(myAuthProvider, times(1)).getHTTPAuthenticationMode(exampleInvalidUrl);
    verify(myAuthProvider, times(1)).getHeaders(exampleInvalidUrl);
    verify(myAuthProvider, never()).getAPIKey(any(URL.class));
    verify(myAuthProvider, times(1)).getUsername(any(URL.class));
    verify(myAuthProvider, times(1)).getPassword(any(URL.class));
    verify(myAuthProvider, never()).getToken(any(URL.class));

    assertServerSentRedirects(urlArgs.length - 1);
  }

  private static @NonNull String getBasicAuth() {
    return "Basic " + new String(Base64.getEncoder().encode("thatUser:thatPass".getBytes(StandardCharsets.UTF_8)));
  }

  /**
   * Get a SimpleHTTPClient that adds any new connections to the passed list.
   * @param connections A list to update when new connections are created
   * @return A SimpleHTTPClient with default instantiation.
   */
  private static @NonNull SimpleHTTPClient getHTTPClient(List<HttpURLConnection> connections) {
    return new SimpleHTTPClient() {
      @Override
      protected HttpURLConnection getHttpConnection(String urlString) throws IOException {
        HttpURLConnection connection = Mockito.spy(super.getHttpConnection(urlString));
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

  private void assertServerSentRedirects(int length) throws InterruptedException {
    assertThat(server.getRequestCount()).isEqualTo(length);

    for (int i = 0; i < length; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

}