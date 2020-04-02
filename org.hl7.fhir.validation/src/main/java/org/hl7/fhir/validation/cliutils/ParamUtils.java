package org.hl7.fhir.validation.cliutils;

public class ParamUtils {

  /** TODO proper error checking, streams
   * Checks the list of passed in params to see if it contains the passed in param.
   *
   * @param args Array of params to search.
   * @param param {@link String} param to search for.
   * @return {@link Boolean#TRUE} if the list contains the given param.
   */
  public static boolean hasParam(String[] args, String param) {
    for (String a : args)
      if (a.equals(param))
        return true;
    return false;
  }

  /** TODO proper error checking, streams
   * Fetches the  vlaue for the passed in param from the provided list of params.
   *
   * @param args Array of params to search.
   * @param param {@link String} param keyword to search for.
   * @return {@link String} value for the provided param.
   */
  public static String getParam(String[] args, String param) {
    for (int i = 0; i < args.length - 1; i++)
      if (args[i].equals(param))
        return args[i + 1];
    return null;
  }

}
