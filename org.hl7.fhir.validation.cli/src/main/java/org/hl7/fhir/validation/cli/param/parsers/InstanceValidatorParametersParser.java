package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

public class InstanceValidatorParametersParser implements IParamParser<InstanceValidatorParameters> {

  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";
  public static final String SHOW_TIMES = "-show-times";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";
  public static final String HTML_OUTPUT = "-html-output";
  public static final String OUTPUT_STYLE = "-output-style";
  public static final String R5_REF_POLICY = "r5-bundle-relative-reference-policy";
  public static final String EXTENSION = "-extension";
  public static final String WANT_INVARIANTS_IN_MESSAGES = "-want-invariants-in-messages";
  public static final String NO_INVARIANTS = "-no-invariants";
  public static final String QUESTIONNAIRE = "-questionnaire";
  public static final String DISPLAY_WARNINGS = "-display-issues-are-warnings";
  public static final String UNKNOWN_CODESYSTEMS_CAUSE_ERROR = "-unknown-codesystems-cause-errors";
  public static final String LEVEL = "-level";
  public static final String BEST_PRACTICE = "-best-practice";
  public static final String FOR_PUBLICATION = "-forPublication";

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
      } else if (args[i].getValue().equals(NO_EXTENSIBLE_BINDING_WARNINGS)) {
        instanceValidatorParameters.setNoExtensibleBindingMessages(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SHOW_TIMES)) {
        instanceValidatorParameters.setShowTimes(true);
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
      } else if (args[i].getValue().equals(DISPLAY_WARNINGS)) {
        instanceValidatorParameters.setDisplayWarnings(true);
        args[i].setProcessed(true);
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
}