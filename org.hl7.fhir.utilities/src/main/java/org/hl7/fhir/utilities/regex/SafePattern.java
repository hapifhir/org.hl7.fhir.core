package org.hl7.fhir.utilities.regex;

import org.hl7.fhir.exceptions.FHIRException;

import javax.annotation.Nonnull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SafePattern {

  private SafePattern() {
    /* This utility class should not be instantiated */
  }

  /**
   * Compiles a regex pattern <b>without</b> checking for catastrophic backtracking constructs.
   *
   * <p><b>IMPORTANT</b> This should only be used in places where the regex is known at compile time and has been
   * verified to be safe for use. The checkstyle plugin must be informed of these usages via @SuppressWarnings or
   * checkstyle_supressions.xml entries, and any usages outside of those will fail the checkstyle check.</p>
   *
   * @param regex The expression to be compiled
   * @return the given regular expression compiled into a pattern
   * @throws PatternSyntaxException if the regular expression's syntax is invalid
   */
  @SuppressWarnings("checkstyle:patternCompile")
  public static Pattern compileKnownSafePattern(@Nonnull String regex) throws PatternSyntaxException {
    return Pattern.compile(regex);
  }

  /**
   * Checks a regex pattern for catastrophic backtracking constructs before compiling it.
   * <br/>
    * @param regex The expression to be compiled
    * @return the given regular expression compiled into a pattern
   * @throws PatternSyntaxException if the regular expression's syntax is invalid
   */
  @SuppressWarnings("checkstyle:patternCompile")
  public static Pattern compile(@Nonnull String regex) throws PatternSyntaxException {
    return compile(regex, 0);
  }

  /**
   * Checks a regex pattern for catastrophic backtracking constructs before compiling it.
   * <br/>
   * @param regex The expression to be compiled
   * @param flags Match flags, a bit mask that may include CASE_INSENSITIVE, MULTILINE, DOTALL, UNICODE_CASE, CANON_EQ, UNIX_LINES, LITERAL, UNICODE_CHARACTER_CLASS and COMMENTS
   * @return the given regular expression compiled into a pattern
   * @throws PatternSyntaxException if the regular expression's syntax is invalid
   */
  @SuppressWarnings("checkstyle:patternCompile")
  public static Pattern compile(@Nonnull String regex, int flags) throws PatternSyntaxException {
    // Reject patterns with known catastrophic backtracking constructs
    if (regex.matches(".*\\(.+[+*]\\)[+*].*")) {
      throw new FHIRException("Regex pattern rejected: potential catastrophic backtracking");
    }
    return Pattern.compile(regex, flags);
  }

  /**
   * Performs a regex match against a CharSequence. Same as Pattern.matches, but uses the safer compilePattern from this
   * utility class.
   *
   * @param regex The expression to be compiled
   * @param input the character sequence to be matched
   * @return whether or not the regular expression matches on the input
   */
  @SuppressWarnings("checkstyle:patternMatches")
  public static boolean matches(@Nonnull String regex, CharSequence input) throws PatternSyntaxException {
    Pattern p = compile(regex);
    Matcher m = p.matcher(input);
    return m.matches();
  }

  /**
   * Performs a regex match against a CharSequence.
   *
   * <p><b>IMPORTANT</b> This should only be used in places where the regex is known at compile time and has been
   * verified to be safe for use. The checkstyle plugin must be informed of these usages via @SuppressWarnings or
   * checkstyle_supressions.xml entries, and any usages outside of those will fail the checkstyle check.</p>
   *
   * @param regex The expression to be compiled
   * @param input the character sequence to be matched
   * @return whether or not the regular expression matches on the input
   */
  @SuppressWarnings("checkstyle:patternMatches")
  public static boolean matchesKnownSafePattern(@Nonnull String regex, CharSequence input) throws PatternSyntaxException {
    return Pattern.matches(regex, input);
  }
}
