package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptions;
import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptionsConvertor;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationEngineOptionsConvertorTest {

  public static Stream<Arguments> testArguments() {
    return Stream.of(
      // Existing FHIR version tests
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("5.0"), new ValidationEngineParameters().setSv("5.0")),
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("4.0.1"), new ValidationEngineParameters().setSv("4.0")),

      // Boolean field tests - individual (note: default fhirVersion="5.0" is always set)
      Arguments.arguments(
        new ValidationEngineOptions().withDoNative(true),
        new ValidationEngineParameters().setSv("5.0").setDoNative(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withRecursive(true),
        new ValidationEngineParameters().setSv("5.0").setRecursive(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withClearTxCache(true),
        new ValidationEngineParameters().setSv("5.0").setClearTxCache(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCheckReferences(true),
        new ValidationEngineParameters().setSv("5.0").setCheckReferences(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withNoInternalCaching(true),
        new ValidationEngineParameters().setSv("5.0").setNoInternalCaching(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDisableDefaultResourceFetcher(true),
        new ValidationEngineParameters().setSv("5.0").setDisableDefaultResourceFetcher(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDisplayWarnings(true),
        new ValidationEngineParameters().setSv("5.0").setDisplayWarnings(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withNoExtensibleBindingMessages(true),
        new ValidationEngineParameters().setSv("5.0").setNoExtensibleBindingMessages(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withShowTimes(true),
        new ValidationEngineParameters().setSv("5.0").setShowTimes(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDoDebug(true),
        new ValidationEngineParameters().setSv("5.0").setDoDebug(true)
      ),

      // Boolean combined test
      Arguments.arguments(
        new ValidationEngineOptions()
          .withDoNative(true)
          .withRecursive(true)
          .withShowTimes(true),
        new ValidationEngineParameters()
          .setSv("5.0")
          .setDoNative(true)
          .setRecursive(true)
          .setShowTimes(true)
      ),

      // String field tests - individual
      Arguments.arguments(
        new ValidationEngineOptions().withSnomedCT("us"),
        new ValidationEngineParameters().setSv("5.0").setSnomedCT("us")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withResolutionContext("test-context"),
        new ValidationEngineParameters().setSv("5.0").setResolutionContext("test-context")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withAiService("http://ai.example.com"),
        new ValidationEngineParameters().setSv("5.0").setAIService("http://ai.example.com")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters().setSv("5.0").setTxServer("http://custom-tx.org").setNoEcosystem(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxLog("/path/to/tx.log"),
        new ValidationEngineParameters().setSv("5.0").setTxLog("/path/to/tx.log")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxCache("/path/to/cache"),
        new ValidationEngineParameters().setSv("5.0").setTxCache("/path/to/cache")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withAdvisorFile("/path/to/advisor.json"),
        new ValidationEngineParameters().setSv("5.0").setAdvisorFile("/path/to/advisor.json")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withLang("de"),
        new ValidationEngineParameters().setSv("5.0").setLang("de")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withMapLog("/path/to/map.log"),
        new ValidationEngineParameters().setSv("5.0").setMapLog("/path/to/map.log")
      ),

      // String combined test
      Arguments.arguments(
        new ValidationEngineOptions()
          .withSnomedCT("uk")
          .withLang("en"),
        new ValidationEngineParameters()
          .setSv("5.0")
          .setSnomedCT("uk")
          .setLang("en")
      ),

      // List field tests - individual
      Arguments.arguments(
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core")),
        new ValidationEngineParameters().setSv("5.0").addIg("hl7.fhir.r4.core")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core", "hl7.fhir.us.core")),
        new ValidationEngineParameters().setSv("5.0").addIg("hl7.fhir.r4.core").addIg("hl7.fhir.us.core")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCertSources(List.of("/path/cert1.pem")),
        new ValidationEngineParameters().setSv("5.0").addCertSource("/path/cert1.pem")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCertSources(List.of("/path/cert1.pem", "/path/cert2.pem")),
        new ValidationEngineParameters().setSv("5.0").addCertSource("/path/cert1.pem").addCertSource("/path/cert2.pem")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withMatchetypes(List.of("match1.conf")),
        new ValidationEngineParameters().setSv("5.0").addMatchetype("match1.conf")
      ),

      // List combined test - all types together
      Arguments.arguments(
        new ValidationEngineOptions()
          .withFhirVersion("4.0.1")
          .withDoNative(true)
          .withSnomedCT("us")
          .withIgs(List.of("hl7.fhir.r4.core", "hl7.fhir.us.core")),
        new ValidationEngineParameters()
          .setSv("4.0")
          .setDoNative(true)
          .setSnomedCT("us")
          .addIg("hl7.fhir.r4.core")
          .addIg("hl7.fhir.us.core")
      ),

      // Edge case: empty list
      Arguments.arguments(
        new ValidationEngineOptions().withIgs(List.of()),
        new ValidationEngineParameters().setSv("5.0")
      ),

      // Edge case: default ValidationEngineOptions (all defaults should be set)
      Arguments.arguments(
        new ValidationEngineOptions(),
        new ValidationEngineParameters()
          .setSv("5.0")
          .setSnomedCT("900000000000207008")
          .setTxServer("http://tx.fhir.org")
          .setLocale("en")
      ),


      // Edge case: txServer with noEcosystem both set
      Arguments.arguments(
        new ValidationEngineOptions()
          .withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters()
          .setSv("5.0")
          .setTxServer("http://custom-tx.org")
          .setNoEcosystem(true)
      )
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
