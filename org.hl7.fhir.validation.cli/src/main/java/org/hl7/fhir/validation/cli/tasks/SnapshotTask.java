package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.SnapshotParametersParser;
import org.hl7.fhir.validation.service.GenerateSnapshotParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;

import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class SnapshotTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "snapshot";
  }

  @Override
  public String getDisplayName() {
    return "Snapshots";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, SnapshotParametersParser.SNAPSHOT);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/snapshot.txt");
  }

  @Override
  protected SnapshotTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new SnapshotTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class SnapshotTaskInstance extends ValidationEngineTaskInstance {

    OutputParameters outputParameters;

    SnapshotTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      Arg.setProcessed(args, SnapshotParametersParser.SNAPSHOT, true);
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      outputParametersParser.parseArgs(args);
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.generateSnapshot(validationEngine, new GenerateSnapshotParameters(validationEngineParameters.getSv(), sources, outputParameters.getOutput(), outputParameters.getOutputSuffix()));
    }
  }
}
