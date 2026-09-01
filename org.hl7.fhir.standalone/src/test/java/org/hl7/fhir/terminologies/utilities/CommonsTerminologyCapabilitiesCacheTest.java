package org.hl7.fhir.terminologies.utilities;

import org.hl7.fhir.standalone.terminology.utilities.CommonsTerminologyCapabilitiesCache;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyCapabilitiesCache;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CommonsTerminologyCapabilitiesCacheTest {

  public static final String TEST_KEY = "testKey";

  @Test
  public void testFileExpiry() throws IOException, InterruptedException {
    String expiringFilePath = TestingUtilities.tempFile("capabilitiesCache", "fileToExpire");

    File file = ManagedFileAccess.file(expiringFilePath);
    if (file.exists()) {
      file.delete();
    }
    file.createNewFile();
    Assertions.assertFalse(TerminologyCapabilitiesCache.cacheFileHasExpired(expiringFilePath, 100L));
    Thread.sleep(200L);
    Assertions.assertTrue(TerminologyCapabilitiesCache.cacheFileHasExpired(expiringFilePath, 100L));

  }

  @Test
  public void testEmptyCache() {
    CommonsTerminologyCapabilitiesCache<String> cache = new CommonsTerminologyCapabilitiesCache<>(100L, java.util.concurrent.TimeUnit.MILLISECONDS);

    Assertions.assertFalse(cache.containsKey(TEST_KEY));
    Assertions.assertNull(cache.get(TEST_KEY));
  }

  @Test
  public void testEntry() {
    CommonsTerminologyCapabilitiesCache<String> cache = new CommonsTerminologyCapabilitiesCache<>(100L, java.util.concurrent.TimeUnit.MILLISECONDS);

    cache.put(TEST_KEY, "testValue");
    Assertions.assertTrue(cache.containsKey(TEST_KEY));
    Assertions.assertEquals("testValue", cache.get(TEST_KEY));
  }

  @Test
  public void testExpiredEntry() throws InterruptedException {
    CommonsTerminologyCapabilitiesCache<String> cache = new CommonsTerminologyCapabilitiesCache<>(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
    cache.put(TEST_KEY, "testValue");

    Thread.sleep(200L);

    Assertions.assertFalse(cache.containsKey(TEST_KEY));
    // Assertions.assertNull(cache.get(TEST_KEY)); FIXME

  }
}
