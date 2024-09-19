package org.hl7.fhir.utilities.npm;


import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.*;

import java.nio.file.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class LockfileTestUtility {



  /**
   * Wait for the lock file to be created in the given path.
   * <p/>
   * Normally, within the same JVM, you could use a CountdownLatch for the same purpose, but since this the lock file is
   * being created in a separate process, we need to use a mechanism that doesn't rely on shared threads.
   *
   * @param path The path containing the lock file
   * @param lockFileName The name of the lock file
   * @throws InterruptedException If the thread is interrupted while waiting
   * @throws TimeoutException If the lock file is not created within 10 seconds
   */
  public static void waitForLockfileCreation(String path, String lockFileName) throws InterruptedException, TimeoutException {

    CountDownLatch latch = new CountDownLatch(1);
    FileAlterationMonitor monitor = new FileAlterationMonitor(100);
    FileAlterationObserver observer = new FileAlterationObserver(path);

    observer.addListener(new FileAlterationListenerAdaptor(){

      @Override
      public void onStart(FileAlterationObserver observer) {
        if (Files.exists(Paths.get(path, lockFileName))) {
          latch.countDown();
        }
      }

      @Override
      public void onFileCreate(File file) {
        System.out.println("File created: " + file.getName());
        latch.countDown();
      }
    });
    monitor.addObserver(observer);

      try {
        monitor.start();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      boolean success = latch.await(10, TimeUnit.SECONDS);
      try {
        monitor.stop();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

      if (!success) {
        throw new TimeoutException("Timed out waiting for lock file creation: " + lockFileName);
      }
      // TODO This is a workaround for an edge condition that shows up with testing, where the lock is not reflected in
      //  the file system immediately. It is unlikely to appear in production environments, but should it occur, it will
      //  result in a lock file being erroneously reported as not having an owning process, and will cause a package to
      //  fail to be loaded from that cache until the lock is cleaned up by cache initialization.
      //Thread.sleep(100);

  }


}
