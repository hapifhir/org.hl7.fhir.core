package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;

@CommandLine.Command()
public class ValidationEngineOptions {
  @CommandLine.Option(names = {"-version"}, description = "Version of FHIR.")
  String fhirVersion;

}
