package org.hl7.fhir.validation.cli.param;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Arg {
  @Getter
  private final String value;

  @Getter
  @Setter
  private boolean processed = false;
  public Arg(String value) {
    this.value = value;
  }

  public static Arg[] of (String[] arg) {
    final Arg[] output = new Arg[arg.length];
    for (int i = 0; i < arg.length; i++) {
      output[i] = new Arg(arg[i]);
    }
    return output;
  }

  public static String[] of (Arg[] arg) {
    final String[] output = new String[arg.length];
    for (int i = 0; i < arg.length; i++) {
      output[i] = arg[i].value;
    }
    return output;
  }

  public static void setProcessed(Arg[] args, int index, int argsProcessed, boolean processed) {
    for (int i = index; i < index + argsProcessed; i++) {
      args[i].setProcessed(processed);
    }
  }

  /**
   * Checks the list of passed in params to see if it contains the passed in param.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param to search for.
   * @return {@link Boolean#TRUE} if the list contains the given param.
   */
  public static boolean hasParam(Arg[] args, String param) {
    return getParamIndex(args,param) != -1;
  }

  public static boolean hasParamAndValue(Arg[] args, String param) {
    int paramIndex = getParamIndex(args, param);
    if (paramIndex == -1) {
      return false;
    }
    checkIfParamValueInBounds(args, param, paramIndex);
    return true;
  }

  /**
   * Check if the value for the param is in bounds in the args array.
   */
  private static void checkIfParamValueInBounds(Arg[] args, String param, int paramIndex) {
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
  public static String getParam(Arg[] args, String param) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].getValue().equals(param)) return args[i + 1].getValue();
    }
    return null;
  }

  public static int getParamIndex(Arg[] args, String param) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].getValue().equals(param)) return i;
    }
    return -1;
  }

  public static void setProcessed(Arg[] args, String valueToMatch, boolean processed) {
    for (Arg arg : args) {
      if (arg.getValue().equals(valueToMatch)) {
        arg.setProcessed(processed);
      }
    }
  }

  public static Collection<String> getMultiValueParam(Arg[] args, String param) {
    final List<String> output = new LinkedList<>();
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].getValue().equals(param)) {
        checkIfParamValueInBounds(args, param, i);
        output.add(args[i + 1].getValue());
      }
    }
    return Collections.unmodifiableList(output);
  }
}
