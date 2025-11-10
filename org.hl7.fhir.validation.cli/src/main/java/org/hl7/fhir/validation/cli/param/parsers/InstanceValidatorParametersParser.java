package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

public class InstanceValidatorParametersParser implements IParamParser<InstanceValidatorParameters> {

  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";
  public static final String HTML_OUTPUT = "-html-output";
  public static final String OUTPUT_STYLE = "-output-style";
  public static final String R5_REF_POLICY = "r5-bundle-relative-reference-policy";
  public static final String EXTENSION = "-extension";
  public static final String WANT_INVARIANTS_IN_MESSAGES = "-want-invariants-in-messages";
  public static final String NO_INVARIANTS = "-no-invariants";
  public static final String QUESTIONNAIRE = "-questionnaire";
  public static final String UNKNOWN_CODESYSTEMS_CAUSE_ERROR = "-unknown-codesystems-cause-errors";
  public static final String LEVEL = "-level";
  public static final String BEST_PRACTICE = "-best-practice";
  public static final String FOR_PUBLICATION = "-forPublication";
  public static final String HTML_IN_MARKDOWN = "-html-in-markdown";
  public static final String NO_UNICODE_BIDI_CONTROL_CHARS = "-no_unicode_bidi_control_chars";
  public static final String CRUMB_TRAIL = "-crumb-trails";
  public static final String SHOW_MESSAGE_IDS = "-show-message-ids";
  public static final String ALLOW_EXAMPLE_URLS = "-allow-example-urls";
  public static final String VERBOSE = "-verbose";
  public static final String SHOW_MESSAGES_FROM_REFERENCES = "-showReferenceMessages";
  public static final String SECURITY_CHECKS = "-security-checks";
  public static final String NO_EXPERIMENTAL_CONTENT = "-no-experimental-content";
  public static final String TERMINOLOGY_ROUTING = "-tx-routing";
  public static final String PROFILE = "-profile";
  public static final String PROFILES = "-profiles";
  public static final String EXP_PARAMS = "-expansion-parameters";
  public static final String CHECK_IPS_CODES = "-check-ips-codes";
  public static final String DO_IMPLICIT_FHIRPATH_STRING_CONVERSION = "-implicit-fhirpath-string-conversions";
  public static final String ALLOW_DOUBLE_QUOTES = "-allow-double-quotes-in-fhirpath";
  public static final String BUNDLE = "-bundle";
  public static final String JURISDICTION = "-jurisdiction";

  InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();

  @Override
  public InstanceValidatorParameters getParameterObject() {
    return instanceValidatorParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(ASSUME_VALID_REST_REF)) {
        instanceValidatorParameters.setAssumeValidRestReferences(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(HINT_ABOUT_NON_MUST_SUPPORT)) {
        instanceValidatorParameters.setHintAboutNonMustSupport(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(HTML_OUTPUT)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -html-output without indicating output file");
        } else {
          instanceValidatorParameters.setHtmlOutput(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(OUTPUT_STYLE)) {
        instanceValidatorParameters.setOutputStyle(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(R5_REF_POLICY)) {
        if (i + 1 == args.length) {
          throw new Error("Specified r5-bundle-relative-reference-policy without indicating policy value");
        } else {
          instanceValidatorParameters.setR5BundleRelativeReferencePolicy(
            ValidationOptions.R5BundleRelativeReferencePolicy.fromCode(args[i + 1].getValue())
          );
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(EXTENSION)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -extension without indicating extension value");
        } else {
          instanceValidatorParameters.addExtension(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(WANT_INVARIANTS_IN_MESSAGES)) {
        instanceValidatorParameters.setWantInvariantsInMessages(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(NO_INVARIANTS)) {
        instanceValidatorParameters.setNoInvariants(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(QUESTIONNAIRE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -questionnaire without indicating questionnaire mode");
        } else {
          instanceValidatorParameters.setQuestionnaireMode(
            QuestionnaireMode.fromCode(args[i + 1].getValue())
          );
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(UNKNOWN_CODESYSTEMS_CAUSE_ERROR)) {
        instanceValidatorParameters.setUnknownCodeSystemsCauseErrors(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(LEVEL)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -level without indicating level mode");
        } else {
          String q = args[i + 1].getValue();
          instanceValidatorParameters.setLevel(ValidationLevel.fromCode(q));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(BEST_PRACTICE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified " + BEST_PRACTICE + " without indicating mode");
        } else {
          String q = args[i + 1].getValue();
          instanceValidatorParameters.setBestPracticeLevel(readBestPractice(q));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(FOR_PUBLICATION)) {
        instanceValidatorParameters.setForPublication(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(HTML_IN_MARKDOWN)) {
        if (i + 1 == args.length) {
          throw new Error("Specified " + HTML_IN_MARKDOWN + " without indicating mode");
        } else {
          String q = args[i + 1].getValue();
          if (!HtmlInMarkdownCheck.isValidCode(q)) {
            throw new Error("Specified " + HTML_IN_MARKDOWN + " with na invalid code - must be ignore, warning, or error");
          } else {
            instanceValidatorParameters.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(q));
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(NO_UNICODE_BIDI_CONTROL_CHARS)) {
        instanceValidatorParameters.setNoUnicodeBiDiControlChars(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(CRUMB_TRAIL)) {
        instanceValidatorParameters.setCrumbTrails(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SHOW_MESSAGE_IDS)) {
        instanceValidatorParameters.setShowMessageIds(true);
        args[i].setProcessed(true);
      }else if (args[i].getValue().equals(VERBOSE)) {
        instanceValidatorParameters.setCrumbTrails(true);
        instanceValidatorParameters.setShowMessageIds(true);
        args[i].setProcessed(true);
      }
      else if (args[i].getValue().equals(ALLOW_EXAMPLE_URLS)) {
        if (i + 1 == args.length) {
          throw new Error("Specified " + ALLOW_EXAMPLE_URLS + " without indicating value");
        } else {
          String bl = args[i + 1].getValue();
          if ("true".equals(bl)) {
            instanceValidatorParameters.setAllowExampleUrls(true);
          } else if ("false".equals(bl)) {
            instanceValidatorParameters.setAllowExampleUrls(false);
          } else {
            throw new Error("Value for " + ALLOW_EXAMPLE_URLS + " not understood: " + bl);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(SHOW_MESSAGES_FROM_REFERENCES)) {
        instanceValidatorParameters.setShowMessagesFromReferences(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SECURITY_CHECKS)) {
        instanceValidatorParameters.setSecurityChecks(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(NO_EXPERIMENTAL_CONTENT)) {
        instanceValidatorParameters.setNoExperimentalContent(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(TERMINOLOGY_ROUTING)) {
        instanceValidatorParameters.setShowTerminologyRouting(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(PROFILE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile url");
        } else {
          String profile = args[i + 1].getValue();
          instanceValidatorParameters.addProfile(profile);
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(PROFILES)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -profiles without indicating profile urls");
        } else {
          String profiles = args[i + 1].getValue();
          for (String profile : profiles.split("\\,")) {
            instanceValidatorParameters.addProfile(profile);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(EXP_PARAMS)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -expansion-parameters without indicating expansion parameters");
        } else {
          instanceValidatorParameters.setExpansionParameters(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(CHECK_IPS_CODES)) {
        instanceValidatorParameters.setCheckIPSCodes(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(DO_IMPLICIT_FHIRPATH_STRING_CONVERSION)) {
        instanceValidatorParameters.setDoImplicitFHIRPathStringConversion(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(ALLOW_DOUBLE_QUOTES)) {
        instanceValidatorParameters.setAllowDoubleQuotesInFHIRPath(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(BUNDLE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -bundle without indicating bundle rule");
        } else {
          String rule = args[i + 1].getValue();
          if (i + 2 == args.length) {
            throw new Error("Specified -bundle without indicating profile source");
          } else {
            String profile = args[i + 2].getValue();
            instanceValidatorParameters.addBundleValidationRule(new BundleValidationRule().setRule(rule).setProfile(profile));
            Arg.setProcessed(args, i, 3, true);
          }
        }
      } else if (args[i].getValue().equals(JURISDICTION)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -jurisdiction without indicating jurisdiction");
        } else {
          instanceValidatorParameters.setJurisdiction(processJurisdiction(args[i + 1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }

  private static BestPracticeWarningLevel readBestPractice(String s) {
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