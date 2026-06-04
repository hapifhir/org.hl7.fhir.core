package org.hl7.fhir.utilities.http;

import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ManagedWebAccessUtilsTests {

  public static final String DUMMY_TOKEN = "dummy_token";

  public static ServerDetailsPOJO getServerDetailsPOJO(String urlString) {
    return new ServerDetailsPOJO(
      urlString,
      "token",
      "web",
      null,
      null,
      DUMMY_TOKEN + "for " + urlString, null, null, null);
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
  void serverAccessTest(Iterable<ServerDetailsPOJO> serverList, String requestUrlString, ServerDetailsPOJO expectedServerDetails) throws MalformedURLException {
    ServerDetailsPOJO actual = ManagedWebAccessUtils.getServer(requestUrlString, serverList);
    assertThat(actual).isEqualTo(expectedServerDetails);
  }
}
