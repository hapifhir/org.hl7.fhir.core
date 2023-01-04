package org.hl7.fhir.utilities;

public class LoincLinker {

  public static String getLinkForCode(String code) {
    return "https://loinc.org/"+code+"/";
  }
}
