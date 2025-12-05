package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptions;
import org.hl7.fhir.validation.cli.picocli.options.ValidationEngineOptionsConvertor;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationEngineOptionsConvertorTest {

  private static File dummyFileA;
  private static String dummyFileAPath;

  private static File dummyFileB;
  private static String dummyFileBPath;


  @BeforeAll
  public static void beforeAll() throws IOException {
    dummyFileA = ManagedFileAccess.fromPath(Files.createTempFile("someFile", ".json"));
    dummyFileAPath = dummyFileA.getAbsolutePath();

    dummyFileB = ManagedFileAccess.fromPath(Files.createTempFile("someFile", ".json"));
    dummyFileBPath = dummyFileB.getAbsolutePath();

  }

  public static Stream<Arguments> validOptions() {
    return Stream.of(
      // Existing FHIR version tests
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("5.0"), new ValidationEngineParameters().setSv("5.0")),
      Arguments.arguments(new ValidationEngineOptions().withFhirVersion("4.0.1"), new ValidationEngineParameters().setSv("4.0")),

      // Boolean field tests - individual (note: default fhirVersion="5.0" is always set)
      Arguments.arguments(
        new ValidationEngineOptions().withDoNative(true),
        new ValidationEngineParameters().setDoNative(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withRecursive(true),
        new ValidationEngineParameters().setRecursive(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withClearTxCache(true),
        new ValidationEngineParameters().setClearTxCache(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCheckReferences(true),
        new ValidationEngineParameters().setCheckReferences(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withNoInternalCaching(true),
        new ValidationEngineParameters().setNoInternalCaching(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDisableDefaultResourceFetcher(true),
        new ValidationEngineParameters().setDisableDefaultResourceFetcher(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDisplayWarnings(true),
        new ValidationEngineParameters().setDisplayWarnings(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withNoExtensibleBindingMessages(true),
        new ValidationEngineParameters().setNoExtensibleBindingMessages(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withShowTimes(true),
        new ValidationEngineParameters().setShowTimes(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withDoDebug(true),
        new ValidationEngineParameters().setDoDebug(true)
      ),

      // Boolean combined test
      Arguments.arguments(
        new ValidationEngineOptions()
          .withDoNative(true)
          .withRecursive(true)
          .withShowTimes(true),
        new ValidationEngineParameters()
          .setDoNative(true)
          .setRecursive(true)
          .setShowTimes(true)
      ),

      // String field tests - individual
      Arguments.arguments(
        new ValidationEngineOptions().withSnomedCT("us"),
        new ValidationEngineParameters().setSnomedCT("us")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withResolutionContext("test-context"),
        new ValidationEngineParameters().setResolutionContext("test-context")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withAiService("http://ai.example.com"),
        new ValidationEngineParameters().setAIService("http://ai.example.com")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters().setTxServer("http://custom-tx.org").setNoEcosystem(true)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxLog("/path/to/tx.log"),
        new ValidationEngineParameters().setTxLog("/path/to/tx.log")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withTxCache("/path/to/cache"),
        new ValidationEngineParameters().setTxCache("/path/to/cache")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withAdvisorFile(dummyFileAPath),
        new ValidationEngineParameters().setAdvisorFile(dummyFileAPath)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withLang("de"),
        new ValidationEngineParameters().setLang("de")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withMapLog("/path/to/map.log"),
        new ValidationEngineParameters().setMapLog("/path/to/map.log")
      ),

      // String combined test
      Arguments.arguments(
        new ValidationEngineOptions()
          .withSnomedCT("uk")
          .withLang("en"),
        new ValidationEngineParameters()
          .setSnomedCT("uk")
          .setLang("en")
      ),

      // List field tests - individual
      Arguments.arguments(
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core")),
        new ValidationEngineParameters().setSv("4.0").addIg("hl7.fhir.r4.core")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core", "hl7.fhir.us.core")),
        new ValidationEngineParameters().setSv("4.0").addIg("hl7.fhir.r4.core").addIg("hl7.fhir.us.core")
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCertSources(List.of(dummyFileAPath)),
        new ValidationEngineParameters().addCertSource(dummyFileAPath)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withCertSources(List.of(dummyFileAPath, dummyFileBPath)),
        new ValidationEngineParameters().addCertSource(dummyFileAPath).addCertSource(dummyFileBPath)
      ),
      Arguments.arguments(
        new ValidationEngineOptions().withMatchetypes(List.of(dummyFileAPath)),
        new ValidationEngineParameters().addMatchetype(dummyFileAPath)
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
        new ValidationEngineParameters()
      ),

      // Edge case: default ValidationEngineOptions (all defaults should be set)
      Arguments.arguments(
        new ValidationEngineOptions(),
        new ValidationEngineParameters()
          .setSnomedCT("900000000000207008")
          .setTxServer("http://tx.fhir.org")
          .setLocale("en")
      ),


      // Edge case: txServer with noEcosystem both set
      Arguments.arguments(
        new ValidationEngineOptions()
          .withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters()
          .setTxServer("http://custom-tx.org")
          .setNoEcosystem(true)
      )
    );
  }

  @ParameterizedTest()
  @MethodSource("validOptions")
  void validOptionsTest(ValidationEngineOptions options, ValidationEngineParameters expectedParameters) {
    ValidationEngineOptionsConvertor convertor = new ValidationEngineOptionsConvertor();
    ValidationEngineParameters actualParameters = convertor.convert(options);
    assertThat(actualParameters).isEqualTo(expectedParameters);
  }

  public static Stream<Arguments> invalidOptions() {
    return Stream.of(
      // Version conflict between -version and core IG package
      Arguments.arguments(
        new ValidationEngineOptions()
          .withFhirVersion("5.0")
          .withIgs(List.of("hl7.fhir.r4.core")),
        "Parameters are inconsistent: version specified by -version is '5.0' but -ig parameter 'hl7.fhir.r4.core' implies '4.0'"
      ),
      Arguments.arguments(
        new ValidationEngineOptions()
          .withFhirVersion("3.0")
          .withIgs(List.of("hl7.fhir.r5.core")),
        "Parameters are inconsistent: version specified by -version is '3.0' but -ig parameter 'hl7.fhir.r5.core' implies '5.0'"
      ),

      // Version conflict between multiple IG packages
      Arguments.arguments(
        new ValidationEngineOptions()
          .withIgs(List.of("hl7.fhir.r4.core", "hl7.fhir.r5.core")),
        "Parameters are inconsistent: another IG has set the version to '4.0' but -ig parameter 'hl7.fhir.r5.core' implies '5.0'"
      ),
      Arguments.arguments(
        new ValidationEngineOptions()
          .withIgs(List.of("hl7.fhir.r3.core", "hl7.fhir.r4.core")),
        "Parameters are inconsistent: another IG has set the version to '3.0' but -ig parameter 'hl7.fhir.r4.core' implies '4.0'"
      ),

      // File does not exist for -matchetype option
      Arguments.arguments(
        new ValidationEngineOptions()
          .withMatchetypes(List.of("/nonexistent/path/to/matchetype.conf")),
        "File does not exist at path '/nonexistent/path/to/matchetype.conf' specified by option -matchetype"
      ),

      // File does not exist for -cert option
      Arguments.arguments(
        new ValidationEngineOptions()
          .withCertSources(List.of("/nonexistent/path/to/certificate.pem")),
        "File does not exist at path '/nonexistent/path/to/certificate.pem' specified by option -cert"
      ),

      // File does not exist for -advisor-file option
      Arguments.arguments(
        new ValidationEngineOptions()
          .withAdvisorFile("/nonexistent/path/to/advisor.json"),
        "File does not exist at path '/nonexistent/path/to/advisor.json' specified by option -advisor-file"
      )
    );
  }

  @ParameterizedTest()
  @MethodSource("invalidOptions")
  void invalidOptionsTest(ValidationEngineOptions options, String expectedExceptionMessage) {
    ValidationEngineOptionsConvertor convertor = new ValidationEngineOptionsConvertor();
    assertThatThrownBy(() -> convertor.convert(options))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(expectedExceptionMessage);
  }
}
