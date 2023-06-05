package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ComparisonService;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.Params;

import java.io.File;
import java.io.PrintStream;

public class CompareTask extends ValidationServiceTask{
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
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return Params.hasParam(args, Params.COMPARE);
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    Display.printCliParamsAndInfo(args);
    if (!destinationDirectoryValid(Params.getParam(args, Params.DESTINATION))) {
      return;
    }
    if (cliContext.getSv() == null) {
      cliContext.setSv(validationService.determineVersion(cliContext));
    }
    String v = VersionUtilities.getCurrentVersion(cliContext.getSv());
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validator = validationService.initializeValidator(cliContext, definitions, tt);
    validator.loadPackage(CommonPackages.ID_PUBPACK, null);
    ComparisonService.doLeftRightComparison(args, Params.getParam(args, Params.DESTINATION), validator);
  }

  private boolean destinationDirectoryValid(String dest) {
    if (dest == null) {
      System.out.println("no -dest parameter provided");
      return false;
    } else if (!new File(dest).isDirectory()) {
      System.out.println("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
      return false;
    } else {
      System.out.println("Valid destination directory provided: \"" + dest + "\")");
      return true;
    }
  }
}
