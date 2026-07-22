package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.http.okhttpimpl.NonPublicAddressRejectingDns;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.UnknownHostException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NonPublicAddressRejectingDnsTests {

  static Stream<String> nonPublicLiteralIps() {
    return Stream.of(
      "127.0.0.1",        // loopback
      "10.0.0.1",         // RFC1918 site-local
      "172.16.0.1",       // RFC1918 site-local
      "192.168.0.1",      // RFC1918 site-local
      "169.254.0.1",      // link-local
      "0.0.0.0",          // unspecified / any-local
      "224.0.0.1",        // multicast
      "100.64.0.1",       // carrier-grade NAT
      "::1",              // IPv6 loopback
      "::",               // IPv6 unspecified
      "fd00::1",          // IPv6 unique local address (ULA)
      "fc00::1",          // IPv6 unique local address (ULA, other half of fc00::/7)
      "fe80::1",          // IPv6 link-local
      "ff02::1",          // IPv6 multicast
      "0.1.2.3",          // 0.0.0.0/8 "this network", other than the unspecified address itself
      "64:ff9b::7f00:1",  // NAT64-synthesized address embedding 127.0.0.1
      "169.254.169.254",  // AWS/GCP/Azure IMDS (explicitly blocked, also link-local)
      "192.0.0.192"       // Oracle metadata (explicitly blocked)
    );
  }

  static Stream<String> publicLiteralIps() {
    return Stream.of("8.8.8.8", "1.1.1.1", "2001:4860:4860::8888");
  }

  @ParameterizedTest
  @MethodSource("nonPublicLiteralIps")
  void throwsForNonPublicAddress(String host) {
    NonPublicAddressRejectingDns dns = new NonPublicAddressRejectingDns();

    assertThatThrownBy(() -> dns.lookup(host))
      .isInstanceOf(UnknownHostException.class)
      .hasMessageContaining("non-public address");
  }

  @ParameterizedTest
  @MethodSource("publicLiteralIps")
  void doesNotThrowForPublicAddress(String host) {
    NonPublicAddressRejectingDns dns = new NonPublicAddressRejectingDns();

    assertThatCode(() -> dns.lookup(host)).doesNotThrowAnyException();
  }
}
