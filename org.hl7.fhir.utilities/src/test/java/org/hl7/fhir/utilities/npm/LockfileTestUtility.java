package org.hl7.fhir.utilities.npm;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * FilesystemPackageCacheManagerLocks relies on the existence of .lock files to prevent access to packages being written
 * by processes outside the current JVM. Testing this functionality means creating a process outside the JUnit test JVM,
 * which is achieved by running a separate Java process.
 * <p/>
 * Intended usage:
 * <p/>
 * The helper method {@link #lockWaitAndDeleteInNewProcess(String, String, int)} is the intended starting point for
 * using this class.
 * <p/>
 *
 *
 * This class deliberately avoids using any dependencies outside java.*, which avoids having to construct a classpath
 * for the separate process.
 */
public class LockfileTestUtility {

  /**
   * Main method to allow running this class.
   *
   * It is not recommended to call this method directly. Instead, use the provided {@link LockfileTestUtility.l} method.
   *
   *
   * @param args
    */
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

  /**
   * Wait for the lock file to be created in the given path.
   * <p/>
   * Normally, within the same JVM, you could use a CountdownLatch for the same purpose, but since this the lock file is
   * being created in a separate process, we need to use a mechanism that doesn't rely on shared threads.
   *
   * @param path The path containing the lock file
   * @param lockFileName The name of the lock file
   * @throws InterruptedException If the thread is interrupted while waiting
   * @throws IOException If there is an error accessing the file system
   * @throws TimeoutException If the lock file is not created within 10 seconds
   */
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

  /**
   * Static helper method that starts a new process, creates a lock file in the path and waits for a specified number of
   * seconds before deleting it.
   * <p/>
   * This method calls the {@link #main(String[])} method in a new process.
   *
   * @param path The path to create the lockfile in
   * @param lockFileName The name of the lockfile
   * @param seconds The number of seconds to wait before deleting the lockfile
   * @return The thread wrapping the process execution. This can be used to wait for the process to complete, so that
   * System.out and System.err can be processed before tests return results.
   */
  public static Thread lockWaitAndDeleteInNewProcess(String path, String lockFileName, int seconds)  {
    Thread t = new Thread(() -> {
      ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "target/test-classes:.", LockfileTestUtility.class.getName(), path, lockFileName, Integer.toString(seconds));
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

  /**
   * The actual logic to create a .lock file.
   * <p/>
   * This should match the logic in FilesystemPackageCacheManagerLocks
   * <p/>
   *
   * @param path The path to create the lockfile in
   * @param lockFileName The name of the lockfile
   * @param seconds The number of seconds to wait before deleting the lockfile
   * @throws InterruptedException If the thread is interrupted while waiting
   * @throws IOException If there is an error accessing the file system
   */
  /* TODO Eventually, this logic should exist in a Lockfile class so that it isn't duplicated between the main code and
      the test code.
   */
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
