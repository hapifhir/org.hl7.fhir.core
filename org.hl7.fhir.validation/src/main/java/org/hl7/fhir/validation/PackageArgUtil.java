package org.hl7.fhir.validation;

public class PackageArgUtil {
  public static boolean hasExplicitFhirVersion(String thePackageArg) {
    return (thePackageArg.startsWith("[") && thePackageArg.indexOf(']', 1) > 1);
  }

  public static String getExplicitFhirVersion(String thePackageArg) {
    return thePackageArg.substring(1,thePackageArg.indexOf(']', 1));
  }

  public static String getPackageForExplicitFhirVersion(String thePackageArg) {
    return thePackageArg.substring(thePackageArg.indexOf(']',1) + 1);
  }
}
