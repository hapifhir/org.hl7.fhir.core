package org.hl7.fhir.utilities.tests;

import java.nio.file.Paths;

import lombok.Getter;
import lombok.Setter;

public class TestConfig {

  private static final TestConfig INSTANCE = new TestConfig();

  public static final String FHIR_TXCACHE_REBUILD = "fhir.txcache.rebuild";
  public static final String FHIR_TEST_CASES = "FHIR-TEST-CASES";

  @Getter @Setter
  private boolean rebuildCache = System.getProperty(FHIR_TXCACHE_REBUILD) != null && "TRUE".equalsIgnoreCase(System.getProperty(FHIR_TXCACHE_REBUILD));

  @Getter @Setter
  private String txCacheDirectory = TestConstants.TX_CACHE;

  @Getter @Setter
  private String fhirTestCasesDirectory = System.getenv(FHIR_TEST_CASES);

  public static TestConfig getInstance() {
    return INSTANCE;
  }

  public String getTxCacheDirectory(String ... path) {
    return Paths.get(txCacheDirectory, path).toString();
  }

}
