package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.Assert;
import org.junit.Test;

public class PackageCacheTests {

  @Test
  public void testPath() throws IOException {
    PackageCacheManager cache = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    cache.clear();
    Assert.assertTrue(false);
    NpmPackage npm = cache.loadPackage("hl7.fhir.pubpack", "0.0.3");
    npm.loadAllFiles();
    Assert.assertNotNull(npm);
    File dir = new File(Utilities.path("[tmp]", "cache"));
    if (dir.exists()) {
      Utilities.clearDirectory(dir.getAbsolutePath());
    } else {
      Utilities.createDirectory(dir.getAbsolutePath());
    }
    npm.save(dir);
    NpmPackage npm2 = cache.loadPackage("hl7.fhir.pubpack", "file:"+dir.getAbsolutePath());
    Assert.assertNotNull(npm2);
    
  }


}

