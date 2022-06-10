package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;

public class TestConfig {

  private static final TestConfig INSTANCE = new TestConfig();

  public static final String FHIR_TXCACHE_REBUILD = "fhir.txcache.rebuild";

  @Getter @Setter
  private boolean rebuildCache = System.getProperty(FHIR_TXCACHE_REBUILD) != null && "TRUE".equals(System.getProperty(FHIR_TXCACHE_REBUILD));

  @Getter @Setter
  private String txCacheDirectory = TestConstants.TX_CACHE;

  @Getter @Setter
  private String fhirTestCasesDirectory = null;

  public static TestConfig getInstance() {
    return INSTANCE;
  }

  public String getTxCacheDirectory(String ... path) {
    return Paths.get(txCacheDirectory, path).toString();
  }

}
