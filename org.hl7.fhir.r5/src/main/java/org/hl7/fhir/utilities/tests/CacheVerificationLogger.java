package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.util.List;

public class CacheVerificationLogger implements ToolingClientLogger {

  public static final String FHIR_TXCACHE_REBUILD = "fhir.txcache.rebuild";

  @Getter
  int requests = 0;

  @Override
  public void logRequest(String method, String url, List<String> headers, byte[] body) {
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
    String isRebuildingCache = System.getProperty(FHIR_TXCACHE_REBUILD);

    if (isRebuildingCache != null && "TRUE".equals(isRebuildingCache.toUpperCase())) {
      return true;
    } else {
      if (requests != 0) {
        System.err.println("Unexpected TX server request during test. If a new test has been added, you may need to " +
          "rebuild the TX Cache for the test using the 'mvn test -D" + FHIR_TXCACHE_REBUILD + "=true' option");
        return false;
      } else {
        return true;
      }
    }
  }
}
