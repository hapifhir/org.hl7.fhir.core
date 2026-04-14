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
      Arguments.of("FHIR version 5.0", new ValidationEngineOptions().withFhirVersion("5.0"), new ValidationEngineParameters().setSv("5.0")),
      Arguments.of("FHIR version 4.0.1 normalized to 4.0", new ValidationEngineOptions().withFhirVersion("4.0.1"), new ValidationEngineParameters().setSv("4.0")),

      Arguments.of("doNative flag",
        new ValidationEngineOptions().withDoNative(true),
        new ValidationEngineParameters().setDoNative(true)
      ),
      Arguments.of("recursive flag",
        new ValidationEngineOptions().withRecursive(true),
        new ValidationEngineParameters().setRecursive(true)
      ),
      Arguments.of("clearTxCache flag",
        new ValidationEngineOptions().withClearTxCache(true),
        new ValidationEngineParameters().setClearTxCache(true)
      ),
      Arguments.of("checkReferences flag",
        new ValidationEngineOptions().withCheckReferences(true),
        new ValidationEngineParameters().setCheckReferences(true)
      ),
      Arguments.of("noInternalCaching flag",
        new ValidationEngineOptions().withNoInternalCaching(true),
        new ValidationEngineParameters().setNoInternalCaching(true)
      ),
      Arguments.of("disableDefaultResourceFetcher flag",
        new ValidationEngineOptions().withDisableDefaultResourceFetcher(true),
        new ValidationEngineParameters().setDisableDefaultResourceFetcher(true)
      ),
      Arguments.of("displayWarnings flag",
        new ValidationEngineOptions().withDisplayWarnings(true),
        new ValidationEngineParameters().setDisplayWarnings(true)
      ),
      Arguments.of("noExtensibleBindingMessages flag",
        new ValidationEngineOptions().withNoExtensibleBindingMessages(true),
        new ValidationEngineParameters().setNoExtensibleBindingMessages(true)
      ),
      Arguments.of("showTimes flag",
        new ValidationEngineOptions().withShowTimes(true),
        new ValidationEngineParameters().setShowTimes(true)
      ),
      Arguments.of("doDebug flag",
        new ValidationEngineOptions().withDoDebug(true),
        new ValidationEngineParameters().setDoDebug(true)
      ),

      Arguments.of("multiple boolean flags combined",
        new ValidationEngineOptions()
          .withDoNative(true)
          .withRecursive(true)
          .withShowTimes(true),
        new ValidationEngineParameters()
          .setDoNative(true)
          .setRecursive(true)
          .setShowTimes(true)
      ),

      Arguments.of("snomedCT edition US",
        new ValidationEngineOptions().withSnomedCT("us"),
        new ValidationEngineParameters().setSnomedCT("us")
      ),
      Arguments.of("resolutionContext",
        new ValidationEngineOptions().withResolutionContext("test-context"),
        new ValidationEngineParameters().setResolutionContext("test-context")
      ),
      Arguments.of("aiService URL",
        new ValidationEngineOptions().withAiService("http://ai.example.com"),
        new ValidationEngineParameters().setAIService("http://ai.example.com")
      ),
      Arguments.of("custom txServer sets noEcosystem",
        new ValidationEngineOptions().withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters().setTxServer("http://custom-tx.org").setNoEcosystem(true)
      ),
      Arguments.of("txLog path",
        new ValidationEngineOptions().withTxLog("/path/to/tx.log"),
        new ValidationEngineParameters().setTxLog("/path/to/tx.log")
      ),
      Arguments.of("txCache path",
        new ValidationEngineOptions().withTxCache("/path/to/cache"),
        new ValidationEngineParameters().setTxCache("/path/to/cache")
      ),
      Arguments.of("advisorFile path",
        new ValidationEngineOptions().withAdvisorFile(dummyFileAPath),
        new ValidationEngineParameters().setAdvisorFile(dummyFileAPath)
      ),
      Arguments.of("language German",
        new ValidationEngineOptions().withLang("de"),
        new ValidationEngineParameters().setLang("de")
      ),
      Arguments.of("mapLog path",
        new ValidationEngineOptions().withMapLog("/path/to/map.log"),
        new ValidationEngineParameters().setMapLog("/path/to/map.log")
      ),

      Arguments.of("multiple string fields combined",
        new ValidationEngineOptions()
          .withSnomedCT("uk")
          .withLang("en"),
        new ValidationEngineParameters()
          .setSnomedCT("uk")
          .setLang("en")
      ),

      Arguments.of("single IG infers FHIR version",
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core")),
        new ValidationEngineParameters().setSv("4.0").addIg("hl7.fhir.r4.core")
      ),
      Arguments.of("multiple IGs",
        new ValidationEngineOptions().withIgs(List.of("hl7.fhir.r4.core", "hl7.fhir.us.core")),
        new ValidationEngineParameters().setSv("4.0").addIg("hl7.fhir.r4.core").addIg("hl7.fhir.us.core")
      ),
      Arguments.of("single certSource",
        new ValidationEngineOptions().withCertSources(List.of(dummyFileAPath)),
        new ValidationEngineParameters().addCertSource(dummyFileAPath)
      ),
      Arguments.of("multiple certSources",
        new ValidationEngineOptions().withCertSources(List.of(dummyFileAPath, dummyFileBPath)),
        new ValidationEngineParameters().addCertSource(dummyFileAPath).addCertSource(dummyFileBPath)
      ),
      Arguments.of("single matchetype",
        new ValidationEngineOptions().withMatchetypes(List.of(dummyFileAPath)),
        new ValidationEngineParameters().addMatchetype(dummyFileAPath)
      ),

      Arguments.of("complex combination of all field types",
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

      Arguments.of("empty IG list",
        new ValidationEngineOptions().withIgs(List.of()),
        new ValidationEngineParameters()
      ),

      Arguments.of("default options apply expected defaults",
        new ValidationEngineOptions(),
        new ValidationEngineParameters()
          .setSnomedCT("900000000000207008")
          .setLocale("en")
      ),


      // Edge case: txServer with noEcosystem both set
      Arguments.of("custom txServer sets noEcosystem flag",
        new ValidationEngineOptions()
          .withTxServer("http://custom-tx.org"),
        new ValidationEngineParameters()
          .setTxServer("http://custom-tx.org")
          .setNoEcosystem(true)
      )
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("validOptions")
  void validOptionsTest(String testName, ValidationEngineOptions options, ValidationEngineParameters expectedParameters) {
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
