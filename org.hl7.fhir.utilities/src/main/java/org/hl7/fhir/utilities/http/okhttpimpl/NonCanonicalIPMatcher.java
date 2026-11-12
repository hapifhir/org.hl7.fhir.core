package org.hl7.fhir.utilities.http.okhttpimpl;

import java.util.regex.Pattern;

/**
 * Recognizes hosts that OkHttp treats as literal IP addresses.
 * <p>
 * OkHttp connects to any host matching its {@code canParseAsIpAddress} check
 * (okhttp3.internal._HostnamesCommon) via {@code InetAddress.getByName}, without consulting the
 * configured {@code Dns}. That check is looser than Guava's {@code InetAddresses.isInetAddress}:
 * it also accepts non-canonical spellings such as {@code 2130706433}, {@code 127.1} or
 * {@code 127.000.000.001}, which {@code InetAddress.getByName} resolves to real addresses.
 */
public class NonCanonicalIPMatcher {

  /**
   * Mirrors OkHttp's {@code canParseAsIpAddress}. Keep in sync with OkHttp when upgrading.
   * <p>
   * Must only be used with {@link java.util.regex.Matcher#matches()}: under
   * {@link java.util.regex.Matcher#find()} the first alternative backtracks in polynomial time.
   */
  @SuppressWarnings("checkstyle:patternUsage")
  //fixed literal mirroring OkHttp; linear when anchored to the whole input (first class excludes ':', so only one split point), polynomial under an unanchored find - NEVER USE FIND
  private static final Pattern OKHTTP_IP_LITERAL = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

  private NonCanonicalIPMatcher() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  /**
   * Returns whether OkHttp would treat {@code host} as a literal IP address.
   * <p>
   * This also matches canonical IP literals (e.g. {@code 127.0.0.1}). Call it only for hosts that
   * Guava's {@code InetAddresses.isInetAddress} has already rejected; a {@code true} result then
   * means the host is a non-canonical IP literal that bypasses DNS-based validation.
   */
  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //Matcher.matches() on the precompiled OKHTTP_IP_LITERAL - nothing is compiled per call; anchored, so linear
  public static boolean isNonCanonicalIPHost(String host) {
    return OKHTTP_IP_LITERAL.matcher(host).matches();
  }
}
