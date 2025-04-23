package org.hl7.fhir.validation.instance;

import lombok.Getter;
import org.slf4j.Logger;

/**
 * A utility class to keep track of task progress in a console as well as an slf4j logger.
 * <p/>
 * Note that this class is intended to be used by a single thread, without interference from other logging. However,
 * guaranteeing.
 */
public class ProgressLogger {

  @Getter
  private boolean isDone;

  private final Logger logger;

  private final String processName;

  private final int intervalPadding;

  public ProgressLogger(Logger logger, String processName, int intervalPadding) {
    this.logger = logger;
    this.processName = processName;
    this.intervalPadding = intervalPadding;
    System.out.print(processName + " progress: ");
    logger.debug(processName + " : started");
  }

  public void logProgress(String message) {
    logProgress(message, false);
  }

  public void logProgress(String message, boolean consoleOnly) {
    // Log the progress message
    StringBuilder stringBuilder = new StringBuilder();
    if (message.length() < intervalPadding) {
      stringBuilder.append(".".repeat(intervalPadding - message.length()));
    }
    stringBuilder.append(message);
    System.out.print(stringBuilder);

    if (!consoleOnly) {
      logger.debug(processName + " progress: " + message);
    }
  }

  public void done() {
    isDone = true;
    System.out.println(" done");
    logger.debug(processName + " : done");
  }
}
