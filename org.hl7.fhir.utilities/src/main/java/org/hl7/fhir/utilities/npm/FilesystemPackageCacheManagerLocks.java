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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
      lock.writeLock().lock();
      T result = null;
      try {
        result = f.get();
      } finally {
        lock.writeLock().unlock();
      }
      return result;
    }

    public boolean canLockFileBeHeldByThisProcess(File lockFile) throws IOException {
      return doWriteWithLock(() -> {
      try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
        if (fileLock != null) {
          fileLock.release();
          channel.close();
          return true;
        }
      } catch (FileNotFoundException e) {
        logSystemSpecificFileNotFoundException(e);
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
        return;
      }

      // Check if the file is locked by a process. If it is not, it is likely an incomplete package cache install, and
      // we should throw an exception.
      if (lockFile.isFile()) {
        try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
          FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
          if (fileLock != null) {
            fileLock.release();
            channel.close();
            throw new IOException("Lock file exists, but is not locked by a process: " + lockFile.getName());
          }
          log.debug("File is locked ('"+lockFile.getAbsolutePath()+"').");
        } catch (FileNotFoundException e) {
          logSystemSpecificFileNotFoundException(e);
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

      try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
        Path dir = lockFile.getParentFile().toPath();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);

        WatchKey key = watchService.poll(lockParameters.lockTimeoutTime, lockParameters.lockTimeoutTimeUnit);
        if (key == null) {
          // It is possible that the lock file is deleted before the watch service is registered, so if we timeout at
          // this point, we should check if the lock file still exists.
          if (lockFile.exists()) {
            throw new TimeoutException("Timeout waiting for lock file deletion: " + lockFile.getName());
          }
        } else {
          for (WatchEvent<?> event : key.pollEvents()) {
            WatchEvent.Kind<?> kind = event.kind();
            if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
              Path deletedFilePath = (Path) event.context();
              if (deletedFilePath.toString().equals(lockFile.getName())) {
                return;
              }
            }
            key.reset();
          }
        }
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

      checkForLockFileWaitForDeleteIfExists(lockFile, resolvedLockParameters);

      T result = null;
      try {
        result = function.get();
      } finally {
        lock.readLock().unlock();
        cacheLock.getLock().readLock().unlock();
      }
      return result;
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
      try (FileChannel channel = getFileChannel(openOptions))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  {

        final FileLock fileLock = getFileLock(channel, resolvedLockParameters);

        if (!lockFile.isFile() && !lockFile.exists()) {
          final ByteBuffer buff = ByteBuffer.wrap(String.valueOf(ProcessHandle.current().pid()).getBytes(StandardCharsets.UTF_8));
          final int bytesWritten = channel.write(buff);
          log.trace(bytesWritten + " bytes written to lock file: " + lockFile.getName());
        }
        T result = null;
        try {
          result = function.get();
        } finally {
          final File toDelete;

          // Windows based file systems do not allow renames for 'open' files so we cannot do this.
          if (!SystemUtils.IS_OS_WINDOWS) {
            toDelete = ManagedFileAccess.file(File.createTempFile(lockFile.getName(), LOCK_DELETION_EXTENSION, lockFile.getParentFile()).getAbsolutePath());
            Files.move(lockFile.toPath(), toDelete.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
          } else {
            toDelete = null;
          }

          fileLock.release();

          // Non-Windows file systems will have atomically renamed the file at this point, so we should clean it up.
          if (toDelete != null) {
            try {
              Files.delete(toDelete.toPath());
            } catch (IOException e) {
              log.warn("Error while deleting lock file: {} File will be set to delete on exit", toDelete.getAbsolutePath(), e);
              toDelete.deleteOnExit();
            }
          }

          lock.writeLock().unlock();
          cacheLock.getLock().writeLock().unlock();
        }
        return result;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Thread interrupted while waiting for lock", e);
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

    private FileLock getFileLock(FileChannel channel, LockParameters resolvedLockParameters) throws IOException, InterruptedException {
      FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);

      if (fileLock == null) {
        waitForLockFileDeletion(lockFile, resolvedLockParameters);
        fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
      }
      if (fileLock == null) {
        throw new IOException("Failed to acquire lock on file: " + lockFile.getName());
      }
      return fileLock;
    }
  }

  private static void logSystemSpecificFileNotFoundException(FileNotFoundException e) {
    if (SystemUtils.IS_OS_WINDOWS && e.getMessage().contains("The process cannot access the file because it is being used by another process")) {
      log.trace("Windows reported a FileNotFoundException whose actual cause is that the file is locked by another process: {}", String.valueOf(e));
    } else {
      log.warn("Unexpected FileNotFoundException while evaluating is a lock file: ", e);
    }
  }

  public synchronized PackageLock getPackageLock(String packageName) throws IOException {
    File lockFile = ManagedFileAccess.file(Utilities.path(cacheFolder.getAbsolutePath(), packageName + LOCKFILE_EXTENSION));
    return packageLocks.computeIfAbsent(lockFile, (k) -> new PackageLock(k, new ReentrantReadWriteLock()));
  }

  public static boolean isLockFile(String fileName) {
    return fileName.endsWith(LOCKFILE_EXTENSION) || fileName.endsWith(LOCK_DELETION_EXTENSION);
  }
}
