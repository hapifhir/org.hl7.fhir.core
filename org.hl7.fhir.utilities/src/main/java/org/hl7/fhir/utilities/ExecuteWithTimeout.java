package org.hl7.fhir.utilities;

import org.hl7.fhir.exceptions.FHIRException;

import java.util.concurrent.*;

public class ExecuteWithTimeout {
  @FunctionalInterface
  public interface ThrowingRunnable {
    void run() throws Exception;
  }

  public static void runWithTimeout(int seconds, String taskName, ThrowingRunnable task) throws FHIRException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<?> future = executor.submit(() -> { task.run(); return null; });
    try {
      future.get(seconds, TimeUnit.SECONDS);
    } catch (TimeoutException e) {
      future.cancel(true);
      throw new FHIRException(taskName+" timed out");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new FHIRException(taskName+" interrupted");
    } catch (ExecutionException e) {
      if (e.getCause() instanceof FHIRException) throw (FHIRException) e.getCause();
      throw new FHIRException(e.getCause());
    } finally {
      executor.shutdownNow();
    }
  }

}
