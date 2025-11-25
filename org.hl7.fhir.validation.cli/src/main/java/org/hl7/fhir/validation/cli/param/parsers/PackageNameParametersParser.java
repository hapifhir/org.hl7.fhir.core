package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.PackageNameParameters;

public class PackageNameParametersParser implements IParamParser<PackageNameParameters> {

  public static final String PACKAGE_NAME = "-package-name";

  PackageNameParameters packageNameParameters = new PackageNameParameters();

  @Override
  public PackageNameParameters getParameterObject() {
    return packageNameParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(PACKAGE_NAME)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -package-name without indicating package name");
        } else {
          packageNameParameters.setPackageName(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}