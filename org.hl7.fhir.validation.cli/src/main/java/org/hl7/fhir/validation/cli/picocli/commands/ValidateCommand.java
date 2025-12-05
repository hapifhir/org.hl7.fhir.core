package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.*;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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
    ServerCommand.class
  })
@Slf4j
public class ValidateCommand extends ValidationEngineCommand implements Callable<Integer> {
  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;

  @CommandLine.ArgGroup(validate = false, heading = "Terminology Client Options%n")
  TerminologyClientOptions terminologyClientOptions = new TerminologyClientOptions();

  //Needed to allow Help Command.
  @CommandLine.Option(names = { "-h", "-help", "-?"}, usageHelp = true, description = "Display this help and exit")
  private boolean help;

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  public ValidateCommand(ValidationService validationService) {
    super(validationService);
  }

  @Override
  public InstanceValidatorOptions getInstanceValidatorOptions() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return whatToValidate == null ? Collections.emptyList() : Arrays.asList(whatToValidate);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    log.info("Locale: " + Locale.getDefault());
    log.info("Sources to validate: " + String.join("", getSources()));
    return 0;
  }
}
