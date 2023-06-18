package org.hl7.fhir.validation.testexecutor;

import static org.hl7.fhir.validation.testexecutor.TestModules.JUNIT5_MODULE_NAMES;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TestExecutorParams {
  private static final String MODULE_DELIMITER = ",";
  public static boolean isValidModuleParam(String param) {
      if (param == null) {
        return true;
      }
      final String[] modules = param.split(MODULE_DELIMITER);
      for (String module : modules) {
        if (Arrays.stream(JUNIT5_MODULE_NAMES).noneMatch(i -> i.equals(module))) {
          return false;
        }
      }
      return true;
    }

    public static String[] parseModuleParam(String param) {
      if (param == null) {
        return null;
      } else {
        return param.split(MODULE_DELIMITER);
      }
    }

    public static boolean isValidClassnameFilterParam(String param) {
      if (param == null) return true;
      try {
        Pattern.compile(param);
        return true;
      } catch (PatternSyntaxException e) {
        return false;
      }
    }
}
