package org.hl7.fhir.validation.cli.picocli;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.picocli.options.DebugOptions;
import org.hl7.fhir.validation.cli.picocli.options.LocaleOptions;
import org.hl7.fhir.validation.cli.picocli.options.ProxyOptions;
import org.hl7.fhir.validation.service.ValidationService;
import picocli.CommandLine;

import javax.annotation.Nonnull;

@Slf4j
public abstract class ValidationEngineCommand {

  @CommandLine.ArgGroup(validate = false, heading = "Debug Options%n")
  DebugOptions debugOptions = new DebugOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Locale Options%n")
  LocaleOptions localeOptions = new LocaleOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Proxy Options%n")
  ProxyOptions proxyOptions = new ProxyOptions();
/*
  public void call(@Nonnull ValidationService validationService) throws Exception {


    GlobalParametersParser globalParametersParser = new GlobalParametersParser();
    globalParametersParser.parseArgs(args);

    TimeTracker timeTracker = new TimeTracker();
    TimeTracker.Session timeTrackerSession = timeTracker.start("Loading");

    ValidationEngineTaskInstance validationEngineTaskInstance = getValidationEngineTaskInstance(args);

    ValidationEngine validationEngine = getValidationEngine(validationService, validationEngineTaskInstance, timeTracker);
    timeTrackerSession.end();
    validationEngineTaskInstance.executeTask(validationService, validationEngine);
    log.info("Done. " + timeTracker.report()+". Max Memory = "+ Utilities.describeSize(Runtime.getRuntime().maxMemory()));
  }

  public boolean inferFhirVersion() {
    return false;
  }

  public abstract boolean usesInstanceValidatorParameters();

  private ValidationEngine getValidationEngine(ValidationService validationService, ValidationEngineTaskInstance validationEngineTaskInstance, TimeTracker timeTracker) throws Exception {
    if (inferFhirVersion()) {
      validationEngineTaskInstance.validationEngineParameters.setInferFhirVersion(Boolean.TRUE);
    }

    if (validationEngineTaskInstance.validationEngineParameters.getSv() == null) {
      validationEngineTaskInstance.validationEngineParameters.setSv(validationService.determineVersion(validationEngineTaskInstance.validationEngineParameters.getIgs(), validationEngineTaskInstance.sources, validationEngineTaskInstance.validationEngineParameters.isRecursive(), validationEngineTaskInstance.validationEngineParameters.isInferFhirVersion()));
    }


    if (usesInstanceValidatorParameters()) {
      log.info("  Locale: "+ Locale.getDefault().getDisplayCountry()+"/"+Locale.getDefault().getCountry());
      if (validationEngineTaskInstance.instanceValidatorParameters.getJurisdiction() == null) {
        log.info("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");
        log.info("  Note that exceptions and validation failures may happen in the absence of a locale");
      } else {
        log.info("  Jurisdiction: "+ JurisdictionUtilities.displayJurisdiction(validationEngineTaskInstance.instanceValidatorParameters.getJurisdiction()));
      }}

    log.info("Loading");
    String definitions = "dev".equals(validationEngineTaskInstance.validationEngineParameters.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(validationEngineTaskInstance.validationEngineParameters.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationEngineTaskInstance.validationEngineParameters.getSv());
    return validationService.initializeValidator(validationEngineTaskInstance.validationEngineParameters, validationEngineTaskInstance.instanceValidatorParameters, definitions, timeTracker, validationEngineTaskInstance.sources);
  }*/
}
