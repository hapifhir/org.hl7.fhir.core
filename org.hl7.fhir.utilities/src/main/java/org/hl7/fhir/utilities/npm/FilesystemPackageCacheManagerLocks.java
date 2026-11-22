package org.hl7.fhir.utilities.npm;

import lombok.Getter;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class FilesystemPackageCacheManagerLocks {

  private static final ConcurrentHashMap<File, FilesystemPackageCacheManagerLocks> cacheFolderLockManagers = new ConcurrentHashMap<>();
  public static final String LOCKFILE_EXTENSION = ".lock";
  private static final String LOCK_DELETION_EXTENSION = ".lock-deletion";

  @Getter
  private final CacheLock cacheLock = new CacheLock();

  private final ConcurrentHashMap<File, PackageLock> packageLocks = new ConcurrentHashMap<>();

  private final File cacheFolder;

  private static final LockParameters lockParameters = new LockParameters();

  public static class LockParameters {
    @Getter @With
    private final long lockTimeoutTime;
    @Getter @With
    private final TimeUnit lockTimeoutTimeUnit;

    public LockParameters() {
      this(60L, TimeUnit.SECONDS);
    }

    public LockParameters(long lockTimeoutTime, TimeUnit lockTimeoutTimeUnit) {
      this.lockTimeoutTime = lockTimeoutTime;
      this.lockTimeoutTimeUnit = lockTimeoutTimeUnit;
    }
  }

  /**
   * This method is intended to be used only for testing purposes.
   * <p/>
   * To ensure that only one instance of the FilesystemPackageCacheManagerLocks is created for a given cacheFolder, use
   * the static org.hl7.fhir.utilities.npm.FilesystemPackageCacheManagerLocks#getFilesystemPackageCacheManagerLocks(java.io.File) method.
   * <p/>
   * Get all the locks necessary to manage a filesystem cache.
   *
   * @param cacheFolder
   * @throws IOException
   */
  public FilesystemPackageCacheManagerLocks(File cacheFolder) throws IOException {
    this.cacheFolder = cacheFolder;
  }


  /**
   * Returns a single FilesystemPackageCacheManagerLocks instance for the given cacheFolder.
   * <p/>
   * If an instance already exists, it is returned. Otherwise, a new instance is created.
   * <p/>
   * Using this method ensures that only one instance of FilesystemPackageCacheManagerLocks is created for a given
   * cacheFolder, which is useful if multiple ValidationEngine instances are running in parallel.
   *
   * @param cacheFolder
   * @return
   * @throws IOException
   */
  public static FilesystemPackageCacheManagerLocks getFilesystemPackageCacheManagerLocks(File cacheFolder) throws IOException {
    return cacheFolderLockManagers.computeIfAbsent(cacheFolder, k -> {
      try {
        return new FilesystemPackageCacheManagerLocks(k);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

  public class CacheLock {
    private final ReadWriteLock lock;

    protected CacheLock() {
      lock = new ReentrantReadWriteLock();
    }

    public ReadWriteLock getLock() {
      return lock;
    }

    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> function) throws IOException {
      lock.writeLock().lock();
      T result = null;
      try {
        result = function.get();
      } finally {
        lock.writeLock().unlock();
      }
      return result;
    }

    /**
     * Whether a lock file is left over: no process holds it. False if it has gone (whoever held it has finished, and
     * moved it away): it isn't made again by looking at it - a lock file no process holds would make the package look
     * like an incomplete install, and it would be deleted
     */
    public boolean canLockFileBeHeldByThisProcess(File lockFile) throws IOException {
      return doWriteWithLock(() -> {
      try (FileChannel channel = openExistingLockFile(lockFile)) {
        if (channel == null) {
          return false;
        }
        Object opened = fileKey(lockFile);
        FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
        if (fileLock != null) {
          fileLock.release();
          // the process that held it may have moved it away and released it while we waited: then it's not left over
          return isStillTheLockFile(lockFile, opened);
        }
      } catch (FileSystemException e) {
        logSystemSpecificFileSystemException(e);
      }
      return false;});
    }
  }

  public class PackageLock {
    @Getter
    private final File lockFile;
    private final ReadWriteLock lock;

    protected PackageLock(File lockFile, ReadWriteLock lock) {
      this.lockFile = lockFile;
      this.lock = lock;
    }

    private void checkForLockFileWaitForDeleteIfExists(File lockFile, @Nonnull LockParameters lockParameters) throws IOException {
      if (!lockFile.exists()) {
        log.debug("checked for lockFile: does not exist");
        return;
      }

      // Check if the file is locked by a process. If it is not, it is likely an incomplete package cache install, and
      // we should throw an exception.
      if (lockFile.isFile()) {
        // not made if it isn't there: it can go between the check above and here, and making it again would leave a
        // lock file no process holds, which every reader after this would refuse (until a write cleared it)
        try (FileChannel channel = openExistingLockFile(lockFile)) {
          if (channel == null) {
            log.debug("checked for lockFile: gone");
            return;
          }
          Object opened = fileKey(lockFile);
          FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
          if (fileLock != null) {
            fileLock.release();
            if (isStillTheLockFile(lockFile, opened)) {
              throw new IOException("Lock file exists, but is not locked by a process: " + lockFile.getName());
            }
            // the process that held it moved it away and released it while we looked: wait for whatever is there now
          } else {
            log.debug("File is locked ('" + lockFile.getAbsolutePath() + "').");
          }
        } catch (FileSystemException e) {
          logSystemSpecificFileSystemException(e);
        }
      }
      try {
        waitForLockFileDeletion(lockFile, lockParameters);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Thread interrupted while waiting for lock", e);
      }
    }

    /*
     Wait for the lock file to be deleted. If the lock file is not deleted within the timeout or if the thread is
     interrupted, an IOException is thrown.
     */
    private void waitForLockFileDeletion(File lockFile, @Nonnull LockParameters lockParameters) throws IOException, InterruptedException {
      log.debug("waiting for lockFile deletion: " + lockFile.getName());
      long deadline = System.nanoTime() + lockParameters.lockTimeoutTimeUnit.toNanos(lockParameters.lockTimeoutTime);
      try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
        Path dir = lockFile.getParentFile().toPath();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);
        // other files in the folder are deleted too (another process renaming the package it just installed into
        // place, say), so keep waiting until it's this one that's gone. The watch only says something was deleted:
        // whether the lock file still exists is what's checked. And it may have gone before the watch started
        while (lockFile.exists()) {
          long left = deadline - System.nanoTime();
          if (left <= 0) {
            throw new TimeoutException("Timeout waiting for lock file deletion: " + lockFile.getName());
          }
          WatchKey key = watchService.poll(Math.min(left, TimeUnit.SECONDS.toNanos(1)), TimeUnit.NANOSECONDS);
          if (key != null) {
            key.pollEvents();
            key.reset();
          }
        }
        log.debug("lockFile deleted: " + lockFile.getName());
      } catch (TimeoutException e) {
        throw new IOException("Package cache timed out waiting for lock.", e);
      }
    }


    /**
     * Wraps the execution of a package read function with the appropriate cache, package, and .lock file locking and
     * checks.
     *
     * @param function The function to execute
     * @param lockParameters The parameters for the lock
     * @return The return of the function
     * @param <T> The return type of the function
     * @throws IOException If an error occurs while managing locking.
     */
    public <T> T doReadWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> function, @Nullable LockParameters lockParameters) throws IOException {
      final LockParameters resolvedLockParameters = lockParameters != null ? lockParameters : FilesystemPackageCacheManagerLocks.lockParameters;

      cacheLock.getLock().readLock().lock();
      lock.readLock().lock();
      // whatever happens, the locks are released - waiting for the lock file can time out, or find a lock file no
      // process holds - or no write in this process could ever happen again
      try {
        checkForLockFileWaitForDeleteIfExists(lockFile, resolvedLockParameters);
        return function.get();
      } finally {
        lock.readLock().unlock();
        cacheLock.getLock().readLock().unlock();
      }
    }

    /**
     * Wraps the execution of a package write function with the appropriate cache, package, and .lock file locking and
     * checks.
     *
     * @param function The function to execute
     * @param lockParameters The parameters for the lock
     * @return The return of the function
     * @param <T> The return type of the function
     * @throws IOException If an error occurs while managing locking.
     */
    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> function, @Nullable LockParameters lockParameters) throws IOException {
      final LockParameters resolvedLockParameters = lockParameters != null ? lockParameters : FilesystemPackageCacheManagerLocks.lockParameters;

      cacheLock.getLock().writeLock().lock();
      lock.writeLock().lock();

      Set<OpenOption> openOptions = new HashSet<>();
      openOptions.add(StandardOpenOption.CREATE);
      openOptions.add(StandardOpenOption.WRITE);
      openOptions.add(StandardOpenOption.READ);

      //Windows does not allow renaming or deletion of 'open' files, so we rely on this option to delete the file after
      //use.
      if (SystemUtils.IS_OS_WINDOWS) {
        openOptions.add(StandardOpenOption.DELETE_ON_CLOSE);
      }

       /*TODO Eventually, this logic should exist in a Lockfile class so that it isn't duplicated between the main code and
          the test code.
        */
      FileChannel lockedChannel;
      FileLock[] fileLock = new FileLock[1];
      try {
        lockedChannel = lockTheLockFile(openOptions, resolvedLockParameters, fileLock);
      } catch (InterruptedException e) {
        lock.writeLock().unlock();
        cacheLock.getLock().writeLock().unlock();
        Thread.currentThread().interrupt();
        throw new IOException("Thread interrupted while waiting for lock", e);
      } catch (IOException | RuntimeException e) {
        lock.writeLock().unlock();
        cacheLock.getLock().writeLock().unlock();
        throw e;
      }
      try {
        // which process holds the lock, for whoever looks (the file has just been opened, and made if it wasn't
        // there, so it always exists by now: this used to be written only if it didn't, which was never). A lock
        // file left by a process that died may still have that one's in it
        lockedChannel.truncate(0);
        final ByteBuffer buff = ByteBuffer.wrap(String.valueOf(ProcessHandle.current().pid()).getBytes(StandardCharsets.UTF_8));
        final int bytesWritten = lockedChannel.write(buff, 0);
        log.debug(bytesWritten + " bytes written to lock file: " + lockFile.getName());
        return function.get();
      } finally {
        // whatever happens, the locks are released: if they weren't, nothing in this process could use the package again
        try {
          removeLockFile(fileLock[0]);
        } finally {
          try {
            lockedChannel.close();
          } finally {
            lock.writeLock().unlock();
            cacheLock.getLock().writeLock().unlock();
          }
        }
      }
    }

    private void removeLockFile(FileLock fileLock) throws IOException {
      File toDelete = lockFile;
      try {
        // Windows based file systems do not allow renames for 'open' files, but others do, and it is atomic. So do a
        // rename if we can before releasing our lock.
        if (!SystemUtils.IS_OS_WINDOWS) {
          log.debug("Attempting lockFile removal by move: " + lockFile.toPath());
          toDelete = ManagedFileAccess.createTempFile(lockFile.getParentFile(), lockFile.getName(), LOCK_DELETION_EXTENSION);
          Files.move(lockFile.toPath(), toDelete.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
          log.debug("Removed lockFile by moving from: " + lockFile.toPath() + " to " + toDelete.toPath());
        }
      } finally {
        fileLock.release();
        // Non-Windows file systems will have atomically renamed the file at this point, so we should delete the file it was named to.
        // Windows file systems will have to delete the original file itself.
        try {
          log.debug("Attempting lockFile deletion " + toDelete.toPath());
          Files.deleteIfExists(toDelete.toPath());
          log.debug("Removed lockFile by deleting " + toDelete.toPath());
        } catch (IOException e) {
          log.warn("Error while deleting lock file: {} File will be set to delete on exit", toDelete.getAbsolutePath(), e);
          toDelete.deleteOnExit();
        }
      }
    }

    /**
     * Opens and locks the lock file. Another process that holds the lock moves the lock file away before it releases
     * it (see doWriteWithLock), so a process that was waiting for it has the moved file open, which no longer is the
     * lock file: it may not be able to lock it yet (the other process hasn't released it), or it may lock it - and then
     * two processes think they have the package. Either way, it tries again, with the lock file that's there now. So
     * once locked, check that the file locked is still the one called lockFile. All the waiting together is limited
     * by the lock timeout
     */
    private FileChannel lockTheLockFile(Set<OpenOption> openOptions, LockParameters lockParameters, FileLock[] fileLock) throws IOException, InterruptedException {
      final int attempts = 10;
      final long deadline = System.nanoTime() + lockParameters.getLockTimeoutTimeUnit().toNanos(lockParameters.getLockTimeoutTime());
      for (int i = 1; ; i++) {
        FileChannel channel = getFileChannel(openOptions);
        try {
          // the file just opened (the window between opening and looking is tiny, where the window this closes is
          // all the time spent waiting for the lock)
          Object opened = fileKey(lockFile);
          long left = Math.max(1, deadline - System.nanoTime());
          FileLock fl = getFileLock(channel, lockParameters.withLockTimeoutTime(left).withLockTimeoutTimeUnit(TimeUnit.NANOSECONDS));
          if (fl == null) {
            log.debug("lockFile was moved away by the process that held it, but it hasn't released it yet, trying again: " + lockFile.getName());
          } else if (isStillTheLockFile(lockFile, opened)) {
            fileLock[0] = fl;
            return channel;
          } else {
            log.debug("lockFile was replaced while waiting for it, trying again: " + lockFile.getName());
            fl.release();
          }
        } catch (IOException | InterruptedException | RuntimeException e) {
          channel.close();
          throw e;
        }
        channel.close();
        if (i == attempts) {
          throw new IOException("Unable to lock " + lockFile.getName() + ": it kept being replaced by other processes");
        }
        if (System.nanoTime() >= deadline) {
          throw new IOException("Package cache timed out waiting for lock: " + lockFile.getName());
        }
      }
    }


    private FileChannel getFileChannel(Set<OpenOption> openOptions) throws IOException, InterruptedException {
      final int retries = 5;
      for (int i = 0; i < retries; i++) {
        try {
          return FileChannel.open(lockFile.toPath(), openOptions);
        } catch (java.nio.file.AccessDeniedException e) {
          log.debug(e.getMessage(), e);
        }
        Thread.sleep(20);
      }
      throw new IOException("Unable to get file lock after " + retries + " retries.");
    }

    /**
     * Locks the file the channel has open; if another process has it locked, waits until the lock file is deleted (or
     * moved away) and tries once more. Null if it still can't: the file open is then the one the other process moved
     * away, which it hasn't released yet (see lockTheLockFile)
     */
    private FileLock getFileLock(FileChannel channel, LockParameters resolvedLockParameters) throws IOException, InterruptedException {
      FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);

      if (fileLock == null) {
        log.debug("Unable to get fileLock on first attempt and waiting for deletion: " + lockFile.toPath());
        waitForLockFileDeletion(lockFile, resolvedLockParameters);
        fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
      }
      if (fileLock != null) {
        log.debug("fileLock acquired: " + lockFile.toPath());
      }
      return fileLock;
    }
  }

  private static void logSystemSpecificFileSystemException(FileSystemException e) {
    if (SystemUtils.IS_OS_WINDOWS && String.valueOf(e.getMessage()).contains("being used by another process")) {
      log.debug("Windows reported that the lock file can't be opened because it is locked by another process: {}", String.valueOf(e));
    } else {
      log.warn("Unexpected FileSystemException while evaluating is a lock file: ", e);
    }
  }

  /**
   * Opens a lock file that is there, to see whether it's locked; null if it isn't there (any more). Never makes it
   * (as RandomAccessFile(f, "rw") does): a lock file made by looking for one is a lock file no process holds
   */
  static FileChannel openExistingLockFile(File lockFile) throws IOException {
    try {
      return FileChannel.open(lockFile.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE);
    } catch (NoSuchFileException e) {
      return null;
    }
  }

  /** identifies the file the name refers to (on Windows, there's no key, and the lock file isn't moved anyway) */
  private static Object fileKey(File file) {
    try {
      return Files.readAttributes(file.toPath(), java.nio.file.attribute.BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).fileKey();
    } catch (IOException e) {
      return null;
    }
  }

  /**
   * Whether the lock file is still the file that was opened (opened: its fileKey then). A process that holds the lock
   * moves the lock file away before it releases it, so a file locked once it's released can be the one moved away. On
   * Windows the lock file isn't moved (and there are no keys): it's still the lock file if it's still there
   */
  private static boolean isStillTheLockFile(File lockFile, Object opened) {
    if (SystemUtils.IS_OS_WINDOWS) {
      return lockFile.exists();
    }
    return opened != null && opened.equals(fileKey(lockFile));
  }

  public synchronized PackageLock getPackageLock(String packageName) throws IOException {
    File lockFile = ManagedFileAccess.file(Utilities.path(cacheFolder.getAbsolutePath(), packageName + LOCKFILE_EXTENSION));
    return packageLocks.computeIfAbsent(lockFile, (k) -> new PackageLock(k, new ReentrantReadWriteLock()));
  }

  public static boolean isLockFile(String fileName) {
    return fileName.endsWith(LOCKFILE_EXTENSION) || fileName.endsWith(LOCK_DELETION_EXTENSION);
  }
}
