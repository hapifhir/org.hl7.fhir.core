package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.validation.ValidationEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class MaxSizeSessionCacheDecorator implements SessionCache {

  public final int maxSize;
  public final SessionCache sessionCache;

  private final List<String> sessionIds;

  public MaxSizeSessionCacheDecorator(SessionCache sessionCache, int maxSize) {
    this.sessionCache = sessionCache;
    this.maxSize = maxSize;
    this.sessionIds = new ArrayList<>(sessionCache.getSessionIds());
    if (this.sessionIds.size() > maxSize) {
      throw new IllegalArgumentException("Session cache size exceeds the maximum size");
    }
  }

  @Override
  public String cacheSession(ValidationEngine validationEngine) {
    checkSizeAndMaintainMax(null);
    String key = sessionCache.cacheSession(validationEngine);
    sessionIds.add(key);
    return key;
  }

  @Override
  public String cacheSession(Supplier<ValidationEngine> validationEngineSupplier) {
    checkSizeAndMaintainMax(null);
    ValidationEngine validationEngine = validationEngineSupplier.get();
    return sessionCache.cacheSession(validationEngine);
  }

  private void checkSizeAndMaintainMax(String keyToAdd) {
    if (keyToAdd != null || sessionCache.sessionExists(keyToAdd)) {
      return;
    }
    Set<String> sessionIds = sessionCache.getSessionIds();
    //Sync our tracked keys, in case the underlying cache has changed
    this.sessionIds.removeIf(key -> !sessionIds.contains(key));

    if (this.sessionIds.size() >= maxSize) {
      final String key = this.sessionIds.remove(0);
      sessionCache.removeSession(key);
    }
  }

  @Override
  public String cacheSession(String sessionId, ValidationEngine validationEngine) {
    checkSizeAndMaintainMax(sessionId);
    cacheSession(sessionId, validationEngine);
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
