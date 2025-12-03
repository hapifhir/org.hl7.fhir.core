package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.With;
import org.apache.commons.lang3.ArrayUtils;
import org.hl7.fhir.utilities.VersionUtilities;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;

@CommandLine.Command
@AllArgsConstructor
public class ValidationEngineOptions {

  static class CLIFHIRVersions extends ArrayList<String> {
    CLIFHIRVersions() { super(
      Arrays.stream(ArrayUtils.addAll(VersionUtilities.SUPPORTED_MAJOR_VERSIONS, VersionUtilities.SUPPORTED_VERSIONS)).toList()
    );
    }
  }

  @CommandLine.Option(names = {"-version"},
    completionCandidates = CLIFHIRVersions.class,
    description = """
    Version of FHIR.
    Valid values are: ${COMPLETION-CANDIDATES}
    Default is ${DEFAULT-VALUE}
    """)
  @With
  public String fhirVersion = "5.0";

  public ValidationEngineOptions() {
    // All public fields should be set in their declaration for Picocli purposes, so we do nothing here.
  }
}
