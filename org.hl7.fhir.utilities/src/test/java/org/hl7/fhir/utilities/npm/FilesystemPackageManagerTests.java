package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
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

    FilesystemPackageCacheManager.Builder builder = new FilesystemPackageCacheManager.Builder() {
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

    return builder.build();

  }

  @Test
  public void testUserCacheDirectory() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().build();
    assertEquals(System.getProperty("user.home") + File.separator + ".fhir" + File.separator + "packages", filesystemPackageCacheManager.getFolder());
  }

  /*
    Targeted folder will only be valid on -nix style systems.
   */
  @Test
  @DisabledOnOs(OS.WINDOWS)
  public void testSystemCacheDirectory() throws IOException {
    File folder = new FilesystemPackageCacheManager.Builder().withSystemCacheFolder().getCacheFolder();

    assertEquals( "/var/lib/.fhir/packages", folder.getAbsolutePath());
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  public void testSystemCacheDirectoryWin() throws IOException {
    File folder = new FilesystemPackageCacheManager.Builder().withSystemCacheFolder().getCacheFolder();
    assertEquals( System.getenv("ProgramData") + "\\.fhir\\packages", folder.getAbsolutePath());
  }

  @Test
  public void multithreadingTest() throws IOException {
    String pcmPath = Files.createTempDirectory("fpcm-multithreadingTest").toFile().getAbsolutePath();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();

    final AtomicInteger totalSuccessful = new AtomicInteger();

    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      final int index = i;
      Thread t = new Thread(() -> {
        try {
          pcm.loadPackage("hl7.fhir.xver-extensions#0.0.12");
          totalSuccessful.incrementAndGet();
          System.out.println("Thread " + index + " completed");
        } catch (Exception e) {
          e.printStackTrace();
          System.err.println("Thread " + index + " failed");
        }
      });
      t.start();
      threads.add(t);
    }
    threads.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {

      }
    });
    assertEquals(3, totalSuccessful.get());
  }
}
