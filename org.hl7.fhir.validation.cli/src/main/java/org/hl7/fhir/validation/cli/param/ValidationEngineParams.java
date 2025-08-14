package org.hl7.fhir.validation.cli.param;

import org.hl7.fhir.validation.service.model.ValidationEngineSettings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationEngineParams {

  private static final Set<String> ARG_NAMES = new HashSet<>(Arrays.asList(
    Params.NATIVE,
    Params.SCT,
    Params.HINT_ABOUT_NON_MUST_SUPPORT
  ));

  public static boolean isValidationEngineParam(String arg) {
    return ARG_NAMES.contains(arg);
  }

  /**
   * Temporary method to be replaced by a proper command line parser
   *
   * This method is to be called from the main loop in Params to process args intended for ValidationEngineSettings
   *
   *
   *
   * @param args
   * @param i
   * @return
   */
  public static int setValidationEngineSettingsFromArgs(ValidationEngineSettings validationEngineSettings, String[] args, final int i) {
      if (args[i].equals(Params.NATIVE)) {
        validationEngineSettings.setDoNative(true);
        return i;
      } else if (args[i].equals(Params.SCT)) {
        validationEngineSettings.setSnomedCT(args[i + 1]);
        return i+1;
      } else if (args[i].equals(Params.HINT_ABOUT_NON_MUST_SUPPORT)) {
        validationEngineSettings.setHintAboutNonMustSupport(true);
      }
    return i;
  }
}
