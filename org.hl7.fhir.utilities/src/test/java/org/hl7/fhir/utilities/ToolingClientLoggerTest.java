package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Request and response headers are logged (and the IG publisher publishes its terminology log as qa-tx.html): whatever
 * authenticates a request or a session is masked
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
    "Set-Cookie: JSESSIONID=abc; Path=/; HttpOnly|Set-Cookie: xxxxxxxxxxxxxxxx",
    "set-cookie: a=b|set-cookie: xxxxxxxxxxxxxxxx",
    "Cookie2: $Version=1|Cookie2: xxxxxxxxxxxxxxxx",
    "X-Session-Id: 42|X-Session-Id: xxxxxxxxxxxxxxxx",
    "X-Auth: secret|X-Auth: xxxxxxxxxxxxxxxx",
    "Authentication-Info: nextnonce=x|Authentication-Info: xxxxxxxxxxxxxxxx",
    "X-Credentials: u:p|X-Credentials: xxxxxxxxxxxxxxxx",
    "X-Password: p|X-Password: xxxxxxxxxxxxxxxx",
    "WWW-Authenticate: Bearer realm=\"tx\"|WWW-Authenticate: Bearer realm=\"tx\"",
    "Proxy-Authenticate: Basic realm=x|Proxy-Authenticate: Basic realm=x",
    "Keep-Alive: timeout=5|Keep-Alive: timeout=5",
    "Accept: application/fhir+json|Accept: application/fhir+json",
    "User-Agent: hapi-fhir-tooling-client|User-Agent: hapi-fhir-tooling-client",
    "X-Cache-Id: 123|X-Cache-Id: 123",
    "not a header|not a header"
  })
  void secretsAreMasked(String header, String logged) {
    assertEquals(logged, ToolingClientLogger.presentHeader(header));
  }

  /** in a Turkish locale, "COOKIE".toLowerCase() has a dotless i in it: the names are compared without the locale */
  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
    "COOKIE: a=b|COOKIE: xxxxxxxxxxxxxxxx",
    "SET-COOKIE: a=b|SET-COOKIE: xxxxxxxxxxxxxxxx",
    "X-API-KEY: k|X-API-KEY: xxxxxxxxxxxxxxxx",
    "AUTHORIZATION: Basic x|AUTHORIZATION: xxxxxxxxxxxxxxxx"
  })
  void secretsAreMaskedInATurkishLocale(String header, String logged) {
    java.util.Locale locale = java.util.Locale.getDefault();
    try {
      java.util.Locale.setDefault(java.util.Locale.forLanguageTag("tr-TR"));
      assertEquals(logged, ToolingClientLogger.presentHeader(header));
    } finally {
      java.util.Locale.setDefault(locale);
    }
  }
}
