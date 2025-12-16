package org.hl7.fhir.utilities.npm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
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
  public static final String CURRENT_PACKAGE_CACHE_VERSION = "4";
  private final List<PackageServer> dummyPrivateServers = List.of(
     new PackageServer(DUMMY_URL_1),
     new PackageServer(DUMMY_URL_2)
  );

  private final List<PackageServer> dummyDefaultServers = List.of(
    new PackageServer(DUMMY_URL_3),
    new PackageServer(DUMMY_URL_4)
  );

  @Test
  void testDefaultServers() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = getFilesystemPackageCacheManager(false);

    assertEquals(4, filesystemPackageCacheManager.myPackageServers.size());
    assertEquals(DUMMY_URL_1, filesystemPackageCacheManager.myPackageServers.get(0).getUrl());
    assertEquals(DUMMY_URL_2, filesystemPackageCacheManager.myPackageServers.get(1).getUrl());
    assertEquals(DUMMY_URL_3, filesystemPackageCacheManager.myPackageServers.get(2).getUrl());
    assertEquals(DUMMY_URL_4, filesystemPackageCacheManager.myPackageServers.get(3).getUrl());
  }

  @Test
  void testIgnoreDefaultServers() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = getFilesystemPackageCacheManager(true);

    assertEquals(2, filesystemPackageCacheManager.myPackageServers.size());
    assertEquals(DUMMY_URL_1, filesystemPackageCacheManager.myPackageServers.get(0).getUrl());
    assertEquals(DUMMY_URL_2, filesystemPackageCacheManager.myPackageServers.get(1).getUrl());
  }

  @Nonnull
  private FilesystemPackageCacheManager getFilesystemPackageCacheManager(final boolean ignoreDefaultPackageServers) throws IOException {

    FilesystemPackageCacheManager.Builder builder = new FilesystemPackageCacheManager.Builder() {
      @Override
      protected boolean isIgnoreDefaultPackageServers() {
        return ignoreDefaultPackageServers;
      }

      @Override
      @Nonnull
      protected List<PackageServer> getDefaultServers() {
        return dummyDefaultServers;
      }

      @Override
      protected List<PackageServer> getConfiguredServers() {
        return dummyPrivateServers;
      }
    };

    return builder.build();

  }

  @Test
  void testUserCacheDirectory() throws IOException {
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().build();
    assertEquals(System.getProperty("user.home") + File.separator + ".fhir" + File.separator + "packages", filesystemPackageCacheManager.getFolder());
  }

  /*
    Targeted folder will only be valid on -nix style systems.
   */
  @Test
  @DisabledOnOs(OS.WINDOWS)
  void testSystemCacheDirectory() throws IOException {
    File folder = new FilesystemPackageCacheManager.Builder().withSystemCacheFolder().getCacheFolder();
    assertEquals( "/var/lib/.fhir/packages", folder.getAbsolutePath());
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void testSystemCacheDirectoryWin() throws IOException {
    File folder = new FilesystemPackageCacheManager.Builder().withSystemCacheFolder().getCacheFolder();
    assertEquals( System.getenv("ProgramData") + "\\.fhir\\packages", folder.getAbsolutePath());
  }

  @Test
  void testCorruptPackageCleanup() throws IOException {
    File cacheDirectory = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest"));

    File dummyPackage = createDummyPackage(cacheDirectory, "example.fhir.uv.myig", "1.2.3");
    File dummyLockFile = createDummyLockFile(cacheDirectory, "example.fhir.uv.myig" , "1.2.3");

    assertThat(dummyPackage).isDirectory();
    assertThat(dummyPackage).exists();
    assertThat(dummyLockFile).exists();

    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().withCacheFolder(cacheDirectory.getAbsolutePath()).build();

    assertThat(dummyPackage).doesNotExist();
    assertThat(dummyLockFile).doesNotExist();
  }

  @Test
  void testLockedPackageIsntCleanedUp() throws IOException, InterruptedException, TimeoutException {
    File cacheDirectory = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest"));

    File dummyPackage = createDummyPackage(cacheDirectory, "example.fhir.uv.myig", "1.2.3");

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cacheDirectory.getAbsolutePath(), "example.fhir.uv.myig#1.2.3.lock", 2);

    LockfileTestUtility.waitForLockfileCreation(cacheDirectory.getAbsolutePath(), "example.fhir.uv.myig#1.2.3.lock");
    File dummyLockFile = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "example.fhir.uv.myig#1.2.3.lock");

    assertThat(dummyPackage).isDirectory();
    assertThat(dummyPackage).exists();
    assertThat(dummyLockFile).exists();

    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().withCacheFolder(cacheDirectory.getAbsolutePath()).build();

    assertThat(dummyPackage).exists();
    assertThat(dummyLockFile).exists();

    lockThread.join();
  }

  @Test
  void testTimeoutForLockedPackageRead() throws IOException, InterruptedException, TimeoutException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();

    final FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder()
      .withCacheFolder(pcmPath)
      .withLockParameters(new FilesystemPackageCacheManagerLocks.LockParameters(5,TimeUnit.SECONDS))
      .build();

    Assertions.assertTrue(pcm.listPackages().isEmpty());

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(pcmPath, "example.fhir.uv.myig#1.2.3.lock", 10);
    File directory = ManagedFileAccess.file(pcmPath, "example.fhir.uv.myig#1.2.3" );
    directory.mkdir();

    LockfileTestUtility.waitForLockfileCreation(pcmPath, "example.fhir.uv.myig#1.2.3.lock");

    IOException exception = assertThrows(IOException.class, () -> pcm.loadPackageFromCacheOnly("example.fhir.uv.myig", "1.2.3"));

    assertThat(exception.getMessage()).contains("Package cache timed out waiting for lock");
    assertThat(exception.getCause().getMessage()).contains("Timeout waiting for lock file deletion");
    lockThread.join();
  }

  @Test
  void testReadFromCacheOnlyWaitsForLockDelete() throws IOException, InterruptedException, TimeoutException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();

    final FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();

    Assertions.assertTrue(pcm.listPackages().isEmpty());

    pcm.addPackageToCache("example.fhir.uv.myig", "1.2.3", this.getClass().getResourceAsStream("/npm/dummy-package.tgz"), "https://packages.fhir.org/example.fhir.uv.myig/1.2.3");

    String packageAndVersion = "example.fhir.uv.myig#1.2.3";

    //Now sneak in a new lock file and directory:

    File directory = ManagedFileAccess.file(pcmPath, packageAndVersion);
    directory.mkdir();

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(pcmPath, "example.fhir.uv.myig#1.2.3.lock", 5);
    LockfileTestUtility.waitForLockfileCreation(pcmPath, "example.fhir.uv.myig#1.2.3.lock");

    NpmPackage npmPackage = pcm.loadPackageFromCacheOnly("example.fhir.uv.myig", "1.2.3");

    assertThat(npmPackage.id()).isEqualTo("example.fhir.uv.myig");

    lockThread.join();
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

  private File createDummyTemp(File cacheDirectory, String lowerCase) throws IOException {
    return createDummyPackage(cacheDirectory, lowerCase);
  }

  private File createDummyPackage(File cacheDirectory, String packageName, String packageVersion) throws IOException {
    String directoryName = packageName + "#" + packageVersion;
    return createDummyPackage(cacheDirectory, directoryName);
  }

  private static File createDummyPackage(File cacheDirectory, String directoryName) throws IOException {
    File packageDirectory = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), directoryName);
    packageDirectory.mkdirs();

    File dummyContentFile = ManagedFileAccess.file(packageDirectory.getAbsolutePath(), "dummy.txt");
    FileWriter wr = new FileWriter(dummyContentFile);
    wr.write("Ain't nobody here but us chickens");
    wr.flush();
    wr.close();
    return packageDirectory;
  }

  private File createDummyLockFile(File cacheDirectory, String packageName, String packageVersion) throws IOException {
    final File dummyLockFile = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), packageName + "#" + packageVersion + ".lock");
    final FileWriter wr = new FileWriter(dummyLockFile);
    wr.write("Ain't nobody here but us chickens");
    wr.flush();
    wr.close();
    return dummyLockFile;
  }

  private void assertThatDummyTempExists(File cacheDirectory, String dummyTempPackage) throws IOException {
    File dummyTempDirectory = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), dummyTempPackage);
    assertThat(dummyTempDirectory).exists();

    File dummyContentFile = ManagedFileAccess.file(dummyTempDirectory.getAbsolutePath(), "dummy.txt");
    assertThat(dummyContentFile).exists();
  }

  @Test
  void testCreatesIniIfDoesntExistAndCacheStaysIntact() throws IOException {
    File cacheDirectory = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest"));
    File cacheIni = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "packages.ini");

    createDummyPackage(cacheDirectory, "example.fhir.uv.myig", "1.2.3");

    String dummyTempPackage = UUID.randomUUID().toString().toLowerCase();
    createDummyTemp(cacheDirectory, dummyTempPackage);
    assertThatDummyTempExists(cacheDirectory, dummyTempPackage);

    assertThat(cacheIni).doesNotExist();
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().withCacheFolder(cacheDirectory.getAbsolutePath()).build();
    assertInitializedTestCacheIsValid(cacheDirectory, true);
  }



  @Test
  void testClearsCacheIfVersionIsWrong() throws IOException {
    File cacheDirectory = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest"));
    File cacheIni = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "packages.ini");

    createDummyPackage(cacheDirectory, "example.fhir.uv.myig", "1.2.3");
    String dummyTempPackage = UUID.randomUUID().toString().toLowerCase();
    createDummyTemp(cacheDirectory, dummyTempPackage);
    assertThatDummyTempExists(cacheDirectory, dummyTempPackage);


    IniFile ini = new IniFile(cacheIni.getAbsolutePath());
    ini.setStringProperty("cache", "version", "2", null);
    ini.save();

    assertThat(cacheIni).exists();
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().withCacheFolder(cacheDirectory.getAbsolutePath()).build();
    assertInitializedTestCacheIsValid(cacheDirectory, false);
  }

  @Test
  void testCacheStaysIntactIfVersionIsTheSame() throws IOException {
    File cacheDirectory = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest"));
    File cacheIni = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "packages.ini");

    createDummyPackage(cacheDirectory, "example.fhir.uv.myig", "1.2.3");
    String dummyTempPackage = UUID.randomUUID().toString().toLowerCase();
    createDummyTemp(cacheDirectory, dummyTempPackage);
    assertThatDummyTempExists(cacheDirectory, dummyTempPackage);


    IniFile ini = new IniFile(cacheIni.getAbsolutePath());
    ini.setStringProperty("cache", "version", CURRENT_PACKAGE_CACHE_VERSION, null);
    ini.save();

    assertThat(cacheIni).exists();
    FilesystemPackageCacheManager filesystemPackageCacheManager = new FilesystemPackageCacheManager.Builder().withCacheFolder(cacheDirectory.getAbsolutePath()).build();
    assertInitializedTestCacheIsValid(cacheDirectory, true);
  }

  private void assertInitializedTestCacheIsValid(File cacheDirectory, boolean dummyPackageShouldExist) throws IOException {
    assertThat(cacheDirectory).exists();
    File iniFile = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "packages.ini");
    assertThat(ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "packages.ini")).exists();
    IniFile ini = new IniFile(iniFile.getAbsolutePath());
    String version = ini.getStringProperty("cache", "version");
    assertThat(version).isEqualTo(CURRENT_PACKAGE_CACHE_VERSION);

    File[] files = cacheDirectory.listFiles();
    if (dummyPackageShouldExist) {
      // Check that only packages.ini and our dummy package are in the cache. Our previous temp should be deleted.
      assertThat(files).hasSize(2); // packages.ini and example.fhir.uv.myig#1.2.3 (directory)

      File dummyPackage = ManagedFileAccess.file(cacheDirectory.getAbsolutePath(), "example.fhir.uv.myig#1.2.3");
      assertThat(dummyPackage).exists();

      File dummyContentFile = ManagedFileAccess.file(dummyPackage.getAbsolutePath(), "dummy.txt");
      assertThat(dummyContentFile).exists();
    } else {
      // Check that only packages.ini is in the cache.
      assertThat(files).hasSize(1);
    }
  }

  @Test
  void generatesIndexWhenMissing() throws IOException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();

    final FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().withCacheFolder(pcmPath).build();

    Assertions.assertTrue(pcm.listPackages().isEmpty());

    NpmPackage npmPackage = pcm.addPackageToCache("example.fhir.uv.myig", "1.2.3", this.getClass().getResourceAsStream("/npm/dummy-package-no-index.tgz"), "https://packages.fhir.org/example.fhir.uv.myig/1.2.3");
    /*FIXME this is not correct. If this is switched to assertThat(...).isTrue, the assert works correctly, but proves
      that isIndexed is in fact broken.
    */
    Assertions.assertTrue(npmPackage.isIndexed());
  }

  @MethodSource("packageCacheMultiThreadTestParams")
  @ParameterizedTest
  @Timeout(120)
  void packageCacheMultiThreadTest(final int threadTotal, final int packageCacheManagerTotal) throws IOException {
    String pcmPath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();
    System.out.println("Using temp pcm path: " + pcmPath);
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

  private void printUnsuccessfulThreads(final ConcurrentHashMap<Long, Integer> successfulThreads, List<Thread> threads) {
    for (Thread t : threads) {
      if (!successfulThreads.containsKey(t.getId())) {
        System.out.println("Thread #" + t.getId() + " failed");
      }
    }
  }
}
