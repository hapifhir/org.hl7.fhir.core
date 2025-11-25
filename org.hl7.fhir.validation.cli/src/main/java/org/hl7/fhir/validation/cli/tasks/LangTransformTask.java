package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.TransformLangParametersParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.model.TransformLangParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class LangTransformTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "lang-transform";
  }

  @Override
  public String getDisplayName() {
    return "Lang Transform";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, TransformLangParametersParser.LANG_TRANSFORM);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  protected LangTransformTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new LangTransformTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class LangTransformTaskInstance extends ValidationEngineTaskInstance {

    TransformLangParameters transformLangParameters;
    OutputParameters outputParameters;

    LangTransformTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      TransformLangParametersParser transformLangParametersParser = new TransformLangParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();

      transformLangParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);

      transformLangParameters = transformLangParametersParser.getParameterObject();
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.transformLang(validationEngine, new org.hl7.fhir.validation.service.TransformLangParameters(
        transformLangParameters.getLangTransform(),
        transformLangParameters.getInputs(),
        transformLangParameters.getSrcLang(),
        transformLangParameters.getTgtLang(),
        sources,
        outputParameters.getOutput()
      ));
    }
  }
}
