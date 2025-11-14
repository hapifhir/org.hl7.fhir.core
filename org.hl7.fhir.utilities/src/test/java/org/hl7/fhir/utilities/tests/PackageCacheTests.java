package org.hl7.fhir.utilities.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackageCacheTests {

  @Test
  void testPath() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager.Builder().withTestingCacheFolder().build();
    NpmPackage packageToDelete = cache.loadPackage(CommonPackages.ID_PUBPACK, CommonPackages.VER_PUBPACK);
    Assertions.assertNotNull(packageToDelete);
    cache.clear();
    List<String> list = cache.listPackages();
    if (!list.isEmpty()) {
      System.out.println("remaining packages: "+list);
    }
    Assertions.assertTrue(list.isEmpty(), "List should be true but is "+list);
    NpmPackage packageToTest = cache.loadPackage(CommonPackages.ID_PUBPACK, CommonPackages.VER_PUBPACK);
    packageToTest.loadAllFiles();
    Assertions.assertNotNull(packageToTest);
    File dir = ManagedFileAccess.file(Utilities.path("[tmp]", "cache"));
    if (dir.exists()) {
      FileUtilities.clearDirectory(dir.getAbsolutePath());
    } else {
      FileUtilities.createDirectory(dir.getAbsolutePath());
    }
    packageToTest.save(dir);
    NpmPackage npm2 = cache.loadPackage(CommonPackages.ID_PUBPACK, "file:" + dir.getAbsolutePath());
    Assertions.assertNotNull(npm2);
    list = cache.listPackages();
    Assertions.assertFalse(list.isEmpty());
  }
  
  @Test
  public void testPatchWildCard() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager.Builder().withTestingCacheFolder().build();
    cache.clear();    
    Assertions.assertEquals("3.1.0", cache.loadPackage("hl7.fhir.us.core", "3.1.0").version());
    Assertions.assertEquals("3.1.1", cache.loadPackage("hl7.fhir.us.core", "3.1.1").version());
    Assertions.assertEquals("3.1.1", cache.loadPackage("hl7.fhir.us.core", "3.1.x").version());
    Assertions.assertEquals("3.0.1", cache.loadPackage("hl7.fhir.us.core", "3.0.x").version());
  }

  @Test
  public void testNotCaseSensitive() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager.Builder().withTestingCacheFolder().build();
    cache.clear();
    Assertions.assertEquals("1.7.0", cache.loadPackage("KBV.Basis", "1.7.0").version());
    Assertions.assertEquals("1.7.0", cache.loadPackage("kbv.basis", "1.7.0").version());
  }
  
  @Test
  public void testLastReleasedVersion() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager.Builder().withTestingCacheFolder().build();
    cache.clear();
    Assertions.assertEquals("0.2.3", cache.loadPackage(CommonPackages.ID_PUBPACK, "0.2.3").version());
    Assertions.assertEquals(CommonPackages.VER_PUBPACK, cache.loadPackage(CommonPackages.ID_PUBPACK).version());    
  }
  
  @Test
  public void testMinimal() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager.Builder().withTestingCacheFolder().build();
    cache.clear();  
    NpmPackage uscore = cache.loadPackage("hl7.fhir.us.core", "3.1.0");
    cache.setMinimalMemory(true);
    NpmPackage uscoreMin = cache.loadPackage("hl7.fhir.us.core", "3.1.0");
    Assertions.assertEquals(uscore.version(), uscoreMin.version());
    Assertions.assertEquals(uscore.getFolders().size(), uscoreMin.getFolders().size());
    Assertions.assertEquals(uscore.list("package").size(), uscoreMin.list("package").size());
    byte[] b1 = FileUtilities.streamToBytes(uscore.load(uscore.list("package").get(1)));
    byte[] b2 = FileUtilities.streamToBytes(uscoreMin.load(uscore.list("package").get(1)));
    Assertions.assertArrayEquals(b1, b2);    
  }
  
}