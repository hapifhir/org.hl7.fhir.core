package org.hl7.fhir.r5.context;

public interface ILoggingService {
  public enum LogCategory {
    INIT, 
    PROGRESS,
    TX, 
    CONTEXT, 
    GENERATE,
    HTML 
  }
  public void logMessage(String message); // status messages, always display
  public void logDebugMessage(ILoggingService.LogCategory category, String message); // verbose; only when debugging 
  public boolean isDebugLogging(); // whether to log debug information
}