package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.InstanceFactoryParameters;

public class InstanceFactoryParametersParser implements IParamParser<InstanceFactoryParameters> {

  public static final String FACTORY = "-factory";

  InstanceFactoryParameters instanceFactoryParameters = new InstanceFactoryParameters();

  @Override
  public InstanceFactoryParameters getParameterObject() {
    return instanceFactoryParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(FACTORY)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -factory without indicating source");
        } else {
          instanceFactoryParameters.setSource(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}