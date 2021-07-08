package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.r4.model.TerminologyCapabilities;

public class TerminologyCapabilities30_40 {
  public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src, boolean b) {
    TerminologyCapabilities res = new TerminologyCapabilities();
    for (Parameters.ParametersParameterComponent p : src.getParameter()) {
      if (p.getName().equals("system")) res.addCodeSystem().setUri(p.getValue().primitiveValue());
    }
    return res;
  }
}
