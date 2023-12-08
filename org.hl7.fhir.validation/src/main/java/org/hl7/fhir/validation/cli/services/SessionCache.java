package org.hl7.fhir.validation.cli.services;

import java.util.Set;

import org.hl7.fhir.validation.ValidationEngine;

public interface SessionCache {

  /**
   * Stores the initialized {@link ValidationEngine} in the cache. Returns the session id that will be associated with
   * this instance.
   * @param validationEngine {@link ValidationEngine}
   * @return The {@link String} id associated with the stored instance.
   */
  String cacheSession(ValidationEngine validationEngine);

  /**
   * Stores the initialized {@link ValidationEngine} in the cache with the passed in id as the key. If a null key is
   * passed in, a new key is generated and returned.
   * @param sessionId The {@link String} key to associate with this stored {@link ValidationEngine}
   * @param validationEngine The {@link ValidationEngine} instance to cache.
   * @return The {@link String} id that will be associated with the stored {@link ValidationEngine}
   */
  String cacheSession(String sessionId, ValidationEngine validationEngine);

  /**
   * Allows for configuration of whether or not cachedSession entry expiration times reset
   * after they are accessed.
   * @param reset The boolean determining session expiration policy
   * @return The {@link SessionCache} with the explicit expiration policy
   */
  SessionCache setExpirationAfterAccess(boolean reset);

  /**
   * When called, this actively checks the cache for expired entries and removes
   * them.
   */
  void removeExpiredSessions();

  /**
   * Checks if the passed in {@link String} id exists in the set of stored session id.
   * @param sessionId The {@link String} id to search for.
   * @return {@link Boolean#TRUE} if such id exists.
   */
  boolean sessionExists(String sessionId);

  /**
   * Returns the stored {@link ValidationEngine} associated with the passed in session id, if one such instance exists.
   * @param sessionId The {@link String} session id.
   * @return The {@link ValidationEngine} associated with the passed in id, or null if none exists.
   */
  ValidationEngine fetchSessionValidatorEngine(String sessionId);

  /**
   * Returns the set of stored session ids.
   * @return {@link Set} of session ids.
   */
  Set<String> getSessionIds();
    
}