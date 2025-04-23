package org.hl7.fhir.validation.cli.logging;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.instance.ProgressLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class AClassThatLogs {

  public static void doSomeLogging() {
    log.info("I'm doing some stuff statically now");
  }

  public void doSomeLoggingAsAnInstance() throws InterruptedException {
    log.info("Hey, I'm doing some stuff as an instance.");
    log.info("I'm loading some IGs.");
    Thread.sleep(2000);
    log.info("I'm doing unspeakable things in the package cache.");
    Thread.sleep(2000);
    log.debug("  here's some debug info.");
    log.debug("  1 is equal to 1.");
    log.trace("     if we're getting serious, here's some trace info.");
    log.trace("     1.0 is equal to 1.0");
  }

  public void doSomeWarningAndErrorLogging() throws InterruptedException {
    log.warn("I smell burning insulation.");
    Thread.sleep(2000);
    log.error("Everything is on fire.");
    log.error("Power supply failure", new Exception("The power supply is on fire."));
  }

  public void doSomeLoggingThatTracksProgress() throws InterruptedException {
    ProgressLogger progressLogger = new ProgressLogger(log, "Reticulating splines", 8);
    String[] progressMessages = {
      "0",
      "20",
      "40",
      "60",
      "80",
      "100"
    };
    for (String progressMessage : progressMessages) {
      progressLogger.logProgress(progressMessage);
      Thread.sleep(1000);
    }
    progressLogger.done();
  }

  public List<String> randomProgressAndLogging() throws InterruptedException {
    ProgressLogger progressLogger = new ProgressLogger(log, "Reticulating splines", 8);
    List<String> expectedLogMessages = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      String log = randomLog(i);
      if (log != null) {
        expectedLogMessages.add(log);
      }
      progressLogger.logProgress(String.valueOf(i));
    }
    progressLogger.done();
    return expectedLogMessages;
  }

  private static String randomLog(int i) {
    Random rand = new Random();
    int randomElement =rand.nextInt(6);
    final String logMessage;
    switch (randomElement) {
      case 0: logMessage = "Error message " + i; log.error(logMessage); return logMessage;
      case 1: logMessage = "Warning message " + i; log.warn(logMessage); return logMessage;
      case 2: logMessage = "Info message " + i; log.info(logMessage); return logMessage;
      case 3: logMessage = "Debug message " + i; log.debug(logMessage); return logMessage;
      case 4: logMessage = "Trace message " + i; log.trace(logMessage); return logMessage;
      default: return null; // do nothing
    }
  }
}
