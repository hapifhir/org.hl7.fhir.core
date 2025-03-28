package org.hl7.fhir.utilities;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class SystemOutTests {
  public static final String TO_OVERWRITE = "TO_OVERWRITE";

  /**
   * This test has no actual assertions. It demonstrates how carriage return operates in a console. This behavior is
   * important for logging purposes, particularly in cases where progress indicators should 'disappear' after completion
   * in the logs, both in files, and in console output.
   * <p/>
   * The intended output for this test is:
   * <code>
   * Line 1
   * Line 2
   * </code>
   * This should work across most platforms, and this test can help diagnose issues in particular environments.
   */
  @Test
  public void testCarriageReturn() {
      System.out.println("Line 1");
      /*
      Writes something, then overwrites it with empty space. In some cases, such as Windows previous content will
      persist, so partial overwrites will leave characters when newly written content is too short.
      */
      System.out.print(TO_OVERWRITE + "\r" + StringUtils.repeat(" ", TO_OVERWRITE.length()) + "\r");
      System.out.println("Line 2");
  }
}
