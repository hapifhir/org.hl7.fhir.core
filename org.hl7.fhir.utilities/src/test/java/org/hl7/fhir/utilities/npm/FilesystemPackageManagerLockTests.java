package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilesystemPackageManagerLockTests {

  public static final String DUMMY_PACKAGE = "dummy#1.2.3";
  String cachePath;
  File cacheDirectory;
  FilesystemPackageCacheManagerLocks filesystemPackageCacheLockManager;


  @BeforeEach
  void setUp() throws IOException {
    cachePath = ManagedFileAccess.fromPath(Files.createTempDirectory("fpcm-multithreadingTest")).getAbsolutePath();
    cacheDirectory = new File(cachePath);
    filesystemPackageCacheLockManager = new FilesystemPackageCacheManagerLocks(cacheDirectory);

  }

  @Test
  void testBaseCases() throws IOException {
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
    }, null);
    assertThat(packageLock.getLockFile()).doesNotExist();

    packageLock.doReadWithLock(() -> {
      assertThat(packageLock.getLockFile()).doesNotExist();
      return null;
    }, null);
  }

  @Test
  void testNoPackageWriteOrReadWhileWholeCacheIsLocked() throws IOException, InterruptedException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);

    AtomicBoolean cacheLockFinished = new AtomicBoolean(false);
    List<Thread> threadList = new ArrayList<>();

    Thread cacheThread = new Thread(() -> {
      try {
        filesystemPackageCacheLockManager.getCacheLock().doWriteWithLock(() -> {
          try {
            Thread.sleep(300);
            cacheLockFinished.set(true);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          return null;
        });
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    cacheThread.start();
    Thread.sleep(100);
    for (int i = 0; i < 5; i++) {
      threadList.add(new Thread(() -> {
        try {
          packageLock.doWriteWithLock(() -> {
            assertThat(cacheLockFinished.get()).isTrue();
            return null;
          }, null);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }));
      threadList.add(new Thread(() -> {
        try {
          packageLock.doReadWithLock(() -> {
            assertThat(cacheLockFinished.get()).isTrue();
            return null;
          }, null);
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
  }

  @Test
  void testWhenLockIsntHeld_canLockFileBeHeldByThisProcessIsTrue() throws IOException {
    File lockFile = getPackageLockFile();
    lockFile.createNewFile();
    Assertions.assertTrue(filesystemPackageCacheLockManager.getCacheLock().canLockFileBeHeldByThisProcess(lockFile));
  }

  @Test
  void testWhenLockIsHelp_canLockFileBeHeldByThisProcessIsFalse() throws InterruptedException, TimeoutException, IOException {
    File lockFile = getPackageLockFile();
    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, DUMMY_PACKAGE + ".lock", 2);

    LockfileTestUtility.waitForLockfileCreation(cacheDirectory.getAbsolutePath(), DUMMY_PACKAGE + ".lock");

    Assertions.assertFalse(filesystemPackageCacheLockManager.getCacheLock().canLockFileBeHeldByThisProcess(lockFile));

    lockThread.join();
  }

  @Test
  void testSinglePackageWriteMultiPackageRead() throws IOException {
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
          }, null);
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
          }, null);
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
  void testReadWhenLockedByFileTimesOut() throws InterruptedException, TimeoutException, IOException {
    FilesystemPackageCacheManagerLocks shorterTimeoutManager = filesystemPackageCacheLockManager;
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = shorterTimeoutManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = getPackageLockFile();
    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, lockFile.getName(), 5);
    LockfileTestUtility.waitForLockfileCreation(cachePath,lockFile.getName());

    Exception exception = assertThrows(
      IOException.class,
      () -> packageLock.doReadWithLock(
        () -> {
          assertThat(lockFile).exists();
          return null;
          },
        new FilesystemPackageCacheManagerLocks.LockParameters(3L, TimeUnit.SECONDS)
      )
    );

    assertThat(exception.getMessage()).contains("Package cache timed out waiting for lock");
    assertThat(exception.getCause().getMessage()).contains("Timeout waiting for lock file deletion: " + lockFile.getName());

    lockThread.join();
  }


  @Test
  void testReadWhenLockFileIsDeleted() throws InterruptedException, TimeoutException, IOException {

    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);

    final File lockFile = getPackageLockFile();

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, lockFile.getName(), 5);
    LockfileTestUtility.waitForLockfileCreation(cachePath,lockFile.getName());

    packageLock.doReadWithLock(() -> {
      assertThat(lockFile).doesNotExist();
      return null;
    }, new FilesystemPackageCacheManagerLocks.LockParameters(10L, TimeUnit.SECONDS));

    lockThread.join();
  }

  private File getPackageLockFile() {
    return Path.of(cachePath, DUMMY_PACKAGE + ".lock").toFile();
  }

}
