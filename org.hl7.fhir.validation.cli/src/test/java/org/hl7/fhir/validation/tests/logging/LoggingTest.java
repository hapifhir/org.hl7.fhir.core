package org.hl7.fhir.validation.tests.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.joran.spi.JoranException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.hl7.fhir.validation.tests.logging.LoggingUtil.*;

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
    String logFilePath = Files.createTempFile("logging-test", ".log").toString();
    test(logFilePath);
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

  @AfterEach
  public void tearDown() throws JoranException, IOException {
    setLogbackConfig(LogbackTests.class.getResourceAsStream("/logback-test.xml"));
  }
}
