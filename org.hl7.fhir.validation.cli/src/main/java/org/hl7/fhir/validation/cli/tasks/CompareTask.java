package org.hl7.fhir.validation.cli.tasks;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.parsers.CompareParametersParser;
import org.hl7.fhir.validation.service.ComparisonService;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Params;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Slf4j
public class CompareTask extends ValidationEngineTask {
  @Override
  public String getName() {
    return "compare";
  }

  @Override
  public String getDisplayName() {
    return "Comparing Profiles";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, CompareParametersParser.COMPARE);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/compare.txt");
  }

  @Override
  protected CompareTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new CompareTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return false;
  }

  protected class CompareTaskInstance extends ValidationEngineTaskInstance {

    String destinationDirectory;
    String left;
    String right;

    CompareTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      destinationDirectory = Arg.getParam(args, CompareParametersParser.DESTINATION);
      left =  Arg.getParam(args, CompareParametersParser.LEFT);
      right =  Arg.getParam(args, CompareParametersParser.RIGHT);
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
     
      if (!destinationDirectoryValid(destinationDirectory)) {
        return;
      }
      validationEngine.loadPackage(CommonPackages.ID_PUBPACK, null);
      ComparisonService.doLeftRightComparison(left, right, destinationDirectory, validationEngine);
    }

    private boolean destinationDirectoryValid(String dest) throws IOException {
      if (dest == null) {
        log.info("no -dest parameter provided");
        return false;
      } else if (!ManagedFileAccess.file(dest).isDirectory()) {
        log.info("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
        return false;
      } else {
        log.info("Valid destination directory provided: \"" + dest + "\")");
        return true;
      }
    }
  }
}
