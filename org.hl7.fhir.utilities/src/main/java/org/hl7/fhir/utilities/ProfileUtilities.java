package org.hl7.fhir.utilities;

public class ProfileUtilities {
  private ProfileUtilities (){
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  /**
   * Get the last entry in a
   * @param input
   * @return
   */
  public static String getLastPathEntry(String input) {
    int lastIndex = input.lastIndexOf('.');
    return input.substring(lastIndex);
  }
}
