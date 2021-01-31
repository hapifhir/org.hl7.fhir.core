package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PackageCacheTests {

  @Test
  public void testPath() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    cache.clear();
    List<String> list = cache.listPackages();
    if (!list.isEmpty()) {
      System.out.println("remaining packages: "+list.toString());
    }
    Assertions.assertTrue(list.isEmpty(), "List should be true but is "+list.toString());
    NpmPackage npm = cache.loadPackage("hl7.fhir.pubpack", "0.0.7");
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
    list = cache.listPackages();
    Assertions.assertFalse(list.isEmpty());
  }
  
  @Test
  public void testPatchWildCard() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    cache.clear();    
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.0").version(), "3.1.0");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.1").version(), "3.1.1");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.x").version(), "3.1.1");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.0.x").version(), "3.0.1");
  }
}