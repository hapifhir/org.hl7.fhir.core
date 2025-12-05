package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.With;
import picocli.CommandLine;

@AllArgsConstructor
public class InstanceValidatorOptions {
  @CommandLine.Option(names = {"-jurisdiction"},
    description = "Specifies the jurisdiction to validate in ")
  @With
  public String jurisdiction;
}
