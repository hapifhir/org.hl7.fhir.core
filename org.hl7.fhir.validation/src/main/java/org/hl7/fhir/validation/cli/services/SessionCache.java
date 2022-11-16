package org.hl7.fhir.validation.cli.services;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.hl7.fhir.validation.ValidationEngine;

/**
 * SessionCache for storing and retrieving ValidationEngine instances, so callers do not have to re-instantiate a new
 * instance for each validation request.
 */
public class SessionCache {

  protected static final long TIME_TO_LIVE = 60;
  protected static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

  private final PassiveExpiringMap<String, ValidationEngine> cachedSessions;

  public SessionCache() {
    cachedSessions = new PassiveExpiringMap<>(TIME_TO_LIVE, TIME_UNIT);
  }

  /**
   * @param sessionLength the constant amount of time an entry is available before it expires. A negative value results
   *                      in entries that NEVER expire. A zero value results in entries that ALWAYS expire.
   * @param sessionLengthUnit the unit of time for the timeToLive parameter, must not be null
   */
  public SessionCache(long sessionLength, TimeUnit sessionLengthUnit) {
    cachedSessions = new PassiveExpiringMap<>(sessionLength, sessionLengthUnit);
  }

  /**
   * Stores the initialized {@link ValidationEngine} in the cache. Returns the session id that will be associated with
   * this instance.
   * @param validationEngine {@link ValidationEngine}
   * @return The {@link String} id associated with the stored instance.
   */
  public String cacheSession(ValidationEngine validationEngine) {
    String generatedId = generateID();
    cachedSessions.put(generatedId, validationEngine);
    return generatedId;
  }

  /**
   * Stores the initialized {@link ValidationEngine} in the cache with the passed in id as the key. If a null key is
   * passed in, a new key is generated and returned.
   * @param sessionId The {@link String} key to associate with this stored {@link ValidationEngine}
   * @param validationEngine The {@link ValidationEngine} instance to cache.
   * @return The {@link String} id that will be associated with the stored {@link ValidationEngine}
   */
  public String cacheSession(String sessionId, ValidationEngine validationEngine) {
    if(sessionId == null) {
      sessionId = cacheSession(validationEngine);
    } else {
      cachedSessions.put(sessionId, validationEngine);
    }
    return sessionId;
  }

  /**
   * When called, this actively checks the cache for expired entries and removes
   * them.
   */
  public void removeExpiredSessions() {
    /*
    The PassiveExpiringMap will remove entries when accessing the mapped value
    for a key, OR when invoking methods that involve accessing the entire map
    contents. So, we call keySet below to force removal of all expired entries.
    * */
    cachedSessions.keySet();
  }

  /**
   * Checks if the passed in {@link String} id exists in the set of stored session id.
   * @param sessionId The {@link String} id to search for.
   * @return {@link Boolean#TRUE} if such id exists.
   */
  public boolean sessionExists(String sessionId) {
    return cachedSessions.containsKey(sessionId);
  }

  /**
   * Returns the stored {@link ValidationEngine} associated with the passed in session id, if one such instance exists.
   * @param sessionId The {@link String} session id.
   * @return The {@link ValidationEngine} associated with the passed in id, or null if none exists.
   */
  public ValidationEngine fetchSessionValidatorEngine(String sessionId) {
    return cachedSessions.get(sessionId);
  }

  /**
   * Returns the set of stored session ids.
   * @return {@link Set} of session ids.
   */
  public Set<String> getSessionIds() {
    return cachedSessions.keySet();
  }

  /**
   * Session ids generated internally are UUID {@link String}.
   * @return A new {@link String} session id.
   */
  private String generateID() {
    return UUID.randomUUID().toString();
  }
}
