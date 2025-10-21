package org.hl7.fhir.validation.cli.param;

import java.util.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Params {

  /**
   * Checks the list of passed in params to see if it contains the passed in param.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param to search for.
   * @return {@link Boolean#TRUE} if the list contains the given param.
   */
  public static boolean hasParam(String[] args, String param) {
    return Arrays.asList(args).contains(param);
  }

  public static boolean hasParamAndValue(String[] args, String param) {
    int paramIndex = Arrays.asList(args).indexOf(param);
    if (paramIndex == -1) {
      return false;
    }
    checkIfParamValueInBounds(args, param, paramIndex);
    return true;
  }

  /**
   * Check if the value for the param is in bounds in the args array.
   */
  private static void checkIfParamValueInBounds(String[] args, String param, int paramIndex) {
    if (paramIndex + 1 >= args.length) {
      throw new Error("Used '"+ param +"' without providing a value");
    }
  }

  /**
   * Fetches the value for the passed in param from the provided list of params.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param keyword to search for.
   * @return {@link String} value for the provided param, or null if param is out of bounds
   */
  public static String getParam(String[] args, String param) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(param)) return args[i + 1];
    }
    return null;
  }

  public static Collection<String> getMultiValueParam(String[] args, String param) {
    final List<String> output = new LinkedList<>();
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(param)) {
        checkIfParamValueInBounds(args, param, i);
        output.add(args[i + 1]);
      }
    }
    return Collections.unmodifiableList(output);
  }

}
