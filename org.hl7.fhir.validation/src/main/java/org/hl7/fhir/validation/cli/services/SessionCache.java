package org.hl7.fhir.validation.cli.services;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.hl7.fhir.validation.ValidationEngine;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SessionCache {

  protected static final long TIME_TO_LIVE = 60;
  protected static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

  private final PassiveExpiringMap<String, ValidationEngine> cachedSessions;

  public SessionCache() {
    cachedSessions = new PassiveExpiringMap<>(TIME_TO_LIVE, TIME_UNIT);
  }

  public SessionCache(long sessionLength, TimeUnit sessionLengthUnit) {
    cachedSessions = new PassiveExpiringMap<>(sessionLength, sessionLengthUnit);
  }

  public String cacheSession(ValidationEngine validator) {
    String generatedId = generateID();
    cachedSessions.put(generatedId, validator);
    return generatedId;
  }

  public String cacheSession(String sessionId, ValidationEngine validator) {
    if(sessionId == null) {
      sessionId = cacheSession(validator);
    } else {
      cachedSessions.put(sessionId, validator);
    }
    return sessionId;
  }

  public boolean sessionExists(String sessionId) {
    return cachedSessions.containsKey(sessionId);
  }

  public ValidationEngine fetchSessionValidatorEngine(String sessionId) {
    return cachedSessions.get(sessionId);
  }

  public Set<String> getSessionIds() {
    return cachedSessions.keySet();
  }

  private String generateID() {
    return UUID.randomUUID().toString();
  }
}
