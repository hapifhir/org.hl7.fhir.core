package org.hl7.fhir.validation.cli.logging;

import java.io.IOException;
import java.io.PrintStream;

public class LoggingTestUtil {
  public static String captureLogOutput(Runnable runnable) {
    PrintStream originalOut = System.out;
    final String output;
    try {
      java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
      System.setOut(new java.io.PrintStream(out));
      runnable.run();
      out.flush();
      output = out.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      System.setOut(originalOut);
    }
    return output;
  }
}