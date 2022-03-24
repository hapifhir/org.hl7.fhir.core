package org.hl7.fhir.r5.context;

class SystemOutLoggingService implements IWorkerContext.ILoggingService {

  @Override
  public void logMessage(String message) {
    System.out.println(message);
  }

  @Override
  public void logDebugMessage(LogCategory category, String message) {
    System.out.println(" -" + category.name().toLowerCase() + ": " + message);
  }
}
