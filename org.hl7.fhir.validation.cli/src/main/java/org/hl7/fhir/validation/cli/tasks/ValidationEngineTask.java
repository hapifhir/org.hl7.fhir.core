package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.InstanceValidatorParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.UnprocessedParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.ValidationEngineParametersParser;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Locale;

@Slf4j
public abstract class ValidationEngineTask extends ValidationServiceTask{

  protected abstract class ValidationEngineTaskInstance {

    final Arg[] args;
    final ValidationEngineParameters validationEngineParameters;
    final InstanceValidatorParameters instanceValidatorParameters;
    final List<String> sources;

    ValidationEngineTaskInstance(Arg[] args) {
      this.args = args;
      ValidationEngineParametersParser validationEngineParametersParser = new ValidationEngineParametersParser();
      InstanceValidatorParametersParser instanceValidatorParametersParser = new InstanceValidatorParametersParser();

      validationEngineParametersParser.parseArgs(args);
      validationEngineParameters = validationEngineParametersParser.getParameterObject();
      if (usesInstanceValidatorParameters()) {
        instanceValidatorParametersParser.parseArgs(args);
        instanceValidatorParameters = instanceValidatorParametersParser.getParameterObject();
      } else {
        instanceValidatorParameters = null;
      }
      buildTaskSpecificParametersFromArgs(args);
      UnprocessedParametersParser unprocessedParametersParser = new UnprocessedParametersParser();
      unprocessedParametersParser.parseArgs(args);
      sources = unprocessedParametersParser.getParameterObject();
    }

    protected abstract void buildTaskSpecificParametersFromArgs(Arg[] args);

    protected abstract void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception;
  }

  protected abstract ValidationEngineTaskInstance getValidationEngineTaskInstance(Arg[] args);

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull String[] stringArgs) throws Exception {
    Arg[] args = Arg.of(stringArgs);

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
  }
}
