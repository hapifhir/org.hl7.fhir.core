package org.hl7.fhir.utilities.tests;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.Utilities;

import lombok.Getter;

public class CacheVerificationLogger implements ToolingClientLogger {

  @Getter
  int requests = 0;

  @Override
  public void logRequest(String method, String url, List<String> headers, byte[] body) {
    if (!TestConfig.getInstance().isRebuildCache()) {
      System.err.println("Unexpected request to server");
      System.err.println(method);
      System.err.println(url);
      if (headers != null) {
        for (String header : headers) {

          System.err.println("Header: " + redact(header));
        }
      }
      if (body != null) {
        System.err.println("Body");
        System.err.println("----");
        System.err.println(new String(body, StandardCharsets.UTF_8));
      }
    }
    requests++;
  }

  /**
   * this output ends up in build logs, so don't echo credentials (e.g. api keys from fhir-settings.json)
   */
  static String redact(String header) {
    int i = header.indexOf(':');
    if (i > 0) {
      String name = header.substring(0, i).trim().toLowerCase();
      if (Utilities.existsInList(name, "api-key", "x-api-key", "authorization", "proxy-authorization", "cookie") || name.contains("token") || name.contains("secret")) {
        return header.substring(0, i) + ": [redacted]";
      }
    }
    return header;
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
