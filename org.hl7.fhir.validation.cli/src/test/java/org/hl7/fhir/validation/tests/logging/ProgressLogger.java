package org.hl7.fhir.validation.tests.logging;

public class ProgressLogger {

  @Getter
  private boolean isDone;

  public ProgressLogger() {

  }

  public void logProgress(String message) {
    // Log the progress message
    System.out.println("Progress: " + message);
  }
}
