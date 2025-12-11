package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.CommonPackages;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ComparisonService;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "compare",
  description = """
  Compare profiles.
  
  You will need to use the -ig option to load the IGs that contain the profiles. The validator can infer the FHIR version based on other Validation Engine options, but you can also use the -version option to explicitly choose one.
  """)
public class CompareCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-dest"},
    description = "folder in which to produce the output. This must exist, and the validator will overwrite existing content if it needs to.")
  private String destinationDirectory;

  @CommandLine.Option(
    names = {"-left"},
    description = "A profile to compare which will appear on the left side of the output")
  private String left;

  @CommandLine.Option(
    names = {"-right"},
    description = "A profile to compare which will appear on the right side of the output")

  private String right;

  @CommandLine.Parameters(
    description = "Additional sources to include")
  private String[] sources;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return List.of();
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    checkDestinationDirectoryValid();

    try {
      validationEngine.loadPackage(CommonPackages.ID_PUBPACK, null);
    } catch (IOException e) {
      log.error("Unable to load package " + CommonPackages.ID_PUBPACK, e);
      System.exit(1);
    }
    try {
      ComparisonService.doLeftRightComparison(left, right, destinationDirectory, validationEngine);
    } catch (IOException | EOperationOutcome e) {
      log.error("Error performing comparison.", e);
      return 1;
    }
    return 0;
  }

  private void checkDestinationDirectoryValid()  {
    if (destinationDirectory == null) {
      log.error("no -dest parameter provided");
      System.exit(1);
    }

    try {
      if (!ManagedFileAccess.file(destinationDirectory).isDirectory()) {
        log.error("Specified destination (-dest parameter) is not a directory: \"{}\")", destinationDirectory);
        System.exit(1);
      } else {
        log.info("Using destination directory: \"{}\")", destinationDirectory);
      }
    } catch (IOException e) {
      log.error("Error accessing destination directory: " + destinationDirectory, e);
      System.exit(1);
    }
  }
}
