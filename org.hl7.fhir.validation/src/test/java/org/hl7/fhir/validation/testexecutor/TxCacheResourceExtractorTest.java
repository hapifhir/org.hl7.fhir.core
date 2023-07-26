package org.hl7.fhir.validation.testexecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class TxCacheResourceExtractorTest {

  /**
   *
   * @return true if the TestConstants.getTxCacheDirectory() is not set to the default value
   */
  public static final boolean isCliRun() {
    return !org.hl7.fhir.r5.test.utils.TestConstants.TX_CACHE.equals(org.hl7.fhir.utilities.tests.TestConfig.getInstance().getTxCacheDirectory());
  }

  @Test
  public void testTxCacheExtraction() throws IOException {
    if (isCliRun()) {
      return;
    }

    Path path = Files.createTempDirectory("txCacheExtractionTest");

    TxCacheResourceExtractor.extractTxCacheResources(path.toString());

  }

}
