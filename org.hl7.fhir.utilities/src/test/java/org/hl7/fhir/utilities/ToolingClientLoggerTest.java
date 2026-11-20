package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Request headers are logged (and the IG publisher publishes its terminology log as qa-tx.html): whatever
 * authenticates the request is masked
 */
class ToolingClientLoggerTest {

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
    "Api-Key: abc123|Api-Key: xxxxxxxxxxxxxxxx",
    "Authorization: Bearer eyJhbGciOi|Authorization: xxxxxxxxxxxxxxxx",
    "Authorization: Basic dXNlcjpwYXNz|Authorization: xxxxxxxxxxxxxxxx",
    "authorization: Bearer x|authorization: xxxxxxxxxxxxxxxx",
    "Proxy-Authorization: Basic x|Proxy-Authorization: xxxxxxxxxxxxxxxx",
    "Cookie: session=1|Cookie: xxxxxxxxxxxxxxxx",
    "X-Api-Token: t|X-Api-Token: xxxxxxxxxxxxxxxx",
    "X-Client-Secret: s|X-Client-Secret: xxxxxxxxxxxxxxxx",
    "Accept: application/fhir+json|Accept: application/fhir+json",
    "User-Agent: hapi-fhir-tooling-client|User-Agent: hapi-fhir-tooling-client",
    "X-Cache-Id: 123|X-Cache-Id: 123",
    "not a header|not a header"
  })
  void secretsAreMasked(String header, String logged) {
    assertEquals(logged, ToolingClientLogger.presentHeader(header));
  }
}
