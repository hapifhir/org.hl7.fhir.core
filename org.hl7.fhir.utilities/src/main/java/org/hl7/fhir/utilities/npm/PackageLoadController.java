package org.hl7.fhir.utilities.npm;

public class PackageLoadController {
  public String checkOKToLoadPackage(String id, String version) {
    return version;
  }

  public PackageLoadController copy() {
    return new PackageLoadController();
  }
}
