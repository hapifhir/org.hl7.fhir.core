package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptionsConvertor;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InstanceValidatorOptionsConvertorTest {

  public static Stream<Arguments> validOptions() {
    return Stream.of(
      // jurisdiction only (existing field)
      Arguments.arguments(
        new InstanceValidatorOptions().withJurisdiction("US"),
        new InstanceValidatorParameters().setJurisdiction("US")
      ),

      // expansionParameters only
      Arguments.arguments(
        new InstanceValidatorOptions().withExpansionParameters("version=4.0.1"),
        new InstanceValidatorParameters().setExpansionParameters("version=4.0.1")
      ),

      // Single profile
      Arguments.arguments(
        new InstanceValidatorOptions().withProfiles(List.of("http://hl7.org/fhir/StructureDefinition/Patient")),
        new InstanceValidatorParameters().addProfile("http://hl7.org/fhir/StructureDefinition/Patient")
      ),

      // Multiple profiles
      Arguments.arguments(
        new InstanceValidatorOptions().withProfiles(List.of(
          "http://hl7.org/fhir/StructureDefinition/Patient",
          "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient"
        )),
        new InstanceValidatorParameters()
          .addProfile("http://hl7.org/fhir/StructureDefinition/Patient")
          .addProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient")
      ),

      // Empty profiles list
      Arguments.arguments(
        new InstanceValidatorOptions().withProfiles(List.of()),
        new InstanceValidatorParameters()
      ),

      // All fields combined
      Arguments.arguments(
        new InstanceValidatorOptions()
          .withJurisdiction("US")
          .withExpansionParameters("version=4.0.1")
          .withProfiles(List.of("http://hl7.org/fhir/StructureDefinition/Patient")),
        new InstanceValidatorParameters()
          .setJurisdiction("US")
          .setExpansionParameters("version=4.0.1")
          .addProfile("http://hl7.org/fhir/StructureDefinition/Patient")
      ),

      // Default InstanceValidatorOptions (null/empty values)
      Arguments.arguments(
        new InstanceValidatorOptions(),
        new InstanceValidatorParameters()
      )
    );
  }

  @ParameterizedTest()
  @MethodSource("validOptions")
  void validOptionsTest(InstanceValidatorOptions options, InstanceValidatorParameters expectedParameters) {
    InstanceValidatorOptionsConvertor convertor = new InstanceValidatorOptionsConvertor();
    InstanceValidatorParameters actualParameters = convertor.convert(options);
    assertThat(actualParameters).isEqualTo(expectedParameters);
  }
}
