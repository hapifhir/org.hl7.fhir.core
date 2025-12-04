package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.picocli.options.*;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import picocli.CommandLine;

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

  @CommandLine.ArgGroup(validate = false, heading = "Validation Engine%n")
  ValidationEngineOptions validationEngineOptions = new ValidationEngineOptions();

  //Needed to allow Help Command.
  @CommandLine.Option(names = { "-h", "-help", "-?"}, usageHelp = true, description = "Display this help and exit")
  private boolean help;

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  @Override
  public Integer call() throws Exception { // your business logic goes here...
    ValidationEngineOptionsConvertor convertor = new ValidationEngineOptionsConvertor();
    ValidationEngineParameters validationEngineParameters = convertor.convert(validationEngineOptions);
    log.info(validationEngineParameters.toString().replace(", ", ", \n"));
    log.info("Sources to validate: " + String.join("", whatToValidate ));
    return 0;
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return true;
  }
}
