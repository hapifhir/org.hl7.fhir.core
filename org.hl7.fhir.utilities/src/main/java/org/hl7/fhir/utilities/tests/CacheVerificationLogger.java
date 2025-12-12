package org.hl7.fhir.utilities.tests;

import java.nio.charset.StandardCharsets;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.ToolingClientLogger;

import lombok.Getter;

@Slf4j
public class CacheVerificationLogger implements ToolingClientLogger {

  @Getter
  int requests = 0;

  @Override
  public void logRequest(String method, String url, List<String> headers, byte[] body) {
    if (!TestConfig.getInstance().isRebuildCache()) {
      log.warn("Unexpected request to server");
      log.warn(method);
      log.warn(url);
      if (headers != null) {
        for (String header : headers) {
          if (header.toLowerCase().startsWith("accept")
            || header.toLowerCase().startsWith("content-type")
            || header.toLowerCase().startsWith("user-agent")
            || header.toLowerCase().startsWith("language")
            ) {
            log.warn("Header: " + header);
          } else {
            log.warn("Header: " + header.substring(0, header.indexOf(":")) + ": [hidden]");
          }
        }
      }
      if (body != null) {
        log.warn("Body");
        log.warn("----");
        log.warn(new String(body, StandardCharsets.UTF_8));
      }
    }
    requests++;
  }

  @Override
  public void logResponse(String outcome, List<String> headers, byte[] body, long start) {

  }

  @Override
  public String getLastId() {
    return null;
  }

  @Override
  public void clearLastId() {

  }



  public boolean verifyHasNoRequests() {
    if (TestConfig.getInstance().isRebuildCache()) {
      return true;
    } else {
      if (requests != 0) {
        System.err.println(requests + " unexpected TX server requests logged. If a new test has been added, you may need to " +
          "rebuild the TX Cache for the test using the 'mvn test -D" + TestConfig.FHIR_TXCACHE_REBUILD + "=true' option");
        return false;
      } else {
        return true;
      }
    }
  }
}
