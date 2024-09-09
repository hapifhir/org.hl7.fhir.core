package org.hl7.fhir.utilities.npm;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FilesystemPackageManagerTests {

  private static final String DUMMY_URL_1 = "https://dummy1.org";
  private static final String DUMMY_URL_2 = "https://dummy2.org";

  private static final String DUMMY_URL_3 = "https://dummy3.org";

  private static final String DUMMY_URL_4 = "https://dummy4.org";
  private final List<PackageServer> dummyPrivateServers = List.of(
     new PackageServer(DUMMY_URL_1),
     new PackageServer(DUMMY_URL_2)
  );

  private final List<PackageServer> dummyDefaultServers = List.of(
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
  public void testFailureForUnlockedLockFiles() throws IOException, InterruptedException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();

    final FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();

    Assertions.assertTrue(pcm.listPackages().isEmpty());

    //Now sneak in a new lock file and directory:
    File lockFile = ManagedFileAccess.file(pcmPath, "example.fhir.uv.myig#1.2.3.lock");
    lockFile.createNewFile();
    File directory = ManagedFileAccess.file(pcmPath, "example.fhir.uv.myig#1.2.3" );
    directory.mkdir();

    IOException exception = assertThrows(IOException.class, () -> pcm.loadPackageFromCacheOnly("example.fhir.uv.myig", "1.2.3"));
    assertThat(exception.getMessage()).contains("Lock file exists, but is not locked by a process");
  }

  @Test
  //@EnabledOnOs(OS.LINUX)
  public void testCacheCleanupForUnlockedLockFiles() throws IOException, InterruptedException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();

    final FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();

    Assertions.assertTrue(pcm.listPackages().isEmpty());

    String packageAndVersion = "example.fhir.uv.myig#1.2.3";
    String lockFileName = packageAndVersion + ".lock";
    //Now sneak in a new lock file and directory:
    File lockFile = ManagedFileAccess.file(pcmPath, lockFileName);
    lockFile.createNewFile();
    File directory = ManagedFileAccess.file(pcmPath, packageAndVersion);
    directory.mkdir();

    // We can't create a lock file from within the same JVM, so we have to use the flock utility, which is OS dependent.
    // The following works for Linux only.
    ProcessBuilder processBuilder = new ProcessBuilder("flock", lockFileName, "--command", "sleep 10");
    processBuilder.directory(new File(pcmPath));
    processBuilder.start();

    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    executorService.schedule(()->{
      try {
        Utilities.clearDirectory(directory.getAbsolutePath());
        directory.delete();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      lockFile.delete();
    }, 15, TimeUnit.SECONDS);

    IOException ioException = assertThrows(IOException.class, () -> { pcm.loadPackageFromCacheOnly("example.fhir.uv.myig", "1.2.3"); });


    ioException.printStackTrace();


  }

  /**
    We repeat the same tests multiple times here, in order to catch very rare edge cases.
   */
  public static Stream<Arguments> packageCacheMultiThreadTestParams() {
    List<Arguments> params = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      params.add(Arguments.of(100, 1));
      params.add(Arguments.of(10,10));
      params.add(Arguments.of(100, 10));
    }
    return params.stream();
  }

  @MethodSource("packageCacheMultiThreadTestParams")
  @ParameterizedTest
  public void packageCacheMultiThreadTest(final int threadTotal, final int packageCacheManagerTotal) throws IOException {

    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();
    FilesystemPackageCacheManager[] packageCacheManagers = new FilesystemPackageCacheManager[packageCacheManagerTotal];
    Random rand = new Random();

    final AtomicInteger totalSuccessful = new AtomicInteger();
    final ConcurrentHashMap<Long, Integer> successfulThreads = new ConcurrentHashMap<>();
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < threadTotal; i++) {
      final int index = i;
      Thread t = new Thread(() -> {
        try {
          System.out.println("Thread #" + index + ": " + Thread.currentThread().getId() + " started");
          final int randomPCM = rand.nextInt(packageCacheManagerTotal);
          final int randomOperation = rand.nextInt(4);
          final String operationName;
          if (packageCacheManagers[randomPCM] == null) {
            packageCacheManagers[randomPCM] = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();
          }
          FilesystemPackageCacheManager pcm = packageCacheManagers[randomPCM];
          if (randomOperation == 0) {
            operationName = "addPackageToCache";
            pcm.addPackageToCache("example.fhir.uv.myig", "1.2.3", this.getClass().getResourceAsStream("/npm/dummy-package.tgz"), "https://packages.fhir.org/example.fhir.uv.myig/1.2.3");
          } else if (randomOperation == 1) {
            operationName = "clear";
            pcm.clear();
          } else if (randomOperation == 2) {
            operationName = "loadPackageFromCacheOnly";
            pcm.loadPackageFromCacheOnly("example.fhir.uv.myig", "1.2.3");
          } else {
            operationName = "removePackage";
            pcm.removePackage("example.fhir.uv.myig", "1.2.3");
          }
          totalSuccessful.incrementAndGet();
          successfulThreads.put(Thread.currentThread().getId(), index);
          System.out.println("Thread #" + index + ": " + Thread.currentThread().getId() + " completed. Ran: " + operationName);
        } catch (Exception e) {
          e.printStackTrace();
          System.err.println("Thread #" + index + ": " + Thread.currentThread().getId() + " failed");
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

    printUnsuccessfulThreads(successfulThreads, threads);
    assertEquals(threadTotal, totalSuccessful.get(), "Not all threads were successful.");

  }

  private void printUnsuccessfulThreads(final ConcurrentHashMap successfulThreads, List<Thread> threads) {
    for (Thread t : threads) {
      if (!successfulThreads.containsKey(t.getId())) {
        System.out.println("Thread #" + t.getId() + " failed");
      }
    }
  }
}
