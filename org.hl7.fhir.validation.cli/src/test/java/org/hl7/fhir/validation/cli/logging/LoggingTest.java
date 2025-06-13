package org.hl7.fhir.validation.cli.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.joran.spi.JoranException;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileUtilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hl7.fhir.validation.cli.logging.LoggingTestUtil.captureLogOutput;
import static org.hl7.fhir.validation.cli.logging.LogbackUtilities.*;

@Slf4j
public class LoggingTest {

  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(5000);
    if (args.length == 0) {
      System.out.println("Please provide a log file path as an argument.");
      return;
    }
    LoggingTest test = new LoggingTest();
    test.test(args[0]);
  }
  @Test
  public void test() throws InterruptedException, IOException {
    File logFile = FileUtilities.createTempFile("logging-test", ".log");
    test(logFile.getAbsolutePath());
  }

  private static void test(String logFilePath) throws InterruptedException {
    setLogToFile(logFilePath);
    setLogLevel(Level.TRACE);
    AClassThatLogs aClassThatLogs = new AClassThatLogs();
    aClassThatLogs.doSomeLoggingAsAnInstance();
    aClassThatLogs.doSomeLoggingThatTracksProgress();
    AClassThatLogs.doSomeLogging();
    aClassThatLogs.doSomeWarningAndErrorLogging();
    System.out.println("Logging complete to file: " + logFilePath);
  }



  @Disabled
  @RepeatedTest(10)
  public void testProgressLogging() throws IOException, InterruptedException {
    File logFile = FileUtilities.createTempFile("logging-test", ".log");
    testProgressLogging(logFile.getAbsolutePath());
  }

  private void testProgressLogging(String logFilePath) throws InterruptedException, IOException {setLogToFile(logFilePath);

    setLogToFileAndConsole(org.hl7.fhir.validation.cli.logging.Level.TRACE, logFilePath);
    AClassThatLogs aClassThatLogs = new AClassThatLogs();

    List<String> expectedLogs = new ArrayList<>();

    String capturedOutput = captureLogOutput(() -> {
      try {
        expectedLogs.addAll(aClassThatLogs.randomProgressAndLogging());
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    String logFileContent = FileUtilities.fileToString(logFilePath);
    System.out.println("Captured console output:");
    System.out.println("========================");

    System.out.println(capturedOutput);

    System.out.println();
    System.out.println("Log file content:");
    System.out.println("=================");

    for (String expectedLog : expectedLogs) {
      if (expectedLog.startsWith("Info")
        || expectedLog.startsWith("Warning")
        || expectedLog.startsWith("Error")) {
        assertThat(capturedOutput).contains(expectedLog);
      }
      assertThat(logFileContent).contains(expectedLog);
    }

  }

  @AfterEach
  public void tearDown() throws JoranException, IOException {
    setLogbackConfig(LogbackTests.class.getResourceAsStream("/logback-test.xml"));
  }
}
