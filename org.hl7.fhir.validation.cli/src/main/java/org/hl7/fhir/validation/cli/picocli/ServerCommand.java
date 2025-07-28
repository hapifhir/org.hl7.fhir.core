package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "server",
  description = "Start a fhir server.")
class ServerCommand implements Callable<Integer> {

  @CommandLine.Option(names = {"-p", "--port"}, description = "The port to run the server on", required = true)
  private String port = null;

  @Override
  public Integer call() throws Exception { // your business logic goes here...
    System.out.println("Running server on port " + port);
    return 0;
  }
}
