package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SIDUtilities {

  private static final Set<String> CODE_SYSTEMS;
  private static final Set<String> ID_SYSTEMS;
  private static final Set<String> INCORRECT_SIDS;
  private static final Set<String> ALL_SYSTEMS;

  static {
    // Initialize code systems
    Set<String> codeSystems = new HashSet<>();
    codeSystems.add("http://hl7.org/fhir/sid/ndc");
    codeSystems.add("http://hl7.org/fhir/sid/icpc-2");
    codeSystems.add("http://hl7.org/fhir/sid/icpc-1");
    codeSystems.add("http://hl7.org/fhir/sid/icpc-1-nl");
    codeSystems.add("http://hl7.org/fhir/sid/icd-9");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10");
    codeSystems.add("http://hl7.org/fhir/sid/cvx");
    codeSystems.add("http://hl7.org/fhir/sid/srt");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10-vn");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10-cm");
    codeSystems.add("http://hl7.org/fhir/sid/icd-10-am");
    codeSystems.add("http://hl7.org/fhir/sid/icd-9-cm");
    codeSystems.add("http://hl7.org/fhir/sid/icf-nl");
    codeSystems.add("http://hl7.org/fhir/sid/ca-hc-npn");
    codeSystems.add("http://hl7.org/fhir/sid/ca-hc-din");
    codeSystems.add("http://hl7.org/fhir/sid/dsm5");
    codeSystems.add("http://hl7.org/fhir/sid/ex-icd-10-procedures");
    CODE_SYSTEMS = Collections.unmodifiableSet(codeSystems);

    // Initialize ID systems
    Set<String> idSystems = new HashSet<>();
    idSystems.add("http://hl7.org/fhir/sid/us-ssn");
    idSystems.add("http://hl7.org/fhir/sid/us-npi");
    idSystems.add("http://hl7.org/fhir/sid/eui-48/bluetooth");
    idSystems.add("http://hl7.org/fhir/sid/eui-48/ethernet");
    ID_SYSTEMS = Collections.unmodifiableSet(idSystems);

    // Initialize incorrect SIDs
    Set<String> incorrectSids = new HashSet<>();
    incorrectSids.add("http://hl7.org/fhir/sid/icpc2");
    incorrectSids.add("http://hl7.org/fhir/sid/icf-nl");
    incorrectSids.add("http://hl7.org/fhir/sid/ca-hc-npn");
    incorrectSids.add("http://hl7.org/fhir/sid/ca-hc-din");
    incorrectSids.add("http://hl7.org/fhir/sid/dsm5");
    INCORRECT_SIDS = Collections.unmodifiableSet(incorrectSids);

    // Initialize all systems
    Set<String> allSystems = new HashSet<>();
    allSystems.addAll(CODE_SYSTEMS);
    allSystems.addAll(ID_SYSTEMS);
    ALL_SYSTEMS = Collections.unmodifiableSet(allSystems);
  }

  public static Set<String> codeSystemList() {
    return CODE_SYSTEMS;
  }

  public static Set<String> idSystemList() {
    return ID_SYSTEMS;
  }

  private static boolean isPassPortSID(String url) {
    // TODO: verify ISO countrycode part vs country code list
    return url.matches("^http:\\/\\/hl7.org\\/fhir\\/sid\\/passport-[a-zA-Z]{3}$");
  }

  public static boolean isknownCodeSystem(String system) {
    return CODE_SYSTEMS.contains(system);
  }

  public static boolean isKnownSID(String url) {
    return isknownCodeSystem(url) || isknownIDSystem(url);
  }

  public static boolean isIncorrectSID(String url) {
    return INCORRECT_SIDS.contains(url);
  }

  private static boolean isknownIDSystem(String url) {
    return ID_SYSTEMS.contains(url) || isPassPortSID(url);
  }

  public static Set<String> allSystemsList() {
    return ALL_SYSTEMS;
  }

  public static boolean isInvalidVersion(String u, String v) {
    if (v == null) {
      return false;
    } else {
      if (ID_SYSTEMS.contains(u)) {
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
          case "http://hl7.org/fhir/sid/icd-10-am":
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