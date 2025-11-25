package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.FHIRPathParametersParser;
import org.hl7.fhir.validation.service.model.FHIRPathParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;

import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class FhirpathTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "fhirpath";
  }

  @Override
  public String getDisplayName() {
    return "FHIRPath";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, FHIRPathParametersParser.FHIRPATH);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/fhirpath.txt");
  }

  @Override
  protected FhirPathTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new FhirPathTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class FhirPathTaskInstance extends ValidationEngineTaskInstance {

    FHIRPathParameters fhirPathParameters;

    FhirPathTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      FHIRPathParametersParser fhirPathParametersParser = new FHIRPathParametersParser();
      fhirPathParametersParser.parseArgs(args);
      fhirPathParameters = fhirPathParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.evaluateFhirpath(validationEngine, fhirPathParameters.getFhirpath(), sources);
    }
  }
}
