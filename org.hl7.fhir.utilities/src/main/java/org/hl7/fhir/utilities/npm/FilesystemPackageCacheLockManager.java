package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FilesystemPackageCacheLockManager {

  private final CacheLock cacheLock = new CacheLock();

  private final ConcurrentHashMap<File, PackageLock> packageLocks = new ConcurrentHashMap<>();

  private final File cacheFolder;

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

  public CacheLock getCacheLock() {
    return cacheLock;
  }

  public class PackageLock {
    private final File lockFile;
    private final ReadWriteLock lock;

    protected PackageLock(File lockFile, ReadWriteLock lock) {
      this.lockFile = lockFile;
      this.lock = lock;
    }

    public File getLockFile() {
      return lockFile;
    }

    public ReadWriteLock getLock() {
      return lock;
    }

    public <T> T doReadWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
        cacheLock.getLock().writeLock().lock();
        lock.writeLock().lock();
        lock.readLock().lock();
        cacheLock.getLock().readLock().lock();
        lock.writeLock().unlock();
        cacheLock.getLock().writeLock().unlock();
     // try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        //final FileLock fileLock = channel.lock(0, Long.MAX_VALUE, true);
        T result = null;
        try {
          result = f.get();
        } finally {
         // fileLock.release();
          cacheLock.getLock().readLock().unlock();
          lock.readLock().unlock();
        }
        return result;
      //}
    }

    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
        cacheLock.getLock().readLock().lock();
        lock.writeLock().lock();
        //try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        //final FileLock fileLock = channel.lock();
        T result = null;
        try {
          result = f.get();
        } finally {
          //fileLock.release();
          lock.writeLock().unlock();
          cacheLock.getLock().readLock().unlock();
        }
        if (!lockFile.delete()) {
          lockFile.deleteOnExit();
        }

        return result;
      //}
    }
  }

  public FilesystemPackageCacheLockManager(File cacheFolder) throws IOException {
    this.cacheFolder = cacheFolder;
  }

  public synchronized PackageLock getPackageLock(String packageName) throws IOException {
    File lockFile = new File(Utilities.path(cacheFolder.getAbsolutePath(), packageName + ".lock"));

    PackageLock packageLock = packageLocks.computeIfAbsent(lockFile, (k) -> {
      if (!lockFile.isFile()) {
        try {
          TextFile.stringToFile("", lockFile);
        } catch (IOException e) {
          e.printStackTrace();
          return null;
        }
      }
      return new PackageLock(k, new ReentrantReadWriteLock());
    });
    return packageLock;
  }


}
