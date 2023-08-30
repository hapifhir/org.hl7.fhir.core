package org.hl7.fhir.utilities.npm;

import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
