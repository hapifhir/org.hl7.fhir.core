package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

public class ValidationEngineParametersParser implements IParamParser<ValidationEngineParameters> {

  public static final String NATIVE = "-native";
  public static final String SCT = "-sct";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";
  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";
  public static final String VERSION = "-version";
  public static final String IMPLEMENTATION_GUIDE = "-ig";
  public static final String DEFINITION = "-defn";

  ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
  @Override
  public ValidationEngineParameters getParameterObject() {
    return validationEngineParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(NATIVE)) {
        validationEngineParameters.setDoNative(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SCT)) {
        validationEngineParameters.setSnomedCT(args[i + 1].getValue());
        Arg.setProcessed(args, i,  2, true);
      } else if (args[i].getValue().equals(HINT_ABOUT_NON_MUST_SUPPORT)) {
        validationEngineParameters.setHintAboutNonMustSupport(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(ASSUME_VALID_REST_REF)) {
        validationEngineParameters.setAssumeValidRestReferences(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(NO_EXTENSIBLE_BINDING_WARNINGS)) {
        validationEngineParameters.setNoExtensibleBindingMessages(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(VERSION)) {
        validationEngineParameters.setSv(VersionUtilities.getCurrentPackageVersion(args[i + 1].getValue()));
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(IMPLEMENTATION_GUIDE) || args[i].getValue().equals(DEFINITION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating ig file");
        else {
          String ig = args[i + 1].getValue();
          String igVersion = Params.getVersionFromIGName(null, ig);
          if (igVersion == null) {
            validationEngineParameters.addIg(ig);
          } else {
            String explicitParamVersion = Arg.getParam(args, VERSION);
            if (explicitParamVersion != null && !explicitParamVersion.equals(igVersion)) {
              throw new Error("Parameters are inconsistent: specified version is "+explicitParamVersion+" but -ig parameter "+ig+" implies a different version");
            } else if (validationEngineParameters.getSv() != null && !igVersion.equals(validationEngineParameters.getSv())) {
              throw new Error("Parameters are inconsistent: multiple -ig parameters implying differetion versions ("+ validationEngineParameters.getSv()+","+igVersion+")");
            } else {
              validationEngineParameters.setSv(igVersion);
            }
          }
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }
}
