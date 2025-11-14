package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.WatchParametersParser;
import org.hl7.fhir.validation.service.ValidateSourceParameters;
import org.hl7.fhir.validation.service.model.*;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.List;

@Slf4j
public class ValidateTask extends ValidationEngineTask {

  final static String[][] PLACEHOLDERS = {
    { "XML_AND_JSON_FHIR_VERSIONS", "1.0, 1.4, 3.0, 4.0, " + Constants.VERSION_MM + ", 6.0" },
    { "TURTLE_FHIR_VERSIONS", "3.0, 4.0, " + Constants.VERSION_MM },
    { "FHIR_MAJOR_VERSIONS", VersionUtilities.listSupportedMajorVersions()},
    { "FHIR_MINOR_VERSIONS", VersionUtilities.listSupportedVersions() },
    { "FHIR_CURRENT_VERSION", Constants.VERSION_MM}
  };

  @Override
  public String getName() {
    return "validate";
  }

  @Override
  public String getDisplayName() {
    return "Validation";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    // There is no explicit way to trigger a validation task.
    // It is the default task.
    return false;
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/validate.txt", PLACEHOLDERS);
  }

  protected ValidationEngineTaskInstance getValidationEngineTaskInstance(Arg[] args){
    return new ValidateTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return true;
  }

  protected class ValidateTaskInstance extends ValidationEngineTaskInstance {

    WatchParameters watchParameters;
    OutputParameters outputParameters;

    ValidateTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      WatchParametersParser watchParametersParser = new WatchParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      watchParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      watchParameters = watchParametersParser.getParameterObject();
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      if (instanceValidatorParameters.getExpansionParameters() != null) {
        validationEngine.loadExpansionParameters(instanceValidatorParameters.getExpansionParameters());
      }

      for (String s : instanceValidatorParameters.getProfiles()) {
        if (!validationEngine.getContext().hasResource(StructureDefinition.class, s) && !validationEngine.getContext().hasResource(ImplementationGuide.class, s)) {
          log.info("  Fetch Profile from " + s);
          //TODO locations appears to never be set via the CLI or anywhere else. Maybe this was left over debugging?
          validationEngine.loadProfile(validationEngineParameters.getLocations().getOrDefault(s, s));
        }
      }
      log.info("Validating");
      validationService.validateSources(validationEngine, new ValidateSourceParameters(instanceValidatorParameters, sources, outputParameters.getOutput(), watchParameters));

      if (validationEngineParameters.getAdvisorFile() != null) {
        log.info("Note: Some validation issues might be hidden by the advisor settings in the file "+ validationEngineParameters.getAdvisorFile());
      }
    }
  }

  @Override
  public boolean inferFhirVersion() {
    return true;
  }
}
