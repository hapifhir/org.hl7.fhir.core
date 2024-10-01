package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
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
    if (Utilities.existsInList(version, "900000000000207008", "731000124108", "32506021000036107", "11000172109", "20611000087101",
        "449081005", "554471000005108", "11000146104", "45991000052106", "2011000195101", "83821000000107", "827022005")) {
      return version;
    } else {
      return null;
    }
  }

  public static String getSctLink(String version, String code, Parameters p) {
    if (!Utilities.noString(code)) { 
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


