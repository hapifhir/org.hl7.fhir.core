package org.hl7.fhir.validation.cli.picocli.options;

import picocli.CommandLine;

/**
 * Options that must be applied globally, or at the JVM level before other commands can function properly. For example:
 * </br>
 * <ul>
 *   <li>Locale</li>
 *   <li>HTTP/S Proxy settings</li>
  *  <li>.../li>
 * </ul>
 *  Once the options are parsed, they are applied through the {@link #apply(CommandLine.ParseResult)} method.
 */
public interface GlobalOptions {
  /**
   * Apply the global options to the parsed command line result
   * @param parseResult A Picocli {@link CommandLine.ParseResult} that contains the parsed options.
   *
   * @return An integer indicating the exit code for the application if this method fails.
   */
  public int apply(CommandLine.ParseResult parseResult);
}
