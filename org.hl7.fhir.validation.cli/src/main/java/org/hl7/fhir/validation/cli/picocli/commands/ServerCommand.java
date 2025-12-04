package org.hl7.fhir.validation.cli.picocli.commands;

import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptions;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "server",
  description = "Start a fhir server.")
public class ServerCommand implements Callable<Integer> {

  @CommandLine.Option(names = {"-p", "--port"}, description = "The port to run the server on", required = true)
  private String port = null;

  @CommandLine.ArgGroup(validate = false, heading = "Validation Engine%n")
  ValidationEngineOptions validationEngineOptions = new ValidationEngineOptions();


  @Override
  public Integer call() throws Exception { // your business logic goes here...
    System.out.println("Running server on port " + port + " with FHIR version " + validationEngineOptions.fhirVersion);
    return (Integer) 0;
  }
}
