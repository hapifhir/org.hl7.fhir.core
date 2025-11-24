package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.OutputParameters;

public class OutputParametersParser implements IParamParser<OutputParameters> {

  public static final String OUTPUT = "-output";
  public static final String OUTPUT_SUFFIX = "-outputSuffix";

  OutputParameters outputParameters = new OutputParameters();

  @Override
  public OutputParameters getParameterObject() {
    return outputParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(OUTPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -output without indicating output file");
        else {
          outputParameters.setOutput(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(OUTPUT_SUFFIX)) {
        if (i + 1 == args.length)
          throw new Error("Specified -outputSuffix without indicating output suffix");
        else {
          outputParameters.setOutputSuffix(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}