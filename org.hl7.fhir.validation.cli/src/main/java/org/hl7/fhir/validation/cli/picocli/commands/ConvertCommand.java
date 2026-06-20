package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Nonnull;

@Slf4j
@CommandLine.Command(name = "convert",
  description = """
  Convert a resource or logical model.

  You can use the validator to convert a resource or logical model.

  -convert requires the parameters -source and one of {-output, -outputSuffix}.
  -ig may be used to provide a logical model.

  If the -source maps to one or more resources, e.g. when using a wildcard,
  use -outputSuffix <suffix>, to obtain multiple result files with a
  `<sourcefilename>.<suffix>` filename.
  Example: `-source *.xml -convert -outputSuffix convert.json` outputs:
  `source1.xml.convert.json`, `source2.xml.convert.json`, etc.
  """)
public class ConvertCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The source file(s) to convert. Can be a file path, directory, or pattern with wildcards.")
  private String[] sources;

  @CommandLine.Option(
    names = {"-output"},
    description = "The output file for the converted resource. Use with single source files.")
  private String output;

  @CommandLine.Option(
    names = {"-outputSuffix"},
    description = "The output suffix for multiple converted resources. Used when source matches multiple files.")
  private String outputSuffix;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : Arrays.asList(sources);
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    validateConvertParameters();

    try {
      validationService.convertSources(validationEngine, getSources(), output, outputSuffix);
    } catch (Exception e) {
      log.error("Error performing conversion.", e);
      return 1;
    }
    return 0;
  }

  private void validateConvertParameters() {
    if (output == null && outputSuffix == null) {
      log.error("-convert requires one of {-output, -outputSuffix}");
      System.exit(1);
    }
  }
}
