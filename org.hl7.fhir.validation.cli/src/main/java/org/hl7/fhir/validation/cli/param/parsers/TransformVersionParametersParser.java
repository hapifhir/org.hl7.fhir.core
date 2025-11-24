package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.TransformVersionParameters;

public class TransformVersionParametersParser implements IParamParser<TransformVersionParameters> {

  public static final String TO_VERSION = "-to-version";
  public static final String DO_NATIVE = "-do-native";
  public static final String NO_NATIVE = "-no-native";

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
      } else if (args[i].getValue().equals(DO_NATIVE)) {
        transformVersionParameters.setCanDoNative(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(NO_NATIVE)) {
        transformVersionParameters.setCanDoNative(false);
        args[i].setProcessed(true);
      }
    }
  }
}
