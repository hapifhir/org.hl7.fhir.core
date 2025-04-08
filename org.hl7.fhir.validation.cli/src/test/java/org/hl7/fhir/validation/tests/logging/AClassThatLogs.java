package org.hl7.fhir.validation.tests.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

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
    ProgressLogger progressLogger = new ProgressLogger(log, "Reticulating splines", 0, "%");
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
}
