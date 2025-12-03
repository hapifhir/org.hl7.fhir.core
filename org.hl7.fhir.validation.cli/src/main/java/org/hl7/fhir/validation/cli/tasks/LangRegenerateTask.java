package org.hl7.fhir.validation.cli.tasks;

import java.io.File;

import org.hl7.fhir.utilities.i18n.POGenerator;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.LangRegenParametersParser;
import org.hl7.fhir.validation.service.model.LangRegenParameters;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class LangRegenerateTask extends StandaloneTask {

  @Override
  public String getName() {
    return "lang-regen";
  }

  @Override
  public String getDisplayName() {
    return "Java Lang Regeneration";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, LangRegenParametersParser.LANG_REGEN);
  }

  @Override
  public void logHelp(Logger out) {

  }

  @Override
  public void executeTask(@Nonnull String[] stringArgs) throws Exception {
    LangRegenParametersParser langRegenParametersParser = new LangRegenParametersParser();
    GlobalParametersParser globalParametersParser = new GlobalParametersParser();
    Arg[] args = Arg.of(stringArgs);
    globalParametersParser.parseArgs(args);
    langRegenParametersParser.parseArgs(args);

    String core = langRegenParametersParser.getParameterObject().getLangRegenParam().get(0);
    String igpub = langRegenParametersParser.getParameterObject().getLangRegenParam().get(1);
    String pascal = langRegenParametersParser.getParameterObject().getLangRegenParam().get(2);
    if (!new File(core).exists()) {
      throw new Error("Did not find fhir hapi core source from https://github.com/hapifhir/org.hl7.fhir.core at "+core);      
    }
    if (!new File(igpub).exists()) {
      throw new Error("Did not find fhir hapi core source from https://github.com/HL7/fhir-ig-publisher at "+igpub);      
    }
    if (!new File(pascal).exists()) {
      throw new Error("Did not find fhir hapi core source from https://github.com/HealthIntersections/fhirserver at "+pascal);      
    }
    new POGenerator().execute(core, igpub, pascal);
  }

}
