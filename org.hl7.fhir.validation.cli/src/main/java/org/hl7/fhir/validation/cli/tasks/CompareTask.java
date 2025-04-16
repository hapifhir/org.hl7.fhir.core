package org.hl7.fhir.validation.cli.tasks;

import java.io.IOException;
import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ComparisonService;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.utils.Display;
import org.hl7.fhir.validation.cli.param.Params;

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.COMPARE);
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/compare.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    Display.printCliParamsAndInfo(args);
    if (!destinationDirectoryValid(Params.getParam(args, Params.DESTINATION))) {
      return;
    }
    if (validationContext.getSv() == null) {
      validationContext.setSv(validationService.determineVersion(validationContext));
    }
    String v = VersionUtilities.getCurrentVersion(validationContext.getSv());
    String definitions = VersionUtilities.packageForVersion(v) + "#" + v;
    ValidationEngine validator = validationService.initializeValidator(validationContext, definitions, tt);
    validator.loadPackage(CommonPackages.ID_PUBPACK, null);
    String left = Params.getParam(args, Params.LEFT);
    String right = Params.getParam(args, Params.RIGHT);
    ComparisonService.doLeftRightComparison(left, right, Params.getParam(args, Params.DESTINATION), validator);
  }

  private boolean destinationDirectoryValid(String dest) throws IOException {
    if (dest == null) {
      System.out.println("no -dest parameter provided");
      return false;
    } else if (!ManagedFileAccess.file(dest).isDirectory()) {
      System.out.println("Specified destination (-dest parameter) is not valid: \"" + dest + "\")");
      return false;
    } else {
      System.out.println("Valid destination directory provided: \"" + dest + "\")");
      return true;
    }
  }
}
