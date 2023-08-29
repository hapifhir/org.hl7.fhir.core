package org.hl7.fhir.utilities.tests;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hl7.fhir.utilities.ToolingClientLogger;

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
          System.err.println("Header: " + header);
        }
      }
      System.err.println("Body");
      System.err.println("----");
      System.err.println(new String(body, StandardCharsets.UTF_8));
    }
    requests++;
  }

  @Override
  public void logResponse(String outcome, List<String> headers, byte[] body) {

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
