package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class InstanceValidatorOptions {
  @CommandLine.Option(names = {"-jurisdiction"},
    description = "Specifies the jurisdiction to validate in ")
  @With
  public String jurisdiction;

  @CommandLine.Option(names = {"-expansion-parameters"},
    description = "Specifies the expansion parameters to use - this can supply fixed versions for code systems and value sets")
  @With
  public String expansionParameters;

  @CommandLine.Option(names = {"-profile"},
    description = "The canonical URL to validate against (same as if it was specified in Resource.meta.profile). If no profile is specified, the resource is validated against the base specification. This parameter can appear any number of times.",
    arity = "0..*")
  @With
  public List<String> profiles = new ArrayList<>();
}
