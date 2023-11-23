package org.hl7.fhir.r5.context;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SystemOutLoggingService implements ILoggingService {

  private final boolean debug;

  public SystemOutLoggingService() {
    this(false);
  }

  @Override
  public void logMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void logDebugMessage(LogCategory category, String message) {
    if (debug) {
      System.out.println(" -" + category.name().toLowerCase() + ": " + message);
    }
  }

  @Override
  public boolean isDebugLogging() {
    return debug;
  }  
  
}
