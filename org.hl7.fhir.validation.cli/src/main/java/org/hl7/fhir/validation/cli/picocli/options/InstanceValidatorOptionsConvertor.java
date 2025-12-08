package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

public class InstanceValidatorOptionsConvertor {
  public InstanceValidatorParameters convert(InstanceValidatorOptions options) {
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();

    // String fields - null check then setter
    if (options.jurisdiction != null) {
      instanceValidatorParameters.setJurisdiction(options.jurisdiction);
    }

    if (options.expansionParameters != null) {
      instanceValidatorParameters.setExpansionParameters(options.expansionParameters);
    }

    // List fields - null/empty check, loop with addX() methods
    if (options.profiles != null && !options.profiles.isEmpty()) {
      for (String profile : options.profiles) {
        instanceValidatorParameters.addProfile(profile);
      }
    }

    return instanceValidatorParameters;
  }
}
