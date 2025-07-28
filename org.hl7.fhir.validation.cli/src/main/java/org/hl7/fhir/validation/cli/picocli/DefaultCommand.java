package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
  description = "Validates FHIR resources.",
  subcommands = {
    CommandLine.HelpCommand.class,
    ServerCommand.class
  })
class DefaultCommand implements Callable<Integer> {
  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;


  @CommandLine.ArgGroup(validate = false, heading = "Validation Engine%n")
  ValidationEngineOptions validationEngineOptions;

  //Needed to allow Help Command.
  @CommandLine.Option(names = { "-h", "--help", "-?", "-help"}, usageHelp = true, description = "Display this help and exit")
  private boolean help;

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  @Override
  public Integer call() throws Exception { // your business logic goes here...
    System.out.println("Validating " + String.join("", whatToValidate )+ " with FHIR version " + validationEngineOptions.fhirVersion );
    return 0;
  }
}
