package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.TransformLangParameters;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Nonnull;

@Slf4j
@CommandLine.Command(name = "lang-transform",
  description = """
  Transform language content in FHIR resources.

  Supports two modes:
  - extract: Extract language content from resources
  - inject: Inject language content into resources
  """)
public class LangTransformCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    description = "The transformation mode: 'extract' or 'inject'",
    index = "0")
  private String langTransform;

  @CommandLine.Option(
    names = {"-src-lang"},
    description = "Source language for extraction (used with extract mode)")
  private String srcLang;

  @CommandLine.Option(
    names = {"-tgt-lang"},
    description = "Target language for extraction (used with extract mode)")
  private String tgtLang;

  @CommandLine.Option(
    names = {"-input"},
    description = "Input file(s) for injection (used with inject mode)")
  private List<String> inputs;

  @CommandLine.Option(
    names = {"-output"},
    description = "Output file path")
  private String output;

  @CommandLine.Parameters(
    description = "Source files to transform",
    index = "1..*"
  )
  private String[] sources;

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return null;
  }

  @Override
  public List<String> getSources() {
    return sources != null ? Arrays.asList(sources) : List.of();
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) {
    try {
      TransformLangParameters transformLangParameters = new TransformLangParameters(
        langTransform,
        inputs != null ? inputs : List.of(),
        srcLang,
        tgtLang,
        getSources(),
        output
      );

      validationService.transformLang(validationEngine, transformLangParameters);
      return 0;
    } catch (IOException e) {
      log.error("Error performing language transformation.", e);
      return 1;
    }
  }
}
