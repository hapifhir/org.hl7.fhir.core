package org.hl7.fhir.utilities.regex;

import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * <p>This utility class executes common regular expression methods and times out if processing takes longer than expected.</p>
 * <p>500ms is the default timeout.</p>
 */
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
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @return true if, and only if, the string matches the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static boolean matches(String string, String regex) throws TimeoutException {
    return matches(string, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#matches(String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @param timeoutMillis the timeout in milliseconds
   * @return true if, and only if, the string matches the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static boolean matches(String string, String regex, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(()->Pattern.matches(regex, string), timeoutMillis);
  }

  /**
   * Wrapper around {@link java.util.regex.Matcher#find()} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to search for within the string
   * @return true if a subsequence of the input sequence matches the pattern
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static boolean find(String string, String regex) throws TimeoutException {
    return find(string, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link java.util.regex.Matcher#find()} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to search for within the string
   * @param timeoutMillis the timeout in milliseconds
   * @return true if a subsequence of the input sequence matches the pattern
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static boolean find(String string, String regex, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(string).find(), timeoutMillis);
  }

  /**
   * Wrapper around {@link String#replaceAll(String, String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @param replacement the string to be substituted for each match
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String replaceAll(String string, String regex, String replacement) throws TimeoutException {
    return replaceAll(string, regex, replacement, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#replaceAll(String, String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @param replacement the string to be substituted for each match
   * @param timeoutMillis the timeout in milliseconds
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String replaceAll(String string, String regex, String replacement, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(string).replaceAll(replacement), timeoutMillis);
  }

  /**
   * Wrapper around {@link String#replaceFirst(String, String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @param replacement the string to be substituted for the first match
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String replaceFirst(String string, String regex, String replacement) throws TimeoutException {
    return replaceFirst(string, regex, replacement, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#replaceFirst(String, String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the regular expression to which the string is to be matched
   * @param replacement the string to be substituted for the first match
   * @param timeoutMillis the timeout in milliseconds
   * @return the resulting string
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String replaceFirst(String string, String regex, String replacement, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(() -> Pattern.compile(regex).matcher(string).replaceFirst(replacement), timeoutMillis);
  }

  /**
   * Wrapper around {@link String#split(String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the delimiting regular expression
   * @return the array of strings computed by splitting the string around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String[] split(String string, String regex) throws TimeoutException {
    return split(string, regex, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#split(String)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the delimiting regular expression
   * @param timeoutMillis the timeout in milliseconds
   * @return the array of strings computed by splitting the string around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String[] split(String string, String regex, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(() -> Pattern.compile(regex).split(string), timeoutMillis);
  }

  /**
   * Wrapper around {@link String#split(String, int)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the delimiting regular expression
   * @param limit the result threshold
   * @return the array of strings computed by splitting the string around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than the default timeout in milliseconds
   */
  public static String[] split(String string, String regex, int limit) throws TimeoutException {
    return split(string, regex, limit, DEFAULT_TIMEOUT);
  }

  /**
   * Wrapper around {@link String#split(String, int)} which will throw an exception if processing runs longer than expected.
   * @param string the string
   * @param regex the delimiting regular expression
   * @param limit the result threshold
   * @param timeoutMillis the timeout in milliseconds
   * @return the array of strings computed by splitting the string around matches of the given regular expression
   * @throws TimeoutException if processing runs longer than timeoutMillis milliseconds
   */
  public static String[] split(String string, String regex, int limit, long timeoutMillis) throws TimeoutException {
    return executeWithTimeout(() -> Pattern.compile(regex).split(string, limit), timeoutMillis);
  }
}
