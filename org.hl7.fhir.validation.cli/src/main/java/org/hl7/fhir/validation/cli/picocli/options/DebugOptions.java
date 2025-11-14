package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.cli.logging.Level;
import org.hl7.fhir.validation.cli.logging.LogbackUtilities;
import org.hl7.fhir.validation.cli.param.Params;
import picocli.CommandLine;

public class DebugOptions implements GlobalOptions {
  public static final String DEBUG_LOG = "-debug-log";
  public static final String TRACE_LOG = "-trace-log";

  @CommandLine.Option(names = {DEBUG_LOG}, description = "A log file to write debug level messages to.")
  String debugLog;

  @CommandLine.Option(names = {TRACE_LOG}, description = "A log file to write trace level messages to.")
  String traceLog;

  @Override
  public int apply(CommandLine.ParseResult parseResult) {
    setLogbackConfiguration(parseResult, DEBUG_LOG, Level.DEBUG);
    setLogbackConfiguration(parseResult, TRACE_LOG, Level.TRACE);
    return 0;
  }

  private static void setLogbackConfiguration(CommandLine.ParseResult parseResult, String logParam, Level logLevel) {
    if (parseResult.hasMatchedOption(logParam)) {
      String logFile = parseResult.matchedOptionValue(logParam, null);
      if (logFile != null) {
        LogbackUtilities.setLogToFileAndConsole(logLevel, logFile);
      }
    }
  }
}
