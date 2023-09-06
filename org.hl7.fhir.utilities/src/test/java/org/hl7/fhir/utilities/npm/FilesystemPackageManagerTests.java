package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class FilesystemPackageManagerTests {

  private static final String DUMMY_URL_1 = "http://dummy1.org";
  private static final String DUMMY_URL_2 = "http://dummy2.org";

  private static final String DUMMY_URL_3 = "http://dummy3.org";

  private static final String DUMMY_URL_4 = "http://dummy4.org";
  private List<PackageServer> dummyPrivateServers = List.of(
     new PackageServer(DUMMY_URL_1),
     new PackageServer(DUMMY_URL_2)
  );

  private List<PackageServer> dummyDefaultServers = List.of(
    new PackageServer(DUMMY_URL_3),
    new PackageServer(DUMMY_URL_4)
  );

  @Test
  public void testDefaultServers() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = getFilesystemPackageCacheManager(false);

    assertEquals(4, filesystemPackageCacheManager.myPackageServers.size());
    assertEquals(DUMMY_URL_1, filesystemPackageCacheManager.myPackageServers.get(0).getUrl());
    assertEquals(DUMMY_URL_2, filesystemPackageCacheManager.myPackageServers.get(1).getUrl());
    assertEquals(DUMMY_URL_3, filesystemPackageCacheManager.myPackageServers.get(2).getUrl());
    assertEquals(DUMMY_URL_4, filesystemPackageCacheManager.myPackageServers.get(3).getUrl());
  }

  @Test
  public void testIgnoreDefaultServers() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = getFilesystemPackageCacheManager(true);

    assertEquals(2, filesystemPackageCacheManager.myPackageServers.size());
    assertEquals(DUMMY_URL_1, filesystemPackageCacheManager.myPackageServers.get(0).getUrl());
    assertEquals(DUMMY_URL_2, filesystemPackageCacheManager.myPackageServers.get(1).getUrl());
  }

  @Nonnull
  private FilesystemPackageCacheManager getFilesystemPackageCacheManager(final boolean ignoreDefaultPackageServers) throws IOException {
    return new FilesystemPackageCacheManager(FilesystemPackageCacheManager.FilesystemPackageCacheMode.TESTING) {
      protected boolean isIgnoreDefaultPackageServers() {
        return ignoreDefaultPackageServers;
      }

      @Nonnull
      protected List<PackageServer> getDefaultServers() {
        return dummyDefaultServers;
      }

      protected List<PackageServer> getConfiguredServers() {
        return dummyPrivateServers;
      }
    };
  }

  @Test
  public void testUserCacheDirectory() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager(true) {
      protected void initCacheFolder() throws IOException {
      }
    };
    assertEquals(System.getProperty("user.home") + File.separator + ".fhir" + File.separator + "packages", filesystemPackageCacheManager.getFolder());
  }

  /*
    Targeted folder will only be valid on -nix style systems.
   */
  @Test
  @DisabledOnOs(OS.WINDOWS)
  public void testSystemCacheDirectory() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager(false) {
      protected void initCacheFolder() throws IOException {
      }
    };
    assertEquals( "/var/lib/.fhir/packages", filesystemPackageCacheManager.getFolder());
  }
}
