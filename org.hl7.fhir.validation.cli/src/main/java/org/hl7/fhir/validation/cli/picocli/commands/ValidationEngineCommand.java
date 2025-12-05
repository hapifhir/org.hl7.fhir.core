package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.*;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Slf4j
public abstract class ValidationEngineCommand extends ValidationServiceCommand {

  @CommandLine.ArgGroup(validate = false, heading = "Debug Options%n")
  DebugOptions debugOptions = new DebugOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Locale Options%n")
  LocaleOptions localeOptions = new LocaleOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Proxy Options%n")
  ProxyOptions proxyOptions = new ProxyOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Validation Engine%n")
  ValidationEngineOptions validationEngineOptions = new ValidationEngineOptions();

  public ValidationEngineCommand(ValidationService validationService) {
    super(validationService);
  }

  protected ValidationEngineParameters getValidationEngineParameters() {
    ValidationEngineOptionsConvertor convertor = new ValidationEngineOptionsConvertor();
    ValidationEngineParameters validationEngineParameters = convertor.convert(validationEngineOptions);
    if (localeOptions.locale != null) {
      validationEngineParameters.setLocale(Locale.forLanguageTag(localeOptions.locale));
    }
    log.info(validationEngineParameters.toString().replace(", ", ", \n"));

    return validationEngineParameters;
  }

  @Override
  public Integer call() { // your business logic goes here...
    ValidationEngineParameters validationEngineParameters = getValidationEngineParameters();
    TimeTracker timeTracker = new TimeTracker();
    TimeTracker.Session timeTrackerSession = timeTracker.start("Loading");

    ValidationEngine validationEngine = null;
    try {
      validationEngine = getValidationEngine(timeTracker);
    } catch (Exception e) {
      log.error("Unable to load validationEngine.", e);
      return 1;
    }
    timeTrackerSession.end();
    Integer result = call(validationService, validationEngine);
    log.info("Done. " + timeTracker.report()+". Max Memory = "+ Utilities.describeSize(Runtime.getRuntime().maxMemory()));
    return result;
  }

  public boolean inferFhirVersion() {
    return false;
  }

  public abstract InstanceValidatorOptions getInstanceValidatorOptions();

  public abstract List<String> getSources();

  protected abstract Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine);

  private ValidationEngine getValidationEngine(TimeTracker timeTracker) throws Exception {
    ValidationEngineParameters validationEngineParameters = getValidationEngineParameters();
    if (inferFhirVersion()) {
      validationEngineParameters.setInferFhirVersion(Boolean.TRUE);
    }

    List<String> sources = getSources();
    if (validationEngineParameters.getSv() == null) {
      validationEngineParameters.setSv(validationService.determineVersion(validationEngineParameters.getIgs(), sources, validationEngineParameters.isRecursive(), validationEngineParameters.isInferFhirVersion()));
    }

    InstanceValidatorOptions instanceValidatorOptions = getInstanceValidatorOptions();
    if (instanceValidatorOptions != null) {
      log.info("  Locale: "+ Locale.getDefault().getDisplayCountry()+"/"+Locale.getDefault().getCountry());
      if (instanceValidatorOptions.jurisdiction == null) {
        log.info("  Jurisdiction: None specified (locale = "+Locale.getDefault().getCountry()+")");
        log.info("  Note that exceptions and validation failures may happen in the absence of a locale");
      } else {
        log.info("  Jurisdiction: "+ JurisdictionUtilities.displayJurisdiction(instanceValidatorOptions.jurisdiction));
      }
    }

    //FIXME convert CLI options to parameters
    InstanceValidatorParameters instanceValidatorParameters = null;

    log.info("Loading");
    String definitions = "dev".equals(validationEngineParameters.getSv()) ? "hl7.fhir.r5.core#current" : VersionUtilities.packageForVersion(validationEngineParameters.getSv()) + "#" + VersionUtilities.getCurrentVersion(validationEngineParameters.getSv());

    return validationService.initializeValidator(validationEngineParameters, instanceValidatorParameters, definitions, timeTracker, sources);
  }
}
