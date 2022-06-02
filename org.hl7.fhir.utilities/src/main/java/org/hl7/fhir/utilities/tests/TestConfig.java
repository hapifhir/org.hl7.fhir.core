package org.hl7.fhir.utilities.tests;

import lombok.Getter;
import lombok.Setter;

public class TestConfig {

  private static final TestConfig INSTANCE = new TestConfig();

  @Getter @Setter
  private String txCacheDirectory = TestConstants.TX_CACHE;

  public static TestConfig getInstance() {
    return INSTANCE;
  }

}
