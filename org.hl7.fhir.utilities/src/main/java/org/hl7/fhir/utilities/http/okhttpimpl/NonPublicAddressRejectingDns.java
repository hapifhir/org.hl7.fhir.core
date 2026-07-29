package org.hl7.fhir.utilities.http.okhttpimpl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import okhttp3.Dns;
import org.hl7.fhir.utilities.http.ManagedWebAccessUtils;

import javax.annotation.Nonnull;


/**
 * An OkHttp {@link Dns} that validates every resolved address against the SSRF policy in
 * {@link ManagedWebAccessUtils}, and returns exactly those validated addresses.
 * <p>
 * OkHttp connects only to the {@link InetAddress} instances a {@link Dns} returns from
 * {@link #lookup(String)} - it never re-resolves the hostname itself. Validating here, rather
 * than resolving separately up front and discarding the result, means the address checked is
 * always the address connected to, closing the DNS-rebinding window that exists when
 * validation and connection perform independent lookups.
 * <p>
 * This is only invoked for genuine hostnames. OkHttp's route selection recognizes literal IP
 * hosts and short-circuits to {@code InetAddress.getByName(host)} without ever calling this
 * class - callers must validate those separately, e.g. via
 * {@link ManagedWebAccessUtils#throwExceptionIfLiteralIpAndNonPublicAddress(String)}.
 */
public class NonPublicAddressRejectingDns implements Dns {

  @Override
  public @Nonnull List<InetAddress> lookup(@Nonnull String hostname) throws UnknownHostException {
    List<InetAddress> addresses = Dns.SYSTEM.lookup(hostname);

      for (InetAddress address : addresses) {
        try {
          ManagedWebAccessUtils.throwExceptionIfNonPublicAddress(address, hostname);
        } catch (IOException e) {
          throw (UnknownHostException) new UnknownHostException(e.getMessage()).initCause(e);
        }
      }

    return addresses;
  }
}
