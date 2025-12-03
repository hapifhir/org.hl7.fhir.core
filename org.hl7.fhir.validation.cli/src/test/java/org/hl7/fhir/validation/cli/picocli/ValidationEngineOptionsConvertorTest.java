package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptions;
import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptionsConvertor;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationEngineOptionsConvertorTest {

  public static Stream<Arguments> testArguments() {
    return Stream.of(
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("5.0"), new ValidationEngineParameters().setSv("5.0")),
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("4.0.1"), new ValidationEngineParameters().setSv("4.0.1"))
    );
  }

  @ParameterizedTest()
  @MethodSource("testArguments")
  void test(ValidationEngineOptions options, ValidationEngineParameters expectedParameters) {
    ValidationEngineOptionsConvertor convertor = new ValidationEngineOptionsConvertor();
    ValidationEngineParameters actualParameters = convertor.convert(options);
    assertThat(actualParameters).isEqualTo(expectedParameters);
  }
}
