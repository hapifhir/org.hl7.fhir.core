package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilesystemPackageManagerLockTests {

  public static final String DUMMY_PACKAGE = "dummy#1.2.3";
  String cachePath;
  File cacheDirectory;
  FilesystemPackageCacheManagerLocks filesystemPackageCacheLockManager;


  @BeforeEach
  public void setUp() throws IOException {
    cachePath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();
    cacheDirectory = new File(cachePath);
    filesystemPackageCacheLockManager = new FilesystemPackageCacheManagerLocks(cacheDirectory);

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


    final  FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
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

  @Test void testSinglePackageWriteMultiPackageRead() throws IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    AtomicInteger writeCounter = new AtomicInteger(0);

    AtomicInteger readCounter = new AtomicInteger(0);
    List<Thread> threadList = new ArrayList<>();

    AtomicInteger maxReadThreads = new AtomicInteger();

    for (int i = 0; i < 10; i++) {
     threadList.add(new Thread(() -> {
        try {
          packageLock.doWriteWithLock(() -> {
            int writeCount = writeCounter.incrementAndGet();
            assertThat(writeCount).isEqualTo(1);
            writeCounter.decrementAndGet();
            return null;
          });
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }));
    }

    for (int i = 0; i < 10; i++) {
      threadList.add(new Thread(() -> {
        try {
          packageLock.doReadWithLock(() -> {
            int readCount = readCounter.incrementAndGet();
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
            assertThat(readCount).isGreaterThan(0);
            if (readCount > maxReadThreads.get()) {
              maxReadThreads.set(readCount);
            }
            readCounter.decrementAndGet();
            return null;
          });
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }));
    }

    for (Thread thread: threadList) {
      thread.start();
    }

    for (Thread thread: threadList) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    assertThat(maxReadThreads.get()).isGreaterThan(1);
  }

  @Test
  public void testReadWhenLockedByFileTimesOut() throws IOException {
    FilesystemPackageCacheManagerLocks shorterTimeoutManager = filesystemPackageCacheLockManager.withLockTimeout(3L, TimeUnit.SECONDS);
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = shorterTimeoutManager.getPackageLock(DUMMY_PACKAGE);
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
    FilesystemPackageCacheManagerLocks shorterTimeoutManager = filesystemPackageCacheLockManager.withLockTimeout(5L, TimeUnit.SECONDS);
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = shorterTimeoutManager.getPackageLock(DUMMY_PACKAGE);
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
