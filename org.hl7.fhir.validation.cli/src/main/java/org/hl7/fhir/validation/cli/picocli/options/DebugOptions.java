package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.cli.logging.Level;
import org.hl7.fhir.validation.cli.logging.LogbackUtilities;
import picocli.CommandLine;

public class DebugOptions {
  public static final String DEBUG_LOG = "-debug-log";
  public static final String TRACE_LOG = "-trace-log";

  @CommandLine.Option(names = {DEBUG_LOG}, description = "A log file to write debug level messages to.", scope = CommandLine.ScopeType.INHERIT)
  public void setDebugLog(String debugLog) {
    setLogbackConfiguration(debugLog, Level.DEBUG);
  }

  @CommandLine.Option(names = {TRACE_LOG}, description = "A log file to write trace level messages to.", scope = CommandLine.ScopeType.INHERIT)
  public void setTraceLog(String traceLog) {
    setLogbackConfiguration(traceLog, Level.TRACE);
  }

  private static void setLogbackConfiguration(String logFile, Level logLevel) {
    if (logFile != null) {
      LogbackUtilities.setLogToFileAndConsole(logLevel, logFile);
    }
  }
}
