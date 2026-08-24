package org.hl7.fhir.utilities.http;

import com.google.common.net.InetAddresses;
import org.hl7.fhir.utilities.http.okhttpimpl.NonPublicAddressRejectingDns;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagedWebAccessUtils {

  private ManagedWebAccessUtils() {
    throw new UnsupportedOperationException("This utility class should not be instantiated");
  }

  public static ServerDetailsPOJO getServer(Iterable<String> serverTypes, String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO serverDetails : serverAuthDetails) {
        for (String serverType : serverTypes) {
          if (urlMatchesOrigin(url, serverDetails.getUrl()) && typesMatch(serverType, serverDetails.getType())) {
            return serverDetails;
          }
        }
      }
    }
    return null;
  }

  public static ServerDetailsPOJO getServer(String url, Iterable<ServerDetailsPOJO> serverAuthDetails) {
    if (serverAuthDetails != null) {
      for (ServerDetailsPOJO serverDetails : serverAuthDetails) {
          if (urlMatchesOrigin(url, serverDetails.getUrl())) {
            return serverDetails;
          }
      }
    }
    return null;
  }

  public static boolean urlMatchesOrigin(String requestUrlString, String serverUrlString) {
    try {
      URL requestUrl = URI.create(requestUrlString).toURL();
      URL serverUrl = URI.create(serverUrlString).toURL();
      return urlMatchesOrigin(requestUrl, serverUrl);
    } catch (MalformedURLException e) {
      return false;
    }
  }

  public static boolean urlMatchesOrigin(URL requestUrl, URL serverUrl) {
    return requestUrl.getProtocol().equals(serverUrl.getProtocol())
      && requestUrl.getHost().equals(serverUrl.getHost())
      && getExplicitOrInferredPort(requestUrl) == getExplicitOrInferredPort(serverUrl)
      && requestUrl.getPath().startsWith(serverUrl.getPath());
  }

  private static int getExplicitOrInferredPort(URL url) {
    int port = url.getPort();
    if (port != -1) {
      return port;
    }
    if (url.getProtocol().equals("https")) {
      return 443;
    }
    if (url.getProtocol().equals("http")) {
      return 80;
    }
    return port;
  }

  private static boolean typesMatch(String criteria, String value) {
    return criteria == null || value == null || criteria.equals(value);
  }

  public static byte[] getEncodedBasicAuth(String providedUsername, String providedPassword) {
    String auth = providedUsername + ":" + providedPassword;
    return Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
  }

  private static final Set<String> explicitlyBlockedHosts = Set.of(
    "metadata.amazonaws.com", // AWS IMDS
    "metadata.google.internal" // GCP Metadata
  );

  private static final Set<InetAddress> explicitlyBlockedInetAddresses = Arrays.stream(new String[]{
    // Block various cloud providers internal IPs.
    "169.254.169.254", // AWS IMDS, GCP Metadata, Azure IMDS
    "192.0.0.192", // Oracle
  }).map(InetAddresses::forString).collect(Collectors.toUnmodifiableSet());

  /**
   * Validates {@code url}'s scheme and host syntax against the DNS-independent parts of the
   * SSRF policy (scheme allow-list, presence of a host, explicitly blocked hostnames). Does
   * not perform any DNS resolution.
   */
  public static void throwExceptionIfNotAllowedScheme(java.net.URI url) throws IOException {
    String scheme = url.getScheme() == null ? "" : url.getScheme().toLowerCase();
    if (!scheme.equals("https")) {
      throw new IOException("Refusing to fetch from non-https URL: " + url);
    }
    String host = url.getHost();
    if (host == null || host.isEmpty()) {
      throw new IOException("Refusing to fetch from URL with no host: " + url);
    }
    if (explicitlyBlockedHosts.contains(host)) {
      throw new IOException("Refusing to fetch from explicitly blocked host: " + url);
    }
  }

  /**
   * If {@code host} is itself a literal IP address (not a hostname), validates it against the
   * SSRF IP-range policy; otherwise does nothing.
   * <p>
   * This must be called explicitly wherever DNS-based validation such as
   * {@link NonPublicAddressRejectingDns} is otherwise relied on: OkHttp's route selection recognizes
   * literal IP hosts and uses {@code InetAddress.getByName(host)} directly, never invoking the
   * configured {@code Dns}, so a literal IP would otherwise bypass validation entirely. This is
   * still safe to do eagerly (unlike hostname validation, which must happen no earlier than the
   * connection uses it) - a literal IP address has nothing to re-resolve, so there is no
   * DNS-rebinding window between checking it and connecting to it.
   */
  public static void throwExceptionIfLiteralIpAndNonPublicAddress(String host) throws IOException {
    if (InetAddresses.isInetAddress(host)) {
      throwExceptionIfNonPublicAddress(InetAddresses.forString(host), host);
    }
  }

  /**
   *
   * <p></p>
   * Validates a single, already-resolved address against the SSRF IP-range policy. Callers
   * that also control DNS resolution (e.g. {@link NonPublicAddressRejectingDns}) should call this with
   * the exact address that will be used to open the connection, so nothing is re-resolved
   * between the check and the connection.
   * </p>
   * <p>The address checks are taken from the production example provided in
   * <a href="https://cheatsheetseries.owasp.org/cheatsheets/Server_Side_Request_Forgery_Prevention_Cheat_Sheet.html">the OWASP SSRF Prevention Cheat Sheet</a>
   * which is from the following project:
   * <a href="https://github.com/cc-tweaked/CC-Tweaked/blob/b9ed66983d714bcb5c6bf15b428e01a035106dbf/projects/core/src/main/java/dan200/computercraft/core/apis/http/options/AddressPredicate.java#L112-L157">CC-Tweaked's AddressPredicate</a>.
   * </p>
   *  Throws IOException if {@code url}'s host resolves to any non-public address
   *  (loopback, link-local incl. 169.254/16, site-local RFC1918, IPv6 ULA fc00::/7,
   *  unspecified incl. 0.0.0.0/8, multicast, carrier-grade NAT, NAT64-synthesized
   *  addresses). Used to block SSRF when dereferencing user-supplied
   * links (SMART Health Links/Cards, terminology endpoints, etc.).
   */
  public static void throwExceptionIfNonPublicAddress(java.net.InetAddress address, String host) throws IOException {
    if (address.isAnyLocalAddress()   // 0.0.0.0, ::0
      || isThisNetworkAddress(address) // 0.0.0.0/8
      || address.isLoopbackAddress()   // 127.0.0.0/8, ::1
      || address.isLinkLocalAddress()  // 169.254.0.0/16, fe80::/10
      || address.isSiteLocalAddress()  // 10.0.0.0/8, 172.16.0.0/12, 192.168.0.0/16, fec0::/10
      || address.isMulticastAddress()  // 224.0.0.0/4, ff00::/8
      || isUniqueLocalAddress(address) // fc00::/7
      || isCarrierGradeNatAddress(address) // 100.64.0.0/10
      || isNat64SynthesizedAddress(address) // 64:ff9b::/96
      || explicitlyBlockedInetAddresses.contains(address)) {
      throw new IOException("Refusing to fetch from non-public address "
        + address.getHostAddress() + " for host " + host);
    }
  }

  /**
   * Determine if an IP address lives inside the ULA address range.
   *
   * @param address The IP address to test.
   * @return Whether this address sits in the ULA address range.
   * @see <a href="https://en.wikipedia.org/wiki/Unique_local_address">Unique local address on Wikipedia</a>
   */
  private static boolean isUniqueLocalAddress(InetAddress address) {
    // ULA is defined as fc00::/7, covering both fc00::/8 and fd00::/8. Only fd00::/8 is
    // currently allocated, but fc00::/8 has no other legitimate public use, so block the whole
    // /7 now rather than waiting on an allocation that would otherwise need a code change.
    return address instanceof Inet6Address && (address.getAddress()[0] & 0xfe) == 0xfc;
  }

  /**
   * Determine if an IP address lives within the CGNAT address range (100.64.0.0/10).
   *
   * @param address The IP address to test.
   * @return Whether this address sits in the CGNAT address range.
   * @see <a href="https://en.wikipedia.org/wiki/Carrier-grade_NAT">Carrier-grade NAT on Wikipedia</a>
   */
  private static boolean isCarrierGradeNatAddress(InetAddress address) {
    if (!(address instanceof Inet4Address)) return false;
    var bytes = address.getAddress();
    return bytes[0] == 100 && ((bytes[1] & 0xFF) >= 64 && (bytes[1] & 0xFF) <= 127);
  }

  /**
   * Determine if an IP address lives within the "this network" range (0.0.0.0/8). {@code isAnyLocalAddress()}
   * only recognizes the single unspecified address (0.0.0.0); the rest of the /8 is also reserved.
   *
   * @param address The IP address to test.
   * @return Whether this address sits in the 0.0.0.0/8 range.
   */
  private static boolean isThisNetworkAddress(InetAddress address) {
    return address instanceof Inet4Address && address.getAddress()[0] == 0;
  }

  /**
   * Determine if an IP address is NAT64-synthesized (64:ff9b::/96) - an IPv6 address with an IPv4 address
   * embedded in its low 32 bits. Unlike IPv4-mapped addresses (::ffff:0:0/96), {@link InetAddress} does not
   * unwrap these, so an embedded private IPv4 address is invisible to every other check in this method
   * unless this range is blocked outright.
   *
   * @param address The IP address to test.
   * @return Whether this address sits in the NAT64 well-known prefix.
   * @see <a href="https://datatracker.ietf.org/doc/html/rfc6052">RFC 6052</a>
   */
  private static boolean isNat64SynthesizedAddress(InetAddress address) {
    if (!(address instanceof Inet6Address)) return false;
    var bytes = address.getAddress();
    return bytes[0] == 0x00 && bytes[1] == 0x64 && bytes[2] == (byte) 0xff && bytes[3] == (byte) 0x9b
      && bytes[4] == 0 && bytes[5] == 0 && bytes[6] == 0 && bytes[7] == 0
      && bytes[8] == 0 && bytes[9] == 0 && bytes[10] == 0 && bytes[11] == 0;
  }
}
