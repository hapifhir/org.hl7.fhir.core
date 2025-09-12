package org.hl7.fhir.validation.cli.param;

import org.hl7.fhir.validation.service.model.ValidationEngineSettings;

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
      }
    return i;
  }
}
