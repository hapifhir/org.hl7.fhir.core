package org.hl7.fhir.support.tests.utilities;

import java.util.Locale;

public class TestUtilities {

  /**
   * True when running under maven surefire (the parent pom sets the runningAsSurefire system property)
   */
  public static boolean runningAsSurefire() {
    String v = System.getProperty("runningAsSurefire");
    return v != null && "true".equals(v.toLowerCase(Locale.ENGLISH));
  }
}
