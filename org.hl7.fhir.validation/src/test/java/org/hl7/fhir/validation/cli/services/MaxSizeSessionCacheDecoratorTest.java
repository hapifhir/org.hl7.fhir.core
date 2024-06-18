package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;


import static org.mockito.Mockito.mock;

public class MaxSizeSessionCacheDecoratorTest {

  private List<ValidationEngine> getMockedEngines(int count) {
    List<ValidationEngine> engines = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      engines.add(mock(ValidationEngine.class));
    }
    return engines;
  }

  private LinkedHashMap<String, ValidationEngine> addMockedEngines(SessionCache cache, int count) {
    LinkedHashMap<String, ValidationEngine> engineMap = new LinkedHashMap<>();
    List<ValidationEngine> engines = getMockedEngines(count);
    for (ValidationEngine engine : engines) {
      String key = cache.cacheSession(engine);
      engineMap.put(key, engine);
    }
    return engineMap;
  }

  @Test
  public void trivialExpiryTest() {

    ExplicitExpirySessionCacheDecorator sessionCache = new ExplicitExpirySessionCacheDecorator(new PassiveExpiringSessionCache());

    LinkedHashMap<String, ValidationEngine> initialEngines = addMockedEngines(sessionCache, 3);

    Assertions.assertEquals(3, sessionCache.getSessionIds().size());

    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 0)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 1)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 2)));

    Assertions.assertTrue(sessionCache.expireOldestSession());

    Assertions.assertEquals(2, sessionCache.getSessionIds().size());
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 1)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 2)));

    LinkedHashMap<String, ValidationEngine> newEngines = addMockedEngines(sessionCache, 2);

    Assertions.assertEquals(4, sessionCache.getSessionIds().size());
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 1)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 2)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(newEngines, 0)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(newEngines, 1)));

    Assertions.assertTrue(sessionCache.expireOldestSession());

    Assertions.assertEquals(3, sessionCache.getSessionIds().size());
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(initialEngines, 2)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(newEngines, 0)));
    Assertions.assertTrue(sessionCache.getSessionIds().contains(getKeyByIndex(newEngines, 1)));

    Assertions.assertTrue(sessionCache.expireOldestSession());
    Assertions.assertTrue(sessionCache.expireOldestSession());
    Assertions.assertTrue(sessionCache.expireOldestSession());
    Assertions.assertFalse(sessionCache.expireOldestSession());
  }

  @Test
  public void producerAddTest() {
    ExplicitExpirySessionCacheDecorator maxSizeSessionCacheDecorator = new ExplicitExpirySessionCacheDecorator(new PassiveExpiringSessionCache());
    ValidationEngine producedEngine = mock(ValidationEngine.class);
    String sessionId = maxSizeSessionCacheDecorator.cacheSession(() -> {
      return producedEngine;
    });
    Assertions.assertEquals(1, maxSizeSessionCacheDecorator.getSessionIds().size());
    Assertions.assertSame(producedEngine, maxSizeSessionCacheDecorator.fetchSessionValidatorEngine(sessionId));
  }

  private String getKeyByIndex(LinkedHashMap<String, ValidationEngine> engineMap, int index) {
    return (String) engineMap.keySet().toArray()[index];
  }
}
