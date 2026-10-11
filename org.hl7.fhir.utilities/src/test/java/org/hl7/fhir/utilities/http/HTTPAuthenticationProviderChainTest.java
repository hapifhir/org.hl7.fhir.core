package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.settings.OAuthClientCredentialsPOJO;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class HTTPAuthenticationProviderChainTest {

  @AfterEach
  void tearDown() {
    HTTPTokenManager.clearCache();
  }

  private static IHTTPAuthenticationProvider mockProviderFor(URL url, Map<String, String> headers) throws IOException {
    IHTTPAuthenticationProvider provider = mock(IHTTPAuthenticationProvider.class);
    when(provider.canProvideHeaders(url)).thenReturn(true);
    when(provider.getHeaders(url)).thenReturn(headers);
    return provider;
  }

  private static IHTTPAuthenticationProvider mockNeverProvider() {
    IHTTPAuthenticationProvider provider = mock(IHTTPAuthenticationProvider.class);
    when(provider.canProvideHeaders(any())).thenReturn(false);
    return provider;
  }

  @Test
  void canProvideHeaders_returnsTrueWhenAnyProviderMatches() throws IOException {
    URL url = URI.create("https://example.com/path").toURL();
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockProviderFor(url, Map.of("Authorization", "Bearer token"))
    ));

    assertThat(chain.canProvideHeaders(url)).isTrue();
  }

  @Test
  void canProvideHeaders_returnsFalseWhenNoProviderMatches() throws IOException {
    URL url = URI.create("https://example.com/path").toURL();
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockNeverProvider()
    ));

    assertThat(chain.canProvideHeaders(url)).isFalse();
  }

  @Test
  void getHeaders_returnsHeadersFromFirstMatchingProvider() throws IOException {
    URL url = URI.create("https://example.com/path").toURL();
    IHTTPAuthenticationProvider first = mockProviderFor(url, Map.of("Authorization", "Bearer first"));
    IHTTPAuthenticationProvider second = mockProviderFor(url, Map.of("Authorization", "Bearer second"));

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(first, second));

    assertThat(chain.getHeaders(url)).containsEntry("Authorization", "Bearer first");
    verify(second, never()).getHeaders(any());
  }

  @Test
  void getHeaders_skipsNonMatchingProvidersAndUsesFirstMatch() throws IOException {
    URL url = URI.create("https://example.com/path").toURL();
    IHTTPAuthenticationProvider nonMatching = mockNeverProvider();
    IHTTPAuthenticationProvider matching = mockProviderFor(url, Map.of("Authorization", "Bearer token"));

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(nonMatching, matching));

    assertThat(chain.getHeaders(url)).containsEntry("Authorization", "Bearer token");
    verify(nonMatching, never()).getHeaders(any());
  }

  @Test
  void getHeaders_returnsEmptyMapWhenNoProviderMatches() throws IOException {
    URL url = URI.create("https://example.com/path").toURL();
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockNeverProvider()
    ));

    assertThat(chain.getHeaders(url)).isEmpty();
  }

  @Test
  void getHeaders_routesDifferentUrlsToDifferentProviders() throws IOException {
    URL urlA = URI.create("https://a.example.com/path").toURL();
    URL urlB = URI.create("https://b.example.com/path").toURL();

    IHTTPAuthenticationProvider providerA = mockProviderFor(urlA, Map.of("Authorization", "Bearer for-a"));
    IHTTPAuthenticationProvider providerB = mockProviderFor(urlB, Map.of("Authorization", "Bearer for-b"));
    when(providerA.canProvideHeaders(urlB)).thenReturn(false);
    when(providerB.canProvideHeaders(urlA)).thenReturn(false);

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(providerA, providerB));

    assertThat(chain.getHeaders(urlA)).containsEntry("Authorization", "Bearer for-a");
    assertThat(chain.getHeaders(urlB)).containsEntry("Authorization", "Bearer for-b");
  }

  private static final String REJECTED = "Bearer rejected-token";

  /** A provider that serves {@code url} and reports whether it discarded cached credentials. */
  private static IHTTPAuthenticationProvider mockInvalidatingProvider(URL url, boolean invalidated) {
    IHTTPAuthenticationProvider provider = mock(IHTTPAuthenticationProvider.class);
    when(provider.canProvideHeaders(url)).thenReturn(true);
    when(provider.invalidateCachedCredentials(url, REJECTED)).thenReturn(invalidated);
    return provider;
  }

  @Test
  void invalidateCachedCredentials_delegatesToFirstMatchingProvider() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockInvalidatingProvider(matchingUrl, true)
    ));

    assertThat(chain.invalidateCachedCredentials(matchingUrl, REJECTED)).isTrue();
  }

  @Test
  void invalidateCachedCredentials_passesOnFalseFromMatchingProvider() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockInvalidatingProvider(matchingUrl, false)
    ));

    assertThat(chain.invalidateCachedCredentials(matchingUrl, REJECTED)).isFalse();
  }

  @Test
  void canRefreshCredentials_asksOnlyTheFirstProviderThatServesTheUrl() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    IHTTPAuthenticationProvider servesButCannotRefresh = mockProviderFor(matchingUrl, Map.of());
    IHTTPAuthenticationProvider laterProvider = mockInvalidatingProvider(matchingUrl, true);
    when(laterProvider.canRefreshCredentials(matchingUrl)).thenReturn(true);

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      servesButCannotRefresh, laterProvider
    ));

    assertThat(chain.canRefreshCredentials(matchingUrl)).isFalse();
    verify(laterProvider, never()).canRefreshCredentials(any());
  }

  @Test
  void canRefreshCredentials_delegatesToFirstMatchingProvider() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    IHTTPAuthenticationProvider refreshing = mockInvalidatingProvider(matchingUrl, true);
    when(refreshing.canRefreshCredentials(matchingUrl)).thenReturn(true);

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(), refreshing
    ));

    assertThat(chain.canRefreshCredentials(matchingUrl)).isTrue();
  }

  @Test
  void invalidateCachedCredentials_stopsAtFirstProviderThatServesTheUrl() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    // The first provider supplied the header that caused the 401, but cannot invalidate anything.
    // Scanning past it would invalidate an unrelated provider's token and trigger a doomed retry.
    IHTTPAuthenticationProvider servesButCannotInvalidate = mockProviderFor(matchingUrl, Map.of());
    IHTTPAuthenticationProvider laterProvider = mockInvalidatingProvider(matchingUrl, true);

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      servesButCannotInvalidate, laterProvider
    ));

    assertThat(chain.invalidateCachedCredentials(matchingUrl, REJECTED)).isFalse();
    verify(laterProvider, never()).invalidateCachedCredentials(any(), any());
  }

  @Test
  void invalidateCachedCredentials_reportsFalseWhenNoBearerTokenWasSent() throws IOException {
    URL matchingUrl = new URL("https://fhir.example.org/Patient");

    ServerDetailsPOJO ccServer = ServerDetailsPOJO.builder()
      .url("https://fhir.example.org/")
      .authenticationType("oauth_client_credentials")
      .type("fhir")
      .oauthClientCredentials(OAuthClientCredentialsPOJO.builder()
        .clientId("testClient")
        .clientSecret("testSecret")
        .tokenEndpoint("https://auth.example.org/token")
        .build())
      .build();

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      new ServerDetailsPOJOHTTPAuthProvider(List.of(ccServer))
    ));

    // Without a rejected bearer token there is nothing to discard, so no point retrying
    assertThat(chain.invalidateCachedCredentials(matchingUrl, null)).isFalse();
    assertThat(chain.invalidateCachedCredentials(matchingUrl, "Basic abc")).isFalse();
  }

  @Test
  void invalidateCachedCredentials_returnsFalseWhenNoProviderMatches() throws IOException {
    URL url = new URL("https://nomatch.example.com/Patient");

    ServerDetailsPOJO ccServer = ServerDetailsPOJO.builder()
      .url("https://fhir.example.org/")
      .authenticationType("oauth_client_credentials")
      .type("fhir")
      .oauthClientCredentials(OAuthClientCredentialsPOJO.builder()
        .clientId("testClient")
        .clientSecret("testSecret")
        .tokenEndpoint("https://auth.example.org/token")
        .build())
      .build();

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      new ServerDetailsPOJOHTTPAuthProvider(List.of(ccServer))
    ));

    assertThat(chain.invalidateCachedCredentials(url, REJECTED)).isFalse();
  }
}
