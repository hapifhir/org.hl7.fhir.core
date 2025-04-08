package org.hl7.fhir.validation.tests.logging;

import lombok.Getter;
import org.slf4j.Logger;

public class ProgressLogger {

  @Getter
  private boolean isDone;

  private final Logger logger;

  private final String processName;

  private final int maxLength;

  private int observedMaxLength = 0;

  private final String suffix;

  public ProgressLogger(Logger logger, String processName, int maxLength, String suffix) {
    this.logger = logger;
    this.processName = processName;
    this.maxLength = maxLength;
    this.suffix = suffix;
  }

  public void logProgress(String message) {
    // Log the progress message
    StringBuilder stringBuilder = new StringBuilder(processName + " progress: " );
    if (message.length() < maxLength) {
      for (int i = 0; i < maxLength - message.length(); i++) {
        stringBuilder.append(".");
      }
    }
    stringBuilder.append(message);
    if (suffix != null) {
      stringBuilder.append(suffix);
    }
    System.out.print(stringBuilder + "\r");
    if (stringBuilder.length() > observedMaxLength) {
      observedMaxLength = stringBuilder.length();
    }
    logger.debug(stringBuilder.toString());
  }

  public void done() {
    isDone = true;
    for (int i = 0; i < observedMaxLength; i++) {
      System.out.print(" ");
    }
    System.out.print("\r");
  }
}
