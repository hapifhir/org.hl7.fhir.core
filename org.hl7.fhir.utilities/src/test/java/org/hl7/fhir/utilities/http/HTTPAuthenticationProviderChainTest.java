package org.hl7.fhir.utilities.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class HTTPAuthenticationProviderChainTest {

  private static IHTTPAuthenticationProvider mockProviderFor(URL url, Map<String, String> headers) {
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
  void canProvideHeaders_returnsTrueWhenAnyProviderMatches() throws MalformedURLException {
    URL url = new URL("https://example.com/path");
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockProviderFor(url, Map.of("Authorization", "Bearer token"))
    ));

    assertThat(chain.canProvideHeaders(url)).isTrue();
  }

  @Test
  void canProvideHeaders_returnsFalseWhenNoProviderMatches() throws MalformedURLException {
    URL url = new URL("https://example.com/path");
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockNeverProvider()
    ));

    assertThat(chain.canProvideHeaders(url)).isFalse();
  }

  @Test
  void getHeaders_returnsHeadersFromFirstMatchingProvider() throws MalformedURLException {
    URL url = new URL("https://example.com/path");
    IHTTPAuthenticationProvider first = mockProviderFor(url, Map.of("Authorization", "Bearer first"));
    IHTTPAuthenticationProvider second = mockProviderFor(url, Map.of("Authorization", "Bearer second"));

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(first, second));

    assertThat(chain.getHeaders(url)).containsEntry("Authorization", "Bearer first");
    verify(second, never()).getHeaders(any());
  }

  @Test
  void getHeaders_skipsNonMatchingProvidersAndUsesFirstMatch() throws MalformedURLException {
    URL url = new URL("https://example.com/path");
    IHTTPAuthenticationProvider nonMatching = mockNeverProvider();
    IHTTPAuthenticationProvider matching = mockProviderFor(url, Map.of("Authorization", "Bearer token"));

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(nonMatching, matching));

    assertThat(chain.getHeaders(url)).containsEntry("Authorization", "Bearer token");
    verify(nonMatching, never()).getHeaders(any());
  }

  @Test
  void getHeaders_returnsEmptyMapWhenNoProviderMatches() throws MalformedURLException {
    URL url = new URL("https://example.com/path");
    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(
      mockNeverProvider(),
      mockNeverProvider()
    ));

    assertThat(chain.getHeaders(url)).isEmpty();
  }

  @Test
  void getHeaders_routesDifferentUrlsToDifferentProviders() throws MalformedURLException {
    URL urlA = new URL("https://a.example.com/path");
    URL urlB = new URL("https://b.example.com/path");

    IHTTPAuthenticationProvider providerA = mockProviderFor(urlA, Map.of("Authorization", "Bearer for-a"));
    IHTTPAuthenticationProvider providerB = mockProviderFor(urlB, Map.of("Authorization", "Bearer for-b"));
    when(providerA.canProvideHeaders(urlB)).thenReturn(false);
    when(providerB.canProvideHeaders(urlA)).thenReturn(false);

    HTTPAuthenticationProviderChain chain = new HTTPAuthenticationProviderChain(List.of(providerA, providerB));

    assertThat(chain.getHeaders(urlA)).containsEntry("Authorization", "Bearer for-a");
    assertThat(chain.getHeaders(urlB)).containsEntry("Authorization", "Bearer for-b");
  }
}
