package org.hl7.fhir.utilities.npm;

import org.apache.commons.lang3.SystemUtils;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

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
public class LockfileTestProcessUtility {
  /**
   * Main method to allow running this class.
   * <p/
   * It is not recommended to call this method directly. Instead, use the provided {@link #lockWaitAndDeleteInNewProcess(String, String, int)} method.
   *
   * @param args The arguments to the main method. The first argument is the path to create the lockfile in, the second
   *             argument is the name of the lockfile, and the third argument is the number of seconds to wait before
   *             deleting the lockfile.
   */
  public static void main(String[] args) {

    String path = args[0];
    String lockFileName = args[1];
    int seconds = Integer.parseInt(args[2]);

    try {
      lockWaitAndDelete(path, lockFileName, seconds);
    } catch (InterruptedException | IOException e) {
      throw new RuntimeException(e);
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
      ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "target/test-classes", LockfileTestProcessUtility.class.getName(), path, lockFileName, Integer.toString(seconds));
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

    File lockFile = Paths.get(path,lockFileName).toFile();

    Set<OpenOption> openOptions = new HashSet<>();
    openOptions.add(StandardOpenOption.CREATE);
    openOptions.add(StandardOpenOption.WRITE);
    openOptions.add(StandardOpenOption.READ);

    //Windows does not allow renaming or deletion of 'open' files, so we rely on this option to delete the file after
    //use.
    if (isSystemWindows()) {
      openOptions.add(StandardOpenOption.DELETE_ON_CLOSE);
    }

    try (FileChannel channel = FileChannel.open(lockFile.toPath(), openOptions)) {
      FileLock fileLock = channel.tryLock(0, Long.MAX_VALUE, false);
      if (fileLock != null) {
        final ByteBuffer buff = ByteBuffer.wrap("Hello world".getBytes(StandardCharsets.UTF_8));
        channel.write(buff);
        System.out.println("File "+lockFileName+" is locked. Waiting for " + seconds + " seconds to release. ");
        Thread.sleep(seconds * 1000L);
       // Normally this would used ManagedFileAccess. We cannot however, use this here, as this class uses no
        // dependencies outside of core Java. See class javadoc for details.
        Path tempDeleteDir = Files.createTempDirectory("temp_deleted_files");
        Path tempFilePath = tempDeleteDir.resolve(lockFile.getName());
        tempDeleteDir.toFile().deleteOnExit();
        tempFilePath.toFile().deleteOnExit();
        final File toDelete = tempFilePath.toFile();
        if (!isSystemWindows()) {
          System.out.println("Atomic move  "+lockFile.getAbsolutePath()+" to " + tempFilePath.toAbsolutePath());
          Files.move(lockFile.toPath(), tempFilePath, StandardCopyOption.ATOMIC_MOVE );
        }

        fileLock.release();
        channel.close();

        System.out.println("File "+lockFileName+" is released at " + System.currentTimeMillis() );
        if (!isSystemWindows()) {
          if (!toDelete.delete()) {
            System.err.println("Could not delete "+lockFile.getAbsolutePath());
            toDelete.deleteOnExit();
          }
        }
      }
    }
  }

  private static boolean isSystemWindows() {
    return System.getProperty("os.name").toLowerCase().startsWith("windows");
  }
}
