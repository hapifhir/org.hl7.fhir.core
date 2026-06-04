package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.http.HTTPAuthenticationMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PackageServerHTTPAuthProviderTests {

  public static final String DUMMY_TOKEN = "DUMMY_TOKEN";

  public static Stream<Arguments> headerAccessTestParams() {
    return Stream.of(
      // Valid requests
      // Base case
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org", true),

      // Valid paths
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org/", true),
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org/a", true),
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org/a/", true),
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org/a/b", true),
      Arguments.of("https://packages.fhir.org/a", "https://packages.fhir.org/a", true),
      Arguments.of("https://packages.fhir.org/a", "https://packages.fhir.org/a/", true),
      Arguments.of("https://packages.fhir.org/a", "https://packages.fhir.org/a/b", true),


      // Valid Server with explicit port
      Arguments.of("https://packages.fhir.org:555", "https://packages.fhir.org:555", true),
      Arguments.of("http://packages.fhir.org:555", "http://packages.fhir.org:555", true),


      // Valid Inferred port
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org:443", true),
      Arguments.of("http://packages.fhir.org", "http://packages.fhir.org:80", true),
      Arguments.of("https://packages.fhir.org:443", "https://packages.fhir.org", true),
      Arguments.of("http://packages.fhir.org:80", "http://packages.fhir.org", true),


      // Invalid requests
      // Malicious server
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org.malicious.com", false),

      // Wrong protocol
      Arguments.of("https://packages.fhir.org", "http://packages.fhir.org", false),
      Arguments.of("http://packages.fhir.org", "https://packages.fhir.org", false),

      // Invalid paths
      Arguments.of("https://packages.fhir.org/a", "https://packages.fhir.org", false),
      Arguments.of("https://packages.fhir.org/a", "https://packages.fhir.org/", false),
      Arguments.of("https://packages.fhir.org/a/b", "https://packages.fhir.org/a", false),
      Arguments.of("https://packages.fhir.org/a/b", "https://packages.fhir.org/a/", false),

      // Invalid Inferred Port
      Arguments.of("https://packages.fhir.org", "https://packages.fhir.org:555", false),
      Arguments.of("http://packages.fhir.org", "http://packages.fhir.org:555", false),
      Arguments.of("https://packages.fhir.org:555", "https://packages.fhir.org", false),
      Arguments.of("http://packages.fhir.org:555", "http://packages.fhir.org", false)

      );
  }

  public PackageServer getPackageServer(String serverUrl) {
   return new PackageServer(serverUrl)
      .withAuthenticationMode(HTTPAuthenticationMode.TOKEN)
     .withToken(DUMMY_TOKEN);
  }


  @ParameterizedTest()
  @MethodSource("headerAccessTestParams")
  void headerAccessTest(String serverUrlString, String requestUrlString, boolean canProvideHeaders) throws MalformedURLException {
    PackageServerHTTPAuthProvider provider = new PackageServerHTTPAuthProvider(getPackageServer(serverUrlString));
    URL requestUrl = new URL(requestUrlString);
    if (canProvideHeaders) {
      assertThat(provider.canProvideHeaders(requestUrl)).isTrue();
      Map<String, String> headers = provider.getHeaders(requestUrl);
      assertThat(headers).hasSize(1);
      assertThat(headers).containsEntry("Authorization", "Bearer " + DUMMY_TOKEN);
    } else {
      assertThat(provider.canProvideHeaders(requestUrl)).isFalse();
      assertThatThrownBy(() -> provider.getHeaders(requestUrl))
        .isInstanceOf(IllegalArgumentException.class);
    }
  }
}
