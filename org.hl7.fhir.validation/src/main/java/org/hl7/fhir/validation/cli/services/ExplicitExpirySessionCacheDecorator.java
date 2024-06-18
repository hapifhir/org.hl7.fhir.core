package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.validation.ValidationEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ExplicitExpirySessionCacheDecorator implements SessionCache {


  public final SessionCache sessionCache;

  private final List<String> sessionIds;

  public ExplicitExpirySessionCacheDecorator(SessionCache sessionCache) {
    this.sessionCache = sessionCache;
    this.sessionIds = new ArrayList<>(sessionCache.getSessionIds());
  }

  public boolean expireOldestSession() {
    if (sessionIds.isEmpty()) {
      return false;
    }
    String oldestSessionId = sessionIds.get(0);
    sessionIds.remove(oldestSessionId);
    sessionCache.removeSession(oldestSessionId);
    return true;
  }

  @Override
  public String cacheSession(ValidationEngine validationEngine) {
    maintainSessionIds(null);
    String key = sessionCache.cacheSession(validationEngine);
    sessionIds.add(key);
    return key;
  }

  @Override
  public String cacheSession(Supplier<ValidationEngine> validationEngineSupplier) {
    maintainSessionIds(null);
    ValidationEngine validationEngine = validationEngineSupplier.get();
    String key = sessionCache.cacheSession(validationEngine);
    sessionIds.add(key);
    return key;
  }

  private void maintainSessionIds(String keyToAdd) {
    if (keyToAdd != null || sessionCache.sessionExists(keyToAdd)) {
      return;
    }
    Set<String> sessionIds = sessionCache.getSessionIds();
    //Sync our tracked keys, in case the underlying cache has changed
    this.sessionIds.removeIf(key -> !sessionIds.contains(key));

  }

  @Override
  public String cacheSession(String sessionId, ValidationEngine validationEngine) {
    maintainSessionIds(sessionId);
    return sessionCache.cacheSession(
        sessionId, validationEngine);
  }

  @Override
  public boolean sessionExists(String sessionId) {
    return sessionCache.sessionExists(sessionId);
  }

  @Override
  public ValidationEngine removeSession(String sessionId) {
    sessionIds.remove(sessionId);
    return sessionCache.removeSession(sessionId);
  }

  @Override
  public ValidationEngine fetchSessionValidatorEngine(String sessionId) {
    return sessionCache.fetchSessionValidatorEngine(sessionId);
  }

  @Override
  public Set<String> getSessionIds() {
    return sessionCache.getSessionIds();
  }
}
