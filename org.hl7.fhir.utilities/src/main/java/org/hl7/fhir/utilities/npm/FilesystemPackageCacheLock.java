package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.TextFile;

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
    this.lockFile = new File(cacheFolder, name + ".lock");
    if (!lockFile.isFile()) {
      TextFile.stringToFile("", lockFile);
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
