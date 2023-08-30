package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SIDUtilities {

  public static List<String> codeSystemList() {
    List<String> codeSystems = new ArrayList<>();
    codeSystems.add("http://hl7.org/fhir/sid/ndc");
    codeSystems.add("http://hl7.org/fhir/sid/icpc2");
    codeSystems.add("http://hl7.org/fhir/sid/icd-9");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10");  
    codeSystems.add("http://hl7.org/fhir/sid/cvx");
    codeSystems.add("http://hl7.org/fhir/sid/srt");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10-vn");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10-cm");
    codeSystems.add("http://hl7.org/fhir/sid/icd-9-cm"); 
    return codeSystems;
  }

  public static List<String> idSystemList() {
    List<String> idSystems = new ArrayList<>();
    idSystems.add("http://hl7.org/fhir/sid/us-ssn");
    idSystems.add("http://hl7.org/fhir/sid/us-npi");
    idSystems.add("http://hl7.org/fhir/sid/eui-48/bluetooth");
    idSystems.add("http://hl7.org/fhir/sid/eui-48/ethernet");
    return idSystems;
  }

  private static boolean isPassPortSID(String url) {
    // TODO: verify ISO countrycode part vs country code list
    return url.matches("^http:\\/\\/hl7.org\\/fhir\\/sid\\/passport-[a-zA-Z]{3}$");
  }
  
  public static boolean isknownCodeSystem(String system) {
    return codeSystemList().contains(system);
  }

  public static boolean isKnownSID(String url) {
    return isknownCodeSystem(url) || isknownIDSystem(url);
  }

  private static boolean isknownIDSystem(String url) {
    return idSystemList().contains(url) || isPassPortSID(url);
  }

  public static List<String> allSystemsList() {
    List<String> allSystems = new ArrayList<>();
    allSystems.addAll(codeSystemList());
    allSystems.addAll(idSystemList());
    return allSystems;
  }

  public static boolean isInvalidVersion(String u, String v) {
    if (v == null) {
      return false;
    } else {
      if (idSystemList().contains(u)) {
        return true;
      } else {
        switch (u) {
        case "http://hl7.org/fhir/sid/ndc":
          return v.matches("[\\d]{8}");
        case "http://hl7.org/fhir/sid/icpc2": 
          return false;
        case "http://hl7.org/fhir/sid/icd-10":
          return false;
        case "http://hl7.org/fhir/sid/icd-9":
          return false;
        case "http://hl7.org/fhir/sid/cvx":
          return v.matches("[\\d]{8}");
        case "http://hl7.org/fhir/sid/srt":
          return false;
        case "http://hl7.org/fhir/sid/icd-10-vn":
          return false;
        case "http://hl7.org/fhir/sid/icd-10-cm":
          return false;
        case "http://hl7.org/fhir/sid/icd-9-cm":
          return false;
        default:
          return true;
        }
      }
    }
  }
    
}
