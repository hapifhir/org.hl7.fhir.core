package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.TransformVersionParameters;

public class TransformVersionParametersParser implements IParamParser<TransformVersionParameters> {

  public static final String TO_VERSION = "-to-version";

  TransformVersionParameters transformVersionParameters =  new TransformVersionParameters();

  @Override
  public TransformVersionParameters getParameterObject() {
    return transformVersionParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(TO_VERSION)) {
        transformVersionParameters.setTargetVer(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      }
    }
  }
}
