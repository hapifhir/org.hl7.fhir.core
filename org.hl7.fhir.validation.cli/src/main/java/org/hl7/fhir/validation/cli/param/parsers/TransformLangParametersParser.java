package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.TransformLangParameters;

public class TransformLangParametersParser implements IParamParser<TransformLangParameters> {
  public static final String SRC_LANG = "-src-lang";
  public static final String TGT_LANG = "-tgt-lang";
  public static final String LANG_TRANSFORM = "-lang-transform";
  public static final String INPUT = "-input";

  private final TransformLangParameters transformLangParameters = new TransformLangParameters();

  @Override
  public TransformLangParameters getParameterObject() {
    return transformLangParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].getValue().equals(SRC_LANG)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -src-lang without indicating file");
        } else {
          transformLangParameters.setSrcLang(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(TGT_LANG)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -tgt-lang without indicating file");
        } else {
          transformLangParameters.setTgtLang(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(LANG_TRANSFORM)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -lang-transform without indicating value");
        } else {
          transformLangParameters.setLangTransform(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(INPUT)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -input without providing value");
        } else {
          transformLangParameters.addInput(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}
