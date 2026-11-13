package org.hl7.fhir.utilities.http.okhttpimpl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NonCanonicalIPMatcherTests {

  @ParameterizedTest
  @ValueSource(strings = {
    "2130706433",      // decimal 127.0.0.1
    "127.1",           // short form of 127.0.0.1
    "127.000.000.001", // leading zeros
    "2852039166",      // decimal 169.254.169.254
    "017700000001",    // octal-looking
    "::1",             // IPv6 alternative of the OkHttp pattern
    "fd00::1"
  })
  void matchesHostsOkHttpTreatsAsIpLiterals(String host) {
    assertThat(NonCanonicalIPMatcher.isNonCanonicalIPHost(host)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "example.org",
    "127.0.0.1.nip.io",
    "0x7f000001",      // hex form: not an OkHttp literal, goes through Dns
    "localhost",
    ""
  })
  void doesNotMatchHostnames(String host) {
    assertThat(NonCanonicalIPMatcher.isNonCanonicalIPHost(host)).isFalse();
  }
}
