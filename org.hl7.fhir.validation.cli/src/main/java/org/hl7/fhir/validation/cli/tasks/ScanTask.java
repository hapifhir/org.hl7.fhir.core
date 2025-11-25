package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.Scanner;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.ScanParametersParser;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class ScanTask extends ValidationEngineTask {


  @Override
  public String getName() {
    return "scan";
  }

  @Override
  public String getDisplayName() {
    return "Scan";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, ScanParametersParser.SCAN);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  protected ScanTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new ScanTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class ScanTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters;

    ScanTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      outputParametersParser.parseArgs(args);
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      Scanner validationScanner = new Scanner(validationEngine.getContext(), validationEngine.getValidator(null), validationEngine.getIgLoader(), validationEngine.getFhirPathEngine());
      validationScanner.validateScan(outputParameters.getOutput(), sources);
    }
  }
}
