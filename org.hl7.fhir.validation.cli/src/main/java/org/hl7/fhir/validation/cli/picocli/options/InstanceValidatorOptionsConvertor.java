package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

public class InstanceValidatorOptionsConvertor {
  public InstanceValidatorParameters convert(InstanceValidatorOptions options) {
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();

    // String fields - null check then setter
    if (options.jurisdiction != null) {
      instanceValidatorParameters.setJurisdiction(options.jurisdiction);
    }

    if (options.expansionParameters != null) {
      instanceValidatorParameters.setExpansionParameters(options.expansionParameters);
    }

    if (options.htmlOutput != null) {
      instanceValidatorParameters.setHtmlOutput(options.htmlOutput);
    }

    if (options.outputStyle != null) {
      instanceValidatorParameters.setOutputStyle(options.outputStyle);
    }

    // Boolean fields
    instanceValidatorParameters.setAssumeValidRestReferences(options.assumeValidRestReferences);
    instanceValidatorParameters.setHintAboutNonMustSupport(options.hintAboutNonMustSupport);
    instanceValidatorParameters.setWantInvariantsInMessages(options.wantInvariantsInMessages);
    instanceValidatorParameters.setNoInvariants(options.noInvariants);
    instanceValidatorParameters.setUnknownCodeSystemsCauseErrors(options.unknownCodeSystemsCauseErrors);
    instanceValidatorParameters.setForPublication(options.forPublication);
    instanceValidatorParameters.setNoUnicodeBiDiControlChars(options.noUnicodeBiDiControlChars);
    instanceValidatorParameters.setCrumbTrails(options.crumbTrails);
    instanceValidatorParameters.setShowMessageIds(options.showMessageIds);
    instanceValidatorParameters.setAllowExampleUrls(options.allowExampleUrls);
    instanceValidatorParameters.setShowMessagesFromReferences(options.showMessagesFromReferences);
    instanceValidatorParameters.setSecurityChecks(options.securityChecks);
    instanceValidatorParameters.setNoExperimentalContent(options.noExperimentalContent);
    instanceValidatorParameters.setShowTerminologyRouting(options.showTerminologyRouting);
    instanceValidatorParameters.setDoImplicitFHIRPathStringConversion(options.doImplicitFHIRPathStringConversion);
    instanceValidatorParameters.setAllowDoubleQuotesInFHIRPath(options.allowDoubleQuotesInFHIRPath);
    instanceValidatorParameters.setCheckIPSCodes(options.checkIPSCodes);

    // Enum fields - null check then setter
    if (options.r5BundleRelativeReferencePolicy != null) {
      instanceValidatorParameters.setR5BundleRelativeReferencePolicy(options.r5BundleRelativeReferencePolicy);
    }

    if (options.questionnaireMode != null) {
      instanceValidatorParameters.setQuestionnaireMode(options.questionnaireMode);
    }

    if (options.level != null) {
      instanceValidatorParameters.setLevel(options.level);
    }

    if (options.bestPracticeLevel != null) {
      instanceValidatorParameters.setBestPracticeLevel(options.bestPracticeLevel);
    }

    if (options.htmlInMarkdownCheck != null) {
      instanceValidatorParameters.setHtmlInMarkdownCheck(options.htmlInMarkdownCheck);
    }

    // List fields - null/empty check, loop with addX() methods
    if (options.profiles != null && !options.profiles.isEmpty()) {
      for (String profile : options.profiles) {
        instanceValidatorParameters.addProfile(profile);
      }
    }

    if (options.extensions != null && !options.extensions.isEmpty()) {
      for (String extension : options.extensions) {
        instanceValidatorParameters.addExtension(extension);
      }
    }

    if (options.bundleValidationRules != null && !options.bundleValidationRules.isEmpty()) {
      for (var rule : options.bundleValidationRules) {
        instanceValidatorParameters.addBundleValidationRule(rule);
      }
    }

    return instanceValidatorParameters;
  }
}
