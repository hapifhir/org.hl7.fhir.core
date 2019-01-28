package org.hl7.fhir.validation.tests.utilities;

import java.io.IOException;

public class TestUtilities {

  public static boolean silent = false;
  
  public static String resourceNameToFile(String name) throws IOException {
    return org.hl7.fhir.utilities.Utilities.path(System.getProperty("user.dir"), "src", "test", "resources", name);
  }


  public static String resourceNameToFile(String subFolder, String name) throws IOException {
    return org.hl7.fhir.utilities.Utilities.path(System.getProperty("user.dir"), "src", "test", "resources", subFolder, name);
  }
  
}
