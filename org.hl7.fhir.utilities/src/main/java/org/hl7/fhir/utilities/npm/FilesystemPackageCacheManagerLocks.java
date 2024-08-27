package org.hl7.fhir.utilities.npm;

import lombok.Getter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FilesystemPackageCacheManagerLocks {

  private static final ConcurrentHashMap<File, FilesystemPackageCacheManagerLocks> cacheFolderLockManagers = new ConcurrentHashMap<>();

  @Getter
  private final CacheLock cacheLock = new CacheLock();

  private final ConcurrentHashMap<File, PackageLock> packageLocks = new ConcurrentHashMap<>();

  private final File cacheFolder;

  private final Long lockTimeoutTime;

  private final TimeUnit lockTimeoutTimeUnit;

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
    this(cacheFolder, 60L, TimeUnit.SECONDS);
  }

  private FilesystemPackageCacheManagerLocks(File cacheFolder, Long lockTimeoutTime, TimeUnit lockTimeoutTimeUnit) throws IOException {
    this.cacheFolder = cacheFolder;
    this.lockTimeoutTime = lockTimeoutTime;
    this.lockTimeoutTimeUnit = lockTimeoutTimeUnit;
  }

  /**
   * This method is intended to be used only for testing purposes.
   */
  protected FilesystemPackageCacheManagerLocks withLockTimeout(Long lockTimeoutTime, TimeUnit lockTimeoutTimeUnit) throws IOException {
    return new FilesystemPackageCacheManagerLocks(cacheFolder, lockTimeoutTime, lockTimeoutTimeUnit);
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
  }

  public class PackageLock {
    @Getter
    private final File lockFile;
    private final ReadWriteLock lock;

    protected PackageLock(File lockFile, ReadWriteLock lock) {
      this.lockFile = lockFile;
      this.lock = lock;
    }

    private void checkForLockFileWaitForDeleteIfExists(File lockFile) throws IOException {
      if (!lockFile.exists()) {
        return;
      }
      try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
        Path dir = lockFile.getParentFile().toPath();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);

        WatchKey key = watchService.poll(lockTimeoutTime, lockTimeoutTimeUnit);
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
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Error reading package.", e);
      } catch (TimeoutException e) {
        throw new IOException("Error reading package.", e);
      }
    }


    public <T> T doReadWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
      cacheLock.getLock().readLock().lock();
      lock.readLock().lock();

      checkForLockFileWaitForDeleteIfExists(lockFile);

      T result = null;
      try {
        result = f.get();
      } finally {
        lock.readLock().unlock();
        cacheLock.getLock().readLock().unlock();
      }
      return result;
    }

    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
      cacheLock.getLock().writeLock().lock();
      lock.writeLock().lock();

      if (!lockFile.isFile()) {
        try {
          TextFile.stringToFile("", lockFile);
        } catch (IOException e) {
          e.printStackTrace();
          return null;
        }
      }
      try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        FileLock fileLock = null;
        while (fileLock == null) {
          fileLock = channel.tryLock(0, Long.MAX_VALUE, true);
          if (fileLock == null) {
            Thread.sleep(100); // Wait and retry
          }
        }
        T result = null;
        try {
          result = f.get();
        } finally {
          fileLock.release();
          channel.close();
          if (!lockFile.delete()) {
            lockFile.deleteOnExit();
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
  }

  public synchronized PackageLock getPackageLock(String packageName) throws IOException {
    File lockFile = new File(Utilities.path(cacheFolder.getAbsolutePath(), packageName + ".lock"));
    return packageLocks.computeIfAbsent(lockFile, (k) -> new PackageLock(k, new ReentrantReadWriteLock()));
  }
}
