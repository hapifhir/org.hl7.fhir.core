package org.hl7.fhir.utilities;

import lombok.Getter;

/**
 * A few places in the code, we call System.exit(int) to pass on the exit code to 
 * other tools (for integration in scripts)
 * <p/>
 * But you don't want to do that while running the failing things under JUnit 
 * This class does two things 
 * <p/>
 * * Remember the exit code while shutdown / cleanup happens 
 * * Allow for a test case to turn exiting off altogether
 *  
 * @author grahamegrieve
 *
 */
public class SystemExitManager {

  @Getter
  private static int error;
  @Getter
  private static boolean noExit;

  public static void setError(int error) {
    SystemExitManager.error = error;
  }

  public static void setNoExit(boolean noExit) {
    SystemExitManager.noExit = noExit;
  }

  public static void finish() {
    if (!noExit && error > 0) {
      System.exit(error);
    }
  }

}
