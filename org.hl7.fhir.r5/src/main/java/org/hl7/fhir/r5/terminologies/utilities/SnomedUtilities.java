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
}


