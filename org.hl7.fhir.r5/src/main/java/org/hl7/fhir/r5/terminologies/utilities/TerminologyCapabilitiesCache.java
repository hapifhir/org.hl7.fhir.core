package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import java.io.File;
import java.io.IOException;

public interface TerminologyCapabilitiesCache<V> {
  boolean containsKey(String key);

  V get(String key);

  V put(String key, V value);

  static boolean cacheFileHasExpired(String fn, long expirationTimeMillis) throws IOException {
    File cacheFile = ManagedFileAccess.csfile(fn);
    if (!cacheFile.exists()) {
      return true;
    }
    final long lastModified = cacheFile.lastModified();
    final long currentTime = System.currentTimeMillis();

    return (currentTime - lastModified) > expirationTimeMillis;
  }
}
