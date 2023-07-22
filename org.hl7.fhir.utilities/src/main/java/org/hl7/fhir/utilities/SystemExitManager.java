package org.hl7.fhir.utilities;

/**
 * A few places in the code, we call System.exit(int) to pass on the exit code to 
 * other tools (for integration in scripts)
 * 
 * But you don't want to do that while running the failing things under JUnit 
 * This class does two things 
 * 
 * * Remember the exit code while shutdown / cleanup happens 
 * * Allow for a test case to turn exiting off altogther 
 *  
 * @author grahamegrieve
 *
 */
public class SystemExitManager {

  private static int error;
  private static boolean noExit;

  public static int getError() {
    return error;
  }

  public static void setError(int error) {
    SystemExitManager.error = error;
  }

  public static boolean isNoExit() {
    return noExit;
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
