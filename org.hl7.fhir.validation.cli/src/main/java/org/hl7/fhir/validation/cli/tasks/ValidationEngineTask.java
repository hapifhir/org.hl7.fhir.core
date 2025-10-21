package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;

import javax.annotation.Nonnull;
import java.util.Locale;

@Slf4j
public abstract class ValidationEngineTask extends ValidationServiceTask{

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] args) throws Exception {
    ValidationContext validationContext = Params.loadValidationContext(args);
    executeTask(validationService, validationContext, args);
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    TimeTracker tt = new TimeTracker();
    TimeTracker.Session tts = tt.start("Loading");

    ValidationEngine validationEngine = getValidationEngine(validationService, tt, validationContext);
    tts.end();
    executeTask(validationService, validationEngine, validationContext, args);
    log.info("Done. " + tt.report()+". Max Memory = "+ Utilities.describeSize(Runtime.getRuntime().maxMemory()));
  }

  public abstract void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception;

  public boolean inferFhirVersion() {
    return false;
  }

  private ValidationEngine getValidationEngine(ValidationService validationService, TimeTracker tt, ValidationContext validationContext) throws Exception {
    if (inferFhirVersion()) {
      validationContext.setInferFhirVersion(Boolean.TRUE);
    }

    if (validationContext.getSv() == null) {
      validationContext.setSv(validationService.determineVersion(validationContext));
    }

    ValidationEngine validationEngine;
    log.info("  Locale: "+ Locale.getDefault().getDisplayCountry()+"/"+Locale.getDefault().getCountry());
    if (validationContext.getJurisdiction() == null) {
      log.info("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");
      log.info("  Note that exceptions and validation failures may happen in the absence of a locale");
    } else {
      log.info("  Jurisdiction: "+ JurisdictionUtilities.displayJurisdiction(validationContext.getJurisdiction()));
    }

    log.info("Loading");
    String definitions = "dev".equals(validationContext.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(validationContext.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationContext.getSv());
    validationEngine = validationService.initializeValidator(validationContext, definitions, tt);
    return validationEngine;
  }
}
