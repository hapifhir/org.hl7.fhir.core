package org.hl7.fhir.r5.context;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
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

  @Deprecated(forRemoval = true)
  public default boolean isDebugLogging() {return false;} // whether to log debug information

}