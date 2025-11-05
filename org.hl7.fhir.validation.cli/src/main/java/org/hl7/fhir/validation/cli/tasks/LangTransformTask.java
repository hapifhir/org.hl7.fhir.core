package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.TransformLangParametersParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.EngineMode;
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
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    validationService.transformLang(validationContext, validationEngine);
  }

}
