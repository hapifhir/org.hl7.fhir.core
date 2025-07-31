package org.hl7.fhir.validation.cli.tasks;

import java.io.File;

import org.hl7.fhir.utilities.i18n.POGenerator;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class LangRegenerateTask extends ValidationEngineTask {

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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return validationContext.getMode() == EngineMode.LANG_REGEN;
  }

  @Override
  public void logHelp(Logger out) {

  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    String core = validationContext.getLangRegenParam().get(0); 
    String igpub = validationContext.getLangRegenParam().get(1);
    String pascal = validationContext.getLangRegenParam().get(2);
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
