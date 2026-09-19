package org.hl7.fhir.validation.special;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import org.hl7.fhir.utilities.Utilities;
import org.slf4j.LoggerFactory;

/**
 * Tees everything the terminology tests log to the console into test.log in the run's output
 * directory, next to the actual/ and expected/ folders it already writes.
 *
 * The console tells you a test failed; the diff in actual/ tells you how. What was missing was
 * everything else: the stack trace behind a test that threw rather than compared, the warnings
 * from the client, the list of failures at the end. All of that is logged, and all of it
 * scrolls away. A run is not reproducible from a terminal you have since closed.
 *
 * slf4j has no file output of its own - it is only the API - so this attaches an appender to
 * the logging backend, which is logback in both the CLI and the JUnit runners. logback is a
 * `provided` dependency of this module: present wherever the tests actually run, and not
 * imposed on anything that merely embeds the validator. If some other backend is in use, or
 * the file cannot be opened, the tests carry on with console output alone rather than failing
 * over their own logging.
 */
public class TxTesterLogFile {

  private static final String APPENDER_NAME = "TX-TESTER-FILE";

  private TxTesterLogFile() {
    throw new IllegalStateException("Utility class. This should never be instantiated");
  }

  /**
   * Start logging to test.log in the given directory, replacing any previous run's file.
   *
   * @param outputDir the test run's output directory; nothing happens if it is null
   * @return the path being written to, or null if no file could be attached
   */
  public static String start(String outputDir) {
    if (outputDir == null) {
      return null;
    }
    try {
      String path = Utilities.path(outputDir, "test.log");
      Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
      stop(); // a second run in the same JVM writes a fresh file rather than two appenders

      PatternLayoutEncoder encoder = new PatternLayoutEncoder();
      encoder.setContext(root.getLoggerContext());
      encoder.setPattern("%d{HH:mm:ss.SSS} %-5level %msg%n");
      encoder.start();

      FileAppender<ILoggingEvent> appender = new FileAppender<>();
      appender.setContext(root.getLoggerContext());
      appender.setName(APPENDER_NAME);
      appender.setFile(path);
      appender.setAppend(false);
      // the run may end in an exception or be interrupted, and a half-written log is still
      // worth having, so take the flush on every event
      appender.setImmediateFlush(true);
      appender.setEncoder(encoder);
      appender.start();

      root.addAppender(appender);
      return path;
    } catch (Exception | NoClassDefFoundError ignored) {
      // logging is not the point of the exercise: if the backend is not logback, or the file
      // cannot be written, the run continues with whatever the console gives us
      return null;
    }
  }

  /** Detach and close the log file, if one was attached. */
  public static void stop() {
    try {
      Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
      ch.qos.logback.core.Appender<ILoggingEvent> existing = root.getAppender(APPENDER_NAME);
      if (existing != null) {
        root.detachAppender(existing);
        existing.stop();
      }
    } catch (Exception | NoClassDefFoundError ignored) {
      // nothing to do
    }
  }
}
