package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptionsConvertor;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;
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
      ),

      // Boolean flags - assumeValidRestReferences
      Arguments.arguments(
        new InstanceValidatorOptions().withAssumeValidRestReferences(true),
        new InstanceValidatorParameters().setAssumeValidRestReferences(true)
      ),

      // Boolean flags - hintAboutNonMustSupport
      Arguments.arguments(
        new InstanceValidatorOptions().withHintAboutNonMustSupport(true),
        new InstanceValidatorParameters().setHintAboutNonMustSupport(true)
      ),

      // Boolean flags - wantInvariantsInMessages
      Arguments.arguments(
        new InstanceValidatorOptions().withWantInvariantsInMessages(true),
        new InstanceValidatorParameters().setWantInvariantsInMessages(true)
      ),

      // Boolean flags - noInvariants
      Arguments.arguments(
        new InstanceValidatorOptions().withNoInvariants(true),
        new InstanceValidatorParameters().setNoInvariants(true)
      ),

      // Boolean flags - unknownCodeSystemsCauseErrors
      Arguments.arguments(
        new InstanceValidatorOptions().withUnknownCodeSystemsCauseErrors(true),
        new InstanceValidatorParameters().setUnknownCodeSystemsCauseErrors(true)
      ),

      // Boolean flags - forPublication
      Arguments.arguments(
        new InstanceValidatorOptions().withForPublication(true),
        new InstanceValidatorParameters().setForPublication(true)
      ),

      // Boolean flags - noUnicodeBiDiControlChars
      Arguments.arguments(
        new InstanceValidatorOptions().withNoUnicodeBiDiControlChars(true),
        new InstanceValidatorParameters().setNoUnicodeBiDiControlChars(true)
      ),

      // Boolean flags - verbose
      Arguments.arguments(
        new InstanceValidatorOptions().withVerbose(true),
        new InstanceValidatorParameters().setCrumbTrails(true).setShowMessageIds(true)
      ),

      // Boolean flags - showMessageIds
      Arguments.arguments(
        new InstanceValidatorOptions().withShowMessageIds(true),
        new InstanceValidatorParameters().setShowMessageIds(true)
      ),

      // Boolean flags - allowExampleUrls
      Arguments.arguments(
        new InstanceValidatorOptions().withAllowExampleUrls(true),
        new InstanceValidatorParameters().setAllowExampleUrls(true)
      ),

      // Boolean flags - showMessagesFromReferences
      Arguments.arguments(
        new InstanceValidatorOptions().withShowMessagesFromReferences(true),
        new InstanceValidatorParameters().setShowMessagesFromReferences(true)
      ),

      // Boolean flags - securityChecks
      Arguments.arguments(
        new InstanceValidatorOptions().withSecurityChecks(true),
        new InstanceValidatorParameters().setSecurityChecks(true)
      ),

      // Boolean flags - noExperimentalContent
      Arguments.arguments(
        new InstanceValidatorOptions().withNoExperimentalContent(true),
        new InstanceValidatorParameters().setNoExperimentalContent(true)
      ),

      // Boolean flags - showTerminologyRouting
      Arguments.arguments(
        new InstanceValidatorOptions().withShowTerminologyRouting(true),
        new InstanceValidatorParameters().setShowTerminologyRouting(true)
      ),

      // Boolean flags - doImplicitFHIRPathStringConversion
      Arguments.arguments(
        new InstanceValidatorOptions().withDoImplicitFHIRPathStringConversion(true),
        new InstanceValidatorParameters().setDoImplicitFHIRPathStringConversion(true)
      ),

      // Boolean flags - allowDoubleQuotesInFHIRPath
      Arguments.arguments(
        new InstanceValidatorOptions().withAllowDoubleQuotesInFHIRPath(true),
        new InstanceValidatorParameters().setAllowDoubleQuotesInFHIRPath(true)
      ),

      // Boolean flags - checkIPSCodes
      Arguments.arguments(
        new InstanceValidatorOptions().withCheckIPSCodes(true),
        new InstanceValidatorParameters().setCheckIPSCodes(true)
      ),

      // String fields - htmlOutput
      Arguments.arguments(
        new InstanceValidatorOptions().withHtmlOutput("/tmp/output.html"),
        new InstanceValidatorParameters().setHtmlOutput("/tmp/output.html")
      ),

      // String fields - outputStyle
      Arguments.arguments(
        new InstanceValidatorOptions().withOutputStyle("compact"),
        new InstanceValidatorParameters().setOutputStyle("compact")
      ),

      // Enum fields - r5BundleRelativeReferencePolicy
      Arguments.arguments(
        new InstanceValidatorOptions().withR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.ALWAYS),
        new InstanceValidatorParameters().setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.ALWAYS)
      ),

      // Enum fields - questionnaireMode
      Arguments.arguments(
        new InstanceValidatorOptions().withQuestionnaireMode(QuestionnaireMode.REQUIRED),
        new InstanceValidatorParameters().setQuestionnaireMode(QuestionnaireMode.REQUIRED)
      ),

      // Enum fields - level
      Arguments.arguments(
        new InstanceValidatorOptions().withLevel(ValidationLevel.ERRORS),
        new InstanceValidatorParameters().setLevel(ValidationLevel.ERRORS)
      ),

      // Enum fields - bestPracticeLevel
      Arguments.arguments(
        new InstanceValidatorOptions().withBestPracticeLevel("error"),
        new InstanceValidatorParameters().setBestPracticeLevel(BestPracticeWarningLevel.Error)
      ),

      // Enum fields - bestPracticeLevel
      Arguments.arguments(
        new InstanceValidatorOptions().withBestPracticeLevel("e"),
        new InstanceValidatorParameters().setBestPracticeLevel(BestPracticeWarningLevel.Error)
      ),

      // Enum fields - htmlInMarkdownCheck
      Arguments.arguments(
        new InstanceValidatorOptions().withHtmlInMarkdownCheck(HtmlInMarkdownCheck.ERROR),
        new InstanceValidatorParameters().setHtmlInMarkdownCheck(HtmlInMarkdownCheck.ERROR)
      ),

      // List fields - extensions (single)
      Arguments.arguments(
        new InstanceValidatorOptions().withExtensions(List.of("http://example.org")),
        new InstanceValidatorParameters().addExtension("http://example.org")
      ),

      // List fields - extensions (multiple)
      Arguments.arguments(
        new InstanceValidatorOptions().withExtensions(List.of("http://example.org", "http://example2.org")),
        new InstanceValidatorParameters()
          .addExtension("http://example.org")
          .addExtension("http://example2.org")
      ),

      // List fields - bundleValidationRules (single)
      Arguments.arguments(
        new InstanceValidatorOptions().withBundleValidationRules(
          List.of("Patient","http://hl7.org/fhir/StructureDefinition/Patient")
        ),
        new InstanceValidatorParameters().addBundleValidationRule(
          new BundleValidationRule().setRule("Patient").setProfile("http://hl7.org/fhir/StructureDefinition/Patient")
        )
      ),

      // List fields - bundleValidationRules (multiple)
      Arguments.arguments(
        new InstanceValidatorOptions().withBundleValidationRules(
          List.of(
            "Patient","http://hl7.org/fhir/StructureDefinition/Patient",
            "Observation","http://hl7.org/fhir/StructureDefinition/Observation")
        ),
        new InstanceValidatorParameters()
          .addBundleValidationRule(new BundleValidationRule().setRule("Patient").setProfile("http://hl7.org/fhir/StructureDefinition/Patient"))
          .addBundleValidationRule(new BundleValidationRule().setRule("Observation").setProfile("http://hl7.org/fhir/StructureDefinition/Observation"))
      ),

      // Combined test with multiple new fields
      Arguments.arguments(
        new InstanceValidatorOptions()
          .withAssumeValidRestReferences(true)
          .withHintAboutNonMustSupport(true)
          .withHtmlOutput("/tmp/validation.html")
          .withOutputStyle("eslint-compact")
          .withQuestionnaireMode(QuestionnaireMode.CHECK)
          .withLevel(ValidationLevel.WARNINGS)
          .withExtensions(List.of("http://example.org", "any")),
        new InstanceValidatorParameters()
          .setAssumeValidRestReferences(true)
          .setHintAboutNonMustSupport(true)
          .setHtmlOutput("/tmp/validation.html")
          .setOutputStyle("eslint-compact")
          .setQuestionnaireMode(QuestionnaireMode.CHECK)
          .setLevel(ValidationLevel.WARNINGS)
          .addExtension("http://example.org")
          .addExtension("any")
      ),

      // Combined test with all field types
      Arguments.arguments(
        new InstanceValidatorOptions()
          .withJurisdiction("US")
          .withExpansionParameters("version=4.0.1")
          .withProfiles(List.of("http://hl7.org/fhir/StructureDefinition/Patient"))
          .withAssumeValidRestReferences(true)
          .withForPublication(true)
          .withVerbose(true)
          .withHtmlOutput("/tmp/output.html")
          .withOutputStyle("json")
          .withR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.NEVER)
          .withQuestionnaireMode(QuestionnaireMode.NONE)
          .withLevel(ValidationLevel.HINTS)
          .withBestPracticeLevel("ignore")
          .withHtmlInMarkdownCheck(HtmlInMarkdownCheck.NONE)
          .withExtensions(List.of("http://example.org"))
          .withBundleValidationRules(List.of(
            "Patient:0","http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient")
          ),
        new InstanceValidatorParameters()
          .setJurisdiction("US")
          .setExpansionParameters("version=4.0.1")
          .addProfile("http://hl7.org/fhir/StructureDefinition/Patient")
          .setAssumeValidRestReferences(true)
          .setForPublication(true)
          .setCrumbTrails(true)
          .setShowMessageIds(true)
          .setHtmlOutput("/tmp/output.html")
          .setOutputStyle("json")
          .setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.NEVER)
          .setQuestionnaireMode(QuestionnaireMode.NONE)
          .setLevel(ValidationLevel.HINTS)
          .setBestPracticeLevel(BestPracticeWarningLevel.Ignore)
          .setHtmlInMarkdownCheck(HtmlInMarkdownCheck.NONE)
          .addExtension("http://example.org")
          .addBundleValidationRule(new BundleValidationRule().setRule("Patient:0").setProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient"))
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
