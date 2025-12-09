package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

public class InstanceValidatorOptionsConvertor {
  public InstanceValidatorParameters convert(InstanceValidatorOptions options) {
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();

    // String fields - null check then setter
    if (options.jurisdiction != null) {
      instanceValidatorParameters.setJurisdiction(processJurisdiction(options.jurisdiction));
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
    instanceValidatorParameters.setShowMessageIds(options.showMessageIds);
    if (options.verbose) {
      instanceValidatorParameters.setCrumbTrails(true);
      instanceValidatorParameters.setShowMessageIds(true);
    }
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
      instanceValidatorParameters.setLevel(ValidationLevel.fromCode(options.level));
    }

    if (options.bestPracticeLevel != null) {
      instanceValidatorParameters.setBestPracticeLevel(readBestPractice(options.bestPracticeLevel));
    }

    if (options.htmlInMarkdownCheck != null) {
      if (!HtmlInMarkdownCheck.isValidCode(options.htmlInMarkdownCheck)) {
        throw new IllegalArgumentException("Specified -html-in-markdown with an invalid code - must be ignore, warning, or error");
      } else {
        instanceValidatorParameters.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(options.htmlInMarkdownCheck));
      }
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
      if(options.bundleValidationRules.size() % 2 != 0) {
        throw new IllegalArgumentException("bundleValidationRule accepts 2 arguments: rule and profile");
      }
      for (int i =0; i < options.bundleValidationRules.size(); i = i + 2) {
        final String rule = options.bundleValidationRules.get(i);
        final String profile = options.bundleValidationRules.get(i+1);
        instanceValidatorParameters.addBundleValidationRule(new BundleValidationRule().setRule(rule).setProfile(profile));
      }

    }

    return instanceValidatorParameters;
  }

  static BestPracticeWarningLevel readBestPractice(String s) {
    if (s == null) {
      return BestPracticeWarningLevel.Warning;
    }
    switch (s.toLowerCase()) {
      case "warning" : return BestPracticeWarningLevel.Warning;
      case "error" : return BestPracticeWarningLevel.Error;
      case "hint" : return BestPracticeWarningLevel.Hint;
      case "ignore" : return BestPracticeWarningLevel.Ignore;
      case "w" : return BestPracticeWarningLevel.Warning;
      case "e" : return BestPracticeWarningLevel.Error;
      case "h" : return BestPracticeWarningLevel.Hint;
      case "i" : return BestPracticeWarningLevel.Ignore;
    }
    throw new Error("The best-practice level ''" + s + "'' is not valid");
  }

  private static String processJurisdiction(String s) {
    if (s.startsWith("urn:iso:std:iso:3166#") || s.startsWith("urn:iso:std:iso:3166:-2#") || s.startsWith("http://unstats.un.org/unsd/methods/m49/m49.htm#")) {
      return s;
    } else {
      String v = JurisdictionUtilities.getJurisdictionFromLocale(s);
      if (v != null) {
        return v;
      } else {
        throw new FHIRException("Unable to understand Jurisdiction '"+s+"'");
      }
    }
  }
}
