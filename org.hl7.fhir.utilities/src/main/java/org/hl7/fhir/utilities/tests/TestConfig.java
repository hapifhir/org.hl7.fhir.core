package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import lombok.Setter;

public class TestConfig {

  private static final TestConfig INSTANCE = new TestConfig();

  @Getter @Setter
  private String txCacheDirectory = TestConstants.TX_CACHE;

  @Getter @Setter
  private String fhirTestCasesDirectory = null;

  public static TestConfig getInstance() {
    return INSTANCE;
  }

}
