package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.*;
import org.hl7.fhir.validation.service.ValidateSourceParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.WatchParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;

@CommandLine.Command(
  description = """
    
    The FHIR validation tool validates a FHIR resource or bundle.
    
    The validation tool compares a resource against the base definitions and any profiles declared in the resource (Resource.meta.profile) or specified on the command line
    
    The FHIR validation tool validates a FHIR resource or bundle. Syntax and content is checked against the specification and other profiles as specified.
    
     * XML & Json (FHIR versions {{XML_AND_JSON_FHIR_VERSIONS}})
     * Turtle (FHIR versions {{TURTLE_FHIR_VERSIONS}})
    
    If requested, instances will also be verified against the appropriate schema W3C XML Schema, JSON schema or ShEx, as appropriate
    """,
  subcommands = {
    CommandLine.HelpCommand.class,
    CompareCommand.class,
    CompileCommand.class,
    ConvertCommand.class,
    VersionCommand.class,
    FhirpathCommand.class,
    TransformCommand.class,
    LangTransformCommand.class,
    LangRegenerateCommand.class,
    NarrativeCommand.class,
    CodeGenCommand.class,
    PreloadCacheCommand.class,
    ScanCommand.class,
    SnapshotCommand.class,
    SpecialCommand.class,
    SpreadsheetCommand.class,
    TestsCommand.class,
    TxTestsCommand.class,
    AiTestsCommand.class,
    InstallCommand.class,
    InstanceFactoryCommand.class,
    HTTPServerCommand.class
  })
@Slf4j
public class ValidateCommand extends ValidationEngineCommand implements Callable<Integer> {
  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;

  @CommandLine.Option(names = "-output",
    description = """
    An output file for the results. Results will be represented as an OperationOutcome. +
    By default results are sent to the std out.
    """)
  String output;

  @CommandLine.ArgGroup(validate = false, heading = "Watch Mode Options%n")
  WatchOptions watchOptions = new WatchOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Terminology Client Options%n")
  TerminologyClientOptions terminologyClientOptions = new TerminologyClientOptions();

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  //Needed to allow Help Command.
  @CommandLine.Option(names = { "-h", "-help", "-?"}, usageHelp = true, description = "Display this help and exit")
  private boolean help;

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    InstanceValidatorOptionsConvertor convertor = new InstanceValidatorOptionsConvertor();
    return convertor.convert(instanceValidatorOptions);
  }

  @Override
  public List<String> getSources() {
    return whatToValidate == null ? Collections.emptyList() : Arrays.asList(whatToValidate);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    InstanceValidatorParameters instanceValidatorParameters = getInstanceValidatorParameters();
    if (instanceValidatorParameters.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(instanceValidatorParameters.getExpansionParameters());
    }

    for (String s : instanceValidatorOptions.profiles) {
      if (
        !validationEngine.getContext().hasResource(StructureDefinition.class, s)
          && !validationEngine.getContext().hasResource(ImplementationGuide.class, s)) {
        log.info("  Fetch Profile from " + s);
        try {
          validationEngine.loadProfile(s);
        } catch (IOException e) {
          log.error("Error loading profile: " + s, e);
          return 1;
        }

      }
    }

    WatchParameters watchParameters = getWatchParameters();

    log.info("Validating");
    try {
      validationService.validateSources(validationEngine, new ValidateSourceParameters(instanceValidatorParameters, List.of(whatToValidate), output, watchParameters));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    if (validationEngineOptions.advisorFile != null) {
      log.info("Note: Some validation issues might be hidden by the advisor settings in the file "+ validationEngineOptions.advisorFile);
    }

    log.info("Locale: " + Locale.getDefault());
    log.info("Sources to validate: " + String.join("", getSources()));
    return 0;
  }

  private WatchParameters getWatchParameters() {
    return WatchParameters.builder()
    .watchMode(readWatchMode(watchOptions.watchMode))
    .watchSettleTime(watchOptions.watchSettleTime)
    .watchScanDelay(watchOptions.watchScanDelay)
    .build();
  }

  private static ValidatorWatchMode readWatchMode(String s) {
    if (s == null) {
      return ValidatorWatchMode.NONE;
    }
    switch (s.toLowerCase()) {
      case "all" : return ValidatorWatchMode.ALL;
      case "none" : return ValidatorWatchMode.NONE;
      case "single" : return ValidatorWatchMode.SINGLE;
      case "a" : return ValidatorWatchMode.ALL;
      case "n" : return ValidatorWatchMode.NONE;
      case "s" : return ValidatorWatchMode.SINGLE;
    }
    throw new IllegalArgumentException("The watch mode ''"+s+"'' is not valid");
  }
}
