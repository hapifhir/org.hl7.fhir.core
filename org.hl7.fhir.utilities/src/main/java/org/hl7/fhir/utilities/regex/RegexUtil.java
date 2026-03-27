package org.hl7.fhir.utilities.regex;

import org.hl7.fhir.exceptions.FHIRException;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexUtil {
  /**
   * Compiles a regex pattern <b>without</b> checking for catastrophic backtracking constructs.
   *
   * <p><b>IMPORTANT</b> This should only be used in places where the regex is known at compile time and has been verified
   * to be safe for use. The checkstyle plugin must be updated with the location of these usages, and any usages outside
   * of those will fail the checkstyle check.</p>
   *
   * @param pattern The expression to be compiled
   * @return the given regular expression compiled into a pattern
   * @throws PatternSyntaxException if the regular expression's syntax is invalid
   */
  public Pattern compileSafePattern(String pattern) throws PatternSyntaxException {
    return Pattern.compile(pattern);
  }

  /**
   * Checks a regex pattern for catastrophic backtracking constructs before compiling it.
   * <br/>
    * @param pattern The expression to be compiled
    * @return the given regular expression compiled into a pattern
   * @throws PatternSyntaxException if the regular expression's syntax is invalid
   */
  public Pattern compilePattern(String pattern) throws PatternSyntaxException {
    // Reject patterns with known catastrophic backtracking constructs
    if (pattern.matches(".*\\(.+[+*]\\)[+*].*")) {
      throw new FHIRException("Regex pattern rejected: potential catastrophic backtracking");
    }
    return Pattern.compile("(?s)" + pattern);
  }
}
