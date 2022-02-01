package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class CacheVerificationLogger implements ToolingClientLogger {

  public static final String FHIR_TXCACHE_REBUILD = "fhir.txcache.rebuild";

  public static final String isRebuildingCache = System.getProperty(FHIR_TXCACHE_REBUILD);

  @Getter
  int requests = 0;

  @Override
  public void logRequest(String method, String url, List<String> headers, byte[] body) {
    if (!isRebuildingCache()) {
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

  private boolean isRebuildingCache() {
    return isRebuildingCache != null && "TRUE".equals(isRebuildingCache.toUpperCase());
  }

  public boolean verifyHasNoRequests() {

    if (isRebuildingCache()) {
      return true;
    } else {
      if (requests != 0) {
        System.err.println(requests + " unexpected TX server requests logged. If a new test has been added, you may need to " +
          "rebuild the TX Cache for the test using the 'mvn test -D" + FHIR_TXCACHE_REBUILD + "=true' option");
        return false;
      } else {
        return true;
      }
    }
  }
}
