package org.hl7.fhir.validation.tests.logging;

import org.slf4j.Logger;

public class AClassThatLogs {

  static final Logger logger = org.slf4j.LoggerFactory.getLogger(AClassThatLogs.class);

  public static void doSomeLogging() {
    logger.info("hey I'm doing some stuff statically.");
  }

  public void doSomeLoggingAsAnInstance() {
    logger.info("hey I'm doing some stuff as an instance.");
    logger.debug("  here's some debug info.");
    logger.debug("  1 is equal to 1.");
    logger.trace("     if we're getting serious, here's some trace info.");
    logger.trace("     1.0 is equal to 1.0");
    logger.warn("I smell burning insulation.");
    logger.error("Everything is on fire.");
    logger.error("Power supply failure", new Exception("The power supply is on fire."));
  }

  public void doSomeLoggingThatTracksProgress() {

  }
}
