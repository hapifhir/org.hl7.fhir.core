package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;

public class LockfileUtility {
  public static void main(String[] args) {
    String lockFileName = args[1];
    String path = args[0];
    int seconds = Integer.parseInt(args[2]);

    try {
      lockWaitAndDelete(path, lockFileName, seconds);
    } catch (InterruptedException | IOException e) {
      throw new RuntimeException(e);
    }

  }

  private static void lockWaitAndDelete(String path, String lockFileName, int seconds) throws InterruptedException, IOException {
    File file = Paths.get(path,lockFileName).toFile();
    try (FileChannel channel = new RandomAccessFile(file.getAbsolutePath(), "rw").getChannel()) {
      FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
      if (fileLock != null) {
        System.out.println("File "+lockFileName+" is locked. Waiting for " + seconds + " seconds to release");
        Thread.sleep(seconds * 1000L);
        fileLock.release();
        System.out.println("File "+lockFileName+" is released.");

        channel.close();
    }}finally {
      if (file.exists()) {
        file.delete();
      }
    }
  }
}
