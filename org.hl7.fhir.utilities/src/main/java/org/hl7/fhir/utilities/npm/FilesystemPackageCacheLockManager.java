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
        cacheLock.getLock().readLock().lock();
        lock.readLock().lock();

         T result = null;
        try {
          result = f.get();
        } finally {
         // fileLock.release();
          lock.readLock().unlock();
          cacheLock.getLock().readLock().unlock();
        }
        return result;
      //}
    }

    public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
        cacheLock.getLock().writeLock().lock();
        lock.writeLock().lock();


      if (!lockFile.isFile()) {
        try {
          System.out.println("Initializing lock file: " + lockFile.getName() + " Thread: " + Thread.currentThread().getId());
          TextFile.stringToFile("", lockFile);
        } catch (IOException e) {
          e.printStackTrace();
          return null;
        }
      }
        //try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        //final FileLock fileLock = channel.lock();
        T result = null;
        try {
          result = f.get();
        } finally {
          //fileLock.release();
          if (!lockFile.delete()) {
            System.out.println("Can't delete lock file: " + lockFile.getName() + " Thread: " + Thread.currentThread().getId());
            lockFile.deleteOnExit();
          } else {
            System.out.println("Deleted lock file: " + lockFile.getName() + " Thread: " + Thread.currentThread().getId());
          }
          lock.writeLock().unlock();
          cacheLock.getLock().writeLock().unlock();
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
    return packageLocks.computeIfAbsent(lockFile, (k) -> new PackageLock(k, new ReentrantReadWriteLock()));
  }


}
