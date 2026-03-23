package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.http.HTTPAuthenticationMode;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PackageServerHTTPAuthProviderTests {

  static final PackageServer packageServer = new PackageServer("https://packages.fhir.org")
    .withAuthenticationMode(HTTPAuthenticationMode.BASIC)
    .withUsername("DUMMY_USERNAME")
    .withPassword("DUMMY_PASSWORD");

  @Test
  void canProvideHeadersForServer() throws MalformedURLException {
    PackageServerHTTPAuthProvider provider = new PackageServerHTTPAuthProvider(packageServer);
    assertThat(provider.canProvideHeaders(new URL("https://packages.fhir.org/packages"))).isTrue();
  }

  @Test
  void cantProvideHeadersForMaliciousServer() throws MalformedURLException {
    PackageServerHTTPAuthProvider provider = new PackageServerHTTPAuthProvider(packageServer);
    assertThat(provider.canProvideHeaders(new URL("https://packages.fhir.org.malicious.com"))).isFalse();
  }

  @Test
  void getHeadersThrowsForMaliciousServer() throws MalformedURLException {
    PackageServerHTTPAuthProvider provider = new PackageServerHTTPAuthProvider(packageServer);
    assertThatThrownBy(() -> provider.getHeaders(new URL("https://packages.fhir.org.malicious.com")))
      .isInstanceOf(SecurityException.class);
  }
}
