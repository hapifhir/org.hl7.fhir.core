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

  /**
   * A lock file that has gone (whoever held it finished) isn't left over, and looking for it doesn't make it again: a
   * lock file no process holds makes the package look like an incomplete install (and it gets deleted), and makes
   * every read of the package fail
   */
  @Test
  void testWhenLockFileIsGone_canLockFileBeHeldByThisProcessIsFalseAndDoesNotMakeIt() throws IOException {
    File lockFile = getPackageLockFile();
    Assertions.assertFalse(lockFile.exists());
    Assertions.assertFalse(filesystemPackageCacheLockManager.getCacheLock().canLockFileBeHeldByThisProcess(lockFile));
    Assertions.assertFalse(lockFile.exists());
  }

  @Test
  void testOpeningALockFileThatIsGoneDoesNotMakeIt() throws IOException {
    File lockFile = getPackageLockFile();
    Assertions.assertNull(FilesystemPackageCacheManagerLocks.openExistingLockFile(lockFile));
    Assertions.assertFalse(lockFile.exists());
    lockFile.createNewFile();
    try (java.nio.channels.FileChannel channel = FilesystemPackageCacheManagerLocks.openExistingLockFile(lockFile)) {
      Assertions.assertNotNull(channel);
    }
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

  /**
   * Another process holds the lock (installing the same package, say), and moves the lock file away when it's done
   * with it. The write that was waiting must then lock the lock file, not the file that was moved away
   */
  @Test
  void testWriteWhenLockedByAnotherProcess() throws InterruptedException, TimeoutException, IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    final File lockFile = getPackageLockFile();

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, lockFile.getName(), 3);
    LockfileTestUtility.waitForLockfileCreation(cachePath, lockFile.getName());

    String result = packageLock.doWriteWithLock(() -> {
      assertThat(lockFile).exists();
      return "done";
    }, new FilesystemPackageCacheManagerLocks.LockParameters(20L, TimeUnit.SECONDS));

    assertThat(result).isEqualTo("done");
    assertThat(lockFile).doesNotExist();
    lockThread.join();
    // and the package can be written again
    packageLock.doWriteWithLock(() -> null, null);
  }

  /** if what the write does fails, the locks are still released, so the package can be used again */
  @Test
  void testWriteThatFailsReleasesTheLocks() throws IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    assertThrows(IOException.class, () -> packageLock.doWriteWithLock(() -> {
      throw new IOException("failed");
    }, null));
    assertThat(getPackageLockFile()).doesNotExist();
    packageLock.doWriteWithLock(() -> null, null);
    filesystemPackageCacheLockManager.getCacheLock().doWriteWithLock(() -> null);
  }

  /**
   * The other process moves the lock file away before it releases it, so a write that was waiting finds the file it
   * has open still locked: it has to try again with the lock file that's there now, not give up
   */
  @Test
  void testWriteWhenTheMovedLockFileIsStillLocked() throws InterruptedException, TimeoutException, IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    final File lockFile = getPackageLockFile();

    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, lockFile.getName(), 2, 3);
    LockfileTestUtility.waitForLockfileCreation(cachePath, lockFile.getName());

    String result = packageLock.doWriteWithLock(() -> {
      assertThat(lockFile).exists();
      return "done";
    }, new FilesystemPackageCacheManagerLocks.LockParameters(20L, TimeUnit.SECONDS));

    assertThat(result).isEqualTo("done");
    lockThread.join();
    packageLock.doWriteWithLock(() -> null, null);
  }

  /**
   * A read that finds a lock file no process holds (an install that didn't finish) fails - and releases the locks it
   * took, or no write in this process could ever happen again
   */
  @Test
  void testReadThatFailsReleasesTheLocks() throws IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = getPackageLockFile();
    Files.writeString(lockFile.toPath(), "left behind");
    IOException e = assertThrows(IOException.class, () -> packageLock.doReadWithLock(() -> null, null));
    assertThat(e.getMessage()).contains("not locked by a process");
    Files.delete(lockFile.toPath());
    Assertions.assertTimeoutPreemptively(java.time.Duration.ofSeconds(10), () -> {
      packageLock.doWriteWithLock(() -> null, null);
      filesystemPackageCacheLockManager.getCacheLock().doWriteWithLock(() -> null);
    });
  }

  /** a read that times out waiting for the lock file also releases its locks */
  @Test
  void testReadThatTimesOutReleasesTheLocks() throws InterruptedException, TimeoutException, IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = getPackageLockFile();
    Thread lockThread = LockfileTestProcessUtility.lockWaitAndDeleteInNewProcess(cachePath, lockFile.getName(), 3);
    LockfileTestUtility.waitForLockfileCreation(cachePath, lockFile.getName());
    assertThrows(IOException.class, () -> packageLock.doReadWithLock(() -> null, new FilesystemPackageCacheManagerLocks.LockParameters(1L, TimeUnit.SECONDS)));
    lockThread.join();
    Assertions.assertTimeoutPreemptively(java.time.Duration.ofSeconds(10), () -> {
      packageLock.doWriteWithLock(() -> null, null);
    });
  }

  /** the lock file says which process holds it */
  @Test
  void testTheLockFileHasTheProcessId() throws IOException {
    final FilesystemPackageCacheManagerLocks.PackageLock packageLock = filesystemPackageCacheLockManager.getPackageLock(DUMMY_PACKAGE);
    File lockFile = getPackageLockFile();
    // left by a process that died: what's in it is replaced
    Files.writeString(lockFile.toPath(), "99999999999 left behind");
    String content = packageLock.doWriteWithLock(() -> Files.readString(lockFile.toPath()), null);
    assertThat(content).isEqualTo(String.valueOf(ProcessHandle.current().pid()));
  }

  private File getPackageLockFile() {
    return Path.of(cachePath, DUMMY_PACKAGE + ".lock").toFile();
  }

}
