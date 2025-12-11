package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptions;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "server",
  description = "Start a fhir server.")
public class ServerCommand implements Callable<Integer> {

  @CommandLine.Option(names = {"-p", "--port"}, description = "The port to run the server on", required = true)
  private String port = null;

  @CommandLine.ArgGroup(validate = false, heading = "Validation Engine%n")
  ValidationEngineOptions validationEngineOptions = new ValidationEngineOptions();


  @Override
  public Integer call() throws Exception { // your business logic goes here...
    log.info("Running server on port " + port + " with FHIR version " + validationEngineOptions.fhirVersion);
    return 0;
  }
}
