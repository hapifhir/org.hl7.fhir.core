package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.slf4j.Logger;

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return validationContext.getMode() == EngineMode.LANG_TRANSFORM;
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args) throws Exception {
    validationService.transformLang(validationContext, validationEngine);
  }

}
