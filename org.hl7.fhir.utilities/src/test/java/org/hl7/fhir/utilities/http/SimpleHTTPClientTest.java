package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.stream.Stream;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class SimpleHTTPClientTest {

  private MockWebServer server;

  @BeforeEach
  void setup() {
    setupMockServer();
  }

  void setupMockServer() {
    server = new MockWebServer();
  }

  @Test
  public void testGetApplicationJson() throws IOException, InterruptedException {

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
  public void testRedirectsGet(int code, String[] urlArgs) throws IOException, InterruptedException {

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
    HttpUrl[] url = urls;

    SimpleHTTPClient http = new SimpleHTTPClient();

    HTTPResult res = http.get(url[0].url().toString(), "application/json");

    assertThat(res.getCode()).isEqualTo(200);
    assertThat(res.getContentAsString()).isEqualTo("Monkeys");
    assertThat(server.getRequestCount()).isEqualTo(urlArgs.length);

    for (int i = 0; i < urlArgs.length; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

  @ParameterizedTest
  @MethodSource("getRedirectArgs")
  public void testRedirectsToDifferentServers(int code, String[] urlArgs) throws IOException, InterruptedException {

    HttpUrl[] urls = new HttpUrl[urlArgs.length];
    for (int i = 0; i < urlArgs.length; i++) {
      if (i < urlArgs.length - 1) {
        urls[i] = server.url(urlArgs[i]);
      } else {
        urls[i] = HttpUrl.parse("http://example.org/redirected");
      }

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
    HttpUrl[] url = urls;

    SimpleHTTPClient http = Mockito.spy(new SimpleHTTPClient(){

    });

    assertThrows(UnknownHostException.class, () -> {
       http.get(url[0].url().toString(), "application/json");
    });

    assertThat(server.getRequestCount()).isEqualTo(urlArgs.length - 1);

    verify(http, times(1)).getGetConnection(eq("http://example.org/redirected"), anyString(), eq(false));

    for (int i = 0; i < urlArgs.length - 1; i++) {
      RecordedRequest packageRequest = server.takeRequest();
      assertThat(packageRequest.getMethod()).isEqualTo("GET");
      assertThat(packageRequest.getHeader("Accept")).isEqualTo("application/json");
    }
  }

}