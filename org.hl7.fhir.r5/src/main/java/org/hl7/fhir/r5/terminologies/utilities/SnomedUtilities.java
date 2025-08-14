package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;


//URL: http://snomed.info/sct/[module]/version/[e.g. 20150131]'
//International: 900000000000207008
//US:  731000124108
//Australia: 32506021000036107
//Belgium: 11000172109
//Canada: 20611000087101
//Spain: 449081005
//Denmark: 554471000005108
//Netherlands: 11000146104
//Sweden: 45991000052106
//Switzerland: 2011000195101
//UK: 83821000000107
//IPS: 827022005
                       
@MarkedToMoveToAdjunctPackage
public class SnomedUtilities {

  public static String getVersionFromParameters(Parameters p, String version) {
    for (ParametersParameterComponent pp : p.getParameter()) {
      switch (pp.getName()) {
      case "system-version" :
        if (version == null) {
          return pp.getValue().primitiveValue();
        }
      case "force-system-version":
        return pp.getValue().primitiveValue();
      }
    }
    return version;
  }

  public static String getEditionFromVersion(String version) {
    if (version == null) {
      return null;
    }
    if (version.startsWith("http://snomed.info/sct/")) {
      version = version.substring(23);
    }
    if (version.contains("/")) {
      version = version.substring(0, version.indexOf("/"));
    }
    if (Utilities.existsInList(version, "900000000000207008", "449081005", "11000221109", "32506021000036107", "11000234105", "11000172109",
        "20621000087109", "20611000087101", "554471000005108", "11000181102", "11000229106",
        "11000274103", "1121000189102", "11000220105", "11000146104", "21000210109", "51000202101",
        "11000267109", "900000001000122104", "45991000052106", "2011000195101", "83821000000107",
        "999000021000000109", "5631000179106", "731000124108", "599100012410")) {
      return version;
    } else {
      return null;
    }
  }

  public static String getSctLink(String version, String code, Parameters p) {
    if (!Utilities.noString(code) && !code.contains(":")) { 
      version = SnomedUtilities.getVersionFromParameters(p, version);
      String edId = SnomedUtilities.getEditionFromVersion(version);
      if (edId != null) {
        // if there's a version that's an edition, then:
        // http://snomed.info/sct/11000172109/id//371305003
        return "http://snomed.info/sct/"+edId+"/id/"+code;
      } else {
        // no, version:
        return "http://snomed.info/id/"+code;
      }
    } else { 
      return "https://browser.ihtsdotools.org/"; 
    } 
  }
  public static String getCodeFromAlias(String snomedCT) {
    if ("intl".equals(snomedCT)) return "900000000000207008";
    if ("us".equals(snomedCT)) return "731000124108";
    if ("us+icd10cm".equals(snomedCT)) return "5991000124107";
    if ("uk/clinical".equals(snomedCT)) return "999000021000000109";
    if ("uk".equals(snomedCT)) return "83821000000107";
    if ("au".equals(snomedCT)) return "32506021000036107";
    if ("at".equals(snomedCT)) return "11000234105";
    if ("ca".equals(snomedCT)) return "20611000087101";
    if ("ca-en".equals(snomedCT)) return "20621000087109";
    if ("ca-fr".equals(snomedCT)) return "20611000087101";
    if ("nl".equals(snomedCT)) return "11000146104";
    if ("se".equals(snomedCT)) return "45991000052106";
    if ("es".equals(snomedCT)) return "449081005";
    if ("es-ES".equals(snomedCT)) return "900000001000122104";
    if ("ar".equals(snomedCT)) return "11000221109";
    if ("dk".equals(snomedCT)) return "554471000005108";
    if ("be".equals(snomedCT)) return "11000172109";
    if ("ee".equals(snomedCT)) return "11000181102";
    if ("fi".equals(snomedCT)) return "11000229106";
    if ("de".equals(snomedCT)) return "11000274103";
    if ("in".equals(snomedCT)) return "1121000189102";
    if ("ie".equals(snomedCT)) return "11000220105";
    if ("nz".equals(snomedCT)) return "21000210109";
    if ("no".equals(snomedCT)) return "51000202101";
    if ("kr".equals(snomedCT)) return "11000267109";
    if ("ch".equals(snomedCT)) return "2011000195101";
    if ("uy".equals(snomedCT)) return "5631000179106";
    return null;
  }
}


