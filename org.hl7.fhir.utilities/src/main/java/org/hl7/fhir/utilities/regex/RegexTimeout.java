package org.hl7.fhir.utilities.regex;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * <p>This utility class executes common regular expression methods and times out if processing takes longer than expected.</p>
 * <p>500ms is the default timeout.</p>
 * <p>The timeout is enforced on the calling thread: the input is wrapped in a {@link DeadlineCharSequence}
 * that throws once a deadline has passed. Because the regex engine reads the input character-by-character
 * (via {@link CharSequence#charAt(int)}) as it matches - including while backtracking - a runaway (ReDoS)
 * evaluation is aborted promptly without spawning a worker thread.</p>
 */
@SuppressWarnings({"checkstyle:patternUsage", "checkstyle:stringImplicitPatternUsage"})
//Regex sourced from regex parameter; user-supplied at runtime, with timeout enforcement
public final class RegexTimeout {

  private RegexTimeout() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  static final long DEFAULT_TIMEOUT = 500;

  private static <T> T runWithDeadline(Function<CharSequence, T> regexOp, CharSequence input, long timeoutMillis) throws TimeoutException {
    long deadlineNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
    try {
      return regexOp.apply(new DeadlineCharSequence(input, deadlineNanos));
    } catch (RegexTimeoutException e) {
      throw new TimeoutException("Regex evaluation timed out after " + timeoutMillis + "ms");
    }
  }

  /**
   * Wrapper around {@link String#matches(String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @return true if, and only if, the charSequence matches the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static boolean matches(CharSequence charSequence, String regex) throws TimeoutException {
    return matches(charSequence, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#matches(String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @param timeoutMillis the timeout in milliseconds
   * @return true if, and only if, the charSequence matches the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static boolean matches(CharSequence charSequence, String regex, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.matches(regex, seq), charSequence, timeoutMillis);
  }

  /**
   * Wrapper around {@link java.util.regex.Matcher#find()} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to search for within the charSequence
   * @return true if a subsequence of the input sequence matches the pattern
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static boolean find(CharSequence charSequence, String regex) throws TimeoutException {
    return find(charSequence, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link java.util.regex.Matcher#find()} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to search for within the charSequence
   * @param timeoutMillis the timeout in milliseconds
   * @return true if a subsequence of the input sequence matches the pattern
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static boolean find(CharSequence charSequence, String regex, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.compile(regex).matcher(seq).find(), charSequence, timeoutMillis);
  }

  /**
   * Wrapper around {@link String#replaceAll(String, String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @param replacement the string to be substituted for each match
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String replaceAll(CharSequence charSequence, String regex, String replacement) throws TimeoutException {
    return replaceAll(charSequence, regex, replacement, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#replaceAll(String, String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @param replacement the string to be substituted for each match
   * @param timeoutMillis the timeout in milliseconds
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String replaceAll(CharSequence charSequence, String regex, String replacement, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.compile(regex).matcher(seq).replaceAll(replacement), charSequence, timeoutMillis);
  }

  /**
   * Wrapper around {@link String#replaceFirst(String, String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @param replacement the string to be substituted for the first match
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String replaceFirst(CharSequence charSequence, String regex, String replacement) throws TimeoutException {
    return replaceFirst(charSequence, regex, replacement, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#replaceFirst(String, String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the regular expression to which the charSequence is to be matched
   * @param replacement the string to be substituted for the first match
   * @param timeoutMillis the timeout in milliseconds
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String replaceFirst(CharSequence charSequence, String regex, String replacement, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.compile(regex).matcher(seq).replaceFirst(replacement), charSequence, timeoutMillis);
  }

  /**
   * Wrapper around {@link String#split(String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the delimiting regular expression
   * @return the array of strings computed by splitting the charSequence around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String[] split(CharSequence charSequence, String regex) throws TimeoutException {
    return split(charSequence, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#split(String)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the delimiting regular expression
   * @param timeoutMillis the timeout in milliseconds
   * @return the array of strings computed by splitting the charSequence around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String[] split(CharSequence charSequence, String regex, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.compile(regex).split(seq), charSequence, timeoutMillis);
  }

  /**
   * Wrapper around {@link String#split(String, int)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the delimiting regular expression
   * @param limit the result threshold
   * @return the array of strings computed by splitting the charSequence around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String[] split(CharSequence charSequence, String regex, int limit) throws TimeoutException {
    return split(charSequence, regex, limit, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#split(String, int)} which will throw an exception if processing runs longer than expected.
   * @param charSequence the charSequence
   * @param regex the delimiting regular expression
   * @param limit the result threshold
   * @param timeoutMillis the timeout in milliseconds
   * @return the array of strings computed by splitting the charSequence around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String[] split(CharSequence charSequence, String regex, int limit, long timeoutMillis) throws TimeoutException {
    return runWithDeadline(seq -> Pattern.compile(regex).split(seq, limit), charSequence, timeoutMillis);
  }

  /**
   * Thrown by {@link DeadlineCharSequence} when the evaluation deadline is exceeded. It propagates out of the
   * regex engine and is translated into a {@link TimeoutException} by {@link #runWithDeadline}. The stack trace
   * is suppressed as it carries no useful information.
   */
  private static final class RegexTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    RegexTimeoutException() {
      super(null, null, false, false);
    }
  }

  /**
   * <p>
   * CharSequence that aborts once a deadline has passed -- as might be necessary to recover from a loose regex
   * on unexpected challenging input. The regex engine reads the input via {@link #charAt(int)} as it matches
   * (including while backtracking), so checking the deadline there aborts a runaway evaluation on the calling
   * thread, with no separate worker thread required.
   * </p>
   * <p>
   * Adapted from <a href="https://stackoverflow.com/a/910798">this StackOverflow answer</a> (originally
   * interrupt-based; changed here to a deadline check).
   * </p>
   */
  static final class DeadlineCharSequence implements CharSequence {
      private final CharSequence inner;
      private final long deadlineNanos;

      public DeadlineCharSequence(CharSequence inner, long deadlineNanos) {
          super();
          this.inner = inner;
          this.deadlineNanos = deadlineNanos;
      }

      public char charAt(int index) {
          if (System.nanoTime() > deadlineNanos) {
              throw new RegexTimeoutException();
          }
          return inner.charAt(index);
      }

      public int length() {
          return inner.length();
      }

      public CharSequence subSequence(int start, int end) {
          return new DeadlineCharSequence(inner.subSequence(start, end), deadlineNanos);
      }

      @Override
      public String toString() {
          return inner.toString();
      }
  }
}
