package org.hl7.fhir.terminologies.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyCache.SourcedCodeSystem;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ExternalCodeSystemLanguageCacheTest {
  private static final String EDQM = "http://standardterms.edqm.eu";

  @TempDir
  Path folder;

  @Test
  void separatesLanguagesVersionsAndLegacyEntriesAfterReload() throws Exception {
    TerminologyCache cache = new TerminologyCache(new Object(), folder.toString(), org.hl7.fhir.standalone.testing.TestingUtilities.getSharedWorkerContext());
    cache.cacheCodeSystem(EDQM, sourced("default"));
    assertFalse(cache.hasCodeSystem(EDQM, "cs"));
    cache.cacheCodeSystem(EDQM, "cs", sourced("czech"));
    cache.cacheCodeSystem(EDQM, "en", sourced("english"));
    cache.cacheCodeSystem(EDQM + "|1.0", "cs", sourced("version1"));
    cache.cacheCodeSystem(EDQM + "|2.0", "cs", null);

    cache = new TerminologyCache(new Object(), folder.toString(), org.hl7.fhir.standalone.testing.TestingUtilities.getSharedWorkerContext());
    assertEquals("default", cache.getCodeSystem(EDQM).getCs().getName());
    assertEquals("czech", cache.getCodeSystem(EDQM, "cs").getCs().getName());
    assertEquals("english", cache.getCodeSystem(EDQM, "en").getCs().getName());
    assertEquals("version1", cache.getCodeSystem(EDQM + "|1.0", "cs").getCs().getName());
    assertTrue(cache.hasCodeSystem(EDQM + "|2.0", "cs"));
    assertNull(cache.getCodeSystem(EDQM + "|2.0", "cs"));
    assertFalse(cache.hasCodeSystem(EDQM + "|2.0", "en"));
    assertFalse(cache.hasCodeSystem(EDQM, "fr"));
    assertEquals("default", cache.getCodeSystem(EDQM, "  ").getCs().getName());
  }

  private SourcedCodeSystem sourced(String name) {
    return new SourcedCodeSystem("https://" + name + ".example.org/r4",
        new CodeSystem().setUrl(EDQM).setName(name));
  }
}
