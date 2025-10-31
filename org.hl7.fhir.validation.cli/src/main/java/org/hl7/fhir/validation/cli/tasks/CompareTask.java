package org.hl7.fhir.validation.cli.tasks;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.parsers.CompareParametersParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
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
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    Display.printCliParamsAndInfo(log, args);
    if (!destinationDirectoryValid(Params.getParam(args, CompareParametersParser.DESTINATION))) {
      return;
    }

    validationEngine.loadPackage(CommonPackages.ID_PUBPACK, null);
    String left = Params.getParam(args, CompareParametersParser.LEFT);
    String right = Params.getParam(args, CompareParametersParser.RIGHT);
    ComparisonService.doLeftRightComparison(left, right, Params.getParam(args, CompareParametersParser.DESTINATION), validationEngine);
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
