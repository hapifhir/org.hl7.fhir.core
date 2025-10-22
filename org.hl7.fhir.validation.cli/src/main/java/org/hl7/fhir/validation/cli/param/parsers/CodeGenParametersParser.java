package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.CodeGenParameters;

public class CodeGenParametersParser implements IParamParser<CodeGenParameters> {

  public static final String OPTION = "-option";
  public static final String OPTIONS = "-options";
    public static final String CODEGEN = "-codegen";

    CodeGenParameters codeGenParameters = new CodeGenParameters();
  @Override
  public CodeGenParameters getParameterObject() {
    return codeGenParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].getValue().equals(OPTION)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -option without indicating option value");
        } else {
          codeGenParameters.addOption(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(OPTIONS)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -options without indicating option values");
        } else {
          String p = args[i + 1].getValue();
          for (String s : p.split("\\,")) {
            codeGenParameters.addOption(s);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}
