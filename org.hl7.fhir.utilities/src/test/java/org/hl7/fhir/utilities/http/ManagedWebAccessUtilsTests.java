package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManagedWebAccessUtilsTests {

  public static final String DUMMY_TOKEN = "dummy_token";

  public static ServerDetailsPOJO getServerDetailsPOJO(String urlString) {
    return new ServerDetailsPOJO(
      urlString,
      "token",
      "web",
      null,
      null,
      DUMMY_TOKEN + "for " + urlString, null, null, null, null);
  }

  // Created by claude-sonnet-4-6
  // See org.hl7.fhir.utilities.npm.PackageServerHTTPAuthProviderTests.headerAccessTestParams for initial source
  public static Stream<Arguments> headerAccessTestParams() {
    ServerDetailsPOJO fhirOrg         = getServerDetailsPOJO("https://packages.fhir.org");
    ServerDetailsPOJO fhirOrg443      = getServerDetailsPOJO("https://packages.fhir.org:443");
    ServerDetailsPOJO fhirOrg555      = getServerDetailsPOJO("https://packages.fhir.org:555");
    ServerDetailsPOJO fhirOrgPathA    = getServerDetailsPOJO("https://packages.fhir.org/a");
    ServerDetailsPOJO fhirOrgPathAB   = getServerDetailsPOJO("https://packages.fhir.org/a/b");
    ServerDetailsPOJO httpFhirOrg     = getServerDetailsPOJO("http://packages.fhir.org");
    ServerDetailsPOJO httpFhirOrg80   = getServerDetailsPOJO("http://packages.fhir.org:80");
    ServerDetailsPOJO httpFhirOrg555  = getServerDetailsPOJO("http://packages.fhir.org:555");
    ServerDetailsPOJO exampleOrg      = getServerDetailsPOJO("https://example.org");

    return Stream.of(
      // Valid requests - base case
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org", fhirOrg),

      // Valid paths
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org/", fhirOrg),
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org/a", fhirOrg),
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org/a/", fhirOrg),
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org/a/b", fhirOrg),
      Arguments.of(List.of(fhirOrgPathA), "https://packages.fhir.org/a", fhirOrgPathA),
      Arguments.of(List.of(fhirOrgPathA), "https://packages.fhir.org/a/", fhirOrgPathA),
      Arguments.of(List.of(fhirOrgPathA), "https://packages.fhir.org/a/b", fhirOrgPathA),

      // Valid server with explicit port
      Arguments.of(List.of(fhirOrg555), "https://packages.fhir.org:555", fhirOrg555),
      Arguments.of(List.of(httpFhirOrg555), "http://packages.fhir.org:555", httpFhirOrg555),

      // Valid inferred port
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org:443", fhirOrg),
      Arguments.of(List.of(httpFhirOrg), "http://packages.fhir.org:80", httpFhirOrg),
      Arguments.of(List.of(fhirOrg443), "https://packages.fhir.org", fhirOrg443),
      Arguments.of(List.of(httpFhirOrg80), "http://packages.fhir.org", httpFhirOrg80),

      // Invalid - malicious server
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org.malicious.com", null),

      // Invalid - wrong protocol
      Arguments.of(List.of(fhirOrg), "http://packages.fhir.org", null),
      Arguments.of(List.of(httpFhirOrg), "https://packages.fhir.org", null),

      // Invalid - request path shorter than server path
      Arguments.of(List.of(fhirOrgPathA), "https://packages.fhir.org", null),
      Arguments.of(List.of(fhirOrgPathA), "https://packages.fhir.org/", null),
      Arguments.of(List.of(fhirOrgPathAB), "https://packages.fhir.org/a", null),
      Arguments.of(List.of(fhirOrgPathAB), "https://packages.fhir.org/a/", null),

      // Invalid - wrong port
      Arguments.of(List.of(fhirOrg), "https://packages.fhir.org:555", null),
      Arguments.of(List.of(httpFhirOrg), "http://packages.fhir.org:555", null),
      Arguments.of(List.of(fhirOrg555), "https://packages.fhir.org", null),
      Arguments.of(List.of(httpFhirOrg555), "http://packages.fhir.org", null),

      // Server list combinations - target server is second in list
      Arguments.of(List.of(exampleOrg, fhirOrg), "https://packages.fhir.org/packages", fhirOrg),

      // Server list combinations - target server is first in list
      Arguments.of(List.of(fhirOrg, exampleOrg), "https://packages.fhir.org/packages", fhirOrg),

      // Server list combinations - first server matches, not second
      Arguments.of(List.of(exampleOrg, fhirOrg), "https://example.org/api", exampleOrg),

      // Server list combinations - no matching server
      Arguments.of(List.of(exampleOrg), "https://packages.fhir.org", null),

      // Server list combinations - empty list
      Arguments.of(List.of(), "https://packages.fhir.org", null)
    );
  }



  @ParameterizedTest()
  @MethodSource("headerAccessTestParams")
  void serverAccessTest(Iterable<ServerDetailsPOJO> serverList, String requestUrlString, ServerDetailsPOJO expectedServerDetails)  {
    ServerDetailsPOJO actual = ManagedWebAccessUtils.getServer(requestUrlString, serverList);
    assertThat(actual).isEqualTo(expectedServerDetails);
  }

  // Shared SSRF test data, reused across the nested test groups below since each group's method
  // validates a different slice of the same overall policy (see ManagedWebAccessUtils):
  // scheme/host-string guards, literal-IP address ranges, and already-resolved addresses.

  static Stream<String> nonPublicLiteralIpHostnames() {
    return Stream.of(
      "metadata.amazonaws.com",   // explicitly blocked by name, not an IP
      "metadata.google.internal", // explicitly blocked by name, not an IP
      "local.fhir.org",           // resolves to a loopback address via DNS
      "localtest.me",             // resolves to a loopback address via DNS
      "127.0.0.1.nip.io"         // resolves to a loopback address via DNS

    );
  }

  @Nested
  class ThrowExceptionIfNotAllowedScheme {

    /**
     * Mirrors the URI-parsing step {@code throwExceptionIfNotPublicWebUrl} performs before
     * delegating to {@code throwExceptionIfNotAllowedScheme}, so malformed-URL test cases can be
     * reused directly against just the scheme/host-string check.
     */
    private void check(String url) throws IOException {
      final URI uri;
      try {
        uri = new URI(url);
      } catch (URISyntaxException e) {
        throw new IOException("Refusing to fetch from malformed URL: " + url, e);
      }
      ManagedWebAccessUtils.throwExceptionIfNotAllowedScheme(uri);
    }

    @ParameterizedTest
    @ValueSource(strings = {
      "http://exa mple.com/", // malformed
      "ftp://example.com/",   // disallowed scheme
      "file:///etc/passwd",   // disallowed scheme
      "http:///nohost",       // no host

      // Explicitly blocked by hostname, independent of what it resolves to
      "http://metadata.amazonaws.com/",
      "http://metadata.google.internal/"
    })
    void throwsForDisallowedSchemeOrHost(String url) {
      assertThatThrownBy(() -> check(url)).isInstanceOf(IOException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
      // Valid scheme and host string - not this method's job to inspect the resolved address,
      // so these all pass even though several are blocked overall by IP range.

      // These are also https, though no certificate verification will be done, as by default servers do not permit http
      "https://127.0.0.1/",
      "https://10.0.0.1/",
      "https://192.168.0.1/",
      "https://[::1]/",
      "https://[fe80::1]/",
      "https://169.254.169.254/",
      "https://192.0.0.192/",
      "https://local.fhir.org/fhir",
      "https://localtest.me/",
      "https://127.0.0.1.nip.io/",
      "https://127.0.0.1/fhir/metadata?redirect=https://example.org",

      // Genuinely public URLs
      "https://8.8.8.8/",
      "https://1.1.1.1/",

      // Paths and query arguments on public hosts should still be permitted
      "https://8.8.8.8/resolve?name=example.com&type=A",
      "https://1.1.1.1/dns-query?ct=application/dns-json",
      "https://[2001:4860:4860::8888]/fhir/metadata?_format=json"
    })
    void doesNotThrowForAllowedSchemeAndHost(String url) {
      assertThatCode(() -> check(url)).doesNotThrowAnyException();
    }
  }

  @Nested
  class ThrowExceptionIfLiteralIpAndNotPublic {

    @ParameterizedTest
    @MethodSource("org.hl7.fhir.utilities.http.NonPublicAddressRejectingDnsTests#nonPublicLiteralIps")
    void throwsForNonPublicLiteralIp(String host) {
      assertThatThrownBy(() -> ManagedWebAccessUtils.throwExceptionIfLiteralIpAndNonPublicAddress(host))
        .isInstanceOf(IOException.class);
    }

    @ParameterizedTest
    @MethodSource("org.hl7.fhir.utilities.http.NonPublicAddressRejectingDnsTests#publicLiteralIps")
    void doesNotThrowForPublicLiteralIp(String host) {
      assertThatCode(() -> ManagedWebAccessUtils.throwExceptionIfLiteralIpAndNonPublicAddress(host))
        .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("org.hl7.fhir.utilities.http.ManagedWebAccessUtilsTests#nonPublicLiteralIpHostnames")
    void doesNotThrowForNonLiteralIpHostname(String host) {
      // A no-op by design: hostnames are validated by resolving them (see NonPublicAddressRejectingDns),
      // not by this method, even when - as here - they happen to resolve to a non-public address.
      assertThatCode(() -> ManagedWebAccessUtils.throwExceptionIfLiteralIpAndNonPublicAddress(host))
        .doesNotThrowAnyException();
    }
  }

  @Nested
  class ThrowExceptionIfNotPublicAddress {

    @ParameterizedTest
    @MethodSource("org.hl7.fhir.utilities.http.NonPublicAddressRejectingDnsTests#nonPublicLiteralIps")
    void throwsForNonPublicAddress(String literalIp) throws Exception {
      InetAddress address = InetAddress.getByName(literalIp);
      assertThatThrownBy(() -> ManagedWebAccessUtils.throwExceptionIfNonPublicAddress(address, literalIp))
        .isInstanceOf(IOException.class);
    }

    @ParameterizedTest
    @MethodSource("org.hl7.fhir.utilities.http.NonPublicAddressRejectingDnsTests#publicLiteralIps")
    void doesNotThrowForPublicAddress(String literalIp) throws Exception {
      InetAddress address = InetAddress.getByName(literalIp);
      assertThatCode(() -> ManagedWebAccessUtils.throwExceptionIfNonPublicAddress(address, literalIp))
        .doesNotThrowAnyException();
    }
  }
}
