package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;


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
    if (Utilities.existsInList(version,
      "900000000000207008", // International
      "449081005", // International Spanish
      "11000221109", // Argentinian
      "32506021000036107", // Australian (with drug extension)
      "11000234105", // Austrian
      "11000172109", // Belgian
      "20621000087109", // Canadian English
      "20611000087101", // Canadian Canadian French
      "21000325107", // Chilean
      "11000279109", // Czech
      "554471000005108", //: Danish
      "11000181102", //: Estonian
      "11000229106", //: Finnish
      "11000274103", //: German
      "1121000189102", //: Indian
      "11000220105", //: Irish
      "11000146104", //: Netherlands
      "21000210109", //: New Zealand
      "51000202101", //: Norwegian
      "11000267109", //: Republic of Korea (South Korea)
      "900000001000122104", //: Spanish National
      "45991000052106", //: Swedish
      "2011000195101", //: Swiss
      "83821000000107", //: UK
      "999000021000000109", //: UK Clinical
      "5631000179106", //: Uruguay
      "731000124108", //: US
      "5991000124107", //: US (with ICD-10-CM maps)
      "827022005" //: IPS Terminology
      )) {
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


