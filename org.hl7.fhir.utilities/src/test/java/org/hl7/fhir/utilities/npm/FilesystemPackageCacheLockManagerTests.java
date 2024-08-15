package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilesystemPackageCacheLockManagerTests {

  public static final String DUMMY_PACKAGE = "dummy#1.2.3";
  String cachePath;
  File cacheDirectory;
  FilesystemPackageCacheLockManager filesystemPackageCacheLockManager;


  @BeforeEach
  public void setUp() throws IOException {
    cachePath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();
    cacheDirectory = new File(cachePath);
    filesystemPackageCacheLockManager = new FilesystemPackageCacheLockManager(cacheDirectory);

  }

  @Test
  public void testBaseCases() throws IOException {
    filesystemPackageCacheLockManager.getCacheLock().doWriteWithLock(() -> {
      assertThat(cacheDirectory).exists();
      assertThat(cacheDirectory).isDirectory();
      assertThat(cacheDirectory).canWrite();
      assertThat(cacheDirectory).canRead();
      return null;
    });


    final  FilesystemPackageCacheLockManager.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    packageLock.doWriteWithLock(() -> {
      assertThat(packageLock.getLockFile()).exists();
      return null;
    });
    assertThat(packageLock.getLockFile()).doesNotExist();

    packageLock.doReadWithLock(() -> {
      assertThat(packageLock.getLockFile()).doesNotExist();
      return null;
    });
  }

  @Test
  public void testReadWhenLockedByFileTimesOut() throws IOException {
    FilesystemPackageCacheLockManager shorterTimeoutManager = filesystemPackageCacheLockManager.withLockTimeout(3L, TimeUnit.SECONDS);
    final FilesystemPackageCacheLockManager.PackageLock packageLock = shorterTimeoutManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = createPackageLockFile();

    Exception exception = assertThrows(IOException.class, () -> {
      packageLock.doReadWithLock(() -> {
        assertThat(lockFile).exists();
        return null;
      });
    });

    assertThat(exception.getMessage()).contains("Error reading package");
    assertThat(exception.getCause().getMessage()).contains("Timeout waiting for lock file deletion: " + lockFile.getName());
  }

  @Test
  public void testReadWhenLockFileIsDeleted() throws IOException {
    FilesystemPackageCacheLockManager shorterTimeoutManager = filesystemPackageCacheLockManager.withLockTimeout(5L, TimeUnit.SECONDS);
    final FilesystemPackageCacheLockManager.PackageLock packageLock = shorterTimeoutManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = createPackageLockFile();

    Thread t = new Thread(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      lockFile.delete();
    });
    t.start();

    packageLock.doReadWithLock(() -> {
      assertThat(lockFile).doesNotExist();
      return null;
    });

  }

  private File createPackageLockFile() throws IOException {
    File lockFile = Path.of(cachePath, DUMMY_PACKAGE + ".lock").toFile();
    TextFile.stringToFile("", lockFile);
    return lockFile;
  }

}
