package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimalMemoryTests {

  @Test
  public void testFetch() throws IOException {
    File folder = new File(Utilities.path("[tmp]", ".fhir-mm"));
    if (folder.exists()) {
      System.out.println("MinimalMemoryTests: clearing folder: " + folder.getAbsolutePath());
      Utilities.clearDirectory(folder.getAbsolutePath());
    } else {
      System.out.println("MinimalMemoryTests: creating folder: " + folder.getAbsolutePath());
      File createdFolder = Utilities.createDirectory(folder.getAbsolutePath());
      System.out.println("MinimalMemoryTests: created folder: " + createdFolder.getAbsolutePath());
      System.out.println("MinimalMemoryTests: new folder exists: " + createdFolder.exists());
    }
    System.out.println("MinimalMemoryTests: passed folder exists: " + folder.exists());
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.FilesystemPackageCacheManagerBuilder().withCacheFolder(folder.getAbsolutePath()).build();
    pcm.setMinimalMemory(true);
    NpmPackage npm = pcm.loadPackage("hl7.fhir.us.core", "5.0.0");
    Assertions.assertTrue(npm.isMinimalMemory());
  }

}
