package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.dstu2.model.Parameters;
import org.hl7.fhir.r4.model.TerminologyCapabilities;

public class TerminologyCapabilities10_40 {
  public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src) {
    TerminologyCapabilities res = new TerminologyCapabilities();
    for (Parameters.ParametersParameterComponent p : src.getParameter()) {
      if (p.getName().equals("system")) res.addCodeSystem().setUri(p.getValue().primitiveValue());
    }
    return res;
  }
}
