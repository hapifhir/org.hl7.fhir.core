package org.hl7.fhir.utilities.regex;

import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * <p>This utility class executes common regular expression methods and times out if processing takes longer than expected.</p>
 * <p>500ms is the default timeout.</p>
 */
@SuppressWarnings({"checkstyle:patternUsage", "checkstyle:stringImplicitPatternUsage"})
//Regex sourced from regex parameter; user-supplied at runtime, with timeout enforcement
public final class RegexTimeout {

  private RegexTimeout() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  static final long DEFAULT_TIMEOUT = 500;

  private static <T> T executeWithTimeout(Callable<T> callable, long timeoutMillis) throws TimeoutException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<T> future = executor.submit(callable);
    try {
      return future.get(timeoutMillis, TimeUnit.MILLISECONDS);
    } catch (TimeoutException e ) {
      future.cancel(true);
      throw new TimeoutException("Regex evaluation timed out after ");
    } catch (ExecutionException | InterruptedException e) {
      future.cancel(true);
      throw new RuntimeException(e);
    } finally {
      executor.shutdownNow();
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
    return executeWithTimeout(()->Pattern.matches(regex, new InterruptibleCharSequence(charSequence)), timeoutMillis);
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
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(new InterruptibleCharSequence(charSequence)).find(), timeoutMillis);
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
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(new InterruptibleCharSequence(charSequence)).replaceAll(replacement), timeoutMillis);
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
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(new InterruptibleCharSequence(charSequence)).replaceFirst(replacement), timeoutMillis);
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
    return executeWithTimeout(() -> Pattern.compile(regex).split(new InterruptibleCharSequence(charSequence)), timeoutMillis);
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
    return executeWithTimeout(() -> Pattern.compile(regex).split(new InterruptibleCharSequence(charSequence), limit), timeoutMillis);
  }

  /**
   * <p>
   * CharSequence that noticed thread interrupts -- as might be necessary
   * to recover from a loose regex on unexpected challenging input.
   * </p>
   * <p>
   * This solution is sourced from <a href="https://stackoverflow.com/a/910798">this StackOverflow answer</a>
   * </p>
   * @author gojomo
   *
   */
  static class InterruptibleCharSequence implements CharSequence {
      CharSequence inner;

      public InterruptibleCharSequence(CharSequence inner) {
          super();
          this.inner = inner;
      }

      public char charAt(int index) {
          if (Thread.interrupted()) { // clears flag if set
              throw new RuntimeException(new InterruptedException());
          }
          return inner.charAt(index);
      }

      public int length() {
          return inner.length();
      }


      public CharSequence subSequence(int start, int end) {
          return new InterruptibleCharSequence(inner.subSequence(start, end));
      }

      @Override
      public String toString() {
          return inner.toString();
      }
  }
}
