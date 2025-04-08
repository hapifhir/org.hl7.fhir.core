package org.hl7.fhir.validation.tests.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class LogbackTests {

  public static final String INFO_MESSAGE = "info message";
  public static final String WARNING_MESSAGE = "warning message";
  public static final String ERROR_MESSAGE = "error message";
  public static final String DEBUG_MESSAGE = "debug message";
  public static final String TRACE_MESSAGE = "trace message";

  Logger logger = LoggerFactory.getLogger(LogbackTests.class);

  @AfterEach
  public void tearDown() throws JoranException, IOException {
    setLogbackConfig(LogbackTests.class.getResourceAsStream("/logback-test.xml"));
  }

  private static void setLogbackConfig(InputStream configStream) throws JoranException, IOException {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    loggerContext.reset();
    JoranConfigurator configurator = new JoranConfigurator();
    configurator.setContext(loggerContext);
    configurator.doConfigure(configStream);// loads logback file
    assert configStream != null;
    configStream.close();
  }

  private void setLogLevel(ch.qos.logback.classic.Level level)
  {
    ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    root.setLevel(level);
  }

  private String captureLogOutput(Runnable runnable) {
    PrintStream originalOut = System.out;
    final String output;
    try {
      java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
      System.setOut(new java.io.PrintStream(out));
      runnable.run();
      output = out.toString();
    } finally {
      System.setOut(originalOut);
    }
    return output;
  }


  public static Stream<Arguments> testLevelsParams() {
    return Stream.of(
      Arguments.of(Level.TRACE, Set.of(INFO_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE, DEBUG_MESSAGE, TRACE_MESSAGE), Set.of()),
      Arguments.of(Level.DEBUG, Set.of(INFO_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE, DEBUG_MESSAGE), Set.of(TRACE_MESSAGE)),
      Arguments.of(Level.INFO, Set.of(INFO_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE), Set.of(DEBUG_MESSAGE, TRACE_MESSAGE)),
      Arguments.of(Level.WARN, Set.of(WARNING_MESSAGE, ERROR_MESSAGE), Set.of(INFO_MESSAGE, DEBUG_MESSAGE, TRACE_MESSAGE)),
      Arguments.of(Level.ERROR, Set.of(ERROR_MESSAGE), Set.of(WARNING_MESSAGE, INFO_MESSAGE, DEBUG_MESSAGE, TRACE_MESSAGE))
    );
  }

  @ParameterizedTest
  @MethodSource("testLevelsParams")
  public void testLogLevelSetting(final Level level, Set<String> containedStrings, Set<String> notContainedStrings) throws InterruptedException {
   String output = captureLogOutput(() -> {
    setLogLevel(level);
    logAllLevels();
   });
    System.out.println(output);
    for (String s : containedStrings) {
      assertThat(output).contains(s);
    }
    for (String s : notContainedStrings) {
      assertThat(output).doesNotContain(s);
    }
  }

  @Test
  public void testCustomConfig() throws JoranException, IOException {
    setLogbackConfig(LogbackTests.class.getResourceAsStream("/custom-logback.xml"));
    String output = captureLogOutput(this::logAllLevels);
    System.out.println(output);

    Set<String> everythingButTrace = Set.of(INFO_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE, DEBUG_MESSAGE);
    for (String s : everythingButTrace) {
      assertThat(output).contains(s);
    }
    assertThat(StringUtils.countMatches(output, "custom-text")).isEqualTo(4);
    assertThat(output).doesNotContain(TRACE_MESSAGE);
  }

  private void logAllLevels() {
    logger.info(INFO_MESSAGE);
    logger.warn(WARNING_MESSAGE);
    logger.error(ERROR_MESSAGE);
    logger.debug(DEBUG_MESSAGE);
    logger.trace(TRACE_MESSAGE);
  }
}
