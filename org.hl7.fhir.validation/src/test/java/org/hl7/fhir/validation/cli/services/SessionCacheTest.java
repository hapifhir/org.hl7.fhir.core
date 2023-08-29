package org.hl7.fhir.validation.cli.services;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionCacheTest {

  @Test
  @DisplayName("test session expiration works")
  void expiredSession() throws IOException, InterruptedException {
    final long EXPIRE_TIME = 5L;
    SessionCache cache = new SessionCache(EXPIRE_TIME, TimeUnit.SECONDS);
    ValidationEngine testEngine = new ValidationEngine.ValidationEngineBuilder().fromNothing();
    String sessionId = cache.cacheSession(testEngine);
    TimeUnit.SECONDS.sleep(EXPIRE_TIME + 1L);
    Assertions.assertNull(cache.fetchSessionValidatorEngine(sessionId));
  }

  @Test
  @DisplayName("test session caching works")
  void cachedSession() throws IOException {
    final long EXPIRE_TIME = 5L;
    SessionCache cache = new SessionCache(EXPIRE_TIME, TimeUnit.SECONDS);
    ValidationEngine testEngine = new ValidationEngine.ValidationEngineBuilder().fromNothing();
    String sessionId = cache.cacheSession(testEngine);
    Assertions.assertEquals(testEngine, cache.fetchSessionValidatorEngine(sessionId));
  }

  @Test
  @DisplayName("test session exists")
  void sessionExists() throws IOException {
    SessionCache cache = new SessionCache();
    ValidationEngine testEngine = new ValidationEngine.ValidationEngineBuilder().fromNothing();
    String sessionId = cache.cacheSession(testEngine);
    Assertions.assertTrue(cache.sessionExists(sessionId));
    Assertions.assertFalse(cache.sessionExists(UUID.randomUUID().toString()));
  }

  @Test
  @DisplayName("test null session test id returns false")
  void testNullSessionExists() {
    SessionCache cache = new SessionCache();
    Assertions.assertFalse(cache.sessionExists(null));
  }

  @Test
  @DisplayName("test that explicit removeExiredSessions works")
  void testRemoveExpiredSessions() throws InterruptedException, IOException {
    final long EXPIRE_TIME = 5L;
    SessionCache cache = new SessionCache(EXPIRE_TIME, TimeUnit.SECONDS);
    ValidationEngine testEngine = new ValidationEngine.ValidationEngineBuilder().fromNothing();
    String sessionId = cache.cacheSession(testEngine);
    Assertions.assertTrue(cache.sessionExists(sessionId));
    TimeUnit.SECONDS.sleep(EXPIRE_TIME + 1L);
    cache.removeExpiredSessions();
    Assertions.assertTrue(cache.getSessionIds().isEmpty());
  }
}