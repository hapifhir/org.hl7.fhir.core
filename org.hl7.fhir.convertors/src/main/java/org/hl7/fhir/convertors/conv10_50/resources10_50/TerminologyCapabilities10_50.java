package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.dstu2.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;

public class TerminologyCapabilities10_50 {
  public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src) {
    TerminologyCapabilities res = new TerminologyCapabilities();
    for (Parameters.ParametersParameterComponent p : src.getParameter()) {
      if (p.getName().equals("system")) res.addCodeSystem().setUri(p.getValue().primitiveValue());
      if (p.getName().equals("expansion.parameter"))
        res.getExpansion().addParameter().setName(p.getValue().primitiveValue());
    }
    return res;
  }
}
