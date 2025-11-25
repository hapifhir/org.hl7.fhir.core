package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.LangRegenParameters;

public class LangRegenParametersParser implements IParamParser<LangRegenParameters> {

  public static final String LANG_REGEN = "-lang-regen";

  LangRegenParameters langRegenParameters = new LangRegenParameters();

  @Override
  public LangRegenParameters getParameterObject() {
    return langRegenParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(LANG_REGEN)) {
        if (i + 3 >= args.length) {
          throw new Error("Specified -lang-regen without indicating three required parameters");
        } else {
          langRegenParameters.addLangRegenParam(args[i + 1].getValue());
          langRegenParameters.addLangRegenParam(args[i + 2].getValue());
          langRegenParameters.addLangRegenParam(args[i + 3].getValue());
          Arg.setProcessed(args, i, 4, true);
        }
      }
    }
  }
}