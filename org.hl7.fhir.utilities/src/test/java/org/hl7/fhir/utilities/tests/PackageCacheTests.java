package org.hl7.fhir.utilities.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.NpmPackageFolder;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackageCacheTests {

  @Test
  public void testPath() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(FilesystemPackageCacheMode.TESTING);
    NpmPackage npm = cache.loadPackage(CommonPackages.ID_PUBPACK, CommonPackages.VER_PUBPACK);
    cache.clear();
    List<String> list = cache.listPackages();
    if (!list.isEmpty()) {
      System.out.println("remaining packages: "+list.toString());
    }
    Assertions.assertTrue(list.isEmpty(), "List should be true but is "+list.toString());
    npm = cache.loadPackage(CommonPackages.ID_PUBPACK, CommonPackages.VER_PUBPACK);
    npm.loadAllFiles();
    Assertions.assertNotNull(npm);
    File dir = new File(Utilities.path("[tmp]", "cache"));
    if (dir.exists()) {
      Utilities.clearDirectory(dir.getAbsolutePath());
    } else {
      Utilities.createDirectory(dir.getAbsolutePath());
    }
    npm.save(dir);
    NpmPackage npm2 = cache.loadPackage(CommonPackages.ID_PUBPACK, "file:" + dir.getAbsolutePath());
    Assertions.assertNotNull(npm2);
    list = cache.listPackages();
    Assertions.assertFalse(list.isEmpty());
  }
  
  @Test
  public void testPatchWildCard() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(FilesystemPackageCacheMode.TESTING);
    cache.clear();    
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.0").version(), "3.1.0");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.1").version(), "3.1.1");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.1.x").version(), "3.1.1");
    Assertions.assertEquals(cache.loadPackage("hl7.fhir.us.core", "3.0.x").version(), "3.0.1");
  }

  @Test
  public void testNotCaseSensitive() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(FilesystemPackageCacheMode.TESTING);
    cache.clear();    
    Assertions.assertEquals(cache.loadPackage("KBV.Basis", "1.1.3").version(), "1.1.3");
    Assertions.assertEquals(cache.loadPackage("kbv.basis", "1.1.3").version(), "1.1.3");    
  }
  
  @Test
  public void testLastReleasedVersion() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(FilesystemPackageCacheMode.TESTING);
    cache.clear();
    Assertions.assertEquals("0.0.8", cache.loadPackage(CommonPackages.ID_PUBPACK, "0.0.8").version());
    Assertions.assertEquals(CommonPackages.VER_PUBPACK, cache.loadPackage(CommonPackages.ID_PUBPACK).version());    
  }
  
  @Test
  public void testMinimal() throws IOException {
    FilesystemPackageCacheManager cache = new FilesystemPackageCacheManager(FilesystemPackageCacheMode.TESTING);
    cache.clear();  
    NpmPackage uscore = cache.loadPackage("hl7.fhir.us.core", "3.1.0");
    cache.setMinimalMemory(true);
    NpmPackage uscoreMin = cache.loadPackage("hl7.fhir.us.core", "3.1.0");
    Assertions.assertEquals(uscore.version(), uscoreMin.version());
    Assertions.assertEquals(uscore.getFolders().size(), uscoreMin.getFolders().size());
    Assertions.assertEquals(uscore.list("package").size(), uscoreMin.list("package").size());
    byte[] b1 = TextFile.streamToBytes(uscore.load(uscore.list("package").get(1)));
    byte[] b2 = TextFile.streamToBytes(uscoreMin.load(uscore.list("package").get(1)));
    Assertions.assertArrayEquals(b1, b2);    
  }
  
}