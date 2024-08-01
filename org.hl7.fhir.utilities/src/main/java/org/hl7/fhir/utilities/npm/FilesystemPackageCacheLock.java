package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FilesystemPackageCacheLock {

  private static final ConcurrentHashMap<File, ReadWriteLock> locks = new ConcurrentHashMap<>();

  private final File lockFile;

  public FilesystemPackageCacheLock(File cacheFolder, String name) throws IOException {
    this.lockFile = ManagedFileAccess.file(Utilities.path(cacheFolder.getAbsolutePath(), name + ".lock"));
    if (!lockFile.isFile()) {
      TextFile.stringToFile("", lockFile);
    }
  }

  public <T> T doReadWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {
    if (!lockFile.exists()) {
      return f.get();
    } else {
      try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
        locks.putIfAbsent(lockFile, new ReentrantReadWriteLock());
        ReadWriteLock lock = locks.get(lockFile);
        lock.writeLock().lock();
        final FileLock fileLock = channel.lock(0, Long.MAX_VALUE, true);
        T result = null;
        try {
          result = f.get();
        } finally {
          fileLock.release();
          lock.writeLock().unlock();
        }
        return result;
      }
    }
  }

  public <T> T doWriteWithLock(FilesystemPackageCacheManager.CacheLockFunction<T> f) throws IOException {

    try (FileChannel channel = new RandomAccessFile(lockFile, "rw").getChannel()) {
      locks.putIfAbsent(lockFile, new ReentrantReadWriteLock());
      ReadWriteLock lock = locks.get(lockFile);
      lock.writeLock().lock();
      final FileLock fileLock = channel.lock();
      T result = null;
      try {
        result = f.get();
      } finally {
        fileLock.release();
        lock.writeLock().unlock();
      }
      if (!lockFile.delete()) {
        lockFile.deleteOnExit();
      }

      return result;
    }
  }
}
