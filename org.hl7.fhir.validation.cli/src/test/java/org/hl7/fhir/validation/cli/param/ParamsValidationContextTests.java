package org.hl7.fhir.validation.cli.param;


import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.cli.param.parsers.ValidationContextParamParser;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParamsValidationContextTests {

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

  @AfterAll
  public static void afterAll() throws IOException {
    dummyFileA.delete();
    dummyFileB.delete();
  }


  // Created by Claude Sonnet 4.5
  public static Stream<Arguments> testCases() {
    List<Arguments> objects = new ArrayList<>();
    //Base case
    objects.add(Arguments.of(
      "source",
      new ValidationContext().addSource("source")));

    //IGs
    objects.add(Arguments.of(
      "-ig implementation.guide#1.2.3 source",
      new ValidationContext().addSource("source").addIg("implementation.guide#1.2.3")));

    // Output tests
    objects.add(Arguments.of(
      "-output output.json source",
      new ValidationContext().addSource("source").setOutput("output.json")));

    objects.add(Arguments.of(
      "-outputSuffix json source",
      new ValidationContext().addSource("source").setOutputSuffix("json")));

    objects.add(Arguments.of(
      "-html-output report.html source",
      new ValidationContext().addSource("source").setHtmlOutput("report.html")));

    // Profile tests
    objects.add(Arguments.of(
      "-profile https://example.org/profile source",
      new ValidationContext().addSource("source").addProfile("https://example.org/profile")));

    objects.add(Arguments.of(
      "-profiles https://ex.org/p1,https://ex.org/p2 source",
      new ValidationContext().addSource("source").addProfile("https://ex.org/p1").addProfile("https://ex.org/p2")));

    // Options tests
    objects.add(Arguments.of(
      "-option narrative source",
      new ValidationContext().addSource("source").addOption("narrative")));

    objects.add(Arguments.of(
      "-options narrative,meta source",
      new ValidationContext().addSource("source").addOption("narrative").addOption("meta")));

    // Bundle tests
    objects.add(Arguments.of(
      "-bundle Composition:0 http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-composition source",
      new ValidationContext().addSource("source").addBundleValidationRule(new BundleValidationRule().setRule("Composition:0").setProfile("http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-composition"))));

    // Mode tests
    objects.add(Arguments.of(
      "-questionnaire check source",
      new ValidationContext().addSource("source").setQuestionnaireMode(QuestionnaireMode.CHECK)));

    objects.add(Arguments.of(
      "-questionnaire none source",
      new ValidationContext().addSource("source").setQuestionnaireMode(QuestionnaireMode.NONE)));

    objects.add(Arguments.of(
      "-questionnaire required source",
      new ValidationContext().addSource("source").setQuestionnaireMode(QuestionnaireMode.REQUIRED)));


    objects.add(Arguments.of(
      "-level hints source",
      new ValidationContext().addSource("source").setLevel(ValidationLevel.HINTS)));

    objects.add(Arguments.of(
      "-level warnings source",
      new ValidationContext().addSource("source").setLevel(ValidationLevel.WARNINGS)));

    objects.add(Arguments.of(
      "-level errors source",
      new ValidationContext().addSource("source").setLevel(ValidationLevel.ERRORS)));

    objects.add(Arguments.of(
      "-mode cnt source",
      new ValidationContext().addSource("source").addModeParam("cnt")));

    objects.add(Arguments.of(
      "-input input.json source",
      new ValidationContext().addSource("source").addInput("input.json")));

    // Boolean flag tests
    objects.add(Arguments.of(
      "-native source",
      new ValidationContext().addSource("source").setDoNative(true)));

    objects.add(Arguments.of(
      "-assumeValidRestReferences source",
      new ValidationContext().addSource("source").setAssumeValidRestReferences(true)));

    objects.add(Arguments.of(
      "-check-references source",
      new ValidationContext().addSource("source").setCheckReferences(true)));

    objects.add(Arguments.of(
      "-recurse source",
      new ValidationContext().addSource("source").setRecursive(true)));

    objects.add(Arguments.of(
      "-showReferenceMessages source",
      new ValidationContext().addSource("source").setShowMessagesFromReferences(true)));

    objects.add(Arguments.of(
      "-implicit-fhirpath-string-conversions source",
      new ValidationContext().addSource("source").setDoImplicitFHIRPathStringConversion(true)));

    objects.add(Arguments.of(
      "-security-checks source",
      new ValidationContext().addSource("source").setSecurityChecks(true)));

    objects.add(Arguments.of(
      "-crumb-trails source",
      new ValidationContext().addSource("source").setCrumbTrails(true)));

    objects.add(Arguments.of(
      "-show-message-ids source",
      new ValidationContext().addSource("source").setShowMessageIds(true)));

    objects.add(Arguments.of(
      "-forPublication source",
      new ValidationContext().addSource("source").setForPublication(true)));

    objects.add(Arguments.of(
      "-verbose source",
      new ValidationContext().addSource("source").setCrumbTrails(true).setShowMessageIds(true)));

    objects.add(Arguments.of(
      "-no-internal-caching source",
      new ValidationContext().addSource("source").setNoInternalCaching(true)));

    objects.add(Arguments.of(
      "-no-extensible-binding-warnings source",
      new ValidationContext().addSource("source").setNoExtensibleBindingMessages(true)));

    objects.add(Arguments.of(
      "-allow-double-quotes-in-fhirpath source",
      new ValidationContext().addSource("source").setAllowDoubleQuotesInFHIRPath(true)));

    objects.add(Arguments.of(
      "-disable-default-resource-fetcher source",
      new ValidationContext().addSource("source").setDisableDefaultResourceFetcher(true)));

    objects.add(Arguments.of(
      "-check-ips-codes source",
      new ValidationContext().addSource("source").setCheckIPSCodes(true)));

    objects.add(Arguments.of(
      "-no_unicode_bidi_control_chars source",
      new ValidationContext().addSource("source").setNoUnicodeBiDiControlChars(true)));

    objects.add(Arguments.of(
      "-no-invariants source",
      new ValidationContext().addSource("source").setNoInvariants(true)));

    objects.add(Arguments.of(
      "-display-issues-are-warnings source",
      new ValidationContext().addSource("source").setDisplayWarnings(true)));

    objects.add(Arguments.of(
      "-want-invariants-in-messages source",
      new ValidationContext().addSource("source").setWantInvariantsInMessages(true)));

    objects.add(Arguments.of(
      "-hintAboutNonMustSupport source",
      new ValidationContext().addSource("source").setHintAboutNonMustSupport(true)));

    objects.add(Arguments.of(
      "-unknown-codesystems-cause-errors source",
      new ValidationContext().addSource("source").setUnknownCodeSystemsCauseErrors(true)));

    objects.add(Arguments.of(
      "-no-experimental-content source",
      new ValidationContext().addSource("source").setNoExperimentalContent(true)));

    // Advanced parameter tests
    objects.add(Arguments.of(
      "-sct us source",
      new ValidationContext().addSource("source").setSnomedCT("us")));

    objects.add(Arguments.of(
      "-locale en-US source",
      new ValidationContext().addSource("source").setLocale(Locale.forLanguageTag("en-US"))));

    objects.add(Arguments.of(
      "-extension https://example.org/ext source",
      new ValidationContext().addSource("source").addExtension("https://example.org/ext")));

    objects.add(Arguments.of(
      "-version 5.0",
      new ValidationContext().setSv("5.0")
    ));

    objects.add(Arguments.of(
      "-to-version 5.0 source",
      new ValidationContext().addSource("source").setTargetVer("5.0")));

    objects.add(Arguments.of(
      "-package-name my.package source",
      new ValidationContext().addSource("source").setPackageName("my.package")));

    objects.add(Arguments.of(
      "-tx-pack hl7.terminology source",
      new ValidationContext().addSource("source").addIg("hl7.terminology").addModeParam("tx").addModeParam("expansions")));

    objects.add(Arguments.of(
      "-tx-pack hl7.terminology,some.other.package source",
      new ValidationContext().addSource("source").addIg("hl7.terminology").addIg("some.other.package").addModeParam("tx").addModeParam("expansions")));

    objects.add(Arguments.of(
      "-pin source",
      new ValidationContext().addSource("source").addModeParam("pin")));

    objects.add(Arguments.of(
      "-expand source",
      new ValidationContext().addSource("source").addModeParam("expand")));

    objects.add(Arguments.of(
      "-do-native source",
      new ValidationContext().addSource("source").setCanDoNative(true)));

    objects.add(Arguments.of(
      "-no-native source",
      new ValidationContext().addSource("source").setCanDoNative(false)));

    objects.add(Arguments.of(
      "-transform map.fml source",
      new ValidationContext().addSource("source").setMap("map.fml")));

    objects.add(Arguments.of(
      "-format json source",
      new ValidationContext().addSource("source").setFormat(FhirFormat.JSON)));

    objects.add(Arguments.of(
      "-format xml source",
      new ValidationContext().addSource("source").setFormat(FhirFormat.XML)));

    objects.add(Arguments.of(
      "-format ttl source",
      new ValidationContext().addSource("source").setFormat(FhirFormat.TURTLE)));

    objects.add(Arguments.of(
      "-lang-transform translate.map source",
      new ValidationContext().addSource("source").setLangTransform("translate.map")));

    objects.add(Arguments.of(
      "-expansion-parameters params.json source",
      new ValidationContext().addSource("source").setExpansionParameters("params.json")));

    objects.add(Arguments.of(
      "-html-in-markdown warning source",
      new ValidationContext().addSource("source").setHtmlInMarkdownCheck(HtmlInMarkdownCheck.WARNING)));

    objects.add(Arguments.of(
      "-html-in-markdown ignore source",
      new ValidationContext().addSource("source").setHtmlInMarkdownCheck(HtmlInMarkdownCheck.NONE)));

    objects.add(Arguments.of(
      "-html-in-markdown error source",
      new ValidationContext().addSource("source").setHtmlInMarkdownCheck(HtmlInMarkdownCheck.ERROR)));


    objects.add(Arguments.of(
      "-best-practice error source",
      new ValidationContext().addSource("source").setBestPracticeLevel(BestPracticeWarningLevel.Error)));

    objects.add(Arguments.of(
      "-allow-example-urls true source",
      new ValidationContext().addSource("source").setAllowExampleUrls(true)));

    objects.add(Arguments.of(
      "-allow-example-urls false source",
      new ValidationContext().addSource("source").setAllowExampleUrls(false)));

    objects.add(Arguments.of(
      "-tx-routing source",
      new ValidationContext().addSource("source").setShowTerminologyRouting(true)));

    objects.add(Arguments.of(
      "-clear-tx-cache source",
      new ValidationContext().addSource("source").setClearTxCache(true)));

    objects.add(Arguments.of(
      "-show-times source",
      new ValidationContext().addSource("source").setShowTimes(true)));

    objects.add(Arguments.of(
      "-output-style compact source",
      new ValidationContext().addSource("source").setOutputStyle("compact")));

    objects.add(Arguments.of(
      "-tx n/a source",
      new ValidationContext().addSource("source").setTxServer(null).setNoEcosystem(true)));

    objects.add(Arguments.of(
      "-tx http://someserver.org source",
      new ValidationContext().addSource("source").setTxServer("http://someserver.org").setNoEcosystem(true)));


    objects.add(Arguments.of(
      "-txLog tx.log source",
      new ValidationContext().addSource("source").setTxLog("tx.log")));

    objects.add(Arguments.of(
      "-txCache cache/ source",
      new ValidationContext().addSource("source").setTxCache("cache/")));

    objects.add(Arguments.of(
      "-log map.log source",
      new ValidationContext().addSource("source").setMapLog("map.log")));

    objects.add(Arguments.of(
      "-language de source",
      new ValidationContext().addSource("source").setLang("de")));

    objects.add(Arguments.of(
      "-src-lang en source",
      new ValidationContext().addSource("source").setSrcLang("en")));

    objects.add(Arguments.of(
      "-tgt-lang de source",
      new ValidationContext().addSource("source").setTgtLang("de")));

    objects.add(Arguments.of(
      "-map transform.map source",
      new ValidationContext().addSource("source").setMap("transform.map")));

    objects.add(Arguments.of(
      "-compile compile.map source",
      new ValidationContext().addSource("source").setMap("compile.map")));

    objects.add(Arguments.of(
      "-watch-mode all source",
      new ValidationContext().addSource("source").setWatchMode(ValidatorWatchMode.ALL)));

    objects.add(Arguments.of(
      "-watch-mode none source",
      new ValidationContext().addSource("source").setWatchMode(ValidatorWatchMode.NONE)));

    objects.add(Arguments.of(
      "-watch-mode single source",
      new ValidationContext().addSource("source").setWatchMode(ValidatorWatchMode.SINGLE)));

    objects.add(Arguments.of(
      "-watch-mode all -watch-scan-delay 1000 -watch-settle-time 500 source",
      new ValidationContext().addSource("source")
        .setWatchMode(ValidatorWatchMode.ALL)
        .setWatchScanDelay(1000)
        .setWatchSettleTime(500)));

    objects.add(Arguments.of(
      "-fhirpath Patient.name.given source",
      new ValidationContext().addSource("source").setFhirpath("Patient.name.given")));

    objects.add(Arguments.of(
      "-resolution-context https://example.org source",
      new ValidationContext().addSource("source").setResolutionContext("https://example.org")));

    objects.add(Arguments.of(
      "-ai-service openai source",
      new ValidationContext().addSource("source").setAIService("openai")));

    objects.add(Arguments.of(
      "-re-package somepackage#1.2.3",
      new ValidationContext().addIg("somepackage#1.2.3").addModeParam("tx").addModeParam("cnt").addModeParam("api")
    ));

    objects.add(Arguments.of(
      "-re-package somepackage#1.2.3,otherpackage#3.2.1",
      new ValidationContext().addIg("somepackage#1.2.3").addIg("otherpackage#3.2.1").addModeParam("tx").addModeParam("cnt").addModeParam("api")
    ));

    objects.add(Arguments.of(
      "-lang-regen param1 param2 param3",
      new ValidationContext().addLangRegenParam("param1").addLangRegenParam("param2").addLangRegenParam("param3")
    ));

    objects.add(Arguments.of(
      "-factory source",
      new ValidationContext().setSource("source")
    ));

    objects.add(Arguments.of(
      "-advisor-file " + dummyFileAPath,
      new ValidationContext().setAdvisorFile(dummyFileAPath)
    ));

    objects.add(Arguments.of(
      "-cert " +dummyFileAPath+ " -cert " + dummyFileBPath,
      new ValidationContext().addCertSource(dummyFileAPath).addCertSource(dummyFileBPath)
    ));

    objects.add(Arguments.of(
      "-matchetype " +dummyFileAPath+ " -matchetype " + dummyFileBPath,
      new ValidationContext().addMatchetype(dummyFileAPath).addMatchetype(dummyFileBPath)
    ));

    objects.add(Arguments.of(
      "-jurisdiction urn:iso:std:iso:3166#",
      new ValidationContext().setJurisdiction("urn:iso:std:iso:3166#")
    ));

    objects.add(Arguments.of(
      "-alt-version 4.0",
      new ValidationContext().addIg("hl7.fhir.r4.core#4.0")
    ));

    objects.add(Arguments.of(
      "r5-bundle-relative-reference-policy always source",
      new ValidationContext().addSource("source").setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.ALWAYS)));

    objects.add(Arguments.of(
      "r5-bundle-relative-reference-policy default source",
      new ValidationContext().addSource("source").setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.DEFAULT)));

    objects.add(Arguments.of(
      "r5-bundle-relative-reference-policy never source",
      new ValidationContext().addSource("source").setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.NEVER)));


    // Multiple sources test
    objects.add(Arguments.of(
      "source1 source2 source3",
      new ValidationContext().addSource("source1").addSource("source2").addSource("source3")));

    // Global params test

    //These are just skipped
    objects.add(Arguments.of("-authorise-non-conformant-tx-servers -no-http-access -fhir-settings source1",
      new ValidationContext().addSource("source1")
    ));

    //These are also just skipped
    objects.add(Arguments.of("-authorise-non-conformant-tx-servers -no-http-access -fhir-settings source1",
      new ValidationContext().addSource("source1")
    ));

    //These use values
    objects.add(Arguments.of(
      "-debug-log debug.log -trace-log trace.log -proxy http://somewhere.org -auth user:pass -https-proxy https://somewhere.org source1",
      new ValidationContext().addSource("source1")
    ));

    return objects.stream();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void testValidationContextParamParser(String argsLine, ValidationContext expectedValidationContext) throws Exception {
    ValidationContextParamParser parser = new ValidationContextParamParser();
    String[] argArray = argsLine.split("\\s");
    parser.parseArgs(Arg.of(argArray));
    ValidationContext actualValidationContext = parser.getParameterObject();
    assertThat(actualValidationContext).isEqualTo(expectedValidationContext);
  }
}
