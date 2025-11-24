package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.FHIRPathParameters;

public class FHIRPathParametersParser implements IParamParser<FHIRPathParameters> {

  public static final String FHIRPATH = "-fhirpath";

  FHIRPathParameters fhirPathParameters = new FHIRPathParameters();

  @Override
  public FHIRPathParameters getParameterObject() {
    return fhirPathParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(FHIRPATH)) {
        if (fhirPathParameters.getFhirpath() == null) {
          if (i + 1 == args.length) {
            throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
          } else {
            fhirPathParameters.setFhirpath(args[i + 1].getValue());
            Arg.setProcessed(args, i, 2, true);
          }
        } else {
          throw new RuntimeException("Can only nominate a single -fhirpath parameter");
        }
      }
    }
  }
}
