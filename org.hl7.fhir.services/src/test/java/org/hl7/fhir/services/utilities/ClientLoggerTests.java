package org.hl7.fhir.services.utilities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * The terminology logs (the IG publisher publishes the HTML one as qa-tx.html): whatever authenticates a request or a
 * session is masked, in the request and the response, and the HTML log escapes what it's given
 */
class ClientLoggerTests {

  @TempDir
  Path dir;

  private static final List<String> REQUEST = List.of("Accept: application/fhir+json", "Authorization: Bearer s3cret-req",
      "Api-Key: s3cret-key", "Cookie: sid=s3cret-cookie");
  private static final List<String> RESPONSE = List.of("Content-Type: application/fhir+json",
      "Set-Cookie: sid=s3cret-set; HttpOnly", "WWW-Authenticate: Bearer realm=\"tx\"");

  @Test
  void theHtmlLogMasksSecretsAndEscapes() throws IOException {
    Path fn = dir.resolve("log.html");
    HTMLClientLogger logger = new HTMLClientLogger(fn.toString());
    logger.logRequest("GET", "http://tx.example.org/r4/ValueSet?url=<x>&a=b", REQUEST, null);
    logger.logResponse("200 <OK>", RESPONSE, null, 0);
    String log = new String(Files.readAllBytes(fn), StandardCharsets.UTF_8);
    assertFalse(log.contains("s3cret"), log);
    assertTrue(log.contains("Authorization: xxxxxxxxxxxxxxxx"), log);
    assertTrue(log.contains("Set-Cookie: xxxxxxxxxxxxxxxx"), log);
    assertTrue(log.contains("Accept: application/fhir+json"), log);
    assertTrue(log.contains("WWW-Authenticate: Bearer realm="), log);
    // the request line and the outcome are escaped, like everything else
    assertFalse(log.contains("<x>"), log);
    assertFalse(log.contains("<OK>"), log);
    assertTrue(log.contains("url=&lt;x&gt;&amp;a=b"), log);
  }

  @Test
  void theTextLogMasksSecrets() throws IOException {
    Path fn = dir.resolve("log.txt");
    TextClientLogger logger = new TextClientLogger(fn.toString());
    logger.logRequest("GET", "http://tx.example.org/r4/ValueSet?url=<x>&a=b", REQUEST, null);
    logger.logResponse("200 OK", RESPONSE, null, 0);
    String log = new String(Files.readAllBytes(fn), StandardCharsets.UTF_8);
    assertFalse(log.contains("s3cret"), log);
    assertTrue(log.contains("Cookie: xxxxxxxxxxxxxxxx"), log);
    assertTrue(log.contains("Set-Cookie: xxxxxxxxxxxxxxxx"), log);
    // a text log isn't escaped
    assertTrue(log.contains("url=<x>&a=b"), log);
    assertTrue(log.contains("WWW-Authenticate: Bearer realm=\"tx\""), log);
  }

  @Test
  void noHeadersIsFine() throws IOException {
    HTMLClientLogger logger = new HTMLClientLogger(dir.resolve("log2.html").toString());
    assertDoesNotThrow(() -> {
      logger.logRequest("GET", "http://tx.example.org/r4/metadata", null, null);
      logger.logResponse("200 OK", null, null, 0);
    });
  }
}
