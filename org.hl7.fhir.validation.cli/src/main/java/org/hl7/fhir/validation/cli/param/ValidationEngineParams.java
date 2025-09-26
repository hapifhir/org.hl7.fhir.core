package org.hl7.fhir.validation.cli.param;

import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.service.model.ValidationEngineSettings;
import org.hl7.fhir.validation.service.utils.EngineMode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationEngineParams {

  private static final Set<String> ARG_NAMES = new HashSet<>(Arrays.asList(
    Params.NATIVE,
    Params.SCT,
    Params.HINT_ABOUT_NON_MUST_SUPPORT,
    Params.ASSUME_VALID_REST_REF,
    Params.NO_EXTENSIBLE_BINDING_WARNINGS
  ));

  public static boolean isValidationEngineParam(String arg) {
    return ARG_NAMES.contains(arg);
  }

  /**
   * Temporary method to be replaced by a proper command line parser
   * <p/>
   * This method is to be called from the main loop in Params to process args intended for ValidationEngineSettings
   *
   * @param validationEngineSettings The instance to which settings will be written
   * @param args the argument array to be parsed
   * @param i the current index being considered
   * @return the next index available after parsing. If no applicable settings were parsed, this will be equal to i
   */
  public static int setValidationEngineSettingsFromArgs(ValidationEngineSettings validationEngineSettings, String[] args, final int i) {
      if (args[i].equals(Params.NATIVE)) {
        validationEngineSettings.setDoNative(true);
      } else if (args[i].equals(Params.SCT)) {
        validationEngineSettings.setSnomedCT(args[i + 1]);
        return i+1;
      } else if (args[i].equals(Params.HINT_ABOUT_NON_MUST_SUPPORT)) {
        validationEngineSettings.setHintAboutNonMustSupport(true);
      } else if (args[i].equals(Params.ASSUME_VALID_REST_REF)) {
        validationEngineSettings.setAssumeValidRestReferences(true);
      } else if (args[i].equals(Params.NO_EXTENSIBLE_BINDING_WARNINGS)) {
        validationEngineSettings.setNoExtensibleBindingMessages(true);
      } else if (args[i].equals(Params.VERSION)) {
        validationEngineSettings.setSv(VersionUtilities.getCurrentPackageVersion(args[i + 1]));
        return i+1;
      } else if (args[i].equals(Params.TO_VERSION)) {
        validationEngineSettings.setTargetVer(args[i + 1]);
        //FIXME test this line. This has been moved to VersionTask as a Params.hasParam
        //validationContext.setMode(EngineMode.VERSION);
      } else if (args[i].equals(Params.IMPLEMENTATION_GUIDE) || args[i].equals(Params.DEFINITION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating ig file");
        else {
          String ig = args[i + 1];
          String igVersion = Params.getVersionFromIGName(null, ig);
          if (igVersion == null) {
            validationEngineSettings.addIg(ig);
          } else {
            String explicitParamVersion = Params.getParam(args, Params.VERSION);
            if (explicitParamVersion != null && !explicitParamVersion.equals(igVersion)) {
              throw new Error("Parameters are inconsistent: specified version is "+explicitParamVersion+" but -ig parameter "+ig+" implies a different version");
            } else if (validationEngineSettings.getSv() != null && !igVersion.equals(validationEngineSettings.getSv())) {
              throw new Error("Parameters are inconsistent: multiple -ig parameters implying differetion versions ("+ validationEngineSettings.getSv()+","+igVersion+")");
            } else {
              validationEngineSettings.setSv(igVersion);
            }
          }
          return i + 1;
        }
      }
    return i;
  }
}
