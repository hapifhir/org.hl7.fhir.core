package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class PackageCacheTests {

  @Test
  public void testPath() throws IOException {
    PackageCacheManager cache = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    cache.clear();
    Assertions.assertTrue(cache.listPackages().isEmpty());
    NpmPackage npm = cache.loadPackage("hl7.fhir.pubpack", "0.0.3");
    npm.loadAllFiles();
    Assertions.assertNotNull(npm);
    File dir = new File(Utilities.path("[tmp]", "cache"));
    if (dir.exists()) {
      Utilities.clearDirectory(dir.getAbsolutePath());
    } else {
      Utilities.createDirectory(dir.getAbsolutePath());
    }
    npm.save(dir);
    NpmPackage npm2 = cache.loadPackage("hl7.fhir.pubpack", "file:" + dir.getAbsolutePath());
    Assertions.assertNotNull(npm2);
    Assertions.assertFalse(cache.listPackages().isEmpty());
  }
}