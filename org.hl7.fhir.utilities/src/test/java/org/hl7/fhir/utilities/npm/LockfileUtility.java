package org.hl7.fhir.utilities.npm;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

  public static void waitForLockfileCreation(String path, String lockFileName) throws InterruptedException, IOException, TimeoutException {
    if (Files.exists(Paths.get(path, lockFileName))) {
      return;
    }
    try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
      Path dir = Paths.get(path);
      dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

      WatchKey key = watchService.poll(10, TimeUnit.SECONDS);
      if (key == null) {
        throw new TimeoutException("Timeout waiting for lock file creation: " + lockFileName);
      }
      for (WatchEvent<?> event : key.pollEvents()) {
        WatchEvent.Kind<?> kind = event.kind();
        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
          Path createdFile = (Path) event.context();
          if (createdFile.toString().equals(lockFileName)) {
            System.out.println("Lock file created: " + lockFileName);
            return;
          }
        }
      }
      throw new TimeoutException("Timeout waiting for lock file creation: " + lockFileName);
    }
  }

  public static Thread lockWaitAndDeleteInNewProcess(String path, String lockFileName, int seconds)  {
    Thread t = new Thread(() -> {
      ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "target/test-classes:.", "org.hl7.fhir.utilities.npm.LockfileUtility", path, lockFileName, Integer.toString(seconds));
      try {
        Process process = processBuilder.start();
        process.getErrorStream().transferTo(System.err);
        process.getInputStream().transferTo(System.out);
        process.waitFor();
      } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    t.start();
    return t;
  }

  private static void lockWaitAndDelete(String path, String lockFileName, int seconds) throws InterruptedException, IOException {

    File file = Paths.get(path,lockFileName).toFile();

    try (FileChannel channel = new RandomAccessFile(file.getAbsolutePath(), "rw").getChannel()) {
      FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
      if (fileLock != null) {
        final ByteBuffer buff = ByteBuffer.wrap("Hello world".getBytes(StandardCharsets.UTF_8));
        channel.write(buff);
        System.out.println("File "+lockFileName+" is locked. Waiting for " + seconds + " seconds to release. ");
        Thread.sleep(seconds * 1000L);
        fileLock.release();
        System.out.println(System.currentTimeMillis());
        System.out.println("File "+lockFileName+" is released.");

        channel.close();
    }}finally {
      if (file.exists()) {
        file.delete();
      }
    }
  }
}
