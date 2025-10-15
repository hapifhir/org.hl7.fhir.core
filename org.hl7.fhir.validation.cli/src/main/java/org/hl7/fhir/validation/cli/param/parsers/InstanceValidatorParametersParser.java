package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

public class InstanceValidatorParametersParser implements IParamParser<InstanceValidatorParameters> {

  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";
  public static final String SHOW_TIMES = "-show-times";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";

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
      }
    }
  }
}